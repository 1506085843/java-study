package com.it.test.Thread;

import java.util.List;

/**
 * 实现Runnable接口，创建线程
 * 
 * @author Hosiang
 *
 */
public class Run1  implements Runnable {
	
	  private List<String[]>  datas; 

	    public Run1(List<String[]> datas){
	        this.datas=datas;
	    }
	 

   //加同步锁
   @Override
   public void run(){
  	 StringBuffer sb = new StringBuffer();
  		 synchronized (this) {
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
  				 
  				System.out.println(i+ "--Run1 ==========="+sb.length());
  			 }
  			 
		}
  		 
  		//通过阻塞程序来查看效果
	     try{
	         Thread.sleep(50);  
	         }
	     catch(Exception e){
	         System.out.println(e);
	     }

  }

}
