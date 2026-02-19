package producerConsumer;public class Main {

    public static void main(String[] args) {

        // Creates an event storage
        QueueBuffer buffer=new QueueBuffer();

        // Creates a Producer Thread
        Producer producer=new Producer(buffer);
        Thread thread1=new Thread(producer);

        // Creates a Consumer Thread
        Consumer consumer=new Consumer(buffer);
        Thread thread2=new Thread(consumer);

        // Starts and joins the threads
        thread1.start();
        thread2.start();

        try {
            thread1.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            thread2.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
