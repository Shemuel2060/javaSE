package multithreading_concurrency;

public class NumberPrinter implements Runnable {

	@Override
	public void run() {
		
		for(int i=1; i<6; i++) {
			System.out.println("number-worker: "+i);
		}
		
		System.out.println(Thread.currentThread().getName());

	}
	
	public static void main(String[] args) {
		
		System.out.println(Thread.currentThread().getName());
		
		Runnable runnable = new NumberPrinter();
		
		Thread thread = new Thread(null, runnable,  "number-worker");
		
		thread.start();
		
	}
	

}


