package com.luv2code.topic9ReentrantReadWriteLock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockApp {

	public static void main(String[] args) {
		
		SharedResource resource1 = new SharedResource();
		SharedResource resource2 = new SharedResource();
		ReadWriteLock lock = new ReentrantReadWriteLock();
		
		
		Thread thread1 = new Thread(
				() -> { resource1.readResource(lock);  }
				);
		
		Thread thread2 = new Thread(
				() -> { resource1.readResource(lock);  }
				);
		
		Thread thread3 = new Thread(
				() -> { resource2.writeResource(lock);  }
				);
		
		thread1.start();
		thread2.start();
		thread3.start();
	}

}
