import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class RecursiveAlgorithms extends Frame implements ActionListener
{
    private int xCenter;               // for centering display, for use by multiple methods
    private int yCenter;               // for centering display, for use by multiple methods
    private String input;              // for use by multiple methods
    
    private double sumOfSeries = 0.0;  // to store return value from sumSeries method
    private double numCombos =   0.0;  // to store return value from numberOfCombos method
    
    private int order = 0;             // to store the number of Sierpinski Triangles
    
    private int numDisks;              // to determine the number of disks in Towers of Hanoi 
    private int numMoves;              // to store the number of moves in Towers of Hanoi
    private int x;                     // for output for Towers of Hanoi 
    private int y;                     // for output for Towers of Hanoi
    
    private String command = "";       // to retrieve command code
        
    public static void main(String[] args)
    {
        Frame frame = new RecursiveAlgorithms();
        frame.setResizable(false);
        frame.setSize(900,880);
        frame.setVisible(true);
    }
    
    public RecursiveAlgorithms()
    {
        setTitle("Recursive Algorithms");
        
        // Create menu bar
        
        MenuBar mb = new MenuBar();
        setMenuBar(mb);
        
        // Create File menu
        
        Menu fileMenu = new Menu("File");
        mb.add(fileMenu);
        
        // Create menu items
        
        MenuItem miSumSeries = new MenuItem("Sum Series");
        miSumSeries.addActionListener(this);
        fileMenu.add(miSumSeries);
        
        MenuItem miNumberOfCombinations = new MenuItem("Number of Combinations");
        miNumberOfCombinations.addActionListener(this);
        fileMenu.add(miNumberOfCombinations);
        
        MenuItem miSierpinskiTriangle = new MenuItem("Sierpinski Triangle");
        miSierpinskiTriangle.addActionListener(this);
        fileMenu.add(miSierpinskiTriangle);
        
        MenuItem miTowersOfHanoi = new MenuItem("Towers of Hanoi");
        miTowersOfHanoi.addActionListener(this);
        fileMenu.add(miTowersOfHanoi);
        
        MenuItem miExit = new MenuItem("Exit");
        miExit.addActionListener(this);
        fileMenu.add(miExit);  // End program when window is closed
        
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
    
// *************************************************
// actionPerformed
// *************************************************
    public void actionPerformed (ActionEvent ev)
        {
            command = ev.getActionCommand();
            
            
            if("Sum Series".equals(command))
            {
                double t;
                input = JOptionPane.showInputDialog(null, "Enter an integer for which to " + 
                        "\nfind the summation" +
                        "\nN / (2N + 1)" + 
                        "\nas N goes from 1 to the integer you enter.\n\n");
                t = Double.parseDouble(input);
                sumOfSeries = sumSeries(t);
                repaint();
            }
            
            
            if("Number of Combinations".equals(command))
            {
                double a, b;
                
                input = JOptionPane.showInputDialog(null, "Enter the size of the set " + 
                        "(i.e., the N in (N,K).");
                a = Double.parseDouble(input);
                
                input = null;  // This assignment is used by the paint method's 
                               // if statment to prevent display until two entries are made.
                
                input = JOptionPane.showInputDialog(null, "Enter the size of the subset" + 
                                        "(i.e., the K in (N,K).");
                b = Double.parseDouble(input);
                
                
                // Ensure b is less than a
                
                while (b > a)
                {
                    input = null;  // This assignment is used by the paint method 
                                   // to prevent display until the valid entry is made.
                    
                    input = JOptionPane.showInputDialog(null, "The subset cannot be greater than the set." + 
                            "\n\nRe-enter the size of the subset.\n\n");
                    b = Double.parseDouble(input);
                }
                
                numCombos = numberOfCombos(a, b);
                
                repaint();
            }
            
            
            if("Sierpinski Triangle".equals(command))
            {
                input = JOptionPane.showInputDialog(null, "Enter the number of Sierpinski triangles." + 
                        "\n\n NOTE: Performance might be slow beyond 6.\n\n");
                order = Integer.parseInt(input);
                repaint();
            }
            
            
            if("Towers of Hanoi".equals(command))
            {
                input = JOptionPane.showInputDialog(null, "Enter the number of disks, up to 10.");
                numDisks = Integer.parseInt(input);
                
                repaint();
            }
            
            
            if("Exit".equals(command))
            {
                System.exit(0);
            }
        }
    
    
// *************************************************
// paint, called by repaint
// *************************************************
    public void paint(Graphics g)
    {
        
        if("Sum Series".equals(command))
        {
            xCenter = (((int)this.getWidth())/2 - 100);
            yCenter = (40 + (((int)this.getHeight() - 40)/2));
            
            g.drawString("The sum is " + Double.toString(sumOfSeries), xCenter, yCenter);
            return;
        }
        
        
        if("Number of Combinations".equals(command))
        {
            xCenter = (((int)this.getWidth())/2 - 100);
            yCenter = (40 + (((int)this.getHeight() - 40)/2));
            
            if (input == null)
                g.drawString(" ", xCenter, yCenter); // Prevents display until both numbers are entered
            else
                g.drawString("The number of combinations is " + Double.toString(numCombos), xCenter, yCenter);
            return;
        }
        
        
        if("Sierpinski Triangle".equals(command))
        {
            Point p1 = new Point(getWidth()/2, 50);
            Point p2 = new Point(10, getHeight() - 50);
            Point p3 = new Point(getWidth() - 50, getHeight() - 50);
            
            sierpinskiTriangle(g, order, p1, p2, p3);
        }
        
        
        if("Towers of Hanoi".equals(command))
        {
            x = 20;
            y = 60;
            numMoves = 1;
            
            // Ensure numDisks is less than 11 and greater than 0
            
            while (numDisks > 10)
            {
                input = JOptionPane.showInputDialog(null, "Enter a number from 1 to 10.\n\n");
                numDisks = Integer.parseInt(input);
            }
            
            towersOfHanoi(g, numDisks, "A", "B", "C");
        }
    }
    
// *************************************************
// Sum of Series
// *************************************************
    public static Double sumSeries(double x)
    {
        double t = x;
        if (t == 1.0)
            return t / (2.0 * t + 1.0);
        else
            return (sumSeries(t - 1) + t / (2.0 * t + 1.0));
    }
    
// *************************************************
// Number of combinations
// *************************************************
    public static Double numberOfCombos(double x, double y)
    {
        double n = x;
        double k = y;
        if (n == 1 || n == k)
            return 1.0;
        else
            return myFactorial(n) / (myFactorial(k) * myFactorial(n - k));
    }
    
//  *************************************************
//  Determine the factorial
//  *************************************************
    public static double myFactorial(double n)
    {
        double number = n;
        if (number == 1)
            return 1;
        else 
            return (number * myFactorial(number - 1));
    }
    
 // *************************************************
 // Sierpinski Triangle
 // *************************************************
     public void sierpinskiTriangle(Graphics g, int order, Point p1, Point p2, Point p3)
     {
         if (order >= 0)
         {
             g.drawLine(p1.x, p1.y, p2.x, p2.y);
             g.drawLine(p1.x, p1.y, p3.x, p3.y);
             g.drawLine(p2.x, p2.y, p3.x, p3.y);
             
             try
             {
                 Thread.sleep(10);   // to slow the drawing of the triangles
             }
             catch (InterruptedException e)
             {
                 e.printStackTrace();
             }
             
             Point p12 = midpoint(p1, p2);
             Point p23 = midpoint(p2, p3);
             Point p31 = midpoint(p3, p1);

             sierpinskiTriangle(g, order - 1, p1, p12, p31);
             sierpinskiTriangle(g, order - 1, p12, p2, p23);
             sierpinskiTriangle(g, order - 1, p31, p23, p3);
         }
     }
     
     public Point midpoint(Point a, Point b)
     {
         return new Point((a.x + b.x) / 2, (a.y + b.y) / 2);
     }
     
     
 // *************************************************
 // Towers of Hanoi
 // *************************************************
     public void towersOfHanoi(Graphics g, int n, String A, String B, String C)
     {
         if (n == 1)
         {
             g.drawString("Move #" + (Integer.toString(numMoves++)), x, y);
             g.drawString(":  Disk " + (Integer.toString(n)), (x+60), y);
             g.drawString(" moved from " + A + " to " + B + ".", (x+105), y);
             y += 30;
             if (y > 840) // to start new column at bottom of window
             {
                 x += 250;
                 y = 60;
             }
         }
         else
         {
             towersOfHanoi(g, (n-1), A, C, B);
             g.drawString("Move #" + (Integer.toString(numMoves++)), x, y);
             g.drawString(":  Disk " + (Integer.toString(n)), (x+60), y);
             g.drawString(" moved from " + A + " to " + B + ".", (x+105), y);
             y += 30;
             if (y > 840) // to start new column at bottom of window
             {
                 x += 250;
                 y = 60;
             }
             towersOfHanoi(g, (n-1), C, B, A);
         }
     }
}
