package dfs_serial;

import tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class SerialDepthFirstSearch {

    private List<Integer> visitOrder;

    public SerialDepthFirstSearch(){
        visitOrder = new ArrayList<Integer>();
    }

    public void resetVisitOrder(){
        visitOrder.clear();
    }

    public List<Integer> getVisitOrder(){
        return visitOrder;
    }

    public void serialDFS(TreeNode node){
        if(!node.isVisited()){
            node.visit();
            visitOrder.add(node.getId());
            // recursive call to serialDFS for each child node
            for (TreeNode child : node.getChildren()) {
                serialDFS(child);
            }
        }
    }

}
