/**
 * SavingsAccount class
 * @param rate The annual interest rate.
 * @param balance The starting balance.
 * @param monthlyRate The monthly interest rate.
 * @param interestEarned The monthly interest earned.
 * @param totalInterestEarned The total interest earned in the time period.
 */


public class SavingsAccount
{
    private double rate,
                   balance,
                   monthlyRate,
                   interestEarned = 0,
                   totalInterestEarned = 0;
    
    /**
     * Constructor
     * @param annualRate The savings account's annual interest rate.
     * @param startingBalance The savings account's balance.
     */
    
    public SavingsAccount(double annualRate, double startingBalance)
    {
        rate = annualRate;
        monthlyRate = (rate / 12);
        balance = startingBalance;
    }
  
    /**
     * The subtractWithdrawal method subtacts a withdrawal from the current balance.
     * @param withdrawal The amount of the withdrawal.
     */
    
    public double subtractWithdrawal(double withdrawal)
    {
        balance = balance - withdrawal;
        return balance;
    }
    
    /** 
     * The addDeposit method adds a deposit to the current balance.
     * @param deposit The amount of the deposit.
     */
    
    public double addDeposit(double deposit)
    {
        balance = balance + deposit;
        return balance;
    }
    
    /**
     * The addMonthlyInterest method adds the monthly interest.
     */
    
    public double addMonthlyInterest()
    {
        interestEarned = balance * monthlyRate;
        balance = balance + interestEarned;
        totalInterestEarned = totalInterestEarned + interestEarned;
        return balance;
    }
  
    public double getInterestEarned()
    {
        return totalInterestEarned;
    }
  }