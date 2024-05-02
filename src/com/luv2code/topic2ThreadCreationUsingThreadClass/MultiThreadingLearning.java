package com.luv2code.topic2ThreadCreationUsingThreadClass;

public class MultiThreadingLearning extends Thread{

	public void run() {
		System.out.println("Thread Name : "+Thread.currentThread().getName());
	}
}
