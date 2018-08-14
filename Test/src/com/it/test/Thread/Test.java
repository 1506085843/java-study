package com.it.test.Thread;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		
    	//模拟数据
        List<String[]> list = new ArrayList<String[]>();
        for (int i = 0; i < 5; i++) {
        	String [] strArray = new String [6];
    	   for(int j=0;j <6;j++){
    		    strArray[j] = i+"-"+j;
            }	
    	   list.add(strArray);
		}
		
		//测试方法一：
        long start1 =System.currentTimeMillis();
        Threads.test1(list);
		long end1 = System.currentTimeMillis();
		System.out.println("test1，时间 为" +  (end1 - start1) + "毫秒");
		
		//测试方法二：
        long start2 =System.currentTimeMillis();
        Threads.test2(list);
		long end2 = System.currentTimeMillis();
		System.out.println("test2，时间 为" +  (end2 - start2) + "毫秒");
	}
}
