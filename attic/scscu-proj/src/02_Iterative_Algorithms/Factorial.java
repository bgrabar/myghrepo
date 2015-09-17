import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class Factorial
{
    public static void main(String[] args)
    {
        String input;
        int[] array = new int[12];
        int index;
        int factorial = 1;
        
        input = JOptionPane.showInputDialog(null, "Enter a number from 1 to 12 to determine its factorial.");
        index = Integer.parseInt(input);
        
        while (index > 12 || index < 0)
        {
            input = JOptionPane.showInputDialog(null, "You must enter a number from 1 to 12.");
            index = Integer.parseInt(input);
        }
        
        for (int i = 0; i < index; i++)
            array[i] = i + 1;
        
        for (int i = 0; i < index; i++)
            factorial *= array[i];
        
        DecimalFormat formatter = new DecimalFormat("#,###.##");
        JOptionPane.showMessageDialog(null, "The factorial of " + index + " is " + formatter.format(factorial) + ".");
        
        System.exit(0);
    }
}