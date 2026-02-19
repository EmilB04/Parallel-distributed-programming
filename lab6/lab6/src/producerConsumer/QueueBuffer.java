package producerConsumer;

import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;


public class QueueBuffer {
    /**
     * Queue Size
     */
    private int maxSize;
    /**
     * Storage of items
     */
    private Queue<Date> storage;

    /**
     * Class instructor.
     */
    public QueueBuffer(){
        maxSize=10;
        storage=new LinkedList<>();
    }

    /**
     * Put an item in the queue.
     */
    public synchronized void put(){

        storage.add(new Date());
        System.out.printf("Put: %d\n",storage.size());

    }

    /**
     * Remove the first item in the queue. Stop removing when the queue is empty.
     */
    public synchronized void remove(){

        String item=storage.poll().toString();
        System.out.printf("Remove: %d: \n",storage.size());

    }

}