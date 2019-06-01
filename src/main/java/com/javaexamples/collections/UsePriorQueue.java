package com.javaexamples.collections;

import java.util.PriorityQueue;

public class UsePriorQueue {
	
	public static void main(String args[])
	{
		PriorityQueue<Double> queu = new PriorityQueue<Double>();
		
		queu.add(3.3);
		queu.add(32321.3);
		queu.add(33.3);
		queu.add(3.44);
		
		Double d;
		
		//Polling leads to removing the head of priorityQueue
		
		while((d = queu.poll()) !=null)
		{
			System.out.println(d);
		}
		
		queu.add(3.3);
		queu.add(32321.3);
		queu.add(33.3);
		queu.add(3.44);

		//Peeking just peeks at the head, does not cut the head
		System.out.println(queu.peek());


	}

}
