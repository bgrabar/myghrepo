/*
 * BookTitles class
 */

import java.io.*;
import java.util.HashMap;
//import javax.swing.*;


/**
 * Creates an object that contains a hash map of text titles and their corresponding book titles
 */

public class BookTitles {
    
    private HashMap<String, String> titlesMap = new HashMap<String, String>();
    
    /**
     * Constructor
     * @param f The file containing the book titles, as extracted from the metadata files
     */
    public BookTitles(String f) {
        getBookTitles(f);
    }
    
    /**
     * Creates the hash map of text files and their corresponding book titles. For input, this class uses 
     * a text file created using the findTitle.sh script, followed by some manual cleanup through search and replace.
     * A single line in this file uses the following formatting:
     *     
     *     37/34/85/40/37348540/37348540    Theoretical mechanics
     *     
     * where the space between the filename and volume name is a tab.
     * Note that the filename does not include an extension. The extension is removed during manual cleanup.
     * For more information on the format of this file, see Working.with.Hathi.Trust.docx located in /gds_02/dev/project.documents.
     * @param f The file containing the book titles, as extracted from the metadata files
     */
    private void getBookTitles(String f) {
        
        String extractedTitlesFile = f;
        
        FileReader fr = null;
        try {
            fr = new FileReader(extractedTitlesFile);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to read file. " + e.getMessage());
            e.printStackTrace();
        }
        BufferedReader br = new BufferedReader(fr);
        String line = null;
        
        try {
            while ( (line = br.readLine()) != null ) {
                
                if (line.trim().equals("")) continue;
                
                String[] a = line.split("\t");
                
                if (a.length != 2)
                    throw new RuntimeException();
                
                /* OLD CODE - This code was necessary when we were not first removing the filename extensions listed in the input file
                String[] b = a[0].split("\\.");
                if (b.length < 1)
                    System.out.println("error is here");
                */
                
                titlesMap.put(a[0], a[1]);
                
            }
        } catch (IOException e) {
            System.out.println("Unable to read file. " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    /**
     * Returns the book title for a given text file
     * @param path The text file (including a porton of its path)
     * @return The book title
     */
    public String getTitle(String path) {
        return titlesMap.get(path);
    }
    
    /**
     * Prints the hash map
     */
    public void printTitlesMap() {
        for (String k : titlesMap.keySet()) {
            System.out.println("Key:" + k + " Value:" + titlesMap.get(k) );
        }
    }
}
