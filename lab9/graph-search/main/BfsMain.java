package main;
import bfs_parallel.ParallelBreadthFirstSearch;
import bfs_serial.*;
import tree.Tree;
import utils.Utils;

public class BfsMain {
    public static void main(String[] args) {
        int RUNS = 1;
        long startTime, endTime;
        SerialBreadthFirstSearch serialBreadthFirstSearch = new SerialBreadthFirstSearch();
        ParallelBreadthFirstSearch parallelBreadthFirstSearch = new ParallelBreadthFirstSearch();

        System.out.println("BFS: Generating tree...");
        Tree tree = Utils.generateTree(10, 1000);

        for(int run = 1; run <= RUNS; run++){
            System.out.println("RUN #" + run);

            System.out.println("Running Serial BFS...");
            // if your tree is too small, you should measure execution time in microsecond to avoid zero running time and Infinitive speedup,
            // change this method accordingly
            startTime = System.currentTimeMillis();
            serialBreadthFirstSearch.serialBFS(tree.getRoot());
            endTime = System.currentTimeMillis();
            System.out.println("Serial version took " + (endTime - startTime) + " miliseconds");

            //Clear the visit flag
            tree.unvisit();

            // Parallel BFS
            System.out.println("Running Parallel BFS...");
            startTime = System.currentTimeMillis();
            parallelBreadthFirstSearch.parallelBFS(tree.getRoot());
            endTime = System.currentTimeMillis();
            System.out.println("Parallel version took " + (endTime - startTime) + " miliseconds");

            //TODO: Compute speedup for each run

            //Clear the visit flag
            tree.unvisit();
        }
        //TODO: Compute average speedup
    }
}
