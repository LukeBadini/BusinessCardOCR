The Java file BusinessCardParserApp is the main file used to run the program.
I used the "Run" button in Eclipse to run the file and execute the code.
BusinessCardParserApp reads in a single business card from businessCard.txt.
The parsed output is simply printed to the console.

Detailed explanation of the system:
When the application is run, BusinessCardParser.getContactInfo() is called in
order to start the process of parsing out the business card. The input string
is split into an array around newline characters in order to look through
each line individually. Following this, each line is evaluated to see if it
contains either a phone number or email address, but not a name. If a phone
number or email address is found, the line is parsed into the correct format
and stored into a local variable. After this loop is done, another loop is done
to find the name on the business card. I did this by comparing the words of each
line against the prefix of the email address to see if they matched. This assumes
that all email addresses contain at least the person's last name. It would be
better to use some sort of names database to determine if a line on the business
card was a name, but I did not have access to such a database. Finally, after
all of the data has been parsed out, it is packaged into a ContactInfo object,
which is then printed in the correct format.
