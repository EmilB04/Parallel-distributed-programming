package main;

import tree.Tree;
import utils.Utils;
import dfs_serial.*;
import dfs_parallel.*;

public class DfsMain {
    public static void main(String[] args) {
        int RUNS = 10;
        long startTime, endTime;
        SerialDepthFirstSearch serialDepthFirstSearch = new SerialDepthFirstSearch();
        ParallelDepthFirstSearch parallelDepthFirstSearch = new ParallelDepthFirstSearch();

        System.out.println("DFS: Generating tree...");
        Tree tree = Utils.generateTree(10, 10);

        for(int run = 1; run <= RUNS; run++){
            System.out.println("RUN #" + run);

            System.out.println("Running Serial DFS...");
            // if your tree is too small, you should measure execution time in microsecond to avoid zero running time and Infinitive speedup,
            // change this method accordingly
            startTime = System.currentTimeMillis();
            serialDepthFirstSearch.serialDFS(tree.getRoot());
            endTime = System.currentTimeMillis();
            System.out.println("Serial version took " + (endTime - startTime) + " miliseconds");

            // Clear the visit flag
            tree.unvisit();

            //TODO: Implement parallel DFS here
            System.out.println("Running Parallel DFS...");
            System.out.println("Parallel version took ... miliseconds");

            // Clear the visit flag
            tree.unvisit();
        }
        //TODO: Compute speedup
    }
}
