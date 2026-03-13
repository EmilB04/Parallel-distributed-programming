package bfs_serial;
import java.util.LinkedList;
import java.util.Queue;

import tree.Tree;
import tree.TreeNode;
import utils.Utils;
public class SerialBreadthFirstSearch {
    public void serialBFS(TreeNode root) {
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);

        while (!nodes.isEmpty()) {
            TreeNode node = nodes.poll();
            if (!node.isVisited()) {
                //TODO: continue the implementation of BFS
                // Visit the node
                // Add the child to the Queue

            }
        }
    }
}
