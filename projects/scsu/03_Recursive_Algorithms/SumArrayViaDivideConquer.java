import javax.swing.JOptionPane;

public class SumArrayViaDivideConquer
{
    public static void main(String[] args)
    {
        int[] array = {6, 1, 4, 5, 7, 9, 8, 3, 10, 2};
        int first = 0;
        int last = 9;
        int sum;
        
        sum = sumArray(first, last, array);
        
        System.out.println(sum);
    }
    
    public static int sumArray(int low, int high, int[] a)
    {
        int mid = (high + low)/2;
        if (high == low)                 // BASE CASE
        {
            JOptionPane.showMessageDialog(null, "High (" + high + ") equals low.\n\n a[low] = " + 
                    a[low] + "\n\nlow is " + low + "\nmid is " + mid + "\nhigh is " + high);
            return a[low];
        }
        else
        {
            JOptionPane.showMessageDialog(null, "low is " + low + "\nmid is " + 
                    mid + "\nhigh is " + high);
            return (sumArray(low, mid, a) + sumArray((mid + 1), high, a));
        }
    }
    
    public static int counter(int count)
    {
        int counter = count + 1;
        return counter;
    }
}