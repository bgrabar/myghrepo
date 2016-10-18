import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class LinkedListProgram extends Frame implements ActionListener
{
    // create objects
    
    RandomNumberGenerator RN = new RandomNumberGenerator(0,100,1000);
    LinkedList LL = new LinkedList();
    Stack stackList = new Stack();
    Queue queueList = new Queue();
    Node nodeToLocate = new Node();  // used to contain a node that is being searched for
    
    int data;
    int position;
    int nodeContent;
    int lengthSorted;
    
    boolean eraseExisting = false;
    
    String input;
    
    String command = "";
    
    public static void main(String[] arg )
    {
        Frame frame = new LinkedListProgram();
        frame.setResizable(false);
        frame.setSize(1150,820);
        frame.setVisible(true);
    }
    
    public LinkedListProgram()
    {
        setTitle("Linked List Operations");
        
        // Create menu bar
        
        MenuBar mb = new MenuBar();
        setMenuBar(mb);
        
        // Create menus
        
        Menu utilitiesMenu = new Menu("Utilities");
        mb.add(utilitiesMenu);
        
        Menu addMenu = new Menu("Add");
        mb.add(addMenu);
        
        Menu deleteMenu = new Menu("Delete");
        mb.add(deleteMenu);
        
        Menu stackMenu = new Menu("Stack");
        mb.add(stackMenu);
        
        Menu queueMenu = new Menu("Queue");
        mb.add(queueMenu);
        
        // Create "Utilities" menu options
        
        MenuItem miSort = new MenuItem("Create a Sorted List");
        miSort.addActionListener(this);
        utilitiesMenu.add(miSort);
        
        MenuItem miLocateNode = new MenuItem("Locate a Node");
        miLocateNode.addActionListener(this);
        utilitiesMenu.add(miLocateNode);
        
        MenuItem miTraverse = new MenuItem("Traverse the List");
        miTraverse.addActionListener(this);
        utilitiesMenu.add(miTraverse);
        
        MenuItem miExit = new MenuItem("Exit");
        miExit.addActionListener(this);
        utilitiesMenu.add(miExit);
        
        // Create "Add" menu options
        
        MenuItem miAddToBeginning = new MenuItem("Add Node to Beginning");
        miAddToBeginning.addActionListener(this);
        addMenu.add(miAddToBeginning);
        
        MenuItem miAddToEnd = new MenuItem("Add Node to End");
        miAddToEnd.addActionListener(this);
        addMenu.add(miAddToEnd);
        
        MenuItem miAddAfterNthNode = new MenuItem("Add Node to Specified Location");
        miAddAfterNthNode.addActionListener(this);
        addMenu.add(miAddAfterNthNode);
        
        // Create "Delete" menu options
        
        MenuItem miDeleteFromBeginning = new MenuItem("Delete Node from Beginning");
        miDeleteFromBeginning.addActionListener(this);
        deleteMenu.add(miDeleteFromBeginning);
        
        MenuItem miDeleteFromEnd = new MenuItem("Delete Node from End");
        miDeleteFromEnd.addActionListener(this);
        deleteMenu.add(miDeleteFromEnd);
        
        MenuItem miDeleteNodeByContent = new MenuItem("Delete Node by Content");
        miDeleteNodeByContent.addActionListener(this);
        deleteMenu.add(miDeleteNodeByContent);
        
        MenuItem miDeleteNodeByPosition = new MenuItem("Delete Node by Position");
        miDeleteNodeByPosition.addActionListener(this);
        deleteMenu.add(miDeleteNodeByPosition);
        
        // Create "Stack" menu options
        
        MenuItem miStackFromBeginning = new MenuItem("Add Node to Stack (Push)");
        miStackFromBeginning.addActionListener(this);
        stackMenu.add(miStackFromBeginning);
        
        MenuItem miStackFromEnd = new MenuItem("Delete Node from Stack (Pop)");
        miStackFromEnd.addActionListener(this);
        stackMenu.add(miStackFromEnd);
        
        // Create "Queue" menu options
        
        MenuItem miQueueFromBeginning = new MenuItem("Add new Node to Queue");
        miQueueFromBeginning.addActionListener(this);
        queueMenu.add(miQueueFromBeginning);
        
        MenuItem miQueueFromEnd = new MenuItem("Remove Node from Queue");
        miQueueFromEnd.addActionListener(this);
        queueMenu.add(miQueueFromEnd);
        
        WindowListener l = new WindowAdapter()
        {
            public void windowClosing(WindowEvent ev)
            {
                System.exit(0);
            }
            
            public void windowActivated(WindowEvent ev)
            {
                repaint();
            }
            
            public void windowStateChanged(WindowEvent ev)
            {
                repaint();
            }
        };
        
        ComponentListener k = new ComponentAdapter()
        {
            public void componentResized(ComponentEvent e) 
            {
                repaint();           
            }
        };
        
        // register listeners
            
        this.addWindowListener(l);
        this.addComponentListener(k);
    }
    
// ******************************************************************************
// called by windows manager when app performs an action
// ******************************************************************************
    public void actionPerformed (ActionEvent ev)
    {
        // determine which command was issued
        
        nodeToLocate = null; // This removes any highlighted node left over from a locate node command.
        
        command = ev.getActionCommand();
        
        // take appropriate action
        
        if("Add Node to Beginning".equals(command))
        {
            eraseExisting = true; // used in Sort command to erase existing list before creating new one.
            LL.addToBeginning(RN.getRandomNumber());
            repaint();
        }
        
        else if ("Add Node to End".equals(command))
        {
            eraseExisting = true; // used in Sort command to erase existing list before creating new one.
            LL.addToEnd(RN.getRandomNumber());
            repaint();
        }
        
        else if ("Add Node to Specified Location".equals(command))
        {
            eraseExisting = true; // used in Sort command to erase existing list before creating new one.
            
            // displays LL's length and prompts for new node's position
            
            input = JOptionPane.showInputDialog(null, "The list has " + LL.getLength() + " nodes." + 
                    "\nAt what position do you want " + 
                    "\nto add the new node?");
            position = Integer.parseInt(input);
            
            // prompts for new entry if position doesn't exist
            
            while (position > LL.getLength() + 1)
            {
                input = JOptionPane.showInputDialog(null, "Enter a position less than " + (LL.getLength() + 2) + ".");
                position = Integer.parseInt(input);
            }
            
            LL.addAfterNthNode(RN.getRandomNumber(), position);
            repaint();
        }
        
        else if ("Delete Node from Beginning".equals(command))
        {
            LL.deleteFromBeginning();
            repaint();
        }
        
        else if ("Delete Node from End".equals(command))
        {
            LL.deleteFromEnd();
            repaint();
        }
        else if ("Delete Node by Content".equals(command))
        {
            if (LL.head == null)
            {
                JOptionPane.showMessageDialog(null, "The list has no nodes to delete.");
                return;
            }
            
            // prompts for the content of the node to delete 
            
            input = JOptionPane.showInputDialog(null, "What is the content of the node to delete?");
            nodeContent = Integer.parseInt(input);
            
            LL.deleteNodeByContent(nodeContent);
            repaint();
        }
        
        else if ("Delete Node by Position".equals(command))
        {
            if (LL.head == null)
            {
                JOptionPane.showMessageDialog(null, "The list has no nodes to delete.");
                return;
            }
            
            // displays LL's length and prompts for position of node to delete 
            
            input = JOptionPane.showInputDialog(null, "The list has " + LL.getLength() + " nodes." + 
                    "\nWhat is the position of the node to delete?");
            position = Integer.parseInt(input);
            
            // prompts for new entry if position doesn't exist
            
            while (LL.head != null && position > LL.getLength())
            {
                input = JOptionPane.showInputDialog(null, "Enter a position less than " + (LL.getLength() + 1) + ".");
                position = Integer.parseInt(input);
            }
            
            LL.deleteNodeByPosition(position);
            repaint();
        }
        
        else if ("Add Node to Stack (Push)".equals(command))
        {
            stackList.push(RN.getRandomNumber());
            repaint();
        }
        
        else if ("Delete Node from Stack (Pop)".equals(command))
        {
            stackList.pop();
            repaint();
        }
        
        else if ("Add new Node to Queue".equals(command))
        {
            queueList.addNodeToQueue(RN.getRandomNumber());
            repaint();
        }
        
        else if ("Remove Node from Queue".equals(command))
        {
            queueList.deleteNodeFromQueue();
            repaint();
        }
        
        
          /* ********************************************************************************
             The "Create a New, Sorted List" command below:
             1. Displays a list of a user-defined length. 
             2. ALWAYS creates a new list. If a sorted list is added to an existing sorted list,
                the two lists together might go beyond the window's display size
             3. Uses the "deleteFromEnd()" method to erase the previous sorted list 
                ***************************************************************************** */
        
        else if ("Create a Sorted List".equals(command))
        {
            if (eraseExisting) // Uses the "deleteFromEnd()" method to erase the previous sorted list
            {
                long listLen = LL.getLength();
                int len = (int)listLen;
                for (int i = 0; i < len; i++)
                    LL.deleteFromEnd();
                    repaint();
            }
            
            input = JOptionPane.showInputDialog(null, "This command creates a new linked list." + 
                    "\nEnter the length of the list, up to 300");
            lengthSorted = Integer.parseInt(input);
            
            while (lengthSorted > 300 || lengthSorted < 1)
            {
                input = JOptionPane.showInputDialog(null, "Enter a number between 1 and 300.");
                lengthSorted = Integer.parseInt(input);
            }
            
            for (int i = 0; i < lengthSorted; i++)
            {
            LL.sort(RN.getRandomNumber());
            repaint();
            eraseExisting = true;
            }
        }
        
        else if ("Locate a Node".equals(command))
        {
            if (LL.head == null)
                JOptionPane.showMessageDialog(null, "The list is empty.");
            else
            {
                input = JOptionPane.showInputDialog(null, "Enter the data of the node to locate.");
                nodeContent = Integer.parseInt(input);
                nodeToLocate = LL.locateNode(nodeContent);
                repaint();
            }
        }
        
        else if ("Traverse Linked List".equals(command))
        {
            repaint();
        }
        
        else if("Exit".equals(command))
        {
            System.exit(0);
        }
    }

// ********************************************************
// called by repaint() to redraw the screen
// ********************************************************
    public void paint(Graphics g)
    {
        
        // Paint Linked List
        
        if("Add Node to Beginning".equals(command) ||
                "Add Node to End".equals(command) ||
                "Add Node to Specified Location".equals(command) ||
                "Delete Node from Beginning".equals(command) ||
                "Delete Node from End".equals(command) ||
                "Delete Node by Content".equals(command) ||
                "Delete Node by Position".equals(command) ||
                "Create a Sorted List".equals(command) ||
                "Locate a Node".equals(command) ||
                "Traverse Linked List".equals(command))
        {
            if (LL.head == null)
            {
                g.drawString("Empty List", 540, 395);
                return;
            }
            else
            {
                int x    = 0;
                int y    = 0;
                int z    = 1;
                int xEnd = 0;
                int yEnd = 0;
                
                Node t = LL.head;
                
                g.drawString("Head", 27, 60);
                g.drawString("L I N K E D   L I S T", 400, 60);
                g.drawLine(60, 65, 100, 110);
                
                while (t != null) // display nodes
                {
                    g.drawLine(100+x, 110+y, 140+x, 110+y);
                    g.drawLine(100+x, 110+y, 100+x, 130+y);
                    g.drawLine(100+x, 130+y, 140+x, 130+y);
                    g.drawLine(140+x, 110+y, 140+x, 130+y);
                    g.drawString((Integer.toString(t.data)), 110+x, 125+y);
                    
                    if (t == nodeToLocate) {
                        g.setColor(new Color(255, 0, 0));
                        g.drawString((Integer.toString(t.data)), 110+x, 125+y);
                        g.setColor(new Color(0, 0, 0));
                    }
                    else
                        g.drawString((Integer.toString(t.data)), 110+x, 125+y);
                    
                    t = t.next;
                    
                    if (t != null)
                    {
                        g.drawLine(140+x, 120+y, 155+x, 120+y);
                        g.drawString(">", 155+x, 125+y);
                    }
                    
                    x=x+63;
                    xEnd = x;
                    yEnd = y;
                    if (x > 890) // if right side of window is reached, move to next line
                    {
                        x = 0;
                        z = z++;
                        y = y + (z * 35);
                    }
                }
                
                // Display end of list
                
                if (y > 625)  // if at bottom of window, use straight line
                {
                    g.drawLine(77+xEnd, 120+yEnd, 117+xEnd, 120+yEnd);
                    g.drawString("End Of List", 119+xEnd, 124+yEnd);
                }
                else
                {
                    g.drawLine(77+xEnd, 130+yEnd, 117+xEnd, 170+yEnd);
                    g.drawString("End Of List", 117+xEnd, 185+yEnd);
                }
            }
        }
        
        
        
        // Paint Stack
        
        if("Add Node to Stack (Push)".equals(command) ||
                "Delete Node from Stack (Pop)".equals(command))
        {
            if (stackList.head == null)
            {
                g.drawString("Empty Stack", 540, 395);
                return;
            }
            else
            {
                int x    = 0;
                int y    = 0;
                int z    = 1;
                int xEnd = 0;
                int yEnd = 0;
                
                Node t = stackList.head;
                
                g.drawString("Head", 27, 60);
                g.drawString("S T A C K", 400, 60);
                g.drawLine(60, 65, 100, 110);
                
                while (t != null) // display nodes
                {
                    g.drawLine(100+x, 110+y, 140+x, 110+y);
                    g.drawLine(100+x, 110+y, 100+x, 130+y);
                    g.drawLine(100+x, 130+y, 140+x, 130+y);
                    g.drawLine(140+x, 110+y, 140+x, 130+y);
                    g.drawString((Integer.toString(t.data)), 110+x, 125+y);
                    
                    if (t == nodeToLocate) {
                        g.setColor(new Color(255, 0, 0));
                        g.drawString((Integer.toString(t.data)), 110+x, 125+y);
                        g.setColor(new Color(0, 0, 0));
                    }
                    else
                        g.drawString((Integer.toString(t.data)), 110+x, 125+y);
                    
                    t = t.next;
                    
                    if (t != null)
                    {
                        g.drawLine(140+x, 120+y, 155+x, 120+y);
                        g.drawString(">", 155+x, 125+y);
                    }
                    
                    x=x+63;
                    xEnd = x;
                    yEnd = y;
                    if (x > 890) // if right side of window is reached, move to next line
                    {
                        x = 0;
                        z = z++;
                        y = y + (z * 35);
                    }
                }
                
                // Display end of list
                
                if (y > 625)  // if at bottom of window, use straight line
                {
                    g.drawLine(77+xEnd, 120+yEnd, 117+xEnd, 120+yEnd);
                    g.drawString("End Of List", 119+xEnd, 124+yEnd);
                }
                else
                {
                    g.drawLine(77+xEnd, 130+yEnd, 117+xEnd, 170+yEnd);
                    g.drawString("End Of List", 117+xEnd, 185+yEnd);
                }
            }
        }
        
        
        // Paint Queue
        
        if("Add new Node to Queue".equals(command) ||
                "Remove Node from Queue".equals(command))
        {
            if (queueList.head == null)
            {
                g.drawString("Empty Queue", 540, 395);
                return;
            }
            else
            {
                int x    = 0;
                int y    = 0;
                int z    = 1;
                int xEnd = 0;
                int yEnd = 0;
                
                Node t = queueList.head;
                
                g.drawString("Head", 27, 60);
                g.drawString("Q U E U E", 400, 60);
                g.drawLine(60, 65, 100, 110);
                
                while (t != null) // display nodes
                {
                    g.drawLine(100+x, 110+y, 140+x, 110+y);
                    g.drawLine(100+x, 110+y, 100+x, 130+y);
                    g.drawLine(100+x, 130+y, 140+x, 130+y);
                    g.drawLine(140+x, 110+y, 140+x, 130+y);
                    g.drawString((Integer.toString(t.data)), 110+x, 125+y);
                    
                    if (t == nodeToLocate) {
                        g.setColor(new Color(255, 0, 0));
                        g.drawString((Integer.toString(t.data)), 110+x, 125+y);
                        g.setColor(new Color(0, 0, 0));
                    }
                    else
                        g.drawString((Integer.toString(t.data)), 110+x, 125+y);
                    
                    t = t.next;
                    
                    if (t != null)
                    {
                        g.drawLine(140+x, 120+y, 155+x, 120+y);
                        g.drawString(">", 155+x, 125+y);
                    }
                    
                    x=x+63;
                    xEnd = x;
                    yEnd = y;
                    if (x > 890) // if right side of window is reached, move to next line
                    {
                        x = 0;
                        z = z++;
                        y = y + (z * 35);
                    }
                }
                
                // Display end of list
                
                if (y > 625)  // if at bottom of window, use straight line
                {
                    g.drawLine(77+xEnd, 120+yEnd, 117+xEnd, 120+yEnd);
                    g.drawString("End Of List", 119+xEnd, 124+yEnd);
                }
                else
                {
                    g.drawLine(77+xEnd, 130+yEnd, 117+xEnd, 170+yEnd);
                    g.drawString("End Of List", 117+xEnd, 185+yEnd);
                }
            }
        }
    }
}