import java.util.Random;
import java.io.*;

public class Randomize
{
    public static void main(String[] args) throws IOException
    {
        int[] sortedArray = {10, 11, 22, 29, 30, 33, 44, 49, 50, 55, 60, 79, 80, 99};
        int[] unsortedArray = new int[14];
        
        Random randomGenerator = new Random();
        
        for (int i = 0; i <= 13; i++)
        {
          unsortedArray[i] = sortedArray[randomGenerator.nextInt(14) - 1];
          System.out.print(unsortedArray[i] + ", ");
        }
    }
}
