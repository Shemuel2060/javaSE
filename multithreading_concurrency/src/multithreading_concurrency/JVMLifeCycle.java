package multithreading_concurrency;

public class JVMLifeCycle {
	
	public static void main(String[] args) throws InterruptedException {
		JVMLifeCycle mainClass = new JVMLifeCycle();
		
		Thread nonDaemonThread = new Thread(mainClass.new NonDaemonTask());
		Thread daemonThread = new Thread(mainClass.new DaemonTask());
		
		nonDaemonThread.start();		
		daemonThread.setDaemon(true);
		daemonThread.start();	
		daemonThread.join(); // main thread to wait for the daemon task to complete
	}
	
	private class DaemonTask implements Runnable{

		@Override
		public void run() {
			
			try {
				System.out.println("Daemon background Message...:)\n");
				Thread.sleep(300);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt(); // re-assert the interrupt state
				return;
			}
			
			System.out.println("Daemon background task completed...");
			
		}
		
	}
	
	private class NonDaemonTask implements Runnable{

		@Override
		public void run() {
			
			try {
				System.out.println("Non-daemon task starting...:)\n");
				Thread.sleep(200);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt(); // re-assert the interrupt state
				return;
			}			
			System.out.println("Non-daemon task completed...");
		}
		
	}

}
