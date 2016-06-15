// CSC 212 sec 01 Project 2

// GUI-related imports
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// File-related imports
import java.io.FileReader;
import java.io.IOException;

@SuppressWarnings("serial")
public class CharacterCounts extends Frame implements ActionListener
{
    // File Parameters
    private String dataFilePath = null;
    private String dataFileName = null;
    private FileReader inputStream = null;
    
    // Parameter for tracking character counts
    private int c = 0; 
    private int characterCount[] = new int [256];
    
    // Retrieved command code
   
    private String command = "";
   
//******************************************************************************
//  main
//******************************************************************************

    public static void main(String[] args)
    {
        Frame frame = new CharacterCounts();
        
        frame.setResizable(true);
        frame.setSize(1000,700);
        frame.setVisible(true);
    }

//******************************************************************************
//  constructor
//******************************************************************************

    public CharacterCounts()
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
//  (select a menu item, close, resize....)
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
                // Set initial character counts to zero before reading the file
                
                for (int i = 0; i <= 255; i++)
                {
                    characterCount[i] = 0;
                }
                
                // Open the file for reading

                inputStream = new FileReader(dataFilePath);  
                
                // Read the file and count characters
                
                while ((c = inputStream.read()) != -1) 
                {
                    characterCount[c]++;
                }
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
                // Display Titles
                
                int x = 20;
                int y = 60;
                g.drawString("Int", x, y);
                g.drawString("Char", x+40, y);
                g.drawString("Count", x+80, y);
                g.drawString("_________________", x, ++y);

                // Display Results
                
                int integerObject = 0;

                for (int i = 0; i <= 255; i++)
                {
                    y += 20;
                    
                    integerObject = i;
                    
                    g.drawString(Integer.toString(integerObject), x, y);
                    g.drawString(Character.toString((char)i), x+40, y);
                    g.drawString(Integer.toString(characterCount[i]), x+80, y);
                    
                    if (i == 39)
                    {
                      x = 200;
                      y = 60;
                      g.drawString("Int", x, y);
                      g.drawString("Char", x+40, y);
                      g.drawString("Count", x+80, y);
                      g.drawString("_________________", x, ++y);
                    }

                    if (i == 79)
                    {
                      x = 380;
                      y = 60;
                      g.drawString("Int", x, y);
                      g.drawString("Char", x+40, y);
                      g.drawString("Count", x+80, y);
                      g.drawString("_________________", x, ++y);
                    }

                    if (i == 119)
                    {
                      x = 560;
                      y = 60;
                      g.drawString("Int", x, y);
                      g.drawString("Char", x+40, y);
                      g.drawString("Count", x+80, y);
                      g.drawString("_________________", x, ++y);
                    }

                    if (i == 159)
                    {
                      x = 740;
                      y = 60;
                      g.drawString("Int", x, y);
                      g.drawString("Char", x+40, y);
                      g.drawString("Count", x+80, y);
                      g.drawString("_________________", x, ++y);
                    }

                    if (i == 199)
                    {
                      x = 920;
                      y = 60;
                      g.drawString("Int", x, y);
                      g.drawString("Char", x+40, y);
                      g.drawString("Count", x+80, y);
                      g.drawString("_________________", x, ++y);
                    }

                    if (i == 239)
                    {
                      x = 1100;
                      y = 60;
                      g.drawString("Int", x, y);
                      g.drawString("Char", x+40, y);
                      g.drawString("Count", x+80, y);
                      g.drawString("_________________", x, ++y);
                    }
                }
                return;
            }
    }
}
