import java.util.concurrent.Callable;

public class Task implements Callable<Long> {

    private final int taskNumber;
    
    public Task(int taskNumber){
        this.taskNumber = taskNumber;
    }
    
    @Override
    public Long call() throws Exception {
        // Calculate the summation from 1 to taskNumber
        long sum = 0;
        for (int i = 1; i <= taskNumber; i++) {
            sum += i;
        }
        
        // Print the result
        System.out.printf("Task %d: Sum from 1 to %d = %d\n", taskNumber, taskNumber, sum);
        
        return sum;
    }
}
