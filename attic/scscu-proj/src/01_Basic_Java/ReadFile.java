import java.util.Scanner;
import javax.swing.JOptionPane;
import java.io.*;

/**
This program creates a copy of a file in which all the file's text is in upper case.
*/

public class ReadFile
{
    public static void main(String[] args) throws IOException
    {
        String lineToRead;
        
        String nameOfSourceFile = JOptionPane.showInputDialog("Type the name of the file to read, " +
                "including extension.");
        File fileToRead = new File(nameOfSourceFile);
        Scanner inputFile = new Scanner(fileToRead);
        
        String newFile = JOptionPane.showInputDialog("Type the name of the new file, " +
                "including extension.");
        PrintWriter outputToFile = new PrintWriter(newFile);
        
        while (inputFile.hasNext())
        {
             lineToRead = inputFile.nextLine();  // Read the next unread line from the input file
             lineToRead = lineToRead.toUpperCase(); // Change the text to upper case
             outputToFile.println(lineToRead);   // Append the file and change characters to upper case
        }
        
        inputFile.close();
        outputToFile.close();
        
        System.exit(0);
    }
}