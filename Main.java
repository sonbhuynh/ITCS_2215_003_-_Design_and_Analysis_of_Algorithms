
/*
 * Name:	Son Huynh
 * Date:	10/31/2015
 */

import java.io.*;				//Needed for File and IOException

public class Main {
	public static void main(String[] args)throws IOException{
		
		//Declaration of variables
	    int[] size = new int [] {50, 500, 5000, 50000, 500000};
	    String[] path = new String [] {"output50.txt", "output500.txt", "output5000.txt", "output50000.txt", "output500000.txt"};	    
	   
	    NumberGenerator.generate(path, size);

        System.out.println("Data has been written to the file.");		//Output success message.
        
        // ****************** Bubble Sort ******************
	    for (int x = 0; x < path.length; x++)
	    {
	    	File outputFile = new File (path[x]);
	    	BubbleSort.sortFile(outputFile, size[x]);
	    }       
        
    	// ****************** Insertion Sort ******************	    
	    for (int x = 0; x < path.length; x++)
	    {
	    	File outputFile = new File (path[x]);
	    	InsertionSort.sortFile(outputFile, size[x]);
	    }       	    
    	
		// ****************** Merge Sort ****************** 
	    for (int x = 0; x < path.length; x++)
	    {
	    	File outputFile = new File (path[x]);
	    	MergeSort.sortFile(outputFile, size[x]);
	    }
	    
	 	// ****************** Quick Sort ****************** 
	    for (int x = 0; x < path.length; x++)
	    {
	    	File outputFile = new File (path[x]);
	    	QuickSort.sortFile(outputFile, size[x]);
	    }
	}
}
