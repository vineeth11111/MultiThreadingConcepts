package com.luv2code.topic9ReentrantReadWriteLock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SharedResource {
	
	boolean isAvailable = false;
	
	public void readResource(ReadWriteLock lock) {
		try {
			lock.readLock().lock();
			System.out.println("Read Lock Acquired by "+Thread.currentThread().getName());
			// isAvailable = true; 
			// When reading you should not change anything
			Thread.sleep(4000);
		}
		catch(Exception e) {
			
		}
		finally {
			lock.readLock().unlock();
			System.out.println("Read Lock released by "+Thread.currentThread().getName());
		}
	}
	
	public void writeResource(ReadWriteLock lock) {
		try {
			lock.writeLock().lock();
			System.out.println("Write Lock Acquired by "+Thread.currentThread().getName());
		}
		catch(Exception e) {
			
		}finally {
			lock.writeLock().unlock();
			System.out.println("Write Lock released by "+Thread.currentThread().getName());
		}
	}

}
