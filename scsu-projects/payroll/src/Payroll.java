// has ???

// CSC 153, Project 6, main program

import javax.swing.JOptionPane;

/**
 * Payroll class
 */

public class Payroll
{
    private static int[] employeeID = {5658845, 4520125, 7895122, 8777541, 8451277, 1302850, 7580489};
    private static int[] hours = new int[7];
    private static double[] payRate = new double[7];
    private static double[] wages = new double[7];
    private static String input;
    
    // is there a way to pass in the hours array and fill it and pass it out ???
    public static void setHours()
    {
        for (int i = 0; i < 7; i++)
        {
            input = JOptionPane.showInputDialog("What are the hours for " + employeeID[i] + "?");
            hours[i] = Integer.parseInt(input);
        }
    }
    
    public static void setRate()
    {
        for (int i = 0; i < 7; i++)
        {
            input = JOptionPane.showInputDialog("What is the pay rate for " + employeeID[i] + "?");
            payRate[i] = Double.parseDouble(input);
        }
    }
    
    public static double[] getWage()
    {
        for (int i = 0; i < 7; i++)
        	wages[i] = hours[i] * payRate[i];
        return wages;
    }
}