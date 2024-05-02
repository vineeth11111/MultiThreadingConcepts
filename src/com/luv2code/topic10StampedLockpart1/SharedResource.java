package com.luv2code.topic10StampedLockpart1;

import java.util.concurrent.locks.StampedLock;

public class SharedResource {

	boolean isAvailable = false;
	
	StampedLock lock = new StampedLock();
	
	public void producer() {
		Long stamp = null;
		try {
			stamp = lock.readLock();
			System.out.println("stamp value in producer : "+stamp);
			System.out.println("Read Lock acquired by : "+Thread.currentThread().getName());
			Thread.sleep(4000);
		}
		catch(Exception e) {
			
		}
		finally {
			lock.unlockRead(stamp);
			System.out.println("Read Lock released by : "+Thread.currentThread().getName());
		}
	}
	
	public void consumer() {
		Long stamp = null;
		try {
			stamp = lock.writeLock();
			System.out.println("stamp value in consumer : "+stamp);
			System.out.println("Write Lock acquired by : "+Thread.currentThread().getName());
		}
		finally {
			lock.unlockWrite(stamp);
			System.out.println("Write Lock released by : "+Thread.currentThread().getName());
		}
	}
}
