import java.util.Scanner;

// This uses the Integer class

public class ConvertIntToBinary {

    public static void main(String[] args) {
        
        boolean quit = false;
        int num;
        Scanner keyboard = new Scanner(System.in);
        String choice = "z";

        while (!quit)
        {
            System.out.println("Enter an integer:");

            // Need to handle case where user enters a non-number
            
            num = keyboard.nextInt();
            System.out.println("num = keyboard grabbed nextInt");

            keyboard.nextLine();
            System.out.println("keyboard grabbed nextLine");

            System.out.println("You entered " + num + ", and the " +
                    "binary representation is " + Integer.toBinaryString(num) + ".");

            choice = "z";
            
           	while (!choice.equals("q") && !choice.equals("c")) {
           		System.out.println("To continue type \"c\". To quit type \"q\".");
                choice = keyboard.next();

                // If the user just hits Enter, this hangs until they type something else.
                // I haven't figured out a way to prompt the user when this happens.
                
                if (choice.equals("q"))
                    quit = true;
                keyboard.nextLine();
            }
           	
        }
        
        System.out.println("Good bye");
        keyboard.close();
        System.exit(0);
    }
}
