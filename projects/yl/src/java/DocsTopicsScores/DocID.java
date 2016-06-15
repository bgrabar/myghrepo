/*
 * DocID class
 */

/**
 * Creates an object to hold the topic/score pairings for a document.
 */
public class DocID {
    
    private String name;
    private int topicID;
    private double score;
    
    /**
     * The constructor class
     */
    public DocID(String name, int topicID, double score) {
        this.name = name;
        this.topicID = topicID;
        this.score = score;
    }
    
    public String getName() {
        return name;
    }
    
    public Integer getTopicID() {
        return topicID;
    }
    
    public Double getScore() {
        return score;
    }
    
    /**
     * Overrides Object.toString
     */
    @Override
    public String toString() {
        return ( (this.getName()) + "\t" + this.getTopicID() + "\t" + this.getScore() + "\n"        );
    }
}
