import java.util.concurrent.TimeUnit;
public class Participant implements Runnable {
    private Meeting meeting;
    private String name;
    public Participant(Meeting meeting, String name) {
        this.meeting=meeting;
        this.name=name;
    }

    @Override
    public void run() {
        Long duration=(long)(Math.random()*10);
        try {
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        meeting.arrive(name);
    }
}
