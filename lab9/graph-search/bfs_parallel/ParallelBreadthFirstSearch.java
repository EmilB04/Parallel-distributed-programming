package bfs_parallel;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import tree.TreeNode;
import utils.Utils;

public class ParallelBreadthFirstSearch {
    public void parallelBFS(TreeNode root) {
        if (root == null) {
            return;
        }

        ConcurrentLinkedQueue<TreeNode> queue = new ConcurrentLinkedQueue<>();
        ConcurrentLinkedQueue<String> visitedList = new ConcurrentLinkedQueue<>();
        queue.add(root);

        int numTasks = Runtime.getRuntime().availableProcessors();
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(numTasks);

        for (int i = 0; i < numTasks; i++) {
            executor.submit(new BreadthFirstSearchTask(queue, visitedList));
        }

        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new IllegalStateException("Parallel BFS interrupted", e);
        }
        
        // Print the visiting list
        System.out.println("\nVisiting order: " + visitedList);
    }

    public static void main(String[] args) {
        TreeNode root = Utils.generateTree(10, 1_000).getRoot();
        new ParallelBreadthFirstSearch().parallelBFS(root);
    }
}
