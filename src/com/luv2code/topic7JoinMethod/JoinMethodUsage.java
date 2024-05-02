package com.luv2code.topic7JoinMethod;

public class JoinMethodUsage {
	
	

	public static void main(String[] args) {
		System.out.println("main thread started");
		SharedResource SharedResource = new SharedResource();
		Thread thread = new Thread(
				() -> {
					SharedResource.useResource();
				}
				);
		thread.start();
	/*	try {
			thread.join();
		}
		catch(Exception e){
			
		}*/
		System.out.println("ended main thread");
	}

}
