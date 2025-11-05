package P500;
import java.util.LinkedList;
import java.util.Queue;

public class Printerqueue
{
    public static void main(String[] args)
    {
        Queue<String> printerQueue = new LinkedList<>();

    
        printerQueue.add("Document1");
        System.out.println("Enqueued: Document1");
        printerQueue.add("Document2");
        System.out.println("Enqueued: Document2");
        printerQueue.add("Document3");
        System.out.println("Enqueued: Document3");

        System.out.println("\nProcessing jobs...");

        while (!printerQueue.isEmpty()) 
        {
            String job = printerQueue.poll(); 
            System.out.println("Processing: " + job);
            System.out.println("Remaining Queue: " + printerQueue);
        }

        System.out.println("\nAll jobs processed successfully!");
    }
}