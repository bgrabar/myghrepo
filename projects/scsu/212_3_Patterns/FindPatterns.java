// Project 3 CSC 212 sec 01

/* ************************************
 * NOTE: This not only centers the grid
 * but also keeps the top and left of 
 * the grid in the viewable area if the 
 * user makes the window very small.
 ************************************** */


// for gui
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// for reading files
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

@SuppressWarnings("serial")
public class FindPatterns extends Frame implements ActionListener
{
    // for reading files
    private String dataFilePath = null;
    private String dataFileName = null;
    private File fileToRead;
    private Scanner fileInput;
    
    // for processing arrays
    private int numRows = 0; 
    private int numCols = 0; 
    private int[][] array;
    private int[][] arrayWithColors;
    
    // for displaying grid
    private int xCenter;
    private int yCenter;
    private int x;
    private int y;
    
    // Retrieved command code
    
    private String command = "";
    
    public static void main(String[] args)
    {
        Frame frame = new FindPatterns();
        
        frame.setResizable(true);
        frame.setSize(1000,700);
        frame.setVisible(true);
    }

    public FindPatterns()
    {
        setTitle("Text File Processing");

        // Create Menu Bar
           
        MenuBar mb = new MenuBar();
        setMenuBar(mb);

        // Create Menu Group Labeled "File"

        Menu menu = new Menu("File");

        // Add it to Menu Bar

        mb.add(menu);

        // Create Menu Items
        // Add action Listener 
        // Add to "File" Menu Group

        MenuItem miOpen = new MenuItem("Open");
        miOpen.addActionListener(this);
        menu.add(miOpen);

        MenuItem miProcess = new MenuItem("Process");
        miProcess.addActionListener(this);
        menu.add(miProcess);

        MenuItem miExit = new MenuItem("Exit");
        miExit.addActionListener(this);
        menu.add(miExit);

        // End program when window is closed

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

//******************************************************************************
//  called by windows manager whenever the application window performs an action
//  (select a menu item, close, resize, ....
//******************************************************************************

    public void actionPerformed (ActionEvent ev)
    {
        // figure out which command was issued

        command = ev.getActionCommand();

        // take action accordingly

        if("Open".equals(command))
        {
        dataFilePath = null;
        dataFileName = null;

        JFileChooser chooser = new JFileChooser();
        chooser.setDialogType(JFileChooser.OPEN_DIALOG );
        chooser.setDialogTitle("Open Data File");
                  
        int returnVal = chooser.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) 
        {
            dataFilePath = chooser.getSelectedFile().getPath();
            dataFileName = chooser.getSelectedFile().getName();
        }
           
        repaint();
        
        }
        else
        if("Process".equals(command))
        {
            try 
            {
            // Open the file for reading

            fileToRead = new File(dataFilePath);
            fileInput = new Scanner(fileToRead);
            
            // Set the array parameters
            
            numRows = fileInput.nextInt();
            numCols = fileInput.nextInt();
            
            array = new int[numRows][numCols];
            arrayWithColors = new int[numRows][numCols];
            
            // Read the file into two arrays
            
            for (int i = 0; i < array.length; i++)
            {
                for (int j = 0; j < array[i].length; j++)
                {
                    array[i][j] = fileInput.nextInt();
                    arrayWithColors[i][j] = 0;
                }
            }

            // Identify groups of four
            
            for (int i = 0; i < array.length; i++)
            {
                for (int j = 0; j < array[i].length; j++)
                {
                    
                    // Identify horizontal combinations
                    if (j < array[i].length - 3)
                    {
                        if (array[i][j] == array[i][j + 1] &&
                            array[i][j + 1] == array[i][j + 2] &&
                            array[i][j + 2] == array[i][j + 3])
                        {
                            for (int k = j; k <= (j + 3); k++)
                                arrayWithColors[i][k] = 1;
                        }
                    }

                    // Identify vertical combinations
                    if (i < array.length - 3)
                    {
                        if (array[i][j] == array[i + 1][j] &&
                            array[i + 1][j] == array[i + 2][j] &&
                            array[i + 2][j] == array[i + 3][j])
                        {
                            for (int k = i; k <= (i + 3); k++)
                                arrayWithColors[k][j] = 2;
                        }
                    }

                    // Identify downward right diagonals
                    if (i < array.length - 3 && j < array[i].length - 3)
                    {
                        if (array[i][j] == array[i + 1][j + 1] &&
                            array[i + 1][j + 1] == array[i + 2][j + 2] &&
                            array[i + 2][j + 2] == array[i + 3][j + 3])
                        {
                            for (int k = i, m = j; k <= (i + 3) && m <= (j + 3); k++, m++)
                                arrayWithColors[k][m] = 3;
                        }
                    }

                    // Identify downward left diagonals
                    if (i < array.length - 3 && j > 2)
                    {
                        if (array[i][j] == array[i + 1][j - 1] &&
                            array[i + 1][j - 1] == array[i + 2][j - 2] &&
                            array[i + 2][j - 2] == array[i + 3][j - 3])
                        {
                            for (int k = i, m = j; k <= (i + 3) && m >= (j - 3); k++, m--)
                            {    
                                arrayWithColors[k][m] = 4;
                                // for testing
                                //JOptionPane.showMessageDialog(null, "i: " + i + " j: " + j + " k: " + k + " m: " + m);
                            }
                        }
                    }
                }
            }
            
            
            fileInput.close();
            
            }
            catch(IOException ioe)
            {
            System.exit(0);
            }
            
            repaint();
            
        }
        else
        if("Exit".equals(command))
        {
            System.exit(0);
        }

    }

//********************************************************
// called by repaint() to redraw the screen
//********************************************************

    public void paint(Graphics g)
    {
        if("Open".equals(command))
        {
        // Acknowledge that file was opened
        if (dataFileName != null)
        {
            g.drawString("File --  "+dataFileName+"  -- was successfully opened", 400, 400);
        }
        else
        {
            g.drawString("NO File is Open", 400, 400);
        }
        
        return;
        }
        else
        if("Process".equals(command))
        {
            // Display Results
            
            // for centering grid
            
            xCenter = (((int)this.getWidth())/2);
            yCenter = (60 + (((int)this.getHeight() - 60)/2));
            
            // for displaying grid
            
            x = (xCenter - (15 * numCols/2));
            y = (yCenter - (15 * numRows/2));
            
            // keep grid within viewable area by not 
            // letting x and y coordinates fall too low
            
            if (x < 5)
            x = 5;
            if (y < 60)
            y = 60;

            // create and display grid
            
            for (int i = 0; i < numRows; i++)
            {
            for (int j = 0; j < numCols; j++)
            {
                if (arrayWithColors[i][j] == 0)
                    g.setColor(Color.black);
                
                if (arrayWithColors[i][j] == 1)
                    g.setColor(Color.orange);
                
                if (arrayWithColors[i][j] == 2)
                    g.setColor(Color.green);
                
                if (arrayWithColors[i][j] == 3)
                    g.setColor(Color.blue);
                
                if (arrayWithColors[i][j] == 4)
                    g.setColor(Color.red);
                
                g.drawString(Integer.toString(array[i][j]), x, y);
                
                x = x + 15;
            }
            
            // to draw next row of grid
            
            x = (xCenter - (15 * numCols/2));
            
            if (x < 5)  // to keep grid within viewable area 
                x = 5;
            
            y = y + 15;
            
            }
                
            return;
        }
    }
}
