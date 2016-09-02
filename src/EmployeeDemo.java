//Keller Han
//Write a demo class that will create an object of the class EmployeeChapter9 and ask user for number of employees. Each employee will have its own
//name, salary, and SSN. Exceptions will be thrown if SSN does not have 9 integers. Each employee object will have its salary compared to the average and determine
//if it is above or below average. All the employee objects will have its data displayed at the end

public class EmployeeDemo {

	/*-------------------------------------------------------------
	|  Method: [Main]
	|
	|  Purpose:  [To create a demo where we test the EmployeeChapter9 class and display name, salary, SSN for a user input number of employees.]
	|
	|  Pre-condition:  [The EmployeeChapter9 class must contain all the methods necessary to store an employee's name, salary, SSN and have it displayed at the end]
	|
	|  Post-condition: [After inputting all necessary data, the object array will have display each employee object's data.]
	|
	|  Parameters: [N/A]
	|
	|  Returns:  [N/A]
	*------------------------------------------------------------------*/
	
	public static void main(String[] args) {
		EmployeeChapter9 demo = new EmployeeChapter9();
		demo.initalizeArray();
		demo.displayResults();
	}
}
