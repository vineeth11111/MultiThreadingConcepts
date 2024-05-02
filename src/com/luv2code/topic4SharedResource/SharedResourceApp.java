package com.luv2code.topic4SharedResource;

public class SharedResourceApp {

	public static void main(String[] args) {
		
		SharedResource sharedResource = new SharedResource();
		Thread producerThread = new Thread(
				() -> {
					try {
						System.out.println("At start of Producer thread");
						Thread.sleep(5000);
						sharedResource.addItem();
						System.out.println("End of producer thread");
					}
					catch(Exception e)
					{
						
					}
				}
				);
		
		Thread consumerThread = new Thread(
				() -> {
					try {
						System.out.println("At start of Consumer thread");
						sharedResource.consumeItem();
						System.out.println("End of consumer thread");
					}
					catch(Exception e)
					{
						
					}
				}
				);
		
		producerThread.start();
		consumerThread.start();
	}
}
