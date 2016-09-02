//Keller Han
//EmployeeChapter9 class contains all the methods necessary to allow a user to enter enter an employee's name, salary, and SSN
//into an array that can hold 100 objects. Each employee's salary will be checked with the average to determine if it is 
//below or above average. If a user enters an invalid SSN, exceptions will be catched and the user will be prompted to enter
//a valid SSN. The data for each employee can then be displayed with displayResults() method

import java.util.Scanner;

public class EmployeeChapter9 extends Person {

	//Initialize variables
	private int salary;
	private String SSN;
	private String name;
	private String employeeSSN;
	final int maxEmployee = 100;
	private int averageSalary;
	private int thisPersonSalary;
	EmployeeChapter9[] employeeInfo;
	
	//Initialize constructors
	public EmployeeChapter9()
	{
		super();
		salary = 0;
		SSN = "";
	}
	
	public EmployeeChapter9(String name, int salary, String SSN)
	{
		this.name = name;
		this.salary = salary;
		this.SSN = SSN;
	}
	
	/*-------------------------------------------------------------
	|  Method: [initializeArray()]
	|
	|  Purpose:  [This method, if called, will ask the user to input how many employees there are. The user then enters name, salary, and SSN for each employee.
				If the user does not enter a valid SSN, exceptions will be thrown and the user will be prompted to re-enter it. The info for each employee is stored in an object array with max size 100.]
	|
	|  Pre-condition:  [Initialize array lengths for employeeInfo array]
	|
	|  Post-condition: [An object array of employee's will have name, salary, and SSN stored.
	|
	|  Parameters:
	|      employeeSalary - the salary of each individual employee.
		   sumSalary - the sum of all employee's salaries
		   employeeCount - the number of employees
		   employeeInfo - object array that stores employee info
	|
	|  Returns:  [N/A]
	*------------------------------------------------------------------*/
	
	public void initalizeArray()
	{
		int employeeSalary = 0;
		int sumSalary = 0;
		Scanner input = new Scanner(System.in);
		System.out.println("How many employees are there?: ");
		int employeeCount = input.nextInt();
		while (employeeCount > maxEmployee)
		{
			System.out.println("Error. Exceed max employee count. The max count is 100, please enter again: ");
			employeeCount = input.nextInt();
		}
		employeeInfo = new EmployeeChapter9[employeeCount];
		for (int i = 0; i < employeeCount; i++)
		{
			Scanner nextName = new Scanner(System.in);
			System.out.println("What is Employee # " + (i + 1) +"'s name?: ");
			String employeeName = nextName.nextLine();
			Scanner nextSalary = new Scanner(System.in);
			System.out.println("What is Employee # " + (i + 1) +"'s salary?: ");
			employeeSalary = nextSalary.nextInt();
			while (employeeSalary < 0)
			{
				System.out.println("Error. Salary can not be negative. Please enter again: ");
				employeeSalary = nextSalary.nextInt();
			}
		    salary = employeeSalary;
		    sumSalary += employeeSalary;
			averageSalary = sumSalary/employeeCount;
		    try {
			Scanner nextSSN = new Scanner(System.in);
			System.out.println("What is Employee # " + (i + 1) +"'s SSN?: ");
		    employeeSSN = nextSSN.nextLine();
			if (employeeSSN.length() != 9)
				throw new InvalidSSNLengthException();
			if (checkSSNCharacter() == false)
				throw new InvalidSSNCharacterException();
			employeeInfo[i] = new EmployeeChapter9(employeeName, employeeSalary, employeeSSN);
			}
			catch(InvalidSSNLengthException e)
			{
				System.out.println(e.getMessage());
				giveSecondChance();
				employeeInfo[i] = new EmployeeChapter9(employeeName, employeeSalary, employeeSSN);
			} catch (InvalidSSNCharacterException e) {
				System.out.println(e.getMessage());
				giveSecondChance();
				employeeInfo[i] = new EmployeeChapter9(employeeName, employeeSalary, employeeSSN);
			}
		}
	}
	
	/*-------------------------------------------------------------
	|  Method: [checkSalary()]
	|
	|  Purpose:  [This method, if called, will check an individual employee's salary against the average and return a string if its
				below or above average.]
	|
	|  Pre-condition:  [Every employee's salary must have already been stored in an object array]
	|
	|  Post-condition: [will return a string of above average or below average.]
	|
	|  Parameters:
	|      thisPersonSalary - the salary of an individual employee
		   averageSalary - average salary of all employees
	|
	|  Returns:  [A string of "below average" or "above average" depending on result]
	*------------------------------------------------------------------*/
	
	public String checkSalary() {
		if (thisPersonSalary < averageSalary)
		{
			return("Employee's salary: below average.");
		}
		if (thisPersonSalary > averageSalary)
		{
			return("Employee's salary: above average.");
		}
		return "";
	}
	
	/*-------------------------------------------------------------
	|  Method: [displayResults()]
	|
	|  Purpose:  [This method, if called, display the object array with stored employee info and their salary compared to the average.
	|
	|  Pre-condition:  [Object array of employee must have data stored and checkSalary() method defined.]
	|
	|  Post-condition: [Object array of employees will have all its data displayed.]
	|
	|  Parameters:
	|      thisPersonSalary - salary of individual employee
		   employeeInfo - object array that stores employee info
	|
	|  Returns:  [N/A]
	*------------------------------------------------------------------*/
	
	public void displayResults() {
		for (int i = 0; i < employeeInfo.length; i++)
		{
			thisPersonSalary = employeeInfo[i].getSalary();
			System.out.println(employeeInfo[i] + " | " + checkSalary());
		}
	}
	
	/*-------------------------------------------------------------
	|  Method: [giveSecondChance()]
	|
	|  Purpose:  [This method, if called, will allow the user to re-enter a valid SSN after they inputted an invalid one.]
	|
	|  Pre-condition:  [The user inputs an invalid SSN]
	|
	|  Post-condition: [The user will input a valid SSN and it will be stored into the object array]
	|
	|  Parameters:
	|      employeeSSN - the SSN of an individual employee
	|
	|  Returns:  [N/A]
	*------------------------------------------------------------------*/
	
	public void giveSecondChance()
	{
		System.out.println("Try again. Enter SSN: ");
		Scanner keyboard = new Scanner(System.in);
		employeeSSN = keyboard.nextLine();
		while (employeeSSN.length() != 9)
		{
			System.out.println("The SSN number is not 9 digits long. Please enter a valid SSN: ");
			employeeSSN = keyboard.nextLine();
		}
	}
	
	/*-------------------------------------------------------------
	|  Method: [checkSSNCharacter()]
	|
	|  Purpose:  [This method, if called, will check each index of an entered SSN and determine if there is a non-integer or not
	|
	|  Pre-condition:  [The user must input the SSN for an employee]
	|
	|  Post-condition: [If at any index of the SSN there appears a non-integer, then this method will return false]
	|
	|  Parameters:
	|      employeeSSN - the SSN of an individual employee
	|
	|  Returns:  [true or false]
	*------------------------------------------------------------------*/
	
	public boolean checkSSNCharacter()
	{
		for (int i = 0; i < 9; i++)
		{
			if (!Character.isDigit(employeeSSN.charAt(i)))
			{
				return false;
			}
		}
		return true;
	}
	
	/*-------------------------------------------------------------
	|  Method: [toString()]
	|
	|  Purpose:  [This method, if called, will override the default toString() method so that the object array can properly display its data
	|
	|  Pre-condition:  [N/A]
	|
	|  Post-condition: [Object array will display readable data]
	|
	|  Parameters:
	|      name - name of employee
		   salary - salary of employee
		   SSN - SSN of employee
	|
	|  Returns:  [name - name of employee
		   salary - salary of employee
		   SSN - SSN of employee]
	*------------------------------------------------------------------*/
	
	public String toString()
	{
		return "Name: " + name + " | Salary: " + salary + " | SSN: " + SSN;
	}
	
	/*-------------------------------------------------------------
	|  Method: [getSalary()]
	|
	|  Purpose:  [This method, if called, will return the salary of an employee]
	|
	|  Pre-condition:  [The variable salary must be defined as int]
	|
	|  Post-condition: [salary of employee is returned.]
	|
	|  Parameters:
	|     	salary - the salary of employee
	|
	|  Returns:  [the salary of employee]
	*------------------------------------------------------------------*/

	public int getSalary() {
		return salary;
	}
	
	/*-------------------------------------------------------------
	|  Method: [setSalary(int salary)]
	|
	|  Purpose:  [This method, if called, will set the salary of an employee]
	|
	|  Pre-condition:  [The variable salary must be defined as int]
	|
	|  Post-condition: [salary of employee is changed]
	|
	|  Parameters:
	|     	salary - the salary of employee
	|
	|  Returns:  [N/A]
	*------------------------------------------------------------------*/

	public void setSalary(int salary) {
		this.salary = salary;
	}

	/*-------------------------------------------------------------
	|  Method: [getSSN()]
	|
	|  Purpose:  [This method, if called, will return the SSN of an employee]
	|
	|  Pre-condition:  [The variable SSN must be defined as String]
	|
	|  Post-condition: [SSN of employee is returned.]
	|
	|  Parameters:
	|     	SSN - the SSN of employee
	|
	|  Returns:  [the SSN of employee]
	*------------------------------------------------------------------*/
	
	public String getSSN() {
		return SSN;
	}

	/*-------------------------------------------------------------
	|  Method: [setSSN(String newSSN)]
	|
	|  Purpose:  [This method, if called, will set the SSN of an employee]
	|
	|  Pre-condition:  [The variable SSN must be defined as String]
	|
	|  Post-condition: [SSN of employee is changed]
	|
	|  Parameters:
	|     	SSN - the SSN of employee
	|
	|  Returns:  [N/A]
	*------------------------------------------------------------------*/
	
	public void setSSN(String newSSN) {
		SSN = newSSN;
	}

	/*-------------------------------------------------------------
	|  Method: [getName()]
	|
	|  Purpose:  [This method, if called, will return the name of an employee]
	|
	|  Pre-condition:  [The variable namemust be defined as String]
	|
	|  Post-condition: [name of employee is returned.]
	|
	|  Parameters:
	|     	name - the name of employee
	|
	|  Returns:  [the name of employee]
	*------------------------------------------------------------------*/
	
	public String getName() {
		return name;
	}

	/*-------------------------------------------------------------
	|  Method: [setName(String name)]
	|
	|  Purpose:  [This method, if called, will set a new name for employee]
	|
	|  Pre-condition:  [The variable name must be defined as String]
	|
	|  Post-condition: [name of employee is changed]
	|
	|  Parameters:
	|     	name - the name of employee
	|
	|  Returns:  [N/A]
	*------------------------------------------------------------------*/
	
	public void setName(String name) {
		this.name = name;
	}
}
