//Keller Han
//InvalidSSNLengthException class will display a message when a user inputs a SSN that is 9 digits long

public class InvalidSSNLengthException extends Exception{
	
	//initialize constructors
	public InvalidSSNLengthException()
	{
		super("Invalid SSN length. SSN must be 9 digits long.");
	}
	
	public InvalidSSNLengthException(String message)
	{
		super(message);
	}

}
