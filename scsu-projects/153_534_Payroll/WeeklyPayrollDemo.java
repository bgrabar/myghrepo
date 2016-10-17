// CSC 153, Project 6, main program

import java.io.*;

/**
 * WeeklyPayrollDemo
 */

public class WeeklyPayrollDemo
{
    public double[] wages;  // public ??? and located here ???
    
    public void main(String[] args) throws IOException    // no static ???
    {
        Payroll.setHours();
        Payroll.setRate();
        wages = Payroll.getWage();
    }
}