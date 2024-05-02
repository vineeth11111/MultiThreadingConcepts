package com.luv2code.topic1ThreadCreationUsingRunnable;

public class MultiThreadingLearningApp {

	public static void main(String[] args) {
		//Runnable Object
		System.out.println("Thread Name : "+Thread.currentThread().getName());
		MultiThreadingLearning multiThreadingLearning = new MultiThreadingLearning();
		Thread thread = new Thread(multiThreadingLearning);
		thread.start();//Thread Name : Thread-0
		System.out.println("Thread Name : "+Thread.currentThread().getName());
	}
}
