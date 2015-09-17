// Bob Grabar, CSC 153, Project 2, p537 #12

import java.util.Scanner;
import java.io.IOException;

/**
* TwoDArraysOperations creates a two-dimensional array with test data and performs arithmetic operations on it. The main method includes a switch statement for user input and displaying console output.
* @param array The two-dimensional array
*/

public class TwoDArrayOperations
{
    private static int[][] array = new int [5][15];

    public static void main(String args[]) throws IOException
    {
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 15; j++)
                array[i][j] = i;

        Scanner keyboard = new Scanner(System.in);
        int num;    // user input for switch statement
        int entry;  // method input
        int answer; // return values

        System.out.println("Type the method to run and press Enter:\n" +
                "1 - get total\n" +
                "2 - get average\n" +
                "3 - get row total\n" +
                "4 - get column total\n" +
                "5 - get highest in row\n" +
                "6 - get lowest in row\n" +
                "7 - display array");
        num = keyboard.nextInt();
        switch (num)
        {
          case (1):
              answer = getTotal(array);
              System.out.println(answer);
              break;
          case (2):
              double average = getAverage(array);
              System.out.println(average);
              break;
          case (3):
              System.out.println("Enter a row from 0 to 4");
              entry = keyboard.nextInt();
              answer = getRowTotal(array, entry);
              System.out.println(answer);
              break;
          case (4):
              System.out.println("Enter a colum from 0 to 14");
              entry = keyboard.nextInt();
              answer = getColTotal(array, entry);
              System.out.println(answer);
              break;
          case (5):
              System.out.println("Enter a row from 0 to 4");
              entry = keyboard.nextInt();
              answer = getHighestInRow(array, entry);
              System.out.println(answer);
              break;
          case (6):
              System.out.println("Enter a row from 0 to 4");
              entry = keyboard.nextInt();
              answer = getLowestInRow(array, entry);
              System.out.println(answer);
              break;
          case (7):
              displayArray();
              break;
        }
    }

/**
* displayArray displays the array of test data
*/
    public static void displayArray() // This method is not part of the assignment.
    {
        for (int i = 0; i < 5; i++)
        {
            for (int j = 0; j < 15; j++)
            {
              array[i][j] = i;
              System.out.print(array[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

/**
* getTotal adds all the numbers in the array
*/
    public static int getTotal(int[][] a)
    {
        int sum = 0;
        for (int i = 0; i < a.length; i++)
        {
            for (int j = 0; j < a[i].length; j++)
              sum += array[i][j];
        }
        return sum;
    }

/**
* getAverage gets the average of all the numbers in the array
*/
    public static double getAverage(int[][] a)
    {
        int sum = 0;
        double divisor = 0;
        double avg = 0;

        for (int i = 0; i < a.length; i++)
        {
            for (int j = 0; j < a[i].length; j++)
            {
                sum += array[i][j];
                divisor++;
            }
        }

        avg = sum / divisor;
        return avg;
    }

/**
* getRowTotal sums up a chosen row passed in as an argument.
*/
    public static int getRowTotal(int[][] a, int r)
    {
        int sum = 0;
        for (int j = 0; j < a[r].length; j++)
              sum += array[r][j];
        return sum;
    }

/**
* getColTotal sums up a chosen column passed in as an argument.
*/
    public static int getColTotal(int[][] a, int c)
    {
        int sum = 0;
        for (int i = 0; i < a.length; i++)
              sum += array[i][c];
        return sum;
    }

/**
* getHighestInRow finds the largest number in a chosen row passed in as an argument.
*/
    public static int getHighestInRow(int[][] a, int r)
    {
        int high = a[r][0];
        for (int j = 1; j < a[r].length; j++)
        {
            if (high < a[r][j])
                high = a[r][j];
        }
        return high;
    }

/**
* getLowestInRow finds the lowest number in a chosen row passed in as an argument.
*/
    public static int getLowestInRow(int[][] a, int r)
    {
        int low = a[r][0];
        for (int j = 1; j < a[r].length; j++)
        {
            if (low > a[r][j])
                low = a[r][j];
        }
        return low;
    }
}