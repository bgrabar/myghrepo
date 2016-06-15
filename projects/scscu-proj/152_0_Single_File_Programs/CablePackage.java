import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class CablePackage
{
  public static void main(String[] args)
  {
    String input;
    char plan;
    double hours, charge, savingsWithC, savingsWithB;
    
    DecimalFormat chargeDollars = new DecimalFormat("#0.00");
    
    input = JOptionPane.showInputDialog("Which package did you purchase, A, B, or C?");
    input = input.toUpperCase();
    plan = input.charAt(0);
    
    while (plan != 'A' && plan != 'B' && plan != 'C')
    {
      JOptionPane.showMessageDialog(null,"You have not entered a valid package.");
      input = JOptionPane.showInputDialog("Which package did you purchase, A, B, or C?");
      input = input.toUpperCase();
      plan = input.charAt(0);
    }
    
    if (plan == 'C')
    {
      JOptionPane.showMessageDialog(null,"This month's charge for package C is $19.95.");
      hours = 0;   
      charge = 0;
    }
    else
    {
      input = JOptionPane.showInputDialog("How many hours did you use?");
      hours = Double.parseDouble(input);
      if (plan == 'A')
      {
        if (hours - 10 > 0)
          charge = 9.95 + (2 * (hours - 10));
        else
          charge = 9.95;
      }
      else
      {
        if (hours - 20 > 0)
          charge = 13.95 + (1 * (hours - 20));
        else
          charge = 13.95;
      }
      JOptionPane.showMessageDialog(null,"This month's charge for package " + plan + 
              " with " + hours + " hours of use is $" + chargeDollars.format(charge) + ".");
    }
    
    if (plan == 'A' && charge > 19.95)
    {
      savingsWithC = charge - 19.95;
      savingsWithB = charge - 13.95;
      JOptionPane.showMessageDialog(null,"If you had purchased package C, you would " + 
              "have saved $" + chargeDollars.format(savingsWithC) + " this month." + 
              "\nIf you had purchased package B, you would have saved $" + 
              chargeDollars.format(savingsWithB) + " this month.");
    }
    if (plan == 'A' && charge > 13.95 && charge <= 19.95)
    {
      savingsWithB = charge - 13.95;
      JOptionPane.showMessageDialog(null,"If you had purchased package B, you would " + 
    		  "have saved $" + chargeDollars.format(savingsWithB) + " this month.");
    }
    if (plan == 'B' && charge > 19.95)
    {
      savingsWithC = charge - 19.95;
      JOptionPane.showMessageDialog(null,"If you had purchased package C, you would " + 
    		  "have saved $" + chargeDollars.format(savingsWithC) + " this month.");
    }
    System.exit(0);
  }
}