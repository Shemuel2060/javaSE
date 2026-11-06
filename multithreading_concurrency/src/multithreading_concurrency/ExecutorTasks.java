package multithreading_concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;

public class ExecutorTasks {
	
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// create a factory of name virtual threads
		ThreadFactory factory = Thread.ofVirtual()
									  .name("Virtual Thread", 0)
									  .factory();
		// create an executor service
//		ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor();
//		
////		executeRunnable(executorService, "Completed Executing Runnable");
////		Future future = submitRunnable(executorService, "Completed submitting Runnable");
//		Future future = submitCallable(executorService, "Completed submitting Callable");		
//		System.out.println(future.get());
//		executorService.shutdown();
		
		try(ExecutorService executorService = Executors.newThreadPerTaskExecutor(factory)){
			 List<Future<String>> futures =
		                perform100TasksWithVirtualThreads(
		                        executorService, "Submitted 100 tasks");

		        for (Future<String> future : futures) {
		            System.out.println(future.get());
		        }
		    }
		}
	
	public static void executeRunnable(ExecutorService exService, String msg) {
		exService.execute(new Runnable() {
			@Override
			public void run() {
				System.out.println("This is a single runnable");
			}
			
		});
		System.out.println(msg);		
	}
	
	public static Future submitRunnable(ExecutorService exService, String msg) {
		Future future = exService.submit(new Runnable() {
			@Override
			public void run() {
				System.out.println("This is a single runnable");
			}
			
		});
		System.out.println(msg);
		return future;		
	}
	
	public static Future submitCallable(ExecutorService exService, String msg) {
		Future future = exService.submit(new Callable() {
			@Override
			public Object call() throws Exception {
				
				return "COMPLETED";
			}			
		});		
		System.out.println(msg);
		return future;
	}
	
	public static List<Future<String>> perform100TasksWithVirtualThreads(ExecutorService exService, String msg) {
		
		List<Future<String>> futures = new ArrayList<>();
		
		for(int j=0; j<100; j++) {
			int taskId = j; 
			Future<String> future = exService.submit(new Callable() {
				@Override
				public Object call() throws Exception{
					Thread.sleep(2000);
					return "Task id: " + taskId + " \nThread Name: " +Thread.currentThread().getName();
				}
			});
			
			futures.add(future);
		}
		
		System.out.println(msg);
		return futures;
		
	}

}
