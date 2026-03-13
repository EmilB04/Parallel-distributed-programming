package main;
import tree.Tree;
import utils.Utils;
import bfs_serial.*;

public class BfsMain {
    public static void main(String[] args) {
        int RUNS = 1;
        long startTime, endTime;
        SerialBreadthFirstSearch serialBreathFirstSearch = new SerialBreadthFirstSearch();

        System.out.println("BFS: Generating tree...");
        Tree tree = Utils.generateTree(10, 1000);

        for(int run = 1; run <= RUNS; run++){
            System.out.println("RUN #" + run);

            System.out.println("Running Serial BFS...");
            // if your tree is too small, you should measure execution time in microsecond to avoid zero running time and Infinitive speedup,
            // change this method accordingly
            startTime = System.currentTimeMillis();
            serialBreathFirstSearch.serialBFS(tree.getRoot());
            endTime = System.currentTimeMillis();
            System.out.println("Serial version took " + (endTime - startTime) + " miliseconds");

            //Clear the visit flag
            tree.unvisit();
            //TODO: Implement parallel BFS here
            System.out.println("Running Parallel BFS...");
            System.out.println("Parallel version took ... miliseconds");

            //TODO: Compute speedup for each run

            //Clear the visit flag
            tree.unvisit();
        }
        //TODO: Compute average speedup
    }
}
