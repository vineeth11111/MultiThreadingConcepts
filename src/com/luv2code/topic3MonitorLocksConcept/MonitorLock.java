package com.luv2code.topic3MonitorLocksConcept;

public class MonitorLock {

	public synchronized void task1() {
		try {
			System.out.println("Inside Task1");
			Thread.sleep(1000);
		}
		catch(Exception e) {
			
		}
		System.out.println("End of task1");
	}
	
	public void task2() {
		System.out.println("task2, but before synchronized");
		synchronized(this) {
			System.out.println("task2, inside synchronized ");
		}
	}
	
	public void task3() {
		System.out.println("Inside task3");
	}
}
