/*
 *	Modification of file provided by the textbook authors to practice with lists,
 *	Comparators, and anonymous inner classes. Page 416 #30.
 */


//---------------------------------------------------------------------------
// CSPeople.java            by Dale/Joyce/Weems                     Chapter 6
//
// Reads information about famous computer scientists from the file 
// input/FamousCS.txt. Allows user to indicate if they wish to see the list 
// sorted by name or by year of birth.
//---------------------------------------------------------------------------

import java.io.*;
import java.util.*;
import lists.*;
import support.*;

public class CSPeople
{
  public static void main(String[] args) throws IOException 
  {

  		boolean validInput = true;
//		NOTE: relative file paths start from the module name as the root dir in IntelliJ!
		final String FILEPATH = "src\\input\\FamousCS.txt";

//		Alternate file path
//	  	final String FILEPATH = "FamousCS.txt";


	  // Set up file reading
	  FileReader fin;
	  try
	  {
	  	fin = new FileReader(FILEPATH);
	  }
	  catch (FileNotFoundException e)
	  {
		  System.out.println("Please check the file path in line 30: " + e);
		  System.exit(0);
		  fin = new FileReader(""); // initialize fin so that it will compile
	  }

	  Scanner info = new Scanner(fin);
	  info.useDelimiter("[,\\n]");  // delimiters are commas, line feeds
	  FamousPerson person;
	  String fname, lname, fact;
	  int year;


    // Get user's display preference
    Scanner scan = new Scanner(System.in);
    int choice;
    System.out.println( "  1: Sorted by last name \n" +
                        "  2: Sorted by first name \n" +
                        "  3: Sorted by year of birth (ascending) \n" +
                        "  4: Sorted by year of birth (descending) \n" +
                        "  5: Sorted by length of fact ");
    System.out.print("How would you like to see the information > ");
    choice = scan.nextInt();
    
    // Instantiate sorted list
    SortedABList<FamousPerson> people;

    if (choice == 2)
      people = new SortedABList<FamousPerson>(FamousPerson.firstNameComparator()); // sorts by first name, then last name
    else if (choice == 3)
      people = new SortedABList<FamousPerson>(FamousPerson.yearOfBirthComparator()); // sorts by year of birth ascending
    else if (choice == 4)
      people = new SortedABList<FamousPerson>(FamousPerson.yearOfBirthComparatorDecreasing()); // sorts by year of birth descending
    else if (choice == 5)
      people = new SortedABList<FamousPerson>(FamousPerson.factComparator()); // sorts by length of fact
    else
      people = new SortedABList<FamousPerson>(); // defaults to natural order, last name
    


    // Read the info from the file and add it to the list
    while (info.hasNext())      
    {
      fname = info.next();   lname = info.next();
      year = info.nextInt(); fact = info.next();
      person = new FamousPerson(fname, lname, year, fact);
      people.add(person);
    }
    
    // Display the list, using the advanced for loop
    System.out.println();
    for (FamousPerson fp: people)
       System.out.println(fp);
  } 
} 