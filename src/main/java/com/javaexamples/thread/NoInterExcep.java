//Using interrupted() api
package com.javaexamples.thread;

public class NoInterExcep {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		NoInterExcep no = new NoInterExcep();
		no.startWork();

	}
	
	private void startWork()
	{
		SomeRunnable sr = new SomeRunnable();
		Thread t = new Thread(sr);
		t.start();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("startWork is interrupted");
		}
		t.interrupt();
		if(t.isInterrupted())
		{
			System.out.println("t got interrupted once");
		}
		else
		{
			System.out.println("t did not got interrupted once");
		}
		
		
		
		
	}
	
	
	class SomeRunnable implements Runnable
	{
		public void run()
		{
			int i = 0;
			while(true)
			{
				try {
				System.out.println("hi "+ i++);
				if(Thread.interrupted())
				{
					System.out.println("I got interrupted");
					throw new InterruptedException();
					
				}					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return;
				}
			}
		}
	}

}
