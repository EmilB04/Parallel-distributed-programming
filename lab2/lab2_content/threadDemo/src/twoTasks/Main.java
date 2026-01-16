package twoTasks;
public class Main{
    public static void main(String[] args){
        int n = 10; // Number of threads

        // First Task
        System.out.printf("Executing the Task1\n");
        for (int i=0; i<n; i++){
            Thread object1 = new Thread(new Task1());
            object1.start();
        }


        // Second Task
        System.out.printf("Executing the Task2\n");
        for (int i=0; i<5; i++){
            Thread object2 = new Thread(new Task2());
            object2.start();
        }
    }
}