## Famous Person Comparator
> Dale, Joyce, Weems (4th) p416 #30

Currently the `FamousPerson` class defines the natural order of its elements to be 
based on the alphabetical order of people names (last name, then first name). It also 
provides a `Comparator` that defines order based on increasing year of birth.  

Augment the class to include more public static methods that return Comparators 
as described below. Augment the `CSPeople` application to demonstrate that the 
new Comparators work properly.  

1. Order alphabetically by name (First name, then last name)
2. Order by year of birth—decreasing
3. Order by length of “fact”—increasing

*In addition to the requirements outlined above, I've also modified the program to handle exceptions pertaining to the
location of the input file, since I had some trouble configuring the application to work with my IDE.*