import javax.swing.JOptionPane;
import java.text.DecimalFormat;
import java.io.*;

/**
 * CalculateSavingsAccountBalance program. This program calculates the balance 
 * of a savings account at the end of a period of time.
 * @param input The user input string.
 * @param interestRate The annual interest rate.
 * @param startingBalance The starting balance.
 * @param numberOfMonths The number of months for which to calculate withdrawals, deposits and 
 * accumulated interest.
 * @param deposit The amount deposited in a given month.
 * @param withdrawal The amount withdrawn in a given month.
 * @param balance The savings account's current balance.
 * @param totalDeposits The total amount of deposits in the time period.
 * @param totalWithdrawals The total amount withdrawals in the time period.
 * @param totalInterest The total interest earned in the time period.
 */

public class CalculateSavingsAccountBalance {

    public static void main(String[] args) throws IOException {
    
        String input;
        int numberOfMonths;
        double interestRate,
               startingBalance,
               deposit,
               withdrawal,
               balance = 0,
               totalDeposits = 0,    // accumulator
               totalWithdrawals = 0, // accumulator
               totalInterest = 0;    // accumulator
        
        input = JOptionPane.showInputDialog("Enter the annual interest rate as a percentage."); 
        interestRate = Double.parseDouble(input);
        interestRate /= 100;
        
        input = JOptionPane.showInputDialog("Enter the account's starting balance."); 
        startingBalance = Double.parseDouble(input);
        
        SavingsAccount account = new SavingsAccount(interestRate, startingBalance);
        
        input = JOptionPane.showInputDialog("Enter the number of months since the account opened."); 
        numberOfMonths = Integer.parseInt(input);
        
        for (int i=1; i <= numberOfMonths; i++) {
            
            input = JOptionPane.showInputDialog("Enter total deposits for month " + i + ":");
            deposit = Double.parseDouble(input);
            balance = account.addDeposit(deposit);
            
            input = JOptionPane.showInputDialog("Enter total withdrawals for month " + i + ":");
            withdrawal = Double.parseDouble(input);
            balance = account.subtractWithdrawal(withdrawal);
            
            balance = account.addMonthlyInterest();
            
            totalDeposits = totalDeposits + deposit;
            totalWithdrawals = totalWithdrawals + withdrawal;
            totalInterest = account.getInterestEarned();
           
        }
        
        DecimalFormat formatter = new DecimalFormat("#0.00");
        
        JOptionPane.showMessageDialog(null, "Balance is " + formatter.format(balance) + ".\n" + 
                "Total deposits are " + totalDeposits + ".\n" + 
                "Total withdrawals are " + totalWithdrawals + ".\n" + 
                "Total interest is " + formatter.format(totalInterest) + ".\n");
        
        System.exit(0);  
    }
}