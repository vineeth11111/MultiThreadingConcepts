package com.luv2code.topic7JoinMethod;

public class SharedResource {
	
	public synchronized void useResource() {
		System.out.println("Kept Lock");
		try {
			Thread.sleep(4000);
		}
		catch(Exception e) {
			
		}
		System.out.println("Released Lock");
	}

}
