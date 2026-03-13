package dfs_parallel;

import java.util.concurrent.ConcurrentLinkedQueue;

import tree.Tree;
import tree.TreeNode;
import dfs_serial.SerialDepthFirstSearch;

public class DepthFirstSearchTask implements Runnable{


    private ConcurrentLinkedQueue<TreeNode> nodes;


    public DepthFirstSearchTask(ConcurrentLinkedQueue<TreeNode> nodes) {
        this.nodes = nodes;
    }

    public void run() {
        // TODO: Implement parallel DFS task here

    }

}
