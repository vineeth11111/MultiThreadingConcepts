package com.luv2code.topic2ThreadCreationUsingThreadClass;

public class MultiThreadingLearningApp {

	public static void main(String[] args) {
		System.out.println("At Start Current Thread Name : "+Thread.currentThread().getName());
		MultiThreadingLearning multiThreadingLearning = new MultiThreadingLearning();
		multiThreadingLearning.start();
		System.out.println("At End Current Thread Name : "+Thread.currentThread().getName());
	}
}
