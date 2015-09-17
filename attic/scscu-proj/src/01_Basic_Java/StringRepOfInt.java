import java.util.Scanner;

/**
 * @param i input
 * 
 */

public class StringRepOfInt {

    public static void main(String[] args) {
        
        boolean quit = false;
        
        int num;
        Scanner keyboard = new Scanner(System.in);
        
        while (!quit)
        {
            System.out.println("Enter an integer:");
            
            num = keyboard.nextInt();
            
            keyboard.nextLine();
            
            System.out.println("You entered " + num + ", and the " +
                    "binary representation is " + Integer.toBinaryString(num) + ".");
            
            System.out.println("To quit enter 0. To continue enter an integer other than 0 (such as 1).");
            
            if (keyboard.nextInt() == 0)
                quit = true;
            
            keyboard.nextLine();
        }
        
        System.out.println("Good bye");
        
        System.exit(0);
    }
}
