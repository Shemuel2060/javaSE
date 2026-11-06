package multithreading_concurrency;

public class VirtualThreads {
	
	// what are virtual threads
	// -- daemon threads 
	// use little RAM 
	// run on top of platform threads 
	
	// --- they are different from platform threads
	
	public static void main(String[] args) throws InterruptedException {
		Runnable myRunnable = new MyRunnable();
		Runnable myRunnable2 = new MyRunnable2();
		
		Thread vThread = Thread.ofVirtual().unstarted(myRunnable);
		Thread vThread2 = Thread.ofVirtual().unstarted(myRunnable2);
		
		// run one virtual thread at a time on the platform thread (main thread)
		vThread.start();
		vThread.join();
		
		vThread2.start();		
		vThread2.join();
	}
	
	
	private static class MyRunnable implements Runnable{

		@Override
		public void run() {
			System.out.println("Starting First virtual thread...");
			try {
				Thread.sleep(300); // 2 seconds
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				return;
			} 
			
			// incase no interruptions
			System.out.println("First Virtual thread has completed...");
			
		}
	}
	
	private static class MyRunnable2 implements Runnable{

		@Override
		public void run() {
			System.out.println("Starting second virtual thread...");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				return;
			} 
			
			// incase no interruptions
			System.out.println("Second Virtual thread has completed...");
			
		}
		
	}
	
}
	
	
	
	
	
	
	
	
	// mounting, unmounting, and pinning
	// pinning - a vThread may not be unmount, esp. when running file system calls
	// time slicing

