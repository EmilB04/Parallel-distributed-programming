package dfs_parallel;

import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import tree.TreeNode;

public class DepthFirstSearchTask implements Runnable{


    private ConcurrentLinkedQueue<TreeNode> nodes;
    private List<Integer> visitOrder;

    public DepthFirstSearchTask(ConcurrentLinkedQueue<TreeNode> nodes, List<Integer> visitOrder) {
        this.nodes = nodes;
        this.visitOrder = visitOrder;
    }

    @Override
    public void run() {
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.poll();
            if (node != null && !node.isVisited()) {
                node.visit();
                // record visit order (thread-safe list provided by caller)
                visitOrder.add(node.getId());
                for (TreeNode child : node.getChildren()) {
                    nodes.add(child);
                }
            }
        }
    }

}
