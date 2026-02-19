package producerConsumer;

public class Producer implements Runnable {
    private QueueBuffer buffer;
    public Producer(QueueBuffer buffer){
        this.buffer=buffer;
    }

    /**
     * This class creates a producer task.
     * The task generates 100 items.
     * However, the producer cannot put all 100 items to the buffer as buffer size is 10
     */

    public void run() {
        for (int i=0; i<100; i++){
            buffer.put();
        }
    }
}

