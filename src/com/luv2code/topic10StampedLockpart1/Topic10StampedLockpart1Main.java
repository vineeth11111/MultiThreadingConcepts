package com.luv2code.topic10StampedLockpart1;

public class Topic10StampedLockpart1Main {

	public static void main(String[] args) {
		SharedResource resource = new SharedResource();
		
		Thread t1 = new Thread(
				() -> {
					resource.producer();
				}
				);
		
		Thread t2 = new Thread(
				() -> {
					resource.producer();
				}
				);
		
		Thread t3 = new Thread(
				() -> {
					resource.consumer();
				}
				);
		
		t1.start();
		t2.start();
		t3.start();

	}

}
