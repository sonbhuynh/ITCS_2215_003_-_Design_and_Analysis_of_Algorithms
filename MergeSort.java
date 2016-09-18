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

public class MergeSort
{
	public static void merge(int[] mergedArray, int[] array1, int[] array2)
	{
	    int i1 = 0;
	    int i2 = 0;
	    int i3 = 0;
	    
	    while (i1 < array1.length && i2 < array2.length)							
	    {
	    	if (array1[i1] < array2[i2])											//If element 1 in array 1 is less than element 1 in array 2
	    	{
	    		mergedArray[i3] = array1[i1];										//Put the smaller element into the mergedArray
	    		i1++;																//Increment counter of array 1 by 1
	    	}
	    	else
	    	{
	    		mergedArray[i3] = array2[i2];										//Put the smaller element into the mergedArray
	    		i2++;	    														//Increment counter of array 2 by 1
	    	}
	    	i3++;																	//Increment counter of mergedArray by 1
	    }
	    
	    //If there's no more elements left in array 1, add the rest of the elements in array 2 to the mergedArray
	    while (i2 < array2.length && i3 <= mergedArray.length - 1)
	    {
	    	mergedArray[i3] = array2[i2];											//Putting the rest of the elements in array 2 into mergedArray
	    	i3++;																	//Increment counter of mergedArray by 1
	    	i2++;																	//Increment counter of array 2 by 1
	    }
	    
	    //If there's no more elements left in array 2, add the rest of the elements in array 1 to the mergedArray
	    while (i1 < array1.length && i3 <= mergedArray.length - 1)
	    {
	    	mergedArray[i3] = array1[i1];											//Putting the rest of the elements in array 1 into mergedArray
	    	i3++;																	//Increment counter of mergedArray by 1
	    	i1++;																	//Increment counter of array 1 by 1
	    }	    
	}
	
	public static void split(int[] randomArray)
	{
		if (randomArray.length == 1)
		{
			return;																	//Return the array if it only has 1 element
		}
		else
		{
			int[] array1 = new int[randomArray.length / 2];							//Initializing array 1
			int[] array2 = new int[randomArray.length - (randomArray.length / 2)];	//Initializing array 2
			
			for (int x = 0; x < array1.length; x++)
			{
				array1[x] = randomArray[x];											//Storing elements from randomArray into array 1
			}
			
			for (int x = 0; x < array2.length; x++)
			{
				array2[x] = randomArray[array1.length + x];							//Storing elements from randomArray into array 2
			}			
			
			split(array1);															//Recursively split array 1
			split(array2);															//Recursively split array 2
			merge(randomArray, array1, array2);										//Merge the two arrays
		}
	}
	
	
	public static void sortFile(File file, int size) throws IOException
	{
		Scanner scanner = new Scanner(file);										//Creating a new scanner object
		ArrayList<Integer> randomArrayList = new ArrayList<>();						//Creating an ArrayList object
		PrintWriter outputMerge = new PrintWriter("outputMerge" + size + ".txt");				//Creating a PrintWriter object
		PrintWriter outputMergeEfficiency = new PrintWriter(new FileWriter("outputMergeEfficiency" + size + ".txt", true)); 	
		
		while (scanner.hasNext())													//While there's a line in the file
		{
			randomArrayList.add(scanner.nextInt());									//Add each element of the file into the ArrayList
		}
		
	    int[] randomArray = new int[randomArrayList.size()];						//Creating a new array
	    
		for (int x = 0; x < randomArrayList.size(); x++)
		{
			randomArray[x] = randomArrayList.get(x);								//Populating the array with elements from the ArrayList
		}
		
	    long startTime = System.nanoTime();											//Recording the stop time in nanoseconds
	    long runTime = 0;															//Initializing variable to 0	    		
		
		split(randomArray);															//Calling the sort function (above) using the new array
		
    	long stopTime = System.nanoTime();											//Recording the stop time in nanoseconds
    	runTime = stopTime - startTime;												//Calculating time ran in nanoseconds 		
		
		for (int x = 0; x < randomArray.length; x++)
		{
    		outputMerge.println(randomArray[x]);									//Outputting merge sort result to the outputMerge file
		}

		outputMergeEfficiency.println(randomArray.length + "\t" + runTime);
		outputMergeEfficiency.close();				
		
		outputMerge.close();		
    	System.out.println();
    	System.out.println("Merge Sort " + size + " result has been written to a file.");			//Output success message		
    	System.out.println("Time took to Merge Sort " + size + ": " + runTime + " nanoseconds.");	//Output time the sort took to run    	    	
		
		scanner.close();															//Close the scanner object
	}	
}