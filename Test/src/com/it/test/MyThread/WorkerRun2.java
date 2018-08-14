package com.it.test.MyThread;

import java.util.List;
import java.util.concurrent.Callable;

public class WorkerRun2  implements Callable<Integer> {

	    private List<String[]>  Value; 

	    public WorkerRun2(List<String[]> Value){
	        this.Value=Value;
	    }
	
	    //不加同步锁
	    @Override  
	    public Integer call() throws Exception {
	   	 StringBuffer sb = new StringBuffer();
	   	 System.out.println("===========Run"+Value.size());
	         for (int i = 0; i < Value.size(); i++) {
		 	   			
		 				String[] channelArray = Value.get(i);
		 				
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
