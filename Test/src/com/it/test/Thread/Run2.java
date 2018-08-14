package com.it.test.Thread;

import java.util.List;

/**
 * 继承Thread类，创建线程
 * （Thread类本身实现了实现Runnable接口）
 * 
 * @author Hosaing
 *
 */
public class Run2  extends Thread {
	
	  private List<String[]>  datas; 

	    public Run2(List<String[]> datas){
	        this.datas=datas;
	    }
	 
   //不加同步锁
   @Override
   public void run(){
  	 StringBuffer sb = new StringBuffer();
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
				
				System.out.println(i+ "--Run2 ==========="+sb.length());
	      }
  	   
      }
}
