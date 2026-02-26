import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
public class MeetingBarrier implements Meeting{
    private CyclicBarrier barrier;
    public MeetingBarrier(int number){
        //TODO: Initialize the barrier
        // with the constructor CyclicBarrier(int parties, Runnable barrierAction)
    }

    public void arrive(String name){
        // TODO: Use barrier to implement this method() to produce the expected output
        // You many want to use getParties() and getNumberWaiting() in barrier
    }

    public void run() {
        System.out.printf("Project Meeting: Initialization: %d participants.\n",barrier.getParties());
        // Starts the meeting
        System.out.println("Project Meeting: Let's start the meeting...");
    }
}
