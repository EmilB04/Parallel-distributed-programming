package main;

import java.util.concurrent.ThreadLocalRandom;
import parallel.VectorVectorMulParallel;
import serial.VectorVectorMulSerial;

public class Main {
    public static void main(String[] args) {
        int N = 2000000;
        int[] vectorA = arrayGen(N);
        int[] vectorB = arrayGen(N);

        VectorVectorMulSerial serialTask = new VectorVectorMulSerial();
        long serialStart = System.nanoTime();
        int serialResult = serialTask.multiSerial(vectorA, vectorB);
        long serialEnd = System.nanoTime();
        long serialTime = serialEnd - serialStart;
        System.out.println("Serial program returns " + serialResult + " during " + serialTime + " (ns)");

        VectorVectorMulParallel parallelTask = new VectorVectorMulParallel();
        long parallelStart = System.nanoTime();
        int parallelResult = parallelTask.multiParallel(vectorA, vectorB);
        long parallelEnd = System.nanoTime();
        long parallelTime = parallelEnd - parallelStart;
        System.out.println("Parallel program returns " + parallelResult + " during " + parallelTime + " (ns)");


        if (parallelTime > 0) {
            double speedup = (double) serialTime / (double) parallelTime;
            System.out.println("Speedup is " + speedup);
        } else {
            System.out.println("Speedup is undefined (parallel time is 0 ns)");
        }
    }

    // code to generate a random array of size N
    public static int[] arrayGen(int N) {
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = ThreadLocalRandom.current().nextInt(10);
        }
        return a;
    }
}
