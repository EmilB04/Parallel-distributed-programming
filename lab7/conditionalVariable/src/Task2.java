public class Task2 implements Runnable {
    private TaskController controller;
    public Task2(TaskController controller) {
        this.controller = controller;
    }
    public void run() {
        controller.Task2();
    }
}
