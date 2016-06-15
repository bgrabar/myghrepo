import javax.swing.*;

public class FindLargestPrimeBelow
{
    public static void main(String[] args) 
    {
        String input;
        int numberOfDataItems;
        
        input = JOptionPane.showInputDialog("Enter a number to find the nearest prime less than the number.");
        numberOfDataItems = Integer.parseInt(input);
        
        int largestPrime = 0;
        boolean isPrime = false;
        
        for (int i = numberOfDataItems; i > 1; i -= 1)
        {
            isPrime = true;
            for (int j = 2; j <= Math.sqrt(numberOfDataItems); j++)
            {
                if (i % j == 0)
                {
                    isPrime = false;
                }
            }
            if (isPrime == true)
            {
                largestPrime = i;
                break;
            }
        }
        
        JOptionPane.showMessageDialog(null, "The nearest prime is " + largestPrime + ".");
    }
}