import javax.swing.JOptionPane;

public class SumNumbers
{
    public static void main(String[] args)
    {
      String input;
      int number, counter = 1, sum = 0;
      
      input = JOptionPane.showInputDialog("Enter an integer.");
      number = Integer.parseInt(input);
      
      while (counter <= number)
        sum = sum + counter++;
      
      JOptionPane.showMessageDialog(null,"The sum is " + sum + ".");
      
      System.exit(0);
    }
}