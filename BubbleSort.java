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

public class BubbleSort
{
	public static void sort(int[] randomArray, int size) throws IOException
	{
		int temp;																	//Declaring variables
	    PrintWriter outputBubble = new PrintWriter("outputBubble" + size + ".txt");
	    PrintWriter outputBubbleEfficiency = new PrintWriter(new FileWriter("outputBubbleEfficiency" + size + ".txt", true)); 
	    
	    long startTime = System.nanoTime();											//Recording the stop time in nanoseconds
	    long runTime = 0;															//Initializing variable to 0
	    
    	for (int x = 0; x < randomArray.length; x++)
    	{
    		for (int y = 0; y < randomArray.length - 1; y++)
    		{
    			if (randomArray[y] >= randomArray[y + 1])							//If the element in the first slot is larger than the second element
    			{
    				temp = randomArray[y];											//Assign the larger, first element into a temp variable
    				randomArray[y] = randomArray[y + 1];							//Assign the smaller, second element into the first slot
    				randomArray[y + 1] = temp;										//Assign the larger, first element into the second slot
    			}
    		}
    	}
    	
    	long stopTime = System.nanoTime();											//Recording the stop time in nanoseconds
    	runTime = stopTime - startTime;												//Calculating time ran in nanoseconds
    	   	
		for (int x = 0; x < randomArray.length; x++)
		{
    		outputBubble.println(randomArray[x]);									//Outputting bubble sort result to the outputBubble file
		}     	
    	
		outputBubbleEfficiency.println(randomArray.length + "\t" + runTime);
		outputBubbleEfficiency.close();
		
    	outputBubble.close();														//Close the outputBubble file
    	System.out.println();
    	System.out.println("Bubble Sort " + size + " result has been written to a file.");			//Output success message
    	System.out.println("Time took to Bubble Sort " + size + ": " + runTime + " nanoseconds.");	//Output time the sort took to run
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