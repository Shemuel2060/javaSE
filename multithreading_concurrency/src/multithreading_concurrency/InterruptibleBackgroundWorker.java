package multithreading_concurrency;


/**
 * This code example illustrates cooperative cancellation
 */
public class InterruptibleBackgroundWorker implements Runnable {

    @Override
    public void run() {
        // Keep checking interruption state
        while (!Thread.currentThread().isInterrupted()) { 
            try {
                System.out.println("Thread Working...");
                Thread.sleep(500); // Sleep for 500 milliseconds
            } catch (InterruptedException e) {
                System.out.println("Worker stopped mid-sleep...");
                
                // IMPROVEMENT: Removed e.printStackTrace() because this is planned control flow.
                System.out.println("Stopping interrupted thread cleanly.");
                
                // Re-assert interrupted flag to alert outer structures
                Thread.currentThread().interrupt();
                
                // IMPROVEMENT: Explicit break ensures we exit the loop immediately
                break; 
            } 
        }
        System.out.println("Worker thread has fully shut down.");
    }
    
    public static void main(String args[]) {
        Runnable interruptibleBackgroundWorker = new InterruptibleBackgroundWorker();
        Thread interruptibleThread = new Thread(interruptibleBackgroundWorker);
        
        interruptibleThread.start();
        
        try {
            System.out.println("Putting main thread to sleep...");
            Thread.sleep(2000); 
        } catch (InterruptedException e) {
            // IMPROVEMENT: Good practice to handle/re-assert main thread interrupts too
            Thread.currentThread().interrupt();
            
        } 
        
        System.out.println("\nSignaling worker thread for interruption from main thread");
        interruptibleThread.interrupt(); 
    }
}
