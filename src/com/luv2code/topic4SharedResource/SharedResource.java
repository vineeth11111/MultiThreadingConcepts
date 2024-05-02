package com.luv2code.topic4SharedResource;

public class SharedResource {

	boolean itemAvailable = false;
	
	public synchronized void addItem() {
		itemAvailable = true;
		System.out.println("Item Added by Thread "+Thread.currentThread().getName() );
		notifyAll();
		System.out.println("Notify Called");
	}
	
	public synchronized void consumeItem() {
		System.out.println("Consume item method invoked by :"+Thread.currentThread().getName());
		while(!itemAvailable)
		{
			try {
				System.out.println(Thread.currentThread().getName() + " is waiting now");
				wait();// It releases monitor lock
				System.out.println("After Notify called");
			}
			catch(Exception e) {
				
			}
			
		}
		System.out.println("Item consumed by Thread "+Thread.currentThread().getName());
		itemAvailable = false;
	}
}
