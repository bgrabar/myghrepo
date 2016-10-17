/*
 * TopicAssignments class
 */

import java.io.*;
import javax.swing.JOptionPane;

/**
 * This class lists the titles of the ten volumes that scored highest for a given topic ID. The output is saved to a text file and 
 * can be added as additional information in the topic.keys file.
 * 
 * For input, this class uses:
 * 1. A text file that maps filenames to their document titles, as found in the Hathi Trust metadata. This mapping file is
 *    created using the findTitle.sh script, followed by some manual cleanup. For more information on creating this file, see
 *    Working.with.Hathi.Trust.docx located in /gds_02/dev/project.documents.
 * 2. The MALLET-generated document.topics file.
 * 
 * This class's default constructor creates an array of topicID objects.
 */

public class TopicAssignments {
    
    // Create an array that can hold 20 TopicID objects. CHANGE THIS NUMBER THROUGHOUT THIS FILE AS NEEDED
    private TopicID[] topicsArray = new TopicID[20];
    
    String pairingsFile = JOptionPane.showInputDialog("Type the name of the file that contains\n" + 
            "the text title and book title pairings,\n" + 
            "as extracted from the metadata files.");
    
    BookTitles bookTitles = new BookTitles(pairingsFile);
    
    /**
     * Reads the document.topics file and populates each topicID object with its associated document/score pairings.
     * @param f
     */
    public void getAssignments(String f) {
        
        // Record the name of the document.topics file to be read
        String docTopicsFile = f;
        
        FileReader fr = null;
        try {
            fr = new FileReader(docTopicsFile);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to read file. " + e.getMessage());
            e.printStackTrace();
        }
        BufferedReader br = new BufferedReader(fr);
        String line = null;
        
        // Read the first line of the file, which is the headers
        try {
            line = br.readLine();
        } catch (IOException e) {
            System.out.println("Unable to read file. " + e.getMessage());
            e.printStackTrace();
        }
        
        // Read the file and record the data
        try {
            String newFilename[];
            String newerFilename;
            String bookName;
            while ( (line = br.readLine()) != null ) {
                
                // Use the String.split method to parse the line's titles, IDs and scores
                String[] temp = line.split("\t");
                
                // Use the split and subtring methods to isolate the filename.
                newFilename = temp[1].split("\\.");
                newerFilename = newFilename[0].substring(52); // IMPORTANT: Change the substring parameter as needed,
                                                              // according to the output in your document.topics file.
                
                // Use the bookName class's getTitle method to get the human-readable title of the volume
                bookName = bookTitles.getTitle(newerFilename);
                
                // For the length of the line (as determined by the length of the array), add the pairing of volume name (bookName) 
                // and score ( Double.parseDouble(temp[x+1]) ) to the appropriate topicID object ( Integer.parseInt(temp[x]) ).
                for (int x=2; x < temp.length; x=x+2) {
                    topicsArray[Integer.parseInt(temp[x])].addNameAndScore(bookName, Double.parseDouble(temp[x+1]));
                    // System.out.print(bookName + " " + temp[x] + " " + temp[x+1] + " ");   // Tests that all data is being recorded
                }
            }
        
        } catch (IOException e) {
            System.out.println("Unable to read file. " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    /**
     *  Prints to stdout each topic ID and its top 10 assignments.
     */
    public void printToScreen() {
        
        // IMPORTANT: Change this number as needed
        for (int x = 0; x < 20 ; x++)
            System.out.println(topicsArray[x]);
    }
    
    /**
     *  Prints to a file each topic ID and its top 10 assignments.
     */
    public void printToFile() {
        
        String myOutputFile = JOptionPane.showInputDialog("Type the name and extension to which to print the\n" + 
                "top documents and scores assigned to each topic ID.");
        
        try {
            FileWriter fw;
            fw = new FileWriter(myOutputFile);
            BufferedWriter bw = new BufferedWriter(fw);
            
            // IMPORTANT: Change this number as needed
            for (int x = 0; x < 20 ; x++)
                bw.write(topicsArray[x] + "\n");
            bw.close();
            
        } catch (IOException e1) {
            System.out.println("Unable to create or write to file.");
            e1.printStackTrace();
        }
    }
    
    /** 
     * Lists the top ten files for each topic ID.
     * @param t Creates an object of this class
     * @param sourceFile The name of the MALLET-generated document topics file
     */
    public static void main(String[] args) {
        
        TopicAssignments t = new TopicAssignments();
        
        /* Populate the array with TopicID objects. The array length is equal to the number of topic IDs.
         * CHANGE THIS NUMBER AS NEEDED THROUGHOUT
         */
        for (int x = 0; x < 20 ; x++)
              t.topicsArray[x] = new TopicID(x);
        
        String docTopicsFile = JOptionPane.showInputDialog("Type the name of the doc topics file.\n" +
                "This is the file that lists the topic IDs\n" + 
                "assigned to each document.");
        
        t.getAssignments(docTopicsFile);   // Read the TopicIDs-per-document from the document.topics file,
                                           // and record them as documents-per-TopicID in TopicID objects
        
        t.printToScreen();                 // Print documents per TopicID to the screen
        
        t.printToFile();                   // Print documents per TopicID to a file
    }
}