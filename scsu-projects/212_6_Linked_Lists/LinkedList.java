import javax.swing.JOptionPane;

public class LinkedList
{
    Node head;
    Node tail;
    long length = 0;
    
    public Long getLength()
    {
        return length;
    }
    
    public void addToBeginning(int d)
    {
        Node t = new Node();    // the node to add
        t.data = d;
        t.next = head;          // place the node in front of the current head
        head = t;               // set t as the current head
        length++;               // increase list length by 1
    }
    
    public void addToEnd(int d)
    {
        Node t = new Node();  // the node to add
        t.data = d;
        Node temp;            // to traverse list
        
        if (head != null)     // ensure list is not empty
        {
            temp = head;
            while (temp.next != null)  // traverse list to set temp equal to last node
                temp = temp.next;
            
            t.next = null;
            temp.next=t;
            length++;                  // increase list length by 1
        }
        else                           // if list is empty, set both head and tail to t and set length to 1
        {
            head = t;
            tail = t;
            length = 1;
        }
    }
    
    public void addAfterNthNode(int d, int nodePosition)
    {
        Node t = new Node();           // the node to add
        t.data = d;
        int position = nodePosition;   // the position in which to place the new node
        Node temp;                     // to traverse list
        
        if (head != null && position <= (length + 1))  // ensure list is long enough
        {
            temp = head;
            if (position == 1)             // create node as first node in list
            {
                t.next = head;             // place the node in front of the current head
                head = t;                  // set t as the current head
                length++;
            }
            else                           // create node at specified position
            {
                for (int counter = 1; counter < (position - 1); counter++)
                    temp = temp.next;
                t.next = temp.next;
                temp.next = t;
                length++;
            }
        }
        
        if (head == null && position == 1) // create node as first node in list
        {
            head = t;
            tail = t;
            length++;
        }
    }
    
    public void deleteFromBeginning()
    {
        if (head == null)
            JOptionPane.showMessageDialog(null, "The list is empty.");
        else
        {
            head  = head.next;
            length--;
        }
    }
    
    public void deleteFromEnd()
    {
        Node current;      // to traverse list
        Node previous;     // to traverse list
        
        if (head == null)
            JOptionPane.showMessageDialog(null, "The list is empty.");
        
        else
        {
            current = head;
            previous = current;
            
            if (head == null)
                JOptionPane.showMessageDialog(null, "The list is empty.");
            
            else if (current.next == null)
            {
                head.next = current.next;
                head = current.next;
                length--;
            }
            else
            {
                while (current.next != null)
                {
                    previous = current;
                    current = current.next;
                }
                previous.next = current.next;
                length--;
            }
        }
    }
    
    public void deleteNodeByContent(int nodeContent)
    {
        int content = nodeContent;     // the content of the node to delete
        Node current;                  // to traverse list
        Node previous;                 // to traverse list
        
        if (head != null)              // ensure list is not empty
        {
            current = head;
            previous = current;
            
            if (current.data == content)
            {
                head.next = current.next;
                head = current.next;
                length--;
            }
            else if (current.data != content)
            {
                for (int counter = 1; counter <= length; counter++)
                {
                    previous = current;
                    current = current.next;
                    if (current.data == content)
                    {
                        previous.next = current.next;
                        length--;
                        break;
                    }
                    if (current.next == null)
                    {
                        JOptionPane.showMessageDialog(null, "The node is not part of this linked list.");
                        return;
                    }
                }
                /* *******************************************
                   OPTIONALLY I COULD HAVE USED:
                     while (current.data != content)
                     {
                         previous = current;
                         current = current.next;
                     }
                     if (current.data == content)    ETC.
                   WOULD DOING SO HAVE BEEN MORE EFFICIENT ???
                   ******************************************* */
            }
            else
            {
                if (head == null)
                    JOptionPane.showMessageDialog(null, "There is no node with the content " + content + ".");
            }
        }
    }
    
    public void deleteNodeByPosition (int nodePosition)
    {
        int position = nodePosition;   // the position of the node to delete
        Node current;                  // to traverse list
        Node previous;                 // to traverse list
        
        if (head != null)              // ensure list is not empty
        {
            current = head;
            previous = current;
            
            if (position == 1)
            {
                head.next = current.next;
                head = current.next;
                length--;
            }
            else
            {
                for (int counter = 1; counter < (position); counter++)
                {
                    previous = current;
                    current = current.next;
                }
                previous.next = current.next;
                length = length - 1;
            }
        }
    }
    
    public Node locateNode(int nodeContent)
    {
        int content = nodeContent;     // the content of the node to locate
        Node temp = head;              // to traverse list
        
        // There is no checking for empty list as LinkedListProgram will call 
        // call this method if head is null.
        
        if (temp.data != content)
        {
            for (int counter = 1; counter <= length; counter++)
            {
                temp = temp.next;
                if (temp.data == content)
                    return temp;
                if (temp.next == null)
                {
                    JOptionPane.showMessageDialog(null, "The node is not part of this linked list.");
                    return null;
                }
            }
        }
        return temp;
    }
    
    public void sort(int d)
    {
        Node t = new Node();  // the node to add
        t.data = d;
        Node current;         // to traverse list
        Node previous;        // to traverse list
        
        if (head != null)
        {
            current = head;
            previous = current;
            
            if (current.data >= t.data)
            {
                t.next = head;          // place the node in front of the current head
                head = t;               // set t as the current head
                length++;               // increase list length by 1
                return;
            }
                
            while (current != null && current.data < t.data)
            {
                previous = current;
                current = current.next;
            }
            
            previous.next = t;
            length++;
                
            if (current == null)
                t.next = null;
            else
                t.next = current;
        }
        else // if list is empty, set both head and tail to t and set length to 1
        {
            head = t;
            tail = t;
            length = 1;
        }
    }
}