package com.luv2code.topic1ThreadCreationUsingRunnable;

public class MultiThreadingLearning implements Runnable{

	@Override
	public void run() {
		System.out.println("Thread Name  : "+Thread.currentThread().getName());
		
	}

	
}
