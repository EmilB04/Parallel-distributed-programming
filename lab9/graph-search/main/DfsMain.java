package main;

import dfs_parallel.*;
import dfs_serial.*;
import tree.Tree;
import utils.Utils;

public class DfsMain {
    public static void main(String[] args) {
        int RUNS = 1;
        long startTime, endTime;
        long serialTotal = 0;
        long parallelTotal = 0;
        SerialDepthFirstSearch serialDepthFirstSearch = new SerialDepthFirstSearch();
        ParallelDepthFirstSearch parallelDepthFirstSearch = new ParallelDepthFirstSearch();

        System.out.println("DFS: Generating tree...");
        Tree tree = Utils.generateTree(10, 10);

        for(int run = 1; run <= RUNS; run++){
            System.out.println("RUN #" + run);

            System.out.println("Running Serial DFS...");
            // if your tree is too small, you should measure execution time in microsecond to avoid zero running time and Infinitive speedup,
            // change this method accordingly
            serialDepthFirstSearch.resetVisitOrder();
            startTime = System.currentTimeMillis();
            serialDepthFirstSearch.serialDFS(tree.getRoot());
            endTime = System.currentTimeMillis();
            long serialTime = endTime - startTime;
            serialTotal += serialTime;
            System.out.println("Serial version took " + serialTime + " miliseconds");
            System.out.println("Serial visiting order: " + serialDepthFirstSearch.getVisitOrder());

            // Clear the visit flag
            tree.unvisit();

            //TODO: Implement parallel DFS here
            System.out.println("Running Parallel DFS...");
            parallelDepthFirstSearch.resetVisitOrder();
            startTime = System.currentTimeMillis();
            parallelDepthFirstSearch.parallelDFS(tree.getRoot());
            endTime = System.currentTimeMillis();
            long parallelTime = endTime - startTime;
            parallelTotal += parallelTime;
            System.out.println("Parallel version took " + parallelTime + " miliseconds");
            System.out.println("Parallel visiting order: " + parallelDepthFirstSearch.getVisitOrder());

            // Clear the visit flag
            tree.unvisit();
        }
        // Compute average times and speedup
        double avgSerial = (double) serialTotal / (double) RUNS;
        double avgParallel = (double) parallelTotal / (double) RUNS;
        if (avgParallel > 0) {
            double speedup = avgSerial / avgParallel;
            System.out.println("Average serial time: " + avgSerial + " ms");
            System.out.println("Average parallel time: " + avgParallel + " ms");
            System.out.println("Speedup (serial/parallel): " + speedup);
        } else {
            System.out.println("Average parallel time is zero, cannot compute speedup.");
        }
    }
}
