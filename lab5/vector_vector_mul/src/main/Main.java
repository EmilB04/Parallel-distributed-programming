package main;

import parallel.VectorVectorMulParallel;
import serial.VectorVectorMulSerial;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args){
        int result;
        int N = 100;
        int[] vectorA = arrayGen(N);
        int[] vectorB = arrayGen(N);

        // TODO: Your code to calculate serial running time
        VectorVectorMulSerial serialTask = new VectorVectorMulSerial();

        long serialTime = 0;
        System.out.println("Serial program returns " + serialTask.multiSerial(vectorA, vectorB) + " during " + serialTime + " (ns)");

        // TODO: Your code to calculate parallel running time
        VectorVectorMulParallel parallelTask = new VectorVectorMulParallel();
        long parallelTime = 0;
        System.out.println("Parallel program returns " + parallelTask.multiParallel(vectorA,vectorB) + " during " + parallelTime + " (ns)");

        // TODO: Your code to calculate speedup

    }
    // code to generate a random array of size N
    public static int[] arrayGen(int N){
       int[] a = new int[N];
       for (int i = 0; i <N; i++){
            a[i] = ThreadLocalRandom.current().nextInt(10);
        }
        return a;
    }
}
