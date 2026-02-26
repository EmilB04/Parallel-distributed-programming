import java.util.Date;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
public class TaskController {
    private final ReentrantLock lock;
    private final Condition condition;
    private int turn;
    public TaskController() {
        lock = new ReentrantLock();
        condition = lock.newCondition();
        turn = 1;
    }
    public void Task1() {
        lock.lock();
        try {
            while (turn != 1)
                condition.await();
            System.out.println("The value of conditional variable is " + turn);
            System.out.println("Thread 1 " + ": Running the task");
            CommonTask.Task();
            System.out.println("Thread 1 " + ": Finishing the execution");
            turn = 2;
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void Task2() {
        lock.lock();
        try {
            while (turn != 2)
                condition.await();
            System.out.println("The value of conditional variable is " + turn);
            System.out.println("Thread 2: " +  ": Running the task");
            CommonTask.Task();
            System.out.println("Thread 2: " +  ": Finishing the execution");
            turn = 1;
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
