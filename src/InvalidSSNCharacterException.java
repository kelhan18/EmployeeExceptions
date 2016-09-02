//Keller Han
//InvalidSSNCharacterException class will display a message when a user inputs a SSN that does not contain all integers

public class InvalidSSNCharacterException extends Exception{
	
	//initialize constructors
	public InvalidSSNCharacterException()
	{
		super("Invalid SSN character(s) recognized. SSN should be integers only.");
	}
	
	public InvalidSSNCharacterException(String message)
	{
		super(message);
	}
}
