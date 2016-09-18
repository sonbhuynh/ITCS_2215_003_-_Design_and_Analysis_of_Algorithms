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

public class QuickSort
{
	public static void sort(int[] randomArray, int start, int end)
	{
		if (end - start < 1)
		{
			return;															//Return array if its size is less than 1
		}
		else if(end - start == 1)
		{
			if (randomArray[start] > randomArray[end])						//Swap the start and end elements if there are only two elements,
			{																	//and the first one is larger than the second one.
				int temp = randomArray[start];
				randomArray[start] = randomArray[end];
				randomArray[end] = temp;
			}
			return;
		}
		
		int pivot = randomArray[start];										//Making pivot the first element
		int r = start + 1;													//Making r counter the element to the right of the pivot
		int l = end;														//Making l counter the end element
		
		while (r <= l)														//While r counter has yet to cross with l counter
		{
			if (randomArray[r] < pivot)										//If element is less than pivot
			{
				r++;														//Increase r counter by 1
			}
			else															//Else, if element is greater than or equal to pivot
			{
				int temp = randomArray[l];									//Perform a swap
				randomArray[l] = randomArray[r];
				randomArray[r] = temp;
				l--;														//Decrease l counter by 1
			}				
		}
		randomArray[start] = randomArray[r - 1];							//Perform a swap
		randomArray[r - 1] = pivot;
		
		sort(randomArray, start, r-2);										//Recursively calling sort on the first half
		sort(randomArray, r, end);											//Recursively calling sort on the second half
		
		
	}
	
	public static void sortFile(File file, int size) throws IOException
	{
		Scanner scanner = new Scanner(file);										//Creating a new scanner object
		ArrayList<Integer> randomArrayList = new ArrayList<>();						//Creating an ArrayList object
		PrintWriter outputQuick = new PrintWriter("outputQuick" + size + ".txt");				//Creating a PrintWriter object
		PrintWriter outputQuickEfficiency = new PrintWriter(new FileWriter("outputQuickEfficiency" + size + ".txt", true)); 	
		
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
		
		sort(randomArray, 0, size - 1);												//Calling the sort function (above) using the new array
		
    	long stopTime = System.nanoTime();											//Recording the stop time in nanoseconds
    	runTime = stopTime - startTime;												//Calculating time ran in nanoseconds 		
		
		for (int x = 0; x < randomArray.length; x++)
		{
    		outputQuick.println(randomArray[x]);									//Outputting quick sort result to the outputQuick file
		}

		outputQuickEfficiency.println(randomArray.length + "\t" + runTime);
		outputQuickEfficiency.close();				
		
		outputQuick.close();		
    	System.out.println();
    	System.out.println("Quick Sort " + size + " result has been written to a file.");			//Output success message		
    	System.out.println("Time took to Quick Sort " + size + ": " + runTime + " nanoseconds.");	//Output time the sort took to run    	    	
		
		scanner.close();															//Close the scanner object
	}		
}
