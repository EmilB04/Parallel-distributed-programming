package bfs_parallel;
import java.util.concurrent.ConcurrentLinkedQueue;

import tree.Tree;
import tree.TreeNode;
import utils.Utils;
import bfs_serial.SerialBreadthFirstSearch;

public class BreadthFirstSearchTask implements Runnable{
    private ConcurrentLinkedQueue<TreeNode> nodes;
    public BreadthFirstSearchTask(ConcurrentLinkedQueue<TreeNode> nodes) {
        this.nodes = nodes;
    }

    public void run() {
        // TODO: Implement parallel BFS task here
    }

}
