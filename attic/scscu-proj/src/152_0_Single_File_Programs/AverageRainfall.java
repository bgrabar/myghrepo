import javax.swing.JOptionPane;
import java.text.DecimalFormat;
import java.util.Scanner;

// NOTE: This programs takes user input through dialog boxes and displays output through the console (or command line).

/**
 This program determines the average monthly rainfall for a specific number of years.
*/ 

public class AverageRainfall
{
    public static void main(String[] args)
    {
    
        String input, month;
        int numberOfYears, jan = 0, feb = 0, mar = 0, apr = 0, may = 0, jun = 0, jul = 0, aug = 0, sep = 0, oct = 0, nov = 0, dec = 0;
        double inchesForMonth, rainTotal = 0, rainAvg;
        
        input = JOptionPane.showInputDialog("Enter the number of years for which to determine average rainfall.");
        numberOfYears = Integer.parseInt(input);
        
        while (numberOfYears < 1)
        {
            input = JOptionPane.showInputDialog("You must enter 1 or higher. Re-enter the number " + 
                                                "of years for which to determine average rainfall.");
            numberOfYears = Integer.parseInt(input);
        }
        
        // Gather rainfall amounts. Loop through each year.
        
        for (int yearIncrement = 1; yearIncrement <= numberOfYears; yearIncrement++)
        {
            
            // Loop through each month in the year.
            
            for (int monthIncrement = 1; monthIncrement <= 12; monthIncrement++)
            {
              
              // For each month, set the "month" variable to the name of the month.
              
              if (monthIncrement == 1)
                    month = "January";
              else if (monthIncrement == 2)
                    month = "February";
              else if (monthIncrement == 3)
                    month = "March";
              else if (monthIncrement == 4)
                    month = "April";
              else if (monthIncrement == 5)
                    month = "May";
              else if (monthIncrement == 6)
                    month = "June";
              else if (monthIncrement == 7)
                    month = "July";
              else if (monthIncrement == 8)
                    month = "August";
              else if (monthIncrement == 9)
                    month = "September";
              else if (monthIncrement == 10)
                    month = "October";
              else if (monthIncrement == 11)
                    month = "November";
              else
                    month = "December";
              
  /*        NOTE: I'd originally done the above with this:
                            switch (monthIncrement)
                            {
                              case 1:
                                month = "January";
                                break;
                              case 2:
                                month = "February";
                                break;
                              case 3:
                                month = "March";
                                break;
                              case 4:
                                month = "April";
                                break;
                              case 5:
                                month = "May";
                                break;
                              case 6:
                                month = "June";
                                break;
                              case 7:
                                month = "July";
                                break;
                              case 8:
                                month = "August";
                                break;
                              case 9:
                                month = "September";
                                break;
                              case 10:
                                month = "October";
                                break;
                              case 11:
                                month = "November";
                                break;
                              case 12:
                                month = "December";
                                break;
                              default:
                                month = "   ";     // If I don't do this, I get a compilation error
                            }        */
              
              // Get current month's amount from user.
              
              input = JOptionPane.showInputDialog("Enter the rainfall for " + month + " of year " + yearIncrement + ".");
              inchesForMonth = Double.parseDouble(input);
              
              // Ensure the rainfall amount is 0 or greater. If it's not, request new input.
              
              while (inchesForMonth < 0)
              {
                  input = JOptionPane.showInputDialog("You must enter 0 or higher. Re-enter the rainfall " + 
                                                      "for " + month + " of year " + yearIncrement + ".");
                  inchesForMonth = Double.parseDouble(input);
              }
              
              // Record info for bar graph
              
              if (month.equals("January"))
                    jan = (int)inchesForMonth;
              else if (month.equals("February"))
                    feb = (int)inchesForMonth;
              else if (month.equals("March"))
                    mar = (int)inchesForMonth;
              else if (month.equals("April"))
                    apr = (int)inchesForMonth;
              else if (month.equals("May"))
                    may = (int)inchesForMonth;
              else if (month.equals("June"))
                    jun = (int)inchesForMonth;
              else if (month.equals("July"))
                    jul = (int)inchesForMonth;
              else if (month.equals("August"))
                    aug = (int)inchesForMonth;
              else if (month.equals("September"))
                    sep = (int)inchesForMonth;
              else if (month.equals("October"))
                    oct = (int)inchesForMonth;
              else if (month.equals("November"))
                    nov = (int)inchesForMonth;
              else
                    dec = (int)inchesForMonth;
                            
              // Calculate the cumulative total rainfall.
              
              rainTotal = rainTotal + inchesForMonth;
              
            }       // CLOSE OF THE MONTH LOOP.
            
            // Display a bar chart for the current year. (This displays to the console/command line.)
            
            System.out.println("Bar chart of monthly rainfall for year " + yearIncrement + ".");
            System.out.print("Jan: ");
            for (int barIncrement = 1; barIncrement <= jan; barIncrement++)
              System.out.print("X");
            
            System.out.println(" ");
            System.out.print("Feb: ");
            for (int barIncrement = 1; barIncrement <= feb; barIncrement++)
              System.out.print("X");
            System.out.println(" ");
            
            System.out.print("Mar: ");
            for (int barIncrement = 1; barIncrement <= mar; barIncrement++)
              System.out.print("X");
            System.out.println(" ");
            
            System.out.print("Apr: ");
            for (int barIncrement = 1; barIncrement <= apr; barIncrement++)
              System.out.print("X");
            System.out.println(" ");
            
            System.out.print("May: ");
            for (int barIncrement = 1; barIncrement <= may; barIncrement++)
              System.out.print("X");
            System.out.println(" ");
            
            System.out.print("Jun: ");
            for (int barIncrement = 1; barIncrement <= jun; barIncrement++)
              System.out.print("X");
            System.out.println(" ");
            
            System.out.print("Jul: ");
            for (int barIncrement = 1; barIncrement <= jul; barIncrement++)
              System.out.print("X");
            System.out.println(" ");
            
            System.out.print("Aug: ");
            for (int barIncrement = 1; barIncrement <= aug; barIncrement++)
              System.out.print("X");
            System.out.println(" ");
            
            System.out.print("Sep: ");
            for (int barIncrement = 1; barIncrement <= sep; barIncrement++)
              System.out.print("X");
            System.out.println(" ");
            
            System.out.print("Oct: ");
            for (int barIncrement = 1; barIncrement <= oct; barIncrement++)
              System.out.print("X");
            System.out.println(" ");
            
            System.out.print("Nov: ");
            for (int barIncrement = 1; barIncrement <= nov; barIncrement++)
              System.out.print("X");
            System.out.println(" ");
            
            System.out.print("Dec: ");
            for (int barIncrement = 1; barIncrement <= dec; barIncrement++)
              System.out.print("X");
            System.out.println(" ");
            
            System.out.println(" ");   // Put lines between bar graphs.
            System.out.println(" ");
            
        }               // CLOSE THE YEAR LOOP.
        
        // Calculate average rainfall per month.
        
        rainAvg = rainTotal / (numberOfYears * 12);
        
        // Display the outputs.
        
        DecimalFormat twoPlaces = new DecimalFormat("#0.00");    // Display values with two decimal places
        System.out.println("The total rainfall for the " + numberOfYears * 12 + " months is " + twoPlaces.format(rainTotal) + " inches.");
        System.out.println("The average rainfall per month during that time is " + twoPlaces.format(rainAvg) + " inches.");
        
        // Allow results to stay on screen until user presses the Enter key
        
        Scanner fromKeyboard = new Scanner(System.in);    // Create a scanner object to read user keyboard input
        System.out.println("To exit, press Enter.");        // Tell users that to exit they must press Enter
        input = fromKeyboard.nextLine();
        
        // End the program
        
        System.exit(0);
    }
}