import java.text.DecimalFormat;
import java.util.Scanner;
import java.io.*;

/**
This program determines the cost and labor to paint a user-determined number of rooms.
*/

public class PaintJobEstimator
{
    public static void main(String[] args) throws IOException
    {
        double totalSquareFeet = 0, totalGallons, totalCostPaint, totalHoursLabor, totalLaborCosts, totalCostAll;
        int squareFeet;
        
        Scanner keyboard = new Scanner(System.in);
        
        DecimalFormat outputFormat = new DecimalFormat("#0.00");
        
        // Get the number of rooms to paint
        
        System.out.print("How many rooms do you want to paint?");
        int numRooms = keyboard.nextInt();
        keyboard.nextLine();               // consume carriage return
        
        // Get the price per gallon of paint
        
        System.out.print("What is the price per gallon of paint?");
        double pricePaint = keyboard.nextDouble();
        keyboard.nextLine();               // consume carriage return
        
        // Get square feet of each room and calculate totals and costs
        
        for (int num = 1; num <= numRooms; num++)
        {
            // Get the square feet of wall space in the room
            
            System.out.print("What is room " + num + "\'s wall space in square feet?");
            squareFeet = keyboard.nextInt();
            keyboard.nextLine();               // Consume carriage return
            totalSquareFeet = totalSquareFeet + (double)squareFeet;
        }
        
        // Calculate totals
        
        totalGallons = getGallons(totalSquareFeet);
        totalCostPaint = getCostPaint(totalGallons, pricePaint);
        totalHoursLabor = getHoursLabor(totalSquareFeet);
        totalLaborCosts = getCostLabor(totalHoursLabor);
        totalCostAll = getCostTotal(totalCostPaint, totalLaborCosts);
        
        // Print labor and cost information
        
        System.out.println("Total gallons of paint: " + outputFormat.format(totalGallons));
        System.out.println("Total cost of paint: " + outputFormat.format(totalCostPaint));
        System.out.println("Total hours of labor: " + outputFormat.format(totalHoursLabor));
        System.out.println("Total cost of labor: " + outputFormat.format(totalLaborCosts));
        System.out.println("Total cost of job: " + outputFormat.format(totalCostAll));
    }
    
    /**
    The getGallons method determines the number of gallons of paint required.
    */
    
    public static double getGallons(double squareFeet)
    {
        double gallons = squareFeet / 115;
        return gallons;
    }
    
    /**
    The getCostPaint method determines the cost of the paint.
    */
    
    public static double getCostPaint(double gallons, double price)
    {
        double costPaint = gallons * price;
        return costPaint;
    }
    
    /**
    The getHoursLabor method determines the hours of labor required.
    */
    
    public static double getHoursLabor(double squareFeet)
    {
        double hoursLabor = squareFeet / 115 * 8;
        return hoursLabor;
    }
    
    /**
    The getCostLabor method determines the labor charges.
    */
    
    public static double getCostLabor(double hours)
    {
        double costLabor = (double)18 * hours;
        return costLabor;
    }
    
    /**
    The getCostTotal method determines the total cost of the paint job.
    */
    
    public static double getCostTotal(double paint, double labor)
    {
        double costTotal = paint + labor;
        return costTotal;
    }
}