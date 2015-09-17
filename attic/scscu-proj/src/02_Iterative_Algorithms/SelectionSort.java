// Order of n squared

// This sorts an integer array of size n. The array's integers are randomized.

import java.io.IOException;
import java.util.Random;

public class SelectionSort {
    public static void main(String[] args) throws IOException {
        
        // Select size of array
        int n = 100;
//        int n = 1000;
//        int n = 10000;
//        int n = 100000;
//        int n = 500000;
//        int n = 1000000;
        
        // Populate array with random integers
        int[] array = new int[n];
        Random randomGenerator = new Random();
        for (int i = 0; i <n; i++) {
          array[i] = randomGenerator.nextInt(n);
        }
        
        // Sstart timer
        long start = System.nanoTime();
        for (int i=0; i<array.length-1; i++) {
            for (int j=i+1; j<array.length; j++) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        // Stop timer
        long end = System.nanoTime();
        long time = (end - start);
        
        System.out.println("The access time is " + time + ".");
    }
}
