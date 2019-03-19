package cal.model;

public class CalendarErrors
{
	private Exception emptyInput;
	private Exception notAnInt;
	private Exception invalidMonth;
	private Exception invalidYear;
	
	public CalendarErrors()
	{
		emptyInput = new Exception("Please enter something", new Throwable("Can't be empty"));
		notAnInt = new Exception("Input couldn't be read, Try again!", new Throwable("Not an Integer"));
		invalidMonth = new Exception("Please enter a valid month (ex: 1 - 12)", new Throwable("Month doesn't exist"));
		invalidYear = new Exception("Year doesn't exist! (must be greater than 1582)", new Throwable("Year doesn't exist"));
	}
	
	public Exception getEmptyInput()
	{
		return emptyInput;
	}
	
	public Exception getNotAnInt()
	{
		return notAnInt;
	}
	
	public Exception getInvalidMonth()
	{
		return invalidMonth;
	}
	
	public Exception getInvalidYear()
	{
		return invalidYear;
	}
}
