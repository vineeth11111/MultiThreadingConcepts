package com.luv2code.topic12threadPoolExecutor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorMain {

	public static void main(String[] args) {
		ThreadPoolExecutor executor = new ThreadPoolExecutor(2,
				                                             4,  
				                                             10,
				                                             TimeUnit.MINUTES,
				                                             new ArrayBlockingQueue<>(2),
				                                             new CustomThreadFactory(),
				                                              new CustomRejectionHandler()
				                                             );
		ThreadPoolExecutor executor2 = new ThreadPoolExecutor(2,
                4,  
                30,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(2),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardPolicy()
                );
		
		for(int count = 0; count < 7 ; count++) {
			executor2.submit(
					   () -> {
						   try {
							   Thread.sleep(4000);
							   
						   }
						   catch(Exception e) {
							   
						   }
						   System.out.println("Task completed by "+Thread.currentThread().getName());
					   }
					);
		}
		

	}

}

class CustomThreadFactory implements ThreadFactory{

	@Override
	public Thread newThread(Runnable r) {
		// TODO Auto-generated method stub
		return new Thread(r);
	}
	}

class CustomRejectionHandler implements RejectedExecutionHandler
{

	@Override
	public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
		System.out.println("Task Rejected "+r.toString());
		
	}
	
}