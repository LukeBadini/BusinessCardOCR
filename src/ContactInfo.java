/**
 * A class that contains the parsed contents of a business card, which
 * includes the name, phone number, and email address.
 */
public class ContactInfo
{
	/** 
	 * Variables containing the name, phone number, and email address
	 * of a business card.
	 */
	private String name;
	private String phoneNumber;
	private String emailAddress;
	
	/**
	 * Constructs a new ContactInfo object with a name, phone number, and email address.
	 * 
	 * @param aName          - the name on the business card
	 * @param aPhoneNumber   - the phone number on the business card
	 * @param anEmailAddress - the email address on the business card
	 */
	public ContactInfo( String aName, String aPhoneNumber, String anEmailAddress )
	{
	    setName( aName );
	    setPhoneNumber( aPhoneNumber );
	    setEmailAddress( anEmailAddress );
	}
	
	/**
	 * Sets the name of this ContactInfo object. If the provided String
	 * is null, sets name to an empty string.
	 * 
	 * @param aString - a provided string to set name equal to
	 */
	private void setName( String aString )
	{
		if( aString == null )
		{
			name = "";
		}
		else
		{
			name = aString;
		}
	}
	
	/**
	 * Sets the phone number of this ContactInfo object. If the provided String
	 * is null, sets phoneNumber to an empty string.
	 * 
	 * @param aString - a provided string to set phoneNumber equal to
	 */
	private void setPhoneNumber( String aString )
	{
		if( aString == null )
		{
			phoneNumber = "";
		}
		else
		{
			phoneNumber = aString;
		}
	}
	
	/**
	 * Sets the name of this ContactInfo object. If the provided String
	 * is null, sets name to an empty string.
	 * 
	 * @param aString - a provided string to set emailAddress equal to
	 */
	private void setEmailAddress( String aString )
	{
		if( aString == null )
		{
			emailAddress = "";
		}
		else
		{
			emailAddress = aString;
		}
	}
	
	/**
	 * Gets the name from this ContactInfo object.
	 * 
	 * @return A String containing the phone number of the business card.
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * Gets the phone number from this ContactInfo object.
	 * 
	 * @return A String containing the phone number of the business card.
	 */
	public String getPhoneNumber()
	{
		return phoneNumber;
	}
	
	/**
	 * Gets the email address from this ContactInfo object.
	 * 
	 * @return A String containing the email address of the business card.
	 */
	public String getEmailAddress()
	{
		return emailAddress;
	}
	
	/*
	 * Returns a String representation of a ContactInfo object with
	 * the correct formatting.
	 */
	public String toString()
	{
		return "Name:  " + name + "\nPhone: " + phoneNumber +
				"\nEmail: " + emailAddress;
	}
}
