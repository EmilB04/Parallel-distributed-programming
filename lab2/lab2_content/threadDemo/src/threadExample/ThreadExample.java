package threadExample;
class Task extends Thread{
    public void run()
    {
        try
        {
            // Displaying the thread that is running
            System.out.println ("Thread " + Thread.currentThread().getId() + " is running");
            Thread.sleep(500);
            System.out.print("Thread " + Thread.currentThread().getId() + " has finished\n");
        }
        catch (Exception e)
        {
            // Throwing an exception
            System.out.println ("Exception is caught");
        }
    }
}
public class ThreadExample {
    public static void main(String[] args){
        int n = 10; // number of threads
        for (int i = 0; i < n; i ++){
            Task obj = new Task();
            obj.start();
        }
    }
}
