package cal.controller;

import cal.model.Calendar;
import cal.controller.CalController;

public class Day extends Calendar
{
	private CalController appController;
	private int day;
	private int month;
	private int year;

	public Day(int month, int year, int day, CalController appController)
	{
		super(month, year, appController);
		this.appController = appController;
		this.day = day;
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
		return isValid;
	}
	
	public int calculateDaysBetween(Day start, Day end)
	{
		int daySince = 0;
		
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

	public void setDay(int month, int year, int day, CalController app)
	{
		Day temp = new Day(month, year, day, app);
		if (validDay(temp))
		{
			this.day = temp.getDay();
		}
	}
}
