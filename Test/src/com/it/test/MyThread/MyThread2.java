package com.it.test.MyThread;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.FutureTask;
import java.util.stream.Collectors;

/**
 * Stream分组List，创建线程运行
 * 
 * @author Hosiang
 *
 */
public class MyThread2 {

	//Stream分组List，创建线程运行
	public static Integer test2(List<String[]> datas) throws InterruptedException {
		
		 Integer sum = 0;
		 Random random = new Random(datas.size()/2);
         Map<Integer,List<String[]>> group = datas.parallelStream().collect(Collectors.groupingBy(e -> random.nextInt(5)));
         Iterator<Map.Entry<Integer,List<String[]>>> entries = group.entrySet().iterator();  
        
         while (entries.hasNext()) { 
            Map.Entry<Integer,List<String[]>> entry = entries.next();  
            //Integer Key = entry.getKey();
            List<String[]>  Value = entry.getValue();
            
            WorkerRun2 mt = new WorkerRun2(Value);
         
            //1.执行 Callable 方式，需要 FutureTask 实现类的支持，用于接收运算结果。
            FutureTask<Integer> result = new FutureTask<>(mt);
	 
	        new Thread(result).start();
	 
	        //2.接收线程运算后的结果
	        try {
	          //FutureTask 可用于 闭锁 类似于CountDownLatch的作用，在所有的线程没有执行完成之后这里是不会执行的
	          Integer  res = result.get();  
	          sum = sum + res;
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        
        }
		return sum;
	}
	
}
