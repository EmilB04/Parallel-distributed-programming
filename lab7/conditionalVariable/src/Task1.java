public class Task1 implements Runnable {

    private TaskController controller;
    public Task1(TaskController controller) {
        this.controller = controller;
    }

    public void run() {
        controller.Task1();
    }
}
