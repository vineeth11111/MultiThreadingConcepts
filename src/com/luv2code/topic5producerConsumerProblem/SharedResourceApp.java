package com.luv2code.topic5producerConsumerProblem;

public class SharedResourceApp {

	public static void main(String[] args) {
		
		SharedResource sharedResource = new SharedResource(3);
		Thread producerThread = new Thread(
				
				() -> {
					for(int count = 0; count < 6 ; count++) {
						sharedResource.produceItem();
					}
				}
				);
		
        Thread consumerThread = new Thread(
				
				() -> {
					for(int count = 0; count < 6 ; count++) {
						try {
							if(count == 0) {
								Thread.sleep(1000);
							}
						}
						catch(Exception e) {
							
						}
						sharedResource.consumeItem();
					}
				}
				);
        
        producerThread.start();
        consumerThread.start();
				
	}
}
