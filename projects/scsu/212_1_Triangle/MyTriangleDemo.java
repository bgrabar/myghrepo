// CSC 212 sec 01 Project 1

import javax.swing.*;

public class MyTriangleDemo
{
    private MyTriangle T = new MyTriangle();
    
    public void menu()
    {
        char option = '0';
        
        while (option != '3')
        {
            Object[] possibleValues = { " 1) Enter Triangle Coordinates",
                                 " 2) Display Results",
                                 " 3) Quit "};
            
            Object selectedValue = JOptionPane.showInputDialog(null, "Choose an Option", "Triangle Operations",
                    JOptionPane.INFORMATION_MESSAGE, null, possibleValues, possibleValues[0]);
            
            String l = (String)selectedValue;
            option = l.charAt(1);
            
            switch (option)
            {
            case '1':
            {
                T.GetCoordinates();
                break;
            }
            case '2':
            {
                T.DisplayResults();
                break;
            }
            case '3':
            {
                break;
            }
            }
        }
        
    }
    
    public static void main(String[] args)
    {
          MyTriangleDemo m = new MyTriangleDemo();
          m.menu();
    }
}

