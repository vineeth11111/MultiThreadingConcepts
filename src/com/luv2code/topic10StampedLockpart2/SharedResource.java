package com.luv2code.topic10StampedLockpart2;

import java.util.concurrent.locks.StampedLock;

public class SharedResource {

	int number = 10;
	
	StampedLock lock = new StampedLock();
	
	public void producer() {
		System.out.println("read lock acquired by "+Thread.currentThread().getName());
		long stamp = 0;
		try {
			stamp = lock.tryOptimisticRead();
			number = 11;
			Thread.sleep(4000);
			if(lock.validate(stamp))
			{
				System.out.println("Updated number sucessfully ! ..");
			}else {
				System.out.println("Number rollback done");
			}
		}
		catch(Exception e) {
			
		}
		System.out.println("read lock released by "+Thread.currentThread().getName());
	}
	
	public void consumer() {
		long stamp = 0;
		System.out.println("write lock acquired by "+Thread.currentThread().getName());
		try {
		 stamp = lock.writeLock();
		 System.out.println("Performing write operation");
		 number = 200;
		}
		finally {
			lock.unlockWrite(stamp);
			System.out.println("write lock released by "+Thread.currentThread().getName());
		}
		
	}
	
	public static void main(String[] args) {
		
		SharedResource resource = new SharedResource();
		Thread t1 = new Thread(
				() -> {
					resource.producer();
				}
				);
		
		Thread t2 = new Thread(
				() -> {
					resource.consumer();
				}
				);
		
		t1.start();
		t2.start();
		
		
		
	}
}
