package dfs_serial;

import tree.TreeNode;

public class SerialDepthFirstSearch {

    public void serialDFS(TreeNode node){
        if(!node.isVisited()){
            node.visit();
            //TODO: continue the implementation of DFS
            //Hint: recursive call to serialDFS for each child node

        }

    }

}
