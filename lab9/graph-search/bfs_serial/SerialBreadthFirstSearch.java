package bfs_serial;
import java.util.LinkedList;
import java.util.Queue;

import tree.TreeNode;
public class SerialBreadthFirstSearch {
    public void serialBFS(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);

        while (!nodes.isEmpty()) {
            TreeNode node = nodes.poll();
            if (!node.isVisited()) {
                // Visit current node before expanding to avoid revisiting in graphs with cycles.
                node.visit();
                for (TreeNode child : node.getChildren()) {
                    if (!child.isVisited()) {
                        nodes.add(child);
                    }
                }
            }
        }
    }
}
