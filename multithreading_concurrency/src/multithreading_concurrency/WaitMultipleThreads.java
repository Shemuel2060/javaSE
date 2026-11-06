package multithreading_concurrency;

public class WaitMultipleThreads {
	
	
	
	public static void main(String[] args) throws InterruptedException {
		WaitMultipleThreads wait = new WaitMultipleThreads();
		
		// transaction validation task
		Runnable transactionTask = wait.new TransactionValidation();		
		Thread transactionThread = new Thread(transactionTask);
		
		// expense calculation task
		Runnable expenseCalcTask = wait.new ExpenseCalculator();
		Thread expenseCalcThread = new Thread(expenseCalcTask);
		
		// revenue calculation task
		Runnable revenueCalcTask = wait.new RevenueCalculator();
		Thread revenueCalcThread = new Thread(revenueCalcTask);
		
		// start all threads to run concurrently
		transactionThread.start();
		expenseCalcThread.start();
		revenueCalcThread.start();
		
		// allow the main thread to wait each thread to w
		transactionThread.join();
		revenueCalcThread.join();
		expenseCalcThread.join();
		
		System.out.println("All reports completed...");
	}
	
	
	
	
	
	
	
	
	
	
	// the three tasks as runnables
	
	private class TransactionValidation implements Runnable{

		@Override
		public void run() {
			try {
				Thread.currentThread().sleep(500);
				System.out.println("Transaction validation DONE...");
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt(); // re-assert the interrupt state
				return;
			}
			
		}
		
	}
	
	private class ExpenseCalculator implements Runnable{

		@Override
		public void run() {
			try {
				Thread.currentThread().sleep(3000);
				System.out.println("Expense calculation DONE...");
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt(); // re-assert the interrupt state
				return;
			}
			
		}
		
	}
	
	private class RevenueCalculator implements Runnable{

		@Override
		public void run() {
			try {
				Thread.currentThread().sleep(2000);
				System.out.println("Revenue calculation DONE...");
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt(); // re-assert the interrupt state
				return;
			}
			
		}
		
	}
	
	

}
