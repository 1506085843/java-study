package com.it.test.MyThread;

import java.util.List;

/**
 * 单线程
 * 
 * @author Hosiang
 *
 */
public class MyThread1 {

	//单线程
	public static Integer test1(List<String[]> datas) throws InterruptedException {
		
		StringBuffer sb = new StringBuffer();
		
		System.out.println("===========test1"+datas.size());
		//这段代码在主线程
	   	 for (int i = 0; i < datas.size(); i++) {
	   			
				String[] channelArray = datas.get(i);
				
					String wocode = channelArray[0];
					String adjustTypeStr = channelArray[1];
					String adjustAmount = channelArray[2];
					String clientCode = channelArray[3];
					String adjustBillCode = channelArray[4];
					String confirmYm = channelArray[5];
					
    				sb.append(wocode);
    				sb.append(adjustTypeStr);
    				sb.append(adjustAmount);
    				sb.append(clientCode);
    				sb.append(adjustBillCode);
    				sb.append(confirmYm);
				
	      }

	   	 return sb.length();
	}
}
