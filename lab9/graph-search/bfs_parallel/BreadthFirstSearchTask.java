package bfs_parallel;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import tree.TreeNode;

public class BreadthFirstSearchTask implements Runnable {

    private ConcurrentLinkedQueue<TreeNode> nodes;
    private ConcurrentLinkedQueue<String> visitedList;
    private static final AtomicInteger activeThreads = new AtomicInteger(0);

    public BreadthFirstSearchTask(ConcurrentLinkedQueue<TreeNode> nodes, ConcurrentLinkedQueue<String> visitedList) {
        this.nodes = nodes;
        this.visitedList = visitedList;
    }

    @Override
    public void run() {
        while (true) {
            TreeNode currentNode = nodes.poll();
            if (currentNode != null) {
                activeThreads.incrementAndGet();
                visitedList.add(currentNode.getName());
                for (TreeNode child : currentNode.getChildren()) {
                    nodes.add(child);
                }
                activeThreads.decrementAndGet();
            } else if (activeThreads.get() == 0 && nodes.isEmpty()) {
                break; // All threads idle and queue empty
            }
        }
    }
}