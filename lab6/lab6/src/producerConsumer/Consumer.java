package producerConsumer;

public class Consumer implements Runnable {
    private QueueBuffer buffer;
    public Consumer(QueueBuffer buffer){
        this.buffer=buffer;
    }

    /**
     * This class create a consumer task.
     * The task consumes 100 items.
     * However, the consumer cannot consume 100 items at once as there are no more than 10 items in the queue
     */
    public void run() {
        for (int i=0; i<100; i++){
            buffer.remove();
        }
    }

}
