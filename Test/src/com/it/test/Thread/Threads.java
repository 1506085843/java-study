package com.it.test.Thread;

import java.util.List;

public class Threads{


    
	public static void test1(List<String[]> datas) throws InterruptedException {
		
		Run1 mt=new Run1(datas);
        //创建三个线程
        Thread th1=new Thread(mt);
        Thread th2=new Thread(mt);
        Thread th3=new Thread(mt);

        //启动三个线程
        th1.start();
        th2.start();
        th3.start();
	}
	
	public static void test2(List<String[]> datas) throws InterruptedException {
		
		Run2 mt=new Run2(datas);
        //创建三个线程
        Thread th1=new Thread(mt);
        Thread th2=new Thread(mt);
        Thread th3=new Thread(mt);

        //启动三个线程
        th1.start();
        th2.start();
        th3.start();
	}
	
}
