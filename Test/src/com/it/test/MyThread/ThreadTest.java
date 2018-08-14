package com.it.test.MyThread;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试
 * @author Hosiang
 *
 */
public class ThreadTest {
	
	public static void main(String[] args) throws InterruptedException {
		
    	//模拟数据
        List<String[]> list = new ArrayList<String[]>();
        for (int i = 0; i < 5000; i++) {
        	String [] strArray = new String [6];
    	   for(int j=0;j <6;j++){
    		    strArray[j] = i+"-"+j;
            }	
    	   list.add(strArray);
		}
        
        System.out.println("模拟数据:"+list.size());
        
       //测试方法一：单线程
		long start1 =System.currentTimeMillis();
		//单线程
		Integer num1= MyThread1.test1(list);
		long end1 = System.currentTimeMillis();
		System.out.println("测试方法一 ============== 时间 为" +  (end1 - start1) + "毫秒"+"，计数："+num1);
		
		/*//测试方法二：Stream分组List，创建线程运行
        long start2 =System.currentTimeMillis();
        //多线程
      	int num2 = MyThread2.test2(list);
		long end2 = System.currentTimeMillis();
		System.out.println("测试方法二 ============== 时间 为" +  (end2 - start2) + "毫秒"+"，计数："+num2);
		*/
		//测试方法三：先subList分组，后创建线程运行
		long start3 =System.currentTimeMillis();
		//多线程
		int num3 = MyThread3.test3(list);
		long end3 = System.currentTimeMillis();
		System.out.println("测试方法三 ============== 时间 为" +  (end3 - start3) + "毫秒"+"，计数："+num3);
		
		/*
		//测试方法三TO：先创建线程运行，后subList分组
        long start3to =System.currentTimeMillis();
        //多线程
      	int num3to = MyThread3.test3To(list);
		long end3to = System.currentTimeMillis();
		System.out.println("测试方法三To ============== 时间 为" +  (end3to - start3to) + "毫秒"+"，计数："+num3to);
		*/
		//测试方法四：
        long start4 =System.currentTimeMillis();
        //多线程
      	int num4 = MyThread4.test4(list);
		long end4 = System.currentTimeMillis();
		System.out.println("测试方法四 ============== 时间 为" +  (end4 - start4) + "毫秒"+"，计数："+num4);
		
	} 
}
