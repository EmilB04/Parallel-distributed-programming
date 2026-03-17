package main;
import bfs_parallel.ParallelBreadthFirstSearch;
import bfs_serial.*;
import tree.Tree;
import utils.Utils;

public class BfsMain {
    public static void main(String[] args) {
        int RUNS = 20;
        long totalSerialTime = 0, totalParallelTime = 0;
        SerialBreadthFirstSearch serialBreadthFirstSearch = new SerialBreadthFirstSearch();
        ParallelBreadthFirstSearch parallelBreadthFirstSearch = new ParallelBreadthFirstSearch();

        System.out.println("BFS: Generating tree...");
        Tree tree = Utils.generateTree(5, 50000);

        for (int run = 1; run <= RUNS; run++) {
            System.out.println("\nRUN #" + run);

            // Serial BFS
            System.out.println("Running Serial BFS...");
            long startTimeSerial = System.currentTimeMillis();
            serialBreadthFirstSearch.serialBFS(tree.getRoot());
            long serialTime = System.currentTimeMillis() - startTimeSerial;
            System.out.println("Serial version took " + serialTime + " milliseconds");
            totalSerialTime += serialTime;

            // Clear the visit flag
            tree.unvisit();

            // Parallel BFS
            System.out.println("Running Parallel BFS...");
            long startTimeParallel = System.currentTimeMillis();
            parallelBreadthFirstSearch.parallelBFS(tree.getRoot());
            long parallelTime = System.currentTimeMillis() - startTimeParallel;
            System.out.println("Parallel version took " + parallelTime + " milliseconds");
            totalParallelTime += parallelTime;

            double speedup = (double) serialTime / (double) parallelTime;
            System.out.println("Speedup (serial/parallel) for run #" + run + ": " + speedup);

            // Clear the visit flag
            tree.unvisit();
        }

        System.out.println("\n--- Summary over " + RUNS + " runs ---");
        System.out.println("Total Serial Time  : " + totalSerialTime + " ms");
        System.out.println("Total Parallel Time: " + totalParallelTime + " ms");
        double averageSpeedup = (double) totalSerialTime / (double) totalParallelTime;
        System.out.println("Average Speedup (serial/parallel): " + averageSpeedup);
    }
}
