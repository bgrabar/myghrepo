// Project 4 CSC 212 sec 01

// GUI-related imports

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// File-related imports

import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.util.Arrays;

@SuppressWarnings("serial")
public class SearchAlgorithms extends Frame implements ActionListener
{
    // For reading files
    private String dataFilePath = null;
    private String dataFileName = null;
    private String keysFilePath = null;
    private String keysFileName = null;
    
    // Arrays and array data
    private int[] originalArray = new int[1000000];
    private int[] sortedArray = new int[1000000];
    private int[] hashedArray = new int[2000000];
    private int[] bucketArray = new int[2000000];
    private int[] keysArray = new int[1000000];

    private int numberOfDataItems   = 0;
    private int numberOfKeys        = 0;
    
    private int largestPrime;
    private boolean isPrime;
    
    // Statistics
    private long ssAvgAccessTime           = 0;
    private long ssNumberKeysFound         = 0;
    private long ssAvgComparisonsPerFound  = 0;
    private long ssNumberKeysNotFound      = 0;
    private long ssAvgCompPerNotFound      = 0;
    
    private long binAvgAccessTime          = 0;
    private long binNumberKeysFound        = 0;
    private long binAvgComparisonsPerFound = 0;
    private long binNumberKeysNotFound     = 0;
    private long binAvgCompPerNotFound     = 0;
    
    private long hsAvgAccessTime           = 0;
    private long hsNumberKeysFound         = 0;
    private long hsAvgComparisonsPerFound  = 0;
    private long hsNumberKeysNotFound      = 0;
    private long hsAvgCompPerNotFound      = 0;
    
    private long bktAvgAccessTime          = 0;
    private long bktNumberKeysFound        = 0;
    private long bktAvgComparisonsPerFound = 0;
    private long bktNumberKeysNotFound     = 0;
    private long bktAvgCompPerNotFound     = 0;
    
    // Retrieved command code
    private String command = "";
    
    public static void main(String[] args)
    {
        Frame frame = new SearchAlgorithms();
        
        
        frame.setResizable(false);
        frame.setSize(900,620);
        frame.setVisible(true);
    }
    
    public SearchAlgorithms()
    {
        setTitle("Search Routines");
        
        // Create Menu Bar
        MenuBar mb = new MenuBar();
        setMenuBar(mb);
        
        // Create Menu Group Labeled "File"
        Menu FileMenu = new Menu("File");
        
        // Add it to Menu Bar
        mb.add(FileMenu);
        
        // Create Menu Items
        // Add action Listener 
        // Add to "File" Menu Group
        
        MenuItem miOpen = new MenuItem("Open");
        miOpen.addActionListener(this);
        FileMenu.add(miOpen);
                        
        MenuItem miExit = new MenuItem("Exit");
        miExit.addActionListener(this);
        FileMenu.add(miExit);

        // Create Menu Group Labeled "File"
        Menu SearchMenu = new Menu("Search");
        
        // Add it to Menu Bar
        mb.add(SearchMenu);
        
        // Create Menu Items
        // Add action Listener 
        // Add to "Search" Menu Group
        
        MenuItem miSearch = new MenuItem("Search");
        miSearch.addActionListener(this);
        SearchMenu.add(miSearch);
        
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
        
        // Register listeners
            
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
                    
        if ("Open".equals(command))
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
            // read data file and copy it to original array
            try
            {
                numberOfDataItems = ReadFileIntoArray(dataFilePath,"Original");
                // System.out.println(numberOfDataItems);
            }
            catch (IOException ioe)
            {
                System.exit(0); 
            }
            
            // read keys
            keysFilePath = null;
            keysFileName = null;
            
            chooser.setDialogType(JFileChooser.OPEN_DIALOG );
            chooser.setDialogTitle("Open Keys File");
            
            returnVal = chooser.showOpenDialog(null);
            if (returnVal == JFileChooser.APPROVE_OPTION) 
            {
                keysFilePath = chooser.getSelectedFile().getPath();
                keysFileName = chooser.getSelectedFile().getName();
            }
            try
            {
                numberOfKeys = ReadFileIntoArray(keysFilePath, "Keys");
            }
            catch (IOException ioe)
            {
                System.exit(0); 
            }
            repaint();        
        }
        
        else
            if ("Exit".equals(command))
            {
                System.exit(0);
            }
        else
            if ("Search".equals(command))
            {
                SequentialSearch();
                BinarySearch();
                HashedSearch();
                BucketSearch();
                repaint();
            }
    }


//********************************************************
// called by repaint() to redraw the screen
//********************************************************
        
    public void paint(Graphics g)
    {
        if ("Open".equals(command))
        {
            // Acknowledge that file was opened
            
            if (dataFileName != null)
            {
                g.drawString("File --  "+dataFileName+"  -- was successfully opened", 300, 200);
                g.drawString("Number of Data Items = "+Integer.toString(numberOfDataItems), 330, 250);
            }
            else
            {
                g.drawString("NO Data File is Open", 300, 200);
            }
            if (keysFileName != null)
            {
                g.drawString("File --  "+keysFileName+"  -- was successfully opened", 300, 300);
                g.drawString("Number of Keys = "+Integer.toString(numberOfKeys), 330, 350);
            }
            else
            {
                g.drawString("NO Keys File is Open", 300, 300);
            }
            return;    
        }

        if ("Search".equals(command)  )
        {
            g.drawLine(70,120,820,120);   // outer box
            g.drawLine(70,120,70,520);    // outer box
            g.drawLine(70,520,820,520);   // outer box
            g.drawLine(820,120,820,520);  // outer box

            g.drawString("Experiment", 120, 230);

            g.drawLine(240,120,240,520);  // vertical line

            g.drawString("Data File Attributes --  " + dataFileName, 425, 150);
            g.drawString("Key File Attributes -- " + keysFileName, 425, 180);

            g.drawLine(240,200,820,200);
            g.drawString("Measured Criteria", 500, 220);
            g.drawLine(240,230,820,230);

            g.drawString("Average", 270, 260);
            g.drawString("Access", 270, 275);
            g.drawString("Time", 270, 290);

            g.drawLine(355,230,355,520);  // vertical line
            g.drawString("Successful Search", 400, 250);
            g.drawLine(355,260,820,260);
            g.drawString("# Keys Found", 370, 280);

            g.drawLine(465,260,465,520);  // vertical line
            g.drawString("Average No.", 480, 280);
            g.drawString("of Comparisons", 480, 295);

            g.drawLine(575,230,575,520);  // vertical line
            g.drawString("Unsuccessful Search", 600, 250);
            g.drawString("# Keys", 590, 280);
            g.drawString("Not Found", 590, 295);

            g.drawLine(685,260,685,520);  // vertical line
            g.drawString("Average No.", 700, 280);
            g.drawString("of Comparisons", 700, 295);

            g.drawLine(70,310,820,310);
            g.drawString("Sequential Search", 90, 325);
            g.drawString(Long.toString(ssAvgAccessTime), 255, 325);
            g.drawString(Long.toString(ssNumberKeysFound), 365, 325);
            g.drawString(Long.toString(ssAvgComparisonsPerFound), 475, 325);
            g.drawString(Long.toString(ssNumberKeysNotFound), 585, 325);
            g.drawString(Long.toString(ssAvgCompPerNotFound), 695, 325);

            g.drawLine(70,340,820,340);
            g.drawString("Binary Search", 90, 355);
            g.drawString(Long.toString(binAvgAccessTime), 255, 355);
            g.drawString(Long.toString(binNumberKeysFound), 365, 355);
            g.drawString(Long.toString(binAvgComparisonsPerFound), 475, 355);
            g.drawString(Long.toString(binNumberKeysNotFound), 585, 355);
            g.drawString(Long.toString(binAvgCompPerNotFound), 695, 355);

            g.drawLine(70,370,820,370);
            g.drawString("Hashed Search", 90, 385);
            g.drawString(Long.toString(hsAvgAccessTime), 255, 385);
            g.drawString(Long.toString(hsNumberKeysFound), 365, 385);
            g.drawString(Long.toString(hsAvgComparisonsPerFound), 475, 385);
            g.drawString(Long.toString(hsNumberKeysNotFound), 585, 385);
            g.drawString(Long.toString(hsAvgCompPerNotFound), 695, 385);

            g.drawLine(70,400,820,400);
            g.drawString("Bucket Hashed, 50", 90, 415);
            g.drawString(Long.toString(bktAvgAccessTime), 255, 415);
            g.drawString(Long.toString(bktNumberKeysFound), 365, 415);
            g.drawString(Long.toString(bktAvgComparisonsPerFound), 475, 415);
            g.drawString(Long.toString(bktNumberKeysNotFound), 585, 415);
            g.drawString(Long.toString(bktAvgCompPerNotFound), 695, 415);


        }
    }

    
    public int ReadFileIntoArray(String filePath , String type) throws IOException
    {
        if (filePath != null)
        {
            int index = 0;
            Scanner integerTextFile = new Scanner(new File(filePath));     
            while (integerTextFile.hasNext())
            {
                    // read the next integer
                if ("Original".equals(type))
                originalArray[index] = integerTextFile.nextInt();
                else
                  keysArray[index]= integerTextFile.nextInt();
                index++;
            }
                //  end of file detected
            integerTextFile.close();
            return index ;

        }
        else
            return 0;
    }


//********************************************************
//  SEQUENTIAL SEARCH
//********************************************************
    public void SequentialSearch() 
    {
      ssAvgAccessTime          = 0;
      ssNumberKeysFound        = 0;
      ssAvgComparisonsPerFound = 0;
      ssNumberKeysNotFound     = 0;
      ssAvgCompPerNotFound     = 0;
      int searchValue;
      int totalComparisonsForKey;
      int totalComparisonsAllFound = 0;
      int totalComparisonsAllNotFound = 0;
      boolean found;

      long startTime = System.nanoTime();
      for (int k = 0; k < numberOfKeys; k++)
      {
          found = false;
          searchValue = keysArray[k];
          totalComparisonsForKey = 0;
          for (int d = 0; d < numberOfDataItems; d++)
          {
              totalComparisonsForKey++;
              if (searchValue == originalArray[d])
                  found = true;
              if (found)
                  break;
          }
          if (found)
          {
              ssNumberKeysFound ++;
              totalComparisonsAllFound = totalComparisonsAllFound + totalComparisonsForKey;
          }
          else
          {
              ssNumberKeysNotFound ++;
              totalComparisonsAllNotFound = totalComparisonsAllNotFound + totalComparisonsForKey;
          }
      }

      long estimatedTime = System.nanoTime() - startTime;

      if (numberOfKeys != 0)
            ssAvgAccessTime = Math.round((estimatedTime/numberOfKeys));
      else
            ssAvgAccessTime = 0;

      if (ssNumberKeysFound != 0)
            ssAvgComparisonsPerFound = totalComparisonsAllFound / ssNumberKeysFound;
      else
            ssAvgComparisonsPerFound = 0;

      if (ssNumberKeysNotFound != 0)
            ssAvgCompPerNotFound = totalComparisonsAllNotFound / ssNumberKeysNotFound;
      else
            ssNumberKeysNotFound = 0;

      return;
    }


//********************************************************
//  BINARY SEARCH
//********************************************************
    public void BinarySearch() 
    {
        binAvgAccessTime          = 0;
        binNumberKeysFound        = 0;
        binAvgComparisonsPerFound = 0;
        binNumberKeysNotFound     = 0;
        binAvgCompPerNotFound     = 0;
        int searchValue;
        int totalComparisonsForKey;
        int low, high, mid;
        int totalComparisonsAllFound = 0;
        int totalComparisonsAllNotFound = 0;
        boolean found;
        
        // Read orignal array into binary-search array
        System.arraycopy(originalArray, 0, sortedArray, 0, numberOfDataItems);
        
        // Sort the binary-search array
        Arrays.sort(sortedArray, 0, numberOfDataItems - 1);
        
        // for (int t = 0; t < numberOfDataItems; t++) System.out.println(sortedArray[t]);
        
        long startTime = System.nanoTime();
        for (int k = 0; k < numberOfKeys; k++)
        {
            found = false;
            searchValue = keysArray[k];
            totalComparisonsForKey = 0;
            low = 0;
            high = numberOfDataItems - 1;
            while (low <= high && !found)
            {
                totalComparisonsForKey++;
                mid = (low + high) / 2;
                if (searchValue == sortedArray[mid])
                {
                  found = true;
                  break;
                }
                else if (sortedArray[mid] > searchValue)
                    high = mid - 1;
                else
                    low = mid + 1;
            }
            if (found)
            {
                binNumberKeysFound ++;
                totalComparisonsAllFound = totalComparisonsAllFound + totalComparisonsForKey;
            }
            else
            {
                binNumberKeysNotFound ++;
                totalComparisonsAllNotFound = totalComparisonsAllNotFound + totalComparisonsForKey;
            }
        }
        long estimatedTime = System.nanoTime() - startTime;

        if (numberOfKeys != 0)
            binAvgAccessTime = Math.round((estimatedTime/numberOfKeys));
        else
            binAvgAccessTime = 0;

        if (binNumberKeysFound != 0)
            binAvgComparisonsPerFound = totalComparisonsAllFound / binNumberKeysFound;
        else
            binAvgComparisonsPerFound = 0;

        if (binNumberKeysNotFound != 0)
            binAvgCompPerNotFound = totalComparisonsAllNotFound / binNumberKeysNotFound;
        else
            binNumberKeysNotFound = 0;

        return;
    }


//********************************************************
//  HASH SEARCH
//********************************************************
    public void HashedSearch() 
    {
      hsAvgAccessTime          = 0;
      hsNumberKeysFound        = 0;
      hsAvgComparisonsPerFound = 0;
      hsNumberKeysNotFound     = 0;
      hsAvgCompPerNotFound     = 0;
      
      largestPrime = 0;
      isPrime = false;
      int hashIndex;
      boolean stored;
      int probe;
      
      int searchValue;
      int totalComparisonsForKey;
      int totalComparisonsAllFound = 0;
      int totalComparisonsAllNotFound = 0;
      boolean found;
      
      // Find largest prime smaller than two times data set
      
      for (int i = ((2 * numberOfDataItems) - 1); i > 1; i -= 2)
      {
          isPrime = true;
          for (int j = 3; j <= Math.sqrt(2 * numberOfDataItems); j++)
          {
              if (i % j == 0)
              {
                  isPrime = false;
              }
          }
          if (isPrime == true)
          {
           largestPrime = i;
           break;
          }
      }
      //System.out.println("largestPrime = " + largestPrime);
      
      // Set the hash list's initial values to -1
      for (int k = 0; k < largestPrime; k++)
      {
          hashedArray[k] = -1;
          // System.out.println(hashedArray[k]);
      }
      
      // Store the data set in the hash list
      for (int m = 0; m < numberOfDataItems; m++)
      {
          hashIndex = originalArray[m]%largestPrime;
          // System.out.println(hashIndex);
          
          if (hashedArray[hashIndex] == -1)
          {
              hashedArray[hashIndex] = originalArray[m];
              stored = true;
              // System.out.println(stored);
          }
          else
          {
              stored = false;
              // System.out.println(stored);
              probe = hashIndex + 1;
              // System.out.println(probe);
              while (!stored)
              {
                  // System.out.println("  " + probe);
                  if (hashedArray[probe] == -1)
                  {
                      hashedArray[probe] = originalArray[m];
                      stored = true;
                      // System.out.println("  " + stored);
                  }
                  else
                      probe++;
              }
          }
      }
      
      // Locate the keys in the hash list
      long startTime = System.nanoTime();
      for (int n = 0; n < numberOfKeys; n++)
      {
          found = false;
          searchValue = keysArray[n];
          hashIndex = keysArray[n]%largestPrime;
          totalComparisonsForKey = 0;
          
          if (hashedArray[hashIndex] == searchValue)
          {
              found = true;
              totalComparisonsForKey++;
          }
          else
          {
              if (hashedArray[hashIndex] == -1)
              {
                  found = false;
                  totalComparisonsForKey++;
              }
              while (hashedArray[hashIndex] != -1 && hashedArray[hashIndex] != searchValue && found != true)
              {
                  hashIndex++;
                  totalComparisonsForKey++;
                  if (hashedArray[hashIndex] == searchValue)
                  {
                      found = true;
                  }
              }
          }

          if (found)
          {
              hsNumberKeysFound ++;
              totalComparisonsAllFound = totalComparisonsAllFound + totalComparisonsForKey;
          }
          else
          {
              hsNumberKeysNotFound ++;
              totalComparisonsAllNotFound = totalComparisonsAllNotFound + totalComparisonsForKey;
          }
      }        
      long estimatedTime = System.nanoTime() - startTime;

      if (numberOfKeys != 0)
          hsAvgAccessTime = Math.round((estimatedTime/numberOfKeys));
      else
          hsAvgAccessTime = 0;

      if (hsNumberKeysFound != 0)
          hsAvgComparisonsPerFound = totalComparisonsAllFound / hsNumberKeysFound;
      else
          hsAvgComparisonsPerFound = 0;

      if (hsNumberKeysNotFound != 0)
          hsAvgCompPerNotFound = totalComparisonsAllNotFound / hsNumberKeysNotFound;
      else
          hsNumberKeysNotFound = 0;

      return;
    }


//********************************************************
//  BUCKET SEARCH
//********************************************************
    public void BucketSearch() 
    {
      bktAvgAccessTime          = 0;
      bktNumberKeysFound        = 0;
      bktAvgComparisonsPerFound = 0;
      bktNumberKeysNotFound     = 0;
      bktAvgCompPerNotFound     = 0;
      
      isPrime = false;

      int index;
      boolean stored;
      int probe;
      
      int searchValue;
      int totalComparisonsForKey;
      int totalComparisonsAllFound = 0;
      int totalComparisonsAllNotFound = 0;
      boolean found;
      
      // create buckets
      int noBuckets = ((largestPrime / 50) + 1);
      int arraySize = noBuckets * 50;
      
      // System.out.println("noBuckets = " + noBuckets);
      // System.out.println("largestPrime = " + largestPrime);

      // Set the bucket array's initial values to -1
//    for (int i = 0; i < (noBuckets * 50); i++)    THIS APPARENTLY DOES NOT WORK
      for (int i = 0; i < (arraySize); i++)
      {
          bucketArray[i] = -1;
          // System.out.println(bucketArray[i]);
      }

      // Store the data set in the bucket array
      for (int j = 0; j < numberOfDataItems; j++)
      {
          index = (originalArray[j]%noBuckets) * 50;
          // System.out.println(index);

          if (bucketArray[index] == -1)
          {
              bucketArray[index] = originalArray[j];
              stored = true;
              // System.out.println(stored);
          }
          else
          {
              stored = false;
              // System.out.println(stored);
              probe = index + 1;
              // System.out.println(probe);
              while (!stored)
              {
                  // System.out.println("  " + probe);
                  if (bucketArray[probe] == -1)
                  {
                      bucketArray[probe] = originalArray[j];
                      stored = true;
                      // System.out.println("  " + stored);
                  }
                  else
//                    probe=(probe+1)%(noBuckets*50);     THIS APPARENTLY DOES NOT WORK
                      probe=(probe+1)%(arraySize);
                   // probe++;
              }
          }
      }

      // Locate the keys
      long startTime = System.nanoTime();
      for (int n = 0; n < numberOfKeys; n++)
      {
          found = false;
          searchValue = keysArray[n];
          index = (keysArray[n]%noBuckets) * 50;
          totalComparisonsForKey = 0;
          
          if (bucketArray[index] == searchValue)
          {
              found = true;
              totalComparisonsForKey++;
          }
          else
          {
              if (bucketArray[index] == -1)
              {
                  found = false;
                  totalComparisonsForKey++;
              }

              index++;
              totalComparisonsForKey++;
              int counter = 1;
              while (bucketArray[index] != -1 && bucketArray[index] != searchValue && found != true)
              {
                  if (counter == 50)
                  {
                      totalComparisonsForKey++;
                      counter = 0;
                  }
                  
                  if (bucketArray[index] == searchValue)
                  {
                      found = true;
                  }
                  index++;
                  counter++;
              }
          }

          if (found)
          {
              bktNumberKeysFound ++;
              totalComparisonsAllFound = totalComparisonsAllFound + totalComparisonsForKey;
          }
          else
          {
              bktNumberKeysNotFound ++;
              totalComparisonsAllNotFound = totalComparisonsAllNotFound + totalComparisonsForKey;
          }
      }        
      long estimatedTime = System.nanoTime() - startTime;

      if (numberOfKeys != 0)
          bktAvgAccessTime = Math.round((estimatedTime/numberOfKeys));
      else
          bktAvgAccessTime = 0;

      if (bktNumberKeysFound != 0)
          bktAvgComparisonsPerFound = totalComparisonsAllFound / bktNumberKeysFound;
      else
          bktAvgComparisonsPerFound = 0;

      if (bktNumberKeysNotFound != 0)
          bktAvgCompPerNotFound = totalComparisonsAllNotFound / bktNumberKeysNotFound;
      else
          bktNumberKeysNotFound = 0;

      return;
    }
}