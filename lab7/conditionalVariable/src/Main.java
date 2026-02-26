public class Main {
    public static void main(String[] args) {
        TaskController controller = new TaskController();
        Task1 conditionTask1 = new Task1(controller);
        Thread thread1 =  new Thread(conditionTask1);
        thread1.start();

        Task2 conditionTask2 = new Task2(controller);
        Thread thread2 = new Thread(conditionTask2);
        thread2.start();
    }
}
