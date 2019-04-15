package cal.model;

import cal.controller.CalController;

public class Day extends Calendar
{
	private CalController appController;
	private int day;
	private Exception invalidDay;
	
	public Day(CalController appController)
	{
		super(appController);
		this.day = 0;
		this.appController = appController;
		invalidDay = new Exception(this.getMonth() + "//" +day + "//" + this.getYear() +" not exist, try again",new Throwable("Not a real date"));
	}

	public Day(int month, int year, int day, CalController appController)
	{
		super(month, year, appController);
		this.appController = appController;
		this.day = day;
		invalidDay = new Exception(month + "//" +day + "//" + year +" not exist, try again",new Throwable("Not a real date"));
		if(!validDay(this))
		{
			this.day = 0;
		}

	}

	private boolean validDay(Day dayToTest)
	{
		boolean isValid = false;
		int maxDays = dayToTest.daysInMonth(dayToTest.getMonth());
		int test = dayToTest.getDay();
		if(test > 0 && test <= maxDays)
		{
			isValid = true;
		}
		else
		{
			appController.errorManager(invalidDay);
		}
		return isValid;
	}
	
	public int calculateDaysBetween(Day start, Day end)
	{
		int daySince = 0;
		boolean sameYear = start.getYear() == end.getYear();
		boolean sameMonth = start.getMonth() == end.getMonth();
		if(sameYear)
		{
			if(sameMonth)
			{
				daySince = Math.abs((start.getDay()-end.getDay()));
			}
			else
			{
				daySince = Math.abs((start.addDaysSinceMonth()+start.getDay()) - (end.addDaysSinceMonth()+end.getDay()));
			}
		}
		else
		{
			daySince = Math.abs((start.addDaysSinceYear()+start.addDaysSinceMonth()+start.getDay()) - (end.addDaysSinceYear()+end.addDaysSinceMonth()+end.getDay()));
		}
		return daySince;
	}
	public String toString()
	{
		return day + "";
	}

	public int getDay()
	{
		return day;
	}
	
	public void processDay(String input)
	{

		if(input == null || input.trim().equals(""))
		{
			appController.errorManager(appError.getEmptyInput());
		}
		else
		{
			input = input.trim();
			try
			{
				int dayToSet = Integer.parseInt(input);
				this.setDay(dayToSet);
			}
			catch(NumberFormatException nope)
			{
				appController.errorManager(appError.getNotAnInt());
			}
		}
		
	}

	public void setDay(int month, int year, int day, CalController app)
	{
		Day temp = new Day(month, year, day, app);
		if (validDay(temp))
		{
			this.day = temp.getDay();
		}
	}
	
	public void setDay(int day)
	{
		this.day = day;
		if(!validDay(this))
		{
			this.day = 0;
		}
	}
}
