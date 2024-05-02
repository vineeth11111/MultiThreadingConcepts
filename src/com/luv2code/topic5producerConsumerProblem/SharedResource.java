package com.luv2code.topic5producerConsumerProblem;

import java.util.LinkedList;
import java.util.Queue;

public class SharedResource {

	Queue<Integer> items = null;
	Integer capacity = null;
	Integer count = 0;
	
	SharedResource(Integer capacity){
		this.items = new LinkedList<>();
		 this.capacity = capacity;
	}
	
	public synchronized void produceItem() {
		try {
			if(items.size() == capacity) {
				System.out.println("Queue is full !! .. waiting for consumerItem to consume");
				wait();
			}
			items.add(++count);
			System.out.println("Added to the queue "+count +"Now Queue size is "+items.size());
			
			notifyAll();
		}
		catch(Exception e) {
			
		}
	}
	
	public synchronized void consumeItem() {
		try {
			if(items.size() == 0) {
				System.out.println("Queue is empty !! .. waiting for producerItem to produce");
				wait();
			}
			Integer poll = items.poll();
			System.out.println("Removed from the queue "+poll);
			notifyAll();
		}
		catch(Exception e) {
			
		}
	}
}
