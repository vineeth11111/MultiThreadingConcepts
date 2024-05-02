package com.luv2code.topic6DeprecatedMethods;

// DeadLock happens if we do not make use of resume();
public class DeprecatedMethods {

	public synchronized void resource() {
		System.out.println("Resource utilization started");
		System.out.println("Kept lock");
		try {
			Thread.sleep(8000);
		}
		catch(Exception e) {
			//Handle Exception
		}
		System.out.println("released lock");
	}
	
	public static void main(String[] args) {
		System.out.println("Main thread started");
		DeprecatedMethods deprecatedMethods = new DeprecatedMethods();
		Thread thread1 = new Thread(
				() -> {
					deprecatedMethods.resource();
				}
				);
		Thread thread2 = new Thread(
				() -> {
					deprecatedMethods.resource();
				}
				);
		
		thread1.start();
		
		
		try {
			Thread.sleep(3000);
			thread1.suspend(); 
			thread2.start();
			 thread1.resume();
		}
		catch(Exception e) {
			
		}
		
		System.out.println("Main thread ended");
		
	}
}
