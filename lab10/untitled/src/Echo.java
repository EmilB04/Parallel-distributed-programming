import java.util.Random;
import mpi.*;

public class Echo{
    public static void main(String args[]) throws Exception
    {
        int me,size;

        args = MPI.Init(args);
        me = MPI.COMM_WORLD.Rank();
        size = MPI.COMM_WORLD.Size();

        if(size!=2){
            System.out.println("Run the Echo example with 2 processes!");
            MPI.Finalize();
            System.exit(1);
        }

        Random random = new Random(20261203);
        int data[]=new int[1];

        // Process 0 sends 5 messages to Process 1
        int numMessages = 5;
        
        if(me==0){
            System.out.println("\n=== Process 0: Sending " + numMessages + " messages ===");
            for(int i = 1; i <= numMessages; i++){
                data[0] = random.nextInt(100);
                MPI.COMM_WORLD.Send(data, 0, 1, MPI.INT, 1, 10);
                System.out.println("  Message " + i + ": Sending number " + data[0] + " to Process 1");
            }
        }
        else {
            System.out.println("\n=== Process 1: Waiting to receive " + numMessages + " messages ===");
            for(int i = 1; i <= numMessages; i++){
                MPI.COMM_WORLD.Recv(data, 0, 1, MPI.INT, 0, 10);
                System.out.println("  Message " + i + ": Received number " + data[0] + " from Process 0");
            }
        }
        
        MPI.Finalize();
    }
}
