package serial;

public class VectorVectorMulSerial {
    public int multiSerial(int[] vector1, int[] vector2){
        int sum = 0;
        System.out.println("Serial program is running...");
        for (int i = 0; i < vector1.length; i++){
            sum +=vector1[i]*vector2[i];
        }
        return sum;
    }
}
