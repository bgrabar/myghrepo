// Recursive ??????????????????????



// Order of 2 to the n

// This extracts all the subsets of a set of integers. Highest number successfully tried is 18.

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class AllSubsets {
    
    public static void main(String[] args) {
        
        // Select size of array
        int x = 17;
        
        // Populate array with random integers
        int[] array = new int[x];
        Random randomGenerator = new Random();
        for (int i = 0; i < array.length; i++) {
          array[i] = randomGenerator.nextInt(100);
          System.out.println(array[i]);
        }
        
        // Create the set
        ArrayList<Integer> set = new ArrayList<Integer>();
        
        // Do not insert repeated elements into the set.
        for (int n : array) {
            if (!set.contains(n)) {
                set.add(n);
            }
        }
        
        // Dump the set
        System.out.print("Set: ");
        dump(System.out, set);
        
        // GET SUBSETS
        ArrayList<ArrayList<Integer>> subSets = getSubsets(set);
        
        System.out.println("Subsets:");
        
        float start = System.nanoTime();
        
        // dump the subsets one by one
        for (ArrayList<Integer> subset : subSets) {
            dump(System.out, subset);
        }
        float end = System.nanoTime();
        float time = (end - start);
        
        double timeInSeconds = time * 0.000000001;
        DecimalFormat formatter = new DecimalFormat("#,###.000");
        
        JOptionPane.showMessageDialog(null, "The access time is " + formatter.format(timeInSeconds) + " seconds." );
    }
    
    private static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set) {
        
        ArrayList<ArrayList<Integer>> subsetCollection = new ArrayList<ArrayList<Integer>>();
        
        if (set.size() == 0) {
            subsetCollection.add(new ArrayList<Integer>());
        }
        else {
            ArrayList<Integer> reducedSet = new ArrayList<Integer>();
            reducedSet.addAll(set);
            int first = reducedSet.remove(0);
            ArrayList<ArrayList<Integer>> subsets = getSubsets(reducedSet);
            subsetCollection.addAll(subsets);
            subsets = getSubsets(reducedSet);
            for (ArrayList<Integer> subset : subsets)
                subset.add(0, first);
            subsetCollection.addAll(subsets);
        }
        
        return subsetCollection;
    }
    
    private static void dump(PrintStream out, ArrayList<Integer> set) {
        
        out.print("{");
        boolean first = true;
        
        for (int n : set) {
            if (first)
                first = false;
            else
                out.print(", ");
            out.printf("%1$d", n);
        }
        
        out.println("}");
    }
}