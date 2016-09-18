import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Name:	Son Huynh
 * Date:	10/31/2015
 */

public class InsertionSort
{
	public static void sort(int[] randomArray, int size) throws IOException
	{
	    PrintWriter outputInsertion = new PrintWriter("outputInsertion" + size +".txt");		//Creating a PrintWriter object
	    PrintWriter outputInsertionEfficiency = new PrintWriter(new FileWriter("outputInsertionEfficiency" + size + ".txt", true)); 	    

	    long startTime = System.nanoTime();											//Recording the stop time in nanoseconds
	    long runTime = 0;															//Initializing variable to 0	    
	    
    	for (int x = 1; x < randomArray.length; x++)
    	{
    		int v = randomArray[x];													//Assign value being used to compare to a temp variable
    		int j = x - 1;															//Subtract 1 from the current index and assigning to j
    		
    		while (j >= 0 && randomArray[j] > v)
    		{
    			randomArray[j + 1] = randomArray[j];								//Assign the value before to the value after
    			j--;
    		}
    		randomArray[j + 1] = v;													//Putting value of the temp variable into value at j+1
    	}
    	
    	long stopTime = System.nanoTime();											//Recording the stop time in nanoseconds
    	runTime = stopTime - startTime;												//Calculating time ran in nanoseconds    	
    	
		for (int x = 0; x < randomArray.length; x++)
		{
    		outputInsertion.println(randomArray[x]);								//Outputting bubble sort result to the outputInsertion file
		}     	
		
		outputInsertionEfficiency.println(randomArray.length + "\t" + runTime);
		outputInsertionEfficiency.close();		
    	
		outputInsertion.close();													//Close the outputBubble file
    	System.out.println();
    	System.out.println("Insertion Sort " + size + " result has been written to a file.");			//Output success message
    	System.out.println("Time took to Insertion Sort " + size + ": " + runTime + " nanoseconds.");	//Output time the sort took to run    	
	}
	
	public static void sortFile(File file, int size) throws IOException
	{
		Scanner scanner = new Scanner(file);										//Creating a new scanner object
		ArrayList<Integer> randomArrayList = new ArrayList<>();						//Creating an ArrayList object
	
		
		while (scanner.hasNext())													//While there's a line in the file
		{
			randomArrayList.add(scanner.nextInt());									//Add each element of the file into the ArrayList
		}
		
	    int[] randomArray = new int[randomArrayList.size()];						//Creating a new array
	    
		for (int x = 0; x < randomArrayList.size(); x++)
		{
			randomArray[x] = randomArrayList.get(x);								//Populating the array with elements from the ArrayList
		}
		
		sort(randomArray, size);													//Calling the sort function (above) using the new array
		
		scanner.close();															//Close the scanner object
	}
}
