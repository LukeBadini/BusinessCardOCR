import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class BusinessCardParserApp
{
	// Runs the BusinessCardParser application
	public static void main( String[] args )
	{
		String businessCardString = readFile( "businessCard.txt" );
		ContactInfo info = new BusinessCardParser().getContactInfo( businessCardString );
		System.out.println( info.toString() );
	}
	
	// Reads in the file containing a business card
	private static String readFile( String filePath )
	{
		String toReturn = "";
	    try
	    {
	    	FileReader reader = new FileReader( filePath );
	    	BufferedReader buff = new BufferedReader( reader );
	    	
	    	String curLine = buff.readLine();
	    	while ( curLine != null )
	    	{
	    		toReturn += ( curLine + "\n" );
	    		curLine = buff.readLine();
	    	}
	    	
	    	buff.close();
	    }
	    catch ( IOException e )
	    {}
	    
	    return toReturn;	
	}

}
