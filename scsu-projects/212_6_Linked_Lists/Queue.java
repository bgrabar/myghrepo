import javax.swing.JOptionPane;

public class Queue
{
    Node head = null;
    long queueLength = 0;
    
    public Long getQueueLength()
    {
        return queueLength;
    }
    
    public void addNodeToQueue(int d)
    {
        Node t = new Node();
        t.data = d;
        t.next = head;
        head   = t;
        
        queueLength++;
    }
    
    public void deleteNodeFromQueue()
    {
        Node current;
        Node previous;
        
        if (head == null)
            JOptionPane.showMessageDialog(null, "The queue is empty.");
        
        else
        {
            current  = head;
            previous = current;
            
            if (head == null)
                JOptionPane.showMessageDialog(null, "The queue is empty.");
            
            else if (current.next == null)
            {
                head.next = current.next;
                head = current.next;
                queueLength--;
            }
            else
            {
                while (current.next != null)
                {
                    previous = current;
                    current  = current.next;
                }
                previous.next = current.next;
                queueLength--;
            }
        }
    }
}