/**
 * A class that parses a business card String into a ContactInfo object.
 */
public class BusinessCardParser
{
	/**
	 * Takes a String representing a business card and parses out the name,
	 * phone number, and email address to be returned in a ContactInfo object.
	 * 
	 * @param document - a String representation of a business card
	 * @return a ContactInfo object populated with the
	 *         information from document
	 */
	public ContactInfo getContactInfo( String document )
	{
		String[] docArray = document.split("\n") ;
		return parseBusinessCard( docArray );
	}
	
	/**
	 * Helper method that does the bulk of the work for getContactInfo().
	 */
	private ContactInfo parseBusinessCard( String[] contents )
	{
		String name = "";
		String phoneNumber = "";
		String emailAddress = "";
		
		for( int i = 0; i < contents.length; i++ )
		{
			String line = contents[i];
			
			if( containsPhoneNumber( line ) )
			{
				phoneNumber = parsePhoneNumber( line );
				contents[i] = "";
			}
			else if( containsEmailAddress( line ) )
			{
				emailAddress = line;
				contents[i] = "";
			}
		}
		
		// A slightly inefficient side effect of using the email address
		// to get the name.
		for( int i = 0; i < contents.length; i++ )
		{
			String line = contents[i];
			
			if( containsName( line, emailAddress ) )
			{
				name = line;
				contents[i] = "";
				break;
			}
		}
		
		return new ContactInfo( name, phoneNumber, emailAddress );
	}
	
	/**
	 * Checks if the input string contains the name from a business card
	 * based on the given email address.
	 * 
	 * @param aString - the input String to be analyzed
	 * @param anEmail - an email address
	 * @return true if aString contains a name, false otherwise
	 */
	private boolean containsName( String aString, String anEmail )
	{
		String[] words = aString.split( "\\s+" );
		String emailPrefix = anEmail.split( "@" )[0].toLowerCase();
		
		for( String word : words )
		{
			if( emailPrefix.contains( word.toLowerCase() ) )
			{
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Checks if the input string contains the phone number from a business card.
	 * 
	 * @param aString - the input String to be analyzed
	 * @return true if aString contains a phone number, false otherwise
	 */
	private boolean containsPhoneNumber( String aString )
	{
		String lowerCase = aString.toLowerCase();
		
		return ( lowerCase.contains( "-" ) && !lowerCase.contains( "fax" ) &&
				!containsEmailAddress( lowerCase ) && isPhoneNumberFormat( lowerCase ) );
	}
	
	/** 
	 * Determines if the last 2 parts of a string follow the format
	 * for a phone number (the 2nd-to-last part is 3 digits, and the
	 * last part is 4 digits) e.g. 123-4567
	 * 
	 * @param aString - a phone number String
	 * @return true if aString is correctly formatted phone number, false otherwise
	 */
	private boolean isPhoneNumberFormat( String aString )
	{
		aString.replaceAll( "[^0-9-]", "");
		String[] strings = aString.split("[-()\\+\\s]");
		
		String secondToLast = strings[strings.length - 2];
		String last = strings[strings.length - 1];
		boolean lengthFormat = ( secondToLast.length() == 3 && last.length() == 4);
		boolean numberFormat = ( secondToLast.matches( "\\d+" ) && last.matches( "\\d+" ) );
		return ( lengthFormat && numberFormat );
	}
	
	/**
	 * Checks if the input string contains the email address from a business card.
	 * 
	 * @param aString - the input String to be analyzed
	 * @return true if aString contains an email address, false otherwise
	 */
	private boolean containsEmailAddress( String aString )
	{
		return aString.contains( "@" );
	}
	
	/**
	 * Returns non-digit characters from a given phone number string
	 * 
	 * @param aLine - a phone number string
	 * @return a phone number string containing only digits
	 */
	private String parsePhoneNumber( String aLine )
	{
		return aLine.replaceAll( "[^0-9]", "");
	}
}
