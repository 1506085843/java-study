package com.it.test.MyThread;

import java.util.List;
import java.util.concurrent.Callable;

public class WorkerRun3  implements Callable<Integer> {

	  private int start;
	  private int end;
	  private List<String[]> datas;

	public WorkerRun3(int start,int end, List<String[]> datas) {
			this.start = start;
			this.end = end;
			this.datas = datas;
		}
	
	     //不加同步锁
	     @Override  
	     public Integer call() throws Exception {
		     List<String[]> subList = datas.subList(start, end);
	    	 StringBuffer sb = new StringBuffer();
	          for (int i = 0; i < subList.size(); i++) {
		 	   			
		 				String[] channelArray = subList.get(i);
		 				
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
