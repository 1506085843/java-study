package com.it.test.MyThread;

import java.util.List;
import java.util.concurrent.FutureTask;

/**
 * 线程运行中，subList分组
 * 
 * @author Hosiang
 *
 */
public class MyThread3 {

	
	//先subList分组，后创建线程运行
 	public static Integer test3(List<String[]> datas) throws InterruptedException {
		
		 Integer sum = 0;
		 int size = datas.size();
		 int nThreads = size/2;
		 
		 for (int i = 0; i < nThreads; i++) {
	            List<String[]> Value = datas.subList(size / nThreads * i, size / nThreads * (i + 1));  
	            System.out.println(Value.toString());
	            WorkerRun2 mt = new WorkerRun2(Value);

	            //1.执行 Callable 方式，需要 FutureTask 实现类的支持，用于接收运算结果。
	            FutureTask<Integer> result = new FutureTask<>(mt);
		 
		        new Thread(result).start();
		 
		        //2.接收线程运算后的结果
		        try {
		        	//FutureTask 可用于 闭锁 类似于CountDownLatch的作用，在所有的线程没有执行完成之后这里是不会执行的
		            int  res = result.get();  
		            sum = sum + res;
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		 }    
			return sum;
	}
 	
 	//先创建线程运行，后subList分组
 	public synchronized static Integer test3To(List<String[]> datas) throws InterruptedException {
		
		 Integer sum = 0;
		 int length = datas.size();
		 int threadNum = length/2;
		 
		 for (int i = 0; i < threadNum; i++) {
	            int tl = length % threadNum == 0 ? length / threadNum : (length / threadNum + 1);
	            int end = (i + 1) * tl;
	            WorkerRun3 thread = new WorkerRun3( i * tl, end > length ? length : end,datas);
	          
	          //1.执行 Callable 方式，需要 FutureTask 实现类的支持，用于接收运算结果。
	            FutureTask<Integer> result = new FutureTask<>(thread);
		 
		        new Thread(result).start();
		 
		        //2.接收线程运算后的结果
		        try {
		        	//FutureTask 可用于 闭锁 类似于CountDownLatch的作用，在所有的线程没有执行完成之后这里是不会执行的
		            int  res = result.get();  
		            sum = sum + res;
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		 }    
			return sum;
	}
}
