// CSC 212 sec 01 Project 1

import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class MyTriangle
{
    
    private int X1, X2, X3;
    private int Y1, Y2, Y3;
    private double Side1 = 0.0;
    private double Side2 = 0.0;
    private double Side3 = 0.0;
    private double Perimeter;
    private double Area;
    
    public MyTriangle()   // constructor
    {
        X1=X2=X3 = 0;
        Y1=Y2=Y3 = 0;
        Perimeter = 0.0f;
        Area = 0.0f;
    }
    
    public void GetCoordinates()
    {
        String input = JOptionPane.showInputDialog(null, "Please enter an integer:",
                "Enter X1", JOptionPane.QUESTION_MESSAGE);
        X1 = Integer.parseInt(input);
        
        input = JOptionPane.showInputDialog(null, "Please enter an integer:",
                "Enter Y1", JOptionPane.QUESTION_MESSAGE);
        
        Y1 = Integer.parseInt(input);
        
        input = JOptionPane.showInputDialog(null, "Please enter an integer:",
                "Enter X2", JOptionPane.QUESTION_MESSAGE);
        X2 = Integer.parseInt(input);
        
        input = JOptionPane.showInputDialog(null, "Please enter an integer:",
                "Enter Y2", JOptionPane.QUESTION_MESSAGE);
        Y2 = Integer.parseInt(input);
        
        input = JOptionPane.showInputDialog(null, "Please enter an integer:",
                "Enter X3", JOptionPane.QUESTION_MESSAGE);
        X3 = Integer.parseInt(input);
        
        input = JOptionPane.showInputDialog(null, "Please enter an integer:",
                "Enter Y3", JOptionPane.QUESTION_MESSAGE);
        Y3 = Integer.parseInt(input);
        
        // Display the coordinates
        
        JOptionPane.showMessageDialog(null,
                "X1 = "+((Integer)X1).toString()+"    Y1 = "+((Integer)Y1).toString()+"\n"+
                "X2 = "+((Integer)X2).toString()+"    Y2 = "+((Integer)Y2).toString()+"\n"+
                "X3 = "+((Integer)X3).toString()+"    Y3 = "+((Integer)Y3).toString()+"\n",
                "Coordinates of three points of Triangle",
                JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void DisplayResults()
    {
        CalculatePerimeter();
        CalculateArea();
        
        // display information
        
        DecimalFormat formatter = new DecimalFormat("#0.0");
        
        JOptionPane.showMessageDialog(null,
                "First point:              (" + X1 + "," + Y1 + ")\n" +
                "Second Point:        (" + X2 + "," + Y2 + ")\n" +
                "Third Point:             (" + X3 + "," + Y3 + ")\n" +
                "Side 1:                     " + formatter.format(Side1) + "\n" +
                "Side 2:                     " + formatter.format(Side2) + "\n" +
                "Side 3:                     " + formatter.format(Side3) + "\n" +
                "Perimeter:              " + formatter.format(Perimeter) + "\n" +
                "Area:                        " + formatter.format(Area),
                "Results",
                JOptionPane.INFORMATION_MESSAGE);

    }
    
    public void CalculatePerimeter()
    {
        // calculate perimeter
        
        Side1 = Math.sqrt(Math.pow((double)(X1 - X2), 2.0) + Math.pow((double)(Y1 - Y2), 2.0));
        Side2 = Math.sqrt(Math.pow((double)(X1 - X3), 2.0) + Math.pow((double)(Y1 - Y3), 2.0));
        Side3 = Math.sqrt(Math.pow((double)(X2 - X3), 2.0) + Math.pow((double)(Y2 - Y3), 2.0));
        Perimeter = Side1 + Side2 + Side3;
    }
    
    public void CalculateArea()
    {
        // calculate area
        
        double S = Perimeter / 2;
        Area = Math.sqrt(S * (S - Side1) * (S - Side2) * (S - Side3));
    }
}