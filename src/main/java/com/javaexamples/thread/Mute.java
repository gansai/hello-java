//Just using interrupt() call on a thread
package com.javaexamples.thread;

public class Mute {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Mute m = new Mute();
		m.startWork();
		

	}
	
	private void startWork()
	{
		SomeRunnable sr = new SomeRunnable();
		Thread t = new Thread(sr);
		t.start();
		t.interrupt();
		
	}
	
	class SomeRunnable implements Runnable
	{
		public void run()
		{
			System.out.println("just running");
			try {
				System.out.println("just sleeping");
				while(true)
				{
					System.out.println("Hi");
					Thread.sleep(10000);
				}
				
			} catch (InterruptedException e) {
				System.out.println("just interrupted");
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
			
		}
	}

}
