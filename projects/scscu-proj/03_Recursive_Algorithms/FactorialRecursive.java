import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class FactorialRecursive
{
    public static void main(String[] args)
    {
        String input;
        int index;
        int factorial;
        
        input = JOptionPane.showInputDialog(null, "Enter a number from 1 to 12 to determine its factorial.");
        index = Integer.parseInt(input);
        
        while (index > 12 || index < 0)
        {
            input = JOptionPane.showInputDialog(null, "You must enter a number from 1 to 12.");
            index = Integer.parseInt(input);
        }
        
        factorial = myFactorial(index);
        
        DecimalFormat formatter = new DecimalFormat("#,###.##");
        JOptionPane.showMessageDialog(null, "The factorial of " + index + " is " + formatter.format(factorial) + ".");
        
        System.exit(0);
    }
    
    public static int myFactorial(int integer)
    {
        if (integer == 1)
            return 1;
        else 
            return (integer * myFactorial(integer - 1));
    }
}