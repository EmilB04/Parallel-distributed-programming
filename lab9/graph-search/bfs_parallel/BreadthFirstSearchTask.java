package bfs_parallel;

import java.util.concurrent.ConcurrentLinkedQueue;
import tree.TreeNode;

public class BreadthFirstSearchTask implements Runnable {
    private ConcurrentLinkedQueue<TreeNode> nodes;

    public BreadthFirstSearchTask(ConcurrentLinkedQueue<TreeNode> nodes) {
        this.nodes = nodes;
    }

    @Override
    public void run() {
        // TODO: Implement parallel BFS task here
        while (!nodes.isEmpty()) {
            TreeNode currentNode = nodes.poll();
            if (currentNode != null) {
                // Process the current node (e.g., print its value)
                System.out.println(currentNode.getName());

                // Add child nodes to the queue
                for (TreeNode child : currentNode.getChildren()) {
                    nodes.add(child);
                }
            }
        }
    }
}
