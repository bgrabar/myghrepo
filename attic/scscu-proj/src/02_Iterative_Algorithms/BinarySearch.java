import java.util.Scanner;

public class BinarySearch
{
    public static void main(String[] args)
    {
        int numbers[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        int result, searchValue;
        String input;
        Scanner keyboard = new Scanner(System.in);
        do {
            System.out.print("Enter a search value: ");
            searchValue = keyboard.nextInt();
            result = binarySrch(numbers, searchValue);
            
            if (result == -1)
                System.out.println(searchValue + " was not found.");
            else
                System.out.println(searchValue + " was found at element " + result);
            
            keyboard.nextLine();
            
            System.out.print("Do you want to search again? (Y or N): ");
            input = keyboard.nextLine();
            
        } while (input.charAt(0) == 'y' || input.charAt(0) == 'Y');
        
        
        System.out.println("Good bye");
        
        
    }
    
    // binary search method  
    public static int binarySrch(int[] array, int value)
    {
        int first, last, mid, position;
        boolean found;
        
        first = 0;
        last = array.length - 1;
        position = -1;
        found = false;
        
        while (!found && first <= last)
        {
            mid = (first + last) / 2;
            
            if (array[mid] == value)
            {
                found = true;
                position = mid;
            }
            else if (array[mid] > value)
                last = mid - 1;
            else
                first = mid + 1;
        }
         
        // Return either the position of the item or -1
        
        return position;
    }
}