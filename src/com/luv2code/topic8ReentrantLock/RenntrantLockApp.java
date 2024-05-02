package com.luv2code.topic8ReentrantLock;

import java.util.concurrent.locks.ReentrantLock;

public class RenntrantLockApp {

	public static void main(String[] args) {
		
		System.out.println("Inside com.luv2code.topic8ReentrantLock RenntrantLockApp ");
		ReentrantLock lock = new ReentrantLock();
		SharedResource resource1 = new SharedResource();
		SharedResource resource2 = new SharedResource();
		
		Thread thread1 = new Thread(
				                           () -> {
				                        	         resource1.producer(lock);
				                                 }
	                                );
		
		Thread thread2 = new Thread(
                                           () -> {
             	                                     resource2.producer(lock);
                                                 }
                                     );
		
		thread1.start();
		thread2.start();

	}

}
