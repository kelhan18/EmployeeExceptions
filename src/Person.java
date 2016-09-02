//Keller Han
//The person class has instance variables to store a person's name as a String. It is the superclass of student and undergraduate

public class Person
{
	//initialize variables
    private String name;
    
    //initialize constructors
    public Person( )
    {
        name = "No name yet";
    }
    
    public Person(String initialName)
    {
        name = initialName;
    }
    
    /*-------------------------------------------------------------
	|  Method: [setName()]
	|
	|  Purpose:  [This method, if called, will take an a String input that will become the person's new name.
	|
	|  Pre-condition:  [The variable name must be defined as String]
	|
	|  Post-condition: [The person's name will be set to String newName
	|
	|  Parameters:
	|      name - the name of Person
	|
	|  Returns:  [N/A]
	*------------------------------------------------------------------*/
    
    public void setName(String newName)
    {
        name = newName;
    }
    
    /*-------------------------------------------------------------
	|  Method: [getName()]
	|
	|  Purpose:  [This method, if called, will return the Person's name
	|
	|  Pre-condition:  [The variable name must be defined as String]
	|
	|  Post-condition: [The person's name will be returned
	|
	|  Parameters:
	|      name - the name of Person
	|
	|  Returns:  [the name of Person]
	*------------------------------------------------------------------*/
    
    public String getName( )
    {
        return name;
    }
    
    /*-------------------------------------------------------------
	|  Method: [writeOutput()]
	|
	|  Purpose:  [This method, if called, will print out the name of the person
	|
	|  Pre-condition:  [The variable name must be defined as String and set]
	|
	|  Post-condition: [The person's name will be displayed.]
	|
	|  Parameters:
	|      name - the name of Person
	|
	|  Returns:  [N/A]
	*------------------------------------------------------------------*/
    
    public void writeOutput( )
    {
        System.out.println("Name: " + name);
    }
   
    /*-------------------------------------------------------------
	|  Method: [hasSameName(Person otherPerson)]
	|
	|  Purpose:  [This method, if called, will check if another person has the same name and return true or false.]
	|
	|  Pre-condition:  [Must be 2 person objects]
	|
	|  Post-condition: [True or false will be returned if they have same name or not.]
	|
	|  Parameters:
	|      name - the name of Person
		  
	|  Returns:  [True or False]
	*------------------------------------------------------------------*/
    
    public boolean hasSameName(Person otherPerson)
    {
        return this.name.equalsIgnoreCase(otherPerson.name);
    }
}