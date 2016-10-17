import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.io.IOException;
import java.io.FileReader;
// import java.io.BufferedReader;

@SuppressWarnings("serial")
public class GUIClass extends Frame implements ActionListener
{
    private String dataFilePath = null;
    private String dataFileName = null;
    
    private FileReader inputStream = null;
    private int c = 0; 
    private int characterCount[] = new int [256];
    
    // Retrieved command code
    
    private String command = "";
    
    public static void main(String[] args)
    {
        Frame frame = new GUIClass();
        frame.setResizable(true);
        frame.setSize(1000,700);
        frame.setVisible(true);
    }
    
    public GUIClass()
    {
        setTitle(" --  TITLE   GOES    HERE  --   ");
        
        // Create menu bar
        
        MenuBar mb = new MenuBar();
        setMenuBar(mb);
        
        // Create FILE MENU
        
        Menu fileMenu = new Menu("File");
        mb.add(fileMenu);
        
        // Create menu items and add action listener
        
        MenuItem miOpen = new MenuItem("Open");
        miOpen.addActionListener(this);
        fileMenu.add(miOpen);
        
        MenuItem miRead = new MenuItem("Read");
        miRead.addActionListener(this);
        fileMenu.add(miRead);
        
        MenuItem miExit = new MenuItem("Exit");
        miExit.addActionListener(this);
        fileMenu.add(miExit);
        
        // Create SEARCH MENU
        
        Menu searchMenu = new Menu("Search");
        mb.add(searchMenu);
        
        // Create menu items and add action listener
        
        MenuItem miSequentialSearch = new MenuItem("Sequential Search");
        miSequentialSearch.addActionListener(this);
        searchMenu.add(miSequentialSearch);
        
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
    
/* ************************************************************************
   actionPerformed is called by windows manager when the application window  
   performs an action (such as select a menu item, close, resize...)
   ************************************************************************ */

    public void actionPerformed (ActionEvent ev)
    {
        // determine which command was issued
        
        command = ev.getActionCommand();
        
        if("Open".equals(command))
        {
            dataFilePath = null;
            dataFileName = null;
            
              JFileChooser chooser = new JFileChooser();
              chooser.setDialogType(JFileChooser.OPEN_DIALOG );
              chooser.setDialogTitle("Open Data File");
              
              int returnVal = chooser.showOpenDialog(null);
              if( returnVal == JFileChooser.APPROVE_OPTION) 
                  {
                  dataFilePath = chooser.getSelectedFile().getPath();
                  dataFileName = chooser.getSelectedFile().getName();
                }
            repaint();
        }
        else if("Read".equals(command))
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
        else if("Sequential Search".equals(command))
        {
            repaint();
        }
        else if("Exit".equals(command))
        {
            System.exit(0);
        }
    }
    
/* *************************************************
   paint is called by repaint() to redraw the screen
   ************************************************* */
    public void paint(Graphics g)
    {
        if("Open".equals(command))
        {
            g.drawString(dataFileName + " was successfully opened.", 300, 200);
            return;
        }
        
        if("Read".equals(command))
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
        
        if("Sequential Search".equals(command))
        {
            g.drawString("placeholder", 255, 325);
        }
        
    }
}



/*
    public void actionPerformed (ActionEvent ev)
    {
        command = ev.getActionCommand();
        
        if("Display".equals(command))
        {
            repaint();
        }
        else if("Exit".equals(command))
        {
            System.exit(0);
        }
    }
    
    public void paint(Graphics g)
    {
        if("Display".equals(command))
        {
            g.drawString(" ", 0, 0);
            
            
            g.drawLine(100, 110, 140, 110);
                    g.drawLine(100, 110, 100, 130);
                    g.drawLine(100, 130, 140, 130);
                    g.drawLine(140, 110, 140, 130);
                    g.drawString((Integer.toString(70)), 115, 125);
                    g.drawLine(140, 120, 155, 120);
                    g.drawString(">", 155, 125);
            
            return;
        }
    }
*/