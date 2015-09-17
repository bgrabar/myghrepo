import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class BSTProgram extends Frame implements ActionListener
{
    private BST tree = new BST();
    private RandomNumberGenerator rn = new RandomNumberGenerator(0,100,500);
    private String command = "";

    private int numNodes = 0;

    public static void main(String[] args)
    {
        Frame frame = new BSTProgram();
        frame.setResizable(false);
        frame.setSize(1150,820);
        frame.setVisible(true);
    }

    public BSTProgram()
    {
        setTitle("Binary Search Tree Operations");

        MenuBar mb = new MenuBar();
        setMenuBar(mb);

        Menu operationsMenu = new Menu("Operations");
        mb.add(operationsMenu);

        MenuItem miAddNode = new MenuItem("Add a Node");
        miAddNode.addActionListener(this);
        operationsMenu.add(miAddNode);

        /*  UNDER CONSTRUCTION
        MenuItem miDeleteNode = new MenuItem("Delete a Node");
        miDeleteNode.addActionListener(this);
        operationsMenu.add(miDeleteNode);

        MenuItem miSearch = new MenuItem("Search");
        miSearch.addActionListener(this);
        operationsMenu.add(miSearch);
        */

        MenuItem miInOrder = new MenuItem("In-Order");
        miInOrder.addActionListener(this);
        operationsMenu.add(miInOrder);

        MenuItem miPreOrder = new MenuItem("Pre-Order");
        miPreOrder.addActionListener(this);
        operationsMenu.add(miPreOrder);

        MenuItem miPostOrder = new MenuItem("Post-Order");
        miPostOrder.addActionListener(this);
        operationsMenu.add(miPostOrder);

        MenuItem miTraverse = new MenuItem("Traverse");
        miTraverse.addActionListener(this);
        operationsMenu.add(miTraverse);

        MenuItem miCreateTree = new MenuItem("Create a New Set of Nodes");
        miCreateTree.addActionListener(this);
        operationsMenu.add(miCreateTree);

        MenuItem miExit = new MenuItem("Exit");
        miExit.addActionListener(this);
        operationsMenu.add(miExit);

        WindowListener l = new WindowAdapter() {
            public void windowClosing(WindowEvent ev) {
                System.exit(0);
            }
            public void windowActivated(WindowEvent ev) {
                repaint();
            }
            public void windowStateChanged(WindowEvent ev) {
                repaint();
            }
        };

        ComponentListener k = new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
                repaint();
            }
        };

        // register listeners
        this.addWindowListener(l);
        this.addComponentListener(k);
    }

/*  ******************************************************************
    *
    * When the app performs an action, Windows Manager calls this method
    *
    */
    public void actionPerformed (ActionEvent ev)
    {
        command = ev.getActionCommand(); // determine which command issued

        int number = rn.getRandomNumber();

        if ("Add a Node".equals(command))
            {
              tree.addToBST(number);
              tree.setTraversalResult("");
              tree.inOrder(tree.getRoot());
              repaint();
            }
/*  UNDER CONSTRUCTION
        else
            if ("Delete a Node".equals(command))
            {
                String input = JOptionPane.showInputDialog("Input Value to be Deleted",
                        "Enter an integer between 100 and 500.");
                number = Integer.parseInt(input);
                tree.deleteFromBST(number);
                repaint();
            }
        else
            if ("Search".equals(command))
            {
                ; // ????
                repaint();
            }
*/
        else
            if ("In-Order".equals(command))
            {
                tree.setTraversalResult("");
                tree.inOrder(tree.getRoot());
                repaint();
            }
        else
            if ("Pre-Order".equals(command))
            {
                tree.setTraversalResult("");
                tree.preOrder(tree.getRoot());
                repaint();
            }
        else
            if ("Post-Order".equals(command))
            {
                tree.setTraversalResult("");
                tree.postOrder(tree.getRoot());
                repaint();
            }
        else
            if ("Create a New Set of Nodes".equals(command))
            {
                tree = new BST();
                rn = new RandomNumberGenerator(0,100,500);

                String input = JOptionPane.showInputDialog(null, "This option creates a new tree.\n" +
                        "\n Type an integer between 10 and 50.");
                numNodes = Integer.parseInt(input);

                while (numNodes < 10 || numNodes > 50)
                {
                    input = JOptionPane.showInputDialog(null, "Integer too high or too low. Type an integer between 10 and 50.");
                    numNodes = Integer.parseInt(input);
                }

                int i = 0;
                while (i < numNodes)
                {
                    tree.addToBST(rn.getRandomNumber());
                    i++;
                }
                tree.setTraversalResult("");
                tree.inOrder(tree.getRoot());
                repaint();
            }
        else
            if ("Exit".equals(command))
                System.exit(0);
    }

/*  ****************************************
    *
    * called by repaint() to redraw the screen
    *
    */
    public void paint(Graphics g)
    {
        if ("Add a Node".equals(command) ||
                "Delete a Node".equals(command) ||
                "In-Order".equals(command) ||
                "Pre-Order".equals(command) ||
                "Post-Order".equals(command) ||
                "Create a New Set of Nodes".equals(command))
        {
            if (tree.getRoot() == null)
                g.drawString("The tree is empty.", 540, 395);
            else
                g.drawString("The tree is: " + tree.getTraversalResult(), 40, 395);
        }
    }
}