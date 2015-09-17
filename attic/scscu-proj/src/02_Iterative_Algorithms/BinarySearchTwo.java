// Order of n log n

/* This app (derived from a GUI app I created for 212) searches data sets of up 
 * to 16m for the key "7". The key is found only in the first postion in each 
 * data set, giving each search the worst case outcome for a scenario where 
 * the key exists. 
 * Use the data sets titled "N is XXm.txt"
 */

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.*;

@SuppressWarnings("serial")
public class BinarySearchTwo extends Frame implements ActionListener {

    private String dataFilePath = null;
    private String dataFileName = null;
    private int[] a = new int[20000000];
    private int numberOfDataItems = 0;
    private long time = 0;
    private String command = "";
    
    public static void main(String[] args)     {
        Frame frame = new BinarySearchTwo();
        frame.setResizable(false);
        frame.setSize(900,620);
        frame.setVisible(true);
    }
    public BinarySearchTwo() {
        setTitle("Binary Search");
        
        MenuBar mb = new MenuBar();
        setMenuBar(mb);
        
        Menu FileMenu = new Menu("File");
        mb.add(FileMenu);
        
        MenuItem miOpen = new MenuItem("Open a data file");
        miOpen.addActionListener(this);
        FileMenu.add(miOpen);
        
        MenuItem miSearch = new MenuItem("Search for 7");
        miSearch.addActionListener(this);
        FileMenu.add(miSearch);
        
        MenuItem miExit = new MenuItem("Exit");
        miExit.addActionListener(this);
        FileMenu.add(miExit);
        
        WindowListener l = new WindowAdapter() {
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
        
        ComponentListener k = new ComponentAdapter() {
            public void componentResized(ComponentEvent e) 
            {
                repaint();           
            }
        };
        
        this.addWindowListener(l);
        this.addComponentListener(k);
    }
    public void actionPerformed (ActionEvent ev) {
        command = ev.getActionCommand();
        
        if ("Open a data file".equals(command)) {
            dataFilePath = null;
            dataFileName = null;
            JFileChooser chooser = new JFileChooser();
            chooser.setDialogType(JFileChooser.OPEN_DIALOG );
            chooser.setDialogTitle("Open Data File");
            
            int returnVal = chooser.showOpenDialog(null);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                dataFilePath = chooser.getSelectedFile().getPath();
                dataFileName = chooser.getSelectedFile().getName();
            }
            // read data file and copy it to original array
            try {
                numberOfDataItems = ReadFileIntoArray(dataFilePath,"Original");
            }
            catch (IOException ioe) {
                System.exit(0); 
            }
            repaint();        
        }
        else
            if ("Search for 7".equals(command)) {
                Search(7);
                repaint();
            }
        else
            if ("Exit".equals(command)) {
                System.exit(0);
            }
    }
    public void paint(Graphics g)
    {
        if ("Open a data file".equals(command)) {
            if (dataFileName != null) {
                g.drawString("The file \"" + dataFileName + "\" is now open.", 300, 200);
            }
            else {
                g.drawString("No data file is opened.", 300, 200);
            }
            return;
        }
        
        if ("Search for 7".equals(command) ) {
            g.drawString("The access time is " + 
                    Long.toString(time) + ".", 90, 355);
        }
    }
    public int ReadFileIntoArray(String filePath , String type) throws IOException {
        if (filePath != null) {
            int index = 0;
            Scanner integerTextFile = new Scanner(new File(filePath));
            while (integerTextFile.hasNext()) {
                a[index] = integerTextFile.nextInt();
                index++;
            }
            integerTextFile.close();
            return index ;
        }
        else
            return 0;
    }
    public void Search(int value) {
        int searchValue = value;
        int low, high, mid;
        boolean found;
        
        Arrays.sort(a, 0, numberOfDataItems - 1);
        found = false;
        low = 0;
        high = numberOfDataItems - 1;
        
        // Start timer
        long start = System.nanoTime();
        
        while (low <= high && !found) {
            mid = (low + high) / 2;
            if (searchValue == a[mid]) {
                found = true;
                break;
            }
            else if (a[mid] > searchValue)
                high = mid - 1;
            else
                low = mid + 1;
        }
        // Stop timer
        long end = System.nanoTime();
        time = (end - start);
        
        return;
    }
}