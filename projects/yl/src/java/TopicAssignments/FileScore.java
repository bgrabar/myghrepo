/*
 * FileScore class
 */

/** 
 * Creates an object that holds the filename and the score for a file assigned to a topic.
 * @param filename The name of the file that is assigned to the topic
 * @param score The score for the file that assigned to the topic
*/
public class FileScore implements Comparable<FileScore>{
    
    private String filename;
    private double score;
    
    /**
     * The constructor class
     * @param f The name of the file that is assigned to the topic
     * @param s The score for the file that assigned to the topic
     */
    public FileScore(String f, double s) {
        
        filename = f;
        score = s;
    }
    
    /**
     * Get's the file's name
     * @return The file's name
     */
    public String getFileName() {
        return filename;
    }
    
    /**
     * Get's the files score for the given topic ID
     * @return The file's score for the given topic ID
     */
    public double getScore() {
        return score;
    }
    
    /**
     * Orders the FileScore object's items as follows:
     * first, according to score
     * second, according to file name
     * Overrides Comparable interface's compareTo method
     */
    @Override
    public int compareTo(FileScore other) {
        if ( this.getScore() != other.getScore() )
            return ( this.getScore() < other.getScore() ? 1 : -1);
        else if (!this.getFileName().equals(other.getFileName()))
            return this.getFileName().compareTo(other.getFileName());
        else
            return 0;
    }
    
    /**
     * Overrides Object.toString
     */
    @Override
    public String toString()
    {
        return filename + "\t" + Double.toString(score);
    }
}
