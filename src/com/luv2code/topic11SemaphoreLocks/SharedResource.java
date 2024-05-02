package com.luv2code.topic11SemaphoreLocks;

import java.util.concurrent.Semaphore;

public class SharedResource {
	
	Semaphore lock = new Semaphore(2);
	boolean isAvailable = false;
	
	public void producer() {
		try {
			lock.acquire();
			System.out.println("Lock acquired by : "+Thread.currentThread().getName());
			isAvailable = true;
			Thread.sleep(4000);
		}
		catch(Exception e) {}
		finally {
			lock.release();
			System.out.println("Lock release by : "+Thread.currentThread().getName());
		}
	}

	public static void main(String[] args) {
		SharedResource resource= new SharedResource();
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
					resource.producer();
				}
				);
		
		Thread t4 = new Thread(
				() -> {
					resource.producer();
				}
				);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();

	}

}
