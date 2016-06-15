import javax.swing.JOptionPane;

public class Stack
{
    Node head = null;
    long stackLength = 0;
    
    public Long getStackLength()
    {
        return stackLength;
    }
    
    public void push(int d)
    {
        Node t = new Node();
        t.data = d;
        t.next = head;
        head = t;
        stackLength++;
    }
    
    
    public void pop()
    {
        if (head == null)
            JOptionPane.showMessageDialog(null, "The stack is empty.");
        else
        {
            head  = head.next;
            stackLength--;
        }
    }
}