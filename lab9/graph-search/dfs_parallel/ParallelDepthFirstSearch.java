package dfs_parallel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import tree.TreeNode;


public class ParallelDepthFirstSearch {
    private List<Integer> visitOrder;

    public ParallelDepthFirstSearch() {
        visitOrder = Collections.synchronizedList(new ArrayList<Integer>());
    }

    public List<Integer> getVisitOrder(){
        return visitOrder;
    }

    public void resetVisitOrder(){
        visitOrder.clear();
    }

    public void parallelDFS(TreeNode node) {
        ConcurrentLinkedQueue<TreeNode> nodes = new ConcurrentLinkedQueue<>();

        // visit root and record
        node.visit();
        visitOrder.add(node.getId());
        for(TreeNode child : node.getChildren())
            nodes.add(child);

        // Create the executor
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors
                .newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        // Number of task to create
        int numTasks = Runtime.getRuntime().availableProcessors();

        // Create the task and submit them to the executor
        for (int i = 0; i < numTasks; i++) {
            DepthFirstSearchTask task = new DepthFirstSearchTask(nodes, visitOrder);
            executor.execute(task);
        }

        executor.shutdown();

        try {
            executor.awaitTermination(1, TimeUnit.DAYS);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}