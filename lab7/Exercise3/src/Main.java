public class Main {
    public static void main(String[] args) {
        //TODO: Creates a barrier with 5 participants.
        MeetingBarrier meeting = new MeetingBarrier(5);
        
        // TODO: Creates 5 participants, a thread for each one
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new Participant(meeting, "Participant " + i));
            thread.start();
        }
    }
}

