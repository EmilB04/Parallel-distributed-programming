package main;

import java.util.Date;
import java.util.List;

import data.BankMarketing;
import loader.BankMarketingLoader;
import parallel.group.KnnClassifierParallelGroup;
import serial.KnnClassifier;

public class Main {

    public static void main(String[] args) {
        BankMarketingLoader loader = new BankMarketingLoader();
        List<BankMarketing> train = loader.load("executor-knn\\data\\bank.data");
        System.out.println("Train: " + train.size());
        List<BankMarketing> test = loader.load("executor-knn\\data\\bank.test");
        System.out.println("Test: " + test.size());

        int k = 10;
        final int RUNS = 1;
        double parallelRun = 0d, parallelRunWithSorting = 0d, serialRun = 0d;

        // Parallel run without parallel sorting
        KnnClassifierParallelGroup parallelClassifier = new  KnnClassifierParallelGroup(train, k, 1, false);
        for(int i = 0; i < RUNS; i++)
        {
            System.out.println("Parallel Run (without sorting) #" + i);
            parallelRun += runParallel(train, test, k, parallelClassifier);
        }
        parallelRun = parallelRun/(1000.0 * RUNS);
        System.out.println("Average Parallel Run Time: " + parallelRun);
        parallelClassifier.destroy();

        // Parallel run with parallel sorting
        parallelClassifier = new  KnnClassifierParallelGroup(train, k, 1, true);
        for(int i = 0; i < RUNS; i++)
        {
            System.out.println("Parallel Run (with sorting) #" + i);
            parallelRunWithSorting += runParallel(train, test, k, parallelClassifier);
        }
        parallelRunWithSorting = parallelRunWithSorting/(1000.0 * RUNS);
        System.out.println("Average Parallel Run Time: " + parallelRunWithSorting);
        parallelClassifier.destroy();

        // Serial run
        KnnClassifier serialClassifier = new KnnClassifier(train, k);
        for(int i = 0; i < RUNS; i++)
        {
            System.out.println("Serial Run #" + i);
            serialRun += runSerial(train, test, k, serialClassifier);

        }
        serialRun = serialRun/ (1000.0 * RUNS);
        System.out.println("Average Serial Run Time: " + serialRun);


        //TODO: Compute the speed up for the two versions of parallel run (with and without parallel sorting)

    }

    private static double runSerial(List<BankMarketing> train, List<BankMarketing> test, int k, KnnClassifier classifier)
    {
        double currentTime = 0d;
        int success = 0, mistakes = 0;
        try {
            Date start, end;
            start = new Date();
            for (BankMarketing example : test) {
                String tag = classifier.classify(example);
                if (tag.equals(example.getTag())) {
                    success++;
                } else {
                    mistakes++;
                }
            }
            end = new Date();

            currentTime = end.getTime() - start.getTime();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("******************************************");
        System.out.println("Serial Classifier - K: " + k);
        System.out.println("Success: " + success);
        System.out.println("Mistakes: " + mistakes);
        System.out.println("Execution Time: " + (currentTime / 1000)
                + " seconds.");
        System.out.println("******************************************");

        return currentTime;
    }

    private static double runParallel(List<BankMarketing> train, List<BankMarketing> test, int k, KnnClassifierParallelGroup classifier)
    {
        double currentTime = 0d;
        int success = 0, mistakes = 0;


        try {
            Date start, end;
            start = new Date();
            for (BankMarketing example : test) {
                String tag = classifier.classify(example);
                if (tag.equals(example.getTag())) {
                    success++;
                } else {
                    mistakes++;
                }
            }
            end = new Date();

            currentTime = end.getTime() - start.getTime();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("******************************************");
        System.out.println("Parallel Classifier Individual - K: " + k
                + " - Factor 1");
        System.out.println("Success: " + success);
        System.out.println("Mistakes: " + mistakes);
        System.out.println("Execution Time: " + (currentTime / 1000)
                + " seconds.");
        System.out.println("******************************************");

        return currentTime;
    }

}