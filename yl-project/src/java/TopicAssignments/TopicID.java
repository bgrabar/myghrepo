/*
 * TopicID class
 */

import java.util.TreeSet;

/**
 * Creates an object to hold the file-and-score pairings for a topic ID. 
 * @author bobgrabar
 * @param TreeSet Contains the file-and-score pairings for a topic ID
 * @param id The topic ID
 */
public class TopicID {
    
    private TreeSet<FileScore> tree = new TreeSet<FileScore>();
    private int id;
    
    /**
     * The constructor class
     * @param id The topic ID
     */
    public TopicID(int id) {
        this.id = id;
    }
    
    /**
     * Add a new file-and-score pairing to the tree TreeSet.
     * @param name The name of the file that is assigned to the topic ID
     * @param score The score for the assigned file
     */
    public void addNameAndScore(String name, double score) {
        
        tree.add(new FileScore(name, score));
        
        if (tree.size() == 11) {
            tree.remove(tree.last());
        }
    }
    
    /**
     * Overrides Object.toString
     */
    @Override
    public String toString() {
        
        String str = "";
        
        // For each x in tree that is a FileScore, add it to the string
        for (FileScore x : tree) {
            str = str + "\t" + x;
        }
        
        return Integer.toString(id) + " " + str;
    }
}
