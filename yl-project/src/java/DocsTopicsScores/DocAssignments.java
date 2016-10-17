/*
 * DocAssignments class
 */

import java.util.*;
import java.io.*;
import javax.swing.JOptionPane;

/**
 * Reads the MALLET-generated document.topics file to create a list of documents and topic/score pairings for upload to a database.
 */

public class DocAssignments {
    
    // Create an ArrayList for the Document objects
    private ArrayList<DocID> docIDarray = new ArrayList<DocID>();
    
    String pairingsFile = JOptionPane.showInputDialog("Type the name of the file that contains\n" + 
            "the text title and book title pairings,\n" + 
            "as extracted from the metadata files.");
    
    BookTitles bookTitles = new BookTitles(pairingsFile);
    
    /**
     * Reads the MALLET-generated document.topics file and populates each DocID object with topic/score pairings.
     * @param f
     */
    public void getAssignments(String f) {
        
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
                
                // Use the String.split method to parse the line's text titles and scores
                String[] temp = line.split("\t");
                
                // Use the split method to isolate the path and filename.
                newFilename = temp[1].split("\\.");
                // Use the substring method to lop off all but the relative path
                newerFilename = newFilename[0].substring(52);
                // Use the bookName class's getTitle method to get the human-readable title of the volume
                bookName = bookTitles.getTitle(newerFilename);
                
                for (int x=2; x < temp.length; x=x+2) {
                    docIDarray.add(new DocID(bookName, Integer.parseInt(temp[x]), Double.parseDouble(temp[x+1])));
                    // System.out.print(bookName + " " + temp[x] + " " + temp[x+1] + " ");   // Test
                }
            }
            
        } catch (IOException e) {
            System.out.println("Unable to read file. " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    /**
     *  Prints to a file each topic ID and its top 10 assignments.
     */
    public void printToFile(String f) {
        
        try {
            FileWriter fw;
            fw = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(fw);
            
            for (DocID docID : docIDarray)
                bw.write(docID.toString());
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
        
        DocAssignments d = new DocAssignments();
        
        String sourceFile = JOptionPane.showInputDialog("Type the name of the document.topics.txt file.");
        
        d.getAssignments(sourceFile);
        
        String outputFile = JOptionPane.showInputDialog("Type the name of the output file.");
        
        d.printToFile(outputFile);
    }
}
