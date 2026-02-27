import java.util.concurrent.CyclicBarrier;
public class MeetingBarrier implements Meeting{
    private CyclicBarrier barrier;
    public MeetingBarrier(int number){
        //TODO: Initialize the barrier
        // with the constructor CyclicBarrier(int parties, Runnable barrierAction)
        barrier = new CyclicBarrier(number, this);
    }

    public void arrive(String name){
        // TODO: Use barrier to implement this method() to produce the expected output
        // You many want to use getParties() and getNumberWaiting() in barrier
        try {
            synchronized(this) { // Added to ensure that the print statements are not interleaved
                System.out.printf("%s has arrived.\n", name);
                int remaining = barrier.getParties() - barrier.getNumberWaiting() - 1;
                if (remaining > 0) {
                    System.out.printf("Project Meeting: Waiting for %d remaining participants.\n", remaining);
                }
            }
            barrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void run() {
        System.out.println("The remaning participant has arrived. All the participants are there!");
        System.out.printf("Project Meeting: Initialization: %d participants.\n",barrier.getParties());
        // Starts the meeting
        System.out.println("Project Meeting: Let's start the meeting...");
    }
}
