package com.it.test.MyThread;

import java.util.List;
import java.util.concurrent.FutureTask;

/**
 * 线程运行中，subList分组
 * 
 * @author Hosiang
 *
 */
public class MyThread4 {

	
 	public static Integer test4(List<String[]> datas) throws InterruptedException {
		
		 Integer sum = 0;
		 int size = datas.size();
		// int nThreads = size/300;
		 
		 //500 1线程
		 if (size <= 500) {
			 
			 List<String[]> Value = datas.subList(0, size - 1);
			 WorkerRun2 mt = new WorkerRun2(Value);
			 
	         FutureTask<Integer> result = new FutureTask<>(mt);
		 
		     new Thread(result).start();
		 
	         try {
	            int  res = result.get();  
	            sum = sum + res;
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		}
		 
		 //1000 2线程
		 if (size > 500 && size <= 1000) {
			
			 List<String[]> Value1 = datas.subList(0, size - 501);
			 List<String[]> Value2 = datas.subList(501, size);
			 
			 WorkerRun2 mt = new WorkerRun2(Value1);
			 WorkerRun2 mt2 = new WorkerRun2(Value2);
			 
			 FutureTask<Integer> result = new FutureTask<>(mt);
			 
			 new Thread(result).start();
			 
			 try {
				 int  res = result.get();  
				 sum = sum + res;
			 } catch (Exception e) {
				 e.printStackTrace();
			 }
			 
			 FutureTask<Integer> result2 = new FutureTask<>(mt2);
			 
			 new Thread(result2).start();
			 
			 try {
				 int  res2 = result2.get();  
				 sum = sum + res2;
			 } catch (Exception e) {
				 e.printStackTrace();
			 }
		}
		 
		 //1500 3线程
		 
		 //2000 4线程
		 
		 //2500 5线程
		 
		 //5000 10线程
		 int i = 500;
		 
		 if (size > 4500 && size <= 5000) {
				
			 List<String[]> Value1 = datas.subList(0, i-1);
			 List<String[]> Value2 = datas.subList(i, 2*i-1);
			 
			 List<String[]> Value3 = datas.subList(2*i, 3*i-1);
			 List<String[]> Value4 = datas.subList(3*i, 4*i-1);
			 
			 List<String[]> Value5 = datas.subList(4*i, 5*i-1);
			 List<String[]> Value6 = datas.subList(5*i, 6*i-1);
			 
			 List<String[]> Value7 = datas.subList(6*i, 7*i-1);
			 List<String[]> Value8 = datas.subList(7*i, 8*i-1);
			 
			 List<String[]> Value9 = datas.subList(8*i, 9*i-1);
			 List<String[]> Value10 = datas.subList(9*i, 10*i-1);
			 
			 
			 WorkerRun2 mt1 = new WorkerRun2(Value1);
			 WorkerRun2 mt2 = new WorkerRun2(Value2);
			 
			 WorkerRun2 mt3 = new WorkerRun2(Value3);
			 WorkerRun2 mt4 = new WorkerRun2(Value4);
			 
			 WorkerRun2 mt5 = new WorkerRun2(Value5);
			 WorkerRun2 mt6 = new WorkerRun2(Value6);
			 
			 WorkerRun2 mt7 = new WorkerRun2(Value7);
			 WorkerRun2 mt8 = new WorkerRun2(Value8);
			 
			 WorkerRun2 mt9 = new WorkerRun2(Value9);
			 WorkerRun2 mt10 = new WorkerRun2(Value10); 
			 
			 FutureTask<Integer> result1 = new FutureTask<>(mt1);
			 FutureTask<Integer> result2 = new FutureTask<>(mt2);
			 FutureTask<Integer> result3 = new FutureTask<>(mt3);
			 FutureTask<Integer> result4 = new FutureTask<>(mt4);
			 FutureTask<Integer> result5 = new FutureTask<>(mt5);
			 
			 FutureTask<Integer> result6 = new FutureTask<>(mt6);
			 FutureTask<Integer> result7 = new FutureTask<>(mt7);
			 FutureTask<Integer> result8 = new FutureTask<>(mt8);
			 FutureTask<Integer> result9 = new FutureTask<>(mt9);
			 FutureTask<Integer> result10 = new FutureTask<>(mt10);
			 
			 
						 
					 new Thread(result1).start();
					 new Thread(result2).start();
					 new Thread(result3).start();
					 new Thread(result4).start();
					 new Thread(result5).start();
					 
					 new Thread(result6).start();
					 new Thread(result7).start();
					 new Thread(result8).start();
					 new Thread(result9).start();
					 new Thread(result10).start();
					 

						 
			 
			/* try {
				 int  res = result.get();  
				 sum = sum + res;
			 } catch (Exception e) {
				 e.printStackTrace();
			 }*/
			 
			/* FutureTask<Integer> result2 = new FutureTask<>(mt2);
			 
			 new Thread(result2).start();
			 
			 try {
				 int  res2 = result2.get();  
				 sum = sum + res2;
			 } catch (Exception e) {
				 e.printStackTrace();
			 }*/
		}
		 

		 
		 
		/* for (int i = 0; i < nThreads; i++) {
	            List<String[]> Value = datas.subList(size / nThreads * i, size / nThreads * (i + 1));  
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
		 } */   
			return sum;
	}
 	
}
