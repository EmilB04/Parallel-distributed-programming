public class FinishBarrierTask implements Runnable {
    public void run() {
        System.out.println("FinishFirstPhase: All the tasks have finished sleeping");
        System.out.println("FinishFirstPhase: Now moving to the next Phase");
    }
}
