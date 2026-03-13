package utils;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import tree.Tree;
import tree.TreeNode;

public class Utils {
    public static Tree generateTree(int maxChild, int numNodes){
        int i = 0;
        TreeNode root = new TreeNode(i, String.valueOf(i));
        Tree tree = new Tree(root);

        Random rand = new Random(20260311);
        List<TreeNode> parents = new LinkedList<TreeNode>();
        List<TreeNode> children = new LinkedList<TreeNode>();

        parents.add(root);
        while(i < numNodes){
            for(TreeNode n : parents){
                int numChild = rand.nextInt(maxChild) + 1;
                for(int j = 1; j <= numChild; j++){
                    TreeNode childNode = new TreeNode(++i, String.valueOf(i));
                    n.addChild(childNode);
                    children.add(childNode);
                }
            }
            parents.clear();
            List<TreeNode> temp = parents;
            parents = children;
            children = temp;
        }
        System.out.println("Size of Tree is: " + i);
        return tree;
    }
}
