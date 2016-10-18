import java.util.Scanner;
import java.io.*;

/**
   This program determines whether a number is a prime number.
*/

public class DetermineIfPrime
{
    public static void main(String[] args) throws IOException
    {
        boolean primeNum;
        
        Scanner keyboard = new Scanner(System.in);
        
        System.out.print("To determine whether a number is prime, enter the number.\n");
        int num = keyboard.nextInt();
        
        primeNum = isPrime(num);
        
        if (primeNum == false)
            System.out.print(num + " is not prime.");
        else
            System.out.print(num + " is prime.");

        keyboard.close();
    }
    
    /**
         The isPrime method determines whether a number is prime.
         @param number The number to be tested.
         @return Returns the boolean value true if the number is prime.
     */
     
    public static boolean isPrime(int number) throws IOException
    {
        // Declare the return variable. This will return the value true if the number is prime.
        boolean bool = true;
        
        for (int counter = number; counter > 2; counter = counter - 1)
        {
            if (number % (counter - 1) == 0)
            {
              bool = false;
            }
        }
        
        return bool;
    }
}