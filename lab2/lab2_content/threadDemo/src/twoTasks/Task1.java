package twoTasks;

public class Task1 implements Runnable{
    public void run(){
        try{
            // Displaying the thread that is running
            System.out.println ("Type 1, Thread : " + Thread.currentThread().getId() + " is running...");

            Thread.sleep(500);
            System.out.print("Type 1, Thread : " + Thread.currentThread().getId() + " has finished\n");
        }
        catch (Exception e){
            // Throwing an exception
            System.out.println ("Exception caught");
        }
    }
}
