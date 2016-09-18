import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

/*
 * Name:	Son Huynh
 * Date:	10/31/2015
 */

public class NumberGenerator
{
	public static void generate(String[] path, int[] size) throws FileNotFoundException
	{
		Random randomGenerator = new Random();
		
	    for (int x = 0; x < size.length; x++)
	    {
	    	int [] randomArray = new int[size[x]];
	    	File outputFile = new File (path[x]);
		    PrintWriter output = new PrintWriter(outputFile);	    	
		    
		    for (int y = 0; y < randomArray.length; y++)
		    {
		    	randomArray[y] = randomGenerator.nextInt(9999999);
		    	output.println(randomArray[y]);		
		    }
		    
		    output.close();
	    }		
	}
}