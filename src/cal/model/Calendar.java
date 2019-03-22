package cal.model;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import cal.controller.CalController;

public class Calendar
{
	private int month;
	private int year;
	private int days;
	private String monthName;
	private ArrayList<String> monthList;
	private boolean validMonth;
	private boolean validYear;
	private int[] months31Days;
	private int[] months30Days;
	private CalendarErrors appError;
	private CalController app;

	public Calendar(CalController appController)
	{
		month = 0;
		year = -9999;
		days = 0;
		monthList = new ArrayList<String>(13);
		validMonth = false;
		validYear = false;
		months31Days = new int[7];
		months30Days = new int[4];
		appError = new CalendarErrors();
		app = appController;

		buildMonths();
		monthName = monthList.get(month);

	}

	public Calendar(int month, int year, CalController appController)
	{
		if (month < 1 || month > 12)
		{
			this.month = 0;
		}
		else
		{
			this.month = month;
		}

		if (year < 1583)
		{
			this.year = 0;
		}
		else
		{
			this.year = year;
		}
		days = 0;
		monthList = new ArrayList<String>(13);
		validMonth = false;
		validYear = false;
		months31Days = new int[7];
		months30Days = new int[4];
		appError = new CalendarErrors();
		app = appController;
		buildMonths();
		monthName = monthList.get(month);

	}

	/**
	 * adds items to list, the indexes in 'monthList' matches the actual number of
	 * the month, meaning '0' should not be reachable
	 */
	private void buildMonths() // index matches actual month
	{
		monthList.add(0, "Null-vember");
		monthList.add(1, "January");
		monthList.add(2, "February");
		monthList.add(3, "March");
		monthList.add(4, "April");
		monthList.add(5, "May");
		monthList.add(6, "June");
		monthList.add(7, "July");
		monthList.add(8, "August");
		monthList.add(9, "September");
		monthList.add(10, "October");
		monthList.add(11, "November");
		monthList.add(12, "December");

		months31Days[0] = 1;
		months31Days[1] = 3;
		months31Days[2] = 5;
		months31Days[3] = 7;
		months31Days[4] = 8;
		months31Days[5] = 10;
		months31Days[6] = 12;

		months30Days[0] = 4;
		months30Days[1] = 6;
		months30Days[2] = 9;
		months30Days[3] = 11;
	}

	/**
	 * Takes input and process it, checks to see if it's valid, and stores it. <br>
	 * <b>(Month has to be between 1 & 12)</b>
	 * 
	 * @param input
	 *            the input you need to check to see if it's a valid month
	 */
	public void processMonth(String input)
	{
		int monthNumber = 0;
		boolean isNumber = false;

		if (input == null || input.equals(""))
		{
			app.errorManager(appError.getEmptyInput());
		}
		else
		{
			input = input.trim().toLowerCase();
			for (int index = 1; index < monthList.size(); index++)
			{
				String currentMonth = monthList.get(index).toLowerCase();
				if (input.toLowerCase().equals(currentMonth) || (!input.equals("ma") && currentMonth.startsWith(input)))
				{
					setMonth(index);
					setValidMonth(true);
				}
			}

			if (!validMonth)
			{
				try
				{
					monthNumber = Integer.parseInt(input);
					isNumber = true;
				}
				catch (NumberFormatException wrong)
				{
					app.errorManager(appError.getNotAnInt());
				}

				if (isNumber)
				{
					if (monthNumber <= 0 || monthNumber > 12)
					{
						app.errorManager(appError.getInvalidMonth());
						;
					}
					else
					{
						setMonth(monthNumber);
						setValidMonth(true);
					}
				}
			}
		}

	}

	/**
	 * Takes input and process it, checks to see if it's valid, and stores it. <br>
	 * <b>(Year can't be before 1583)</b>
	 * 
	 * @param input
	 *            the input you need to check to see if it's a valid year
	 * 
	 */
	public void processYear(String input)
	{
		int yearNumber = 0;
		boolean isNumber = false;

		if (input == null || input.equals(""))
		{
			app.errorManager(appError.getEmptyInput());
		}
		else
		{
			try
			{
				yearNumber = Integer.parseInt(input);
				isNumber = true;
			}
			catch (NumberFormatException nope)
			{
				app.errorManager(appError.getNotAnInt());
			}
			if (isNumber)
			{
				if (yearNumber < 1583)
				{
					app.errorManager(appError.getInvalidYear());
				}
				else
				{
					setYear(yearNumber);
					setValidYear(true);
				}
			}
		}
	}

	/**
	 * Calculate if it's a leap year
	 * 
	 * @param year
	 *            the year you want to check
	 * @return true or false stating that it's a leap year
	 */
	private boolean isLeapYear(int year)
	{
		boolean isLeap = false;

		if (year % 4 == 0)
		{
			if (year % 100 == 0)
			{
				if (year % 400 == 0)
				{
					isLeap = true;
				}
			}
			else
			{
				isLeap = true;
			}
		}

		return isLeap;
	}

	/**
	 * Takes the information and converts it into a readable String
	 * 
	 * @return a single String that displays correctly
	 */
	private String printDays()
	{
		int dayStart = 6;
		String days = "";
		dayStart += addDaysSinceYear() + addDaysSinceMonth();

		days += makeEmptySpace(dayStart, true);

		for (int index = 1; index <= daysInMonth(month); index++)
		{
			if (index < 10)
			{
				days += ("|" + index + " ");
			}
			if (index >= 10)
			{
				days += ("|" + index);
			}
			if (index % 7 == (7 - (dayStart % 7)))
			{
				days += "|\n";
			}
		}

		days += makeEmptySpace(dayStart + daysInMonth(month), false);
		return days;

	}

	/**
	 * <h2><i>Deprecated</i></h2>Converts data into an array of days <br>
	 * <b>NOTE:</b> the max value in the array is 35, when really it should be 42,
	 * meaning that there's a chance of getting an 'IndexOutOfBounds' error'. The
	 * thing is, this case is rare and would mean that a majority of the time there
	 * would be a useless empty row.
	 * 
	 * @return an array with days and empty spaces in their appropriate spot
	 */
	private String[] makeDaysAsArray()
	{
		String[] dayArray;
		dayArray = new String[35];
		String emptySpace = "|  ";
		int currentIndex = 0;
		int lastIndex = 0;
		int dayStart = 6;
		dayStart += addDaysSinceYear() + addDaysSinceMonth();

		for (int times = 0; times < (dayStart % 7); times++)
		{
			dayArray[currentIndex] = emptySpace;
			currentIndex++;
		}

		for (int day = 1; day < daysInMonth(month) + 1; day++)
		{

			dayArray[currentIndex] = day + "";
			currentIndex++;

		}

		lastIndex = currentIndex;

		for (int times = 0; times < (dayArray.length - lastIndex); times++)
		{

			dayArray[currentIndex] = emptySpace;
			currentIndex++;
		}

		return dayArray;
	}

	/**
	 * converts calendar as an ArrayList, making it more dynamic
	 * 
	 * @return an ArrayList with days and empty spaces in the appropriate spot
	 */
	private ArrayList<String> makeDaysAsList()
	{
		ArrayList<String> dayList = new ArrayList<String>();
		String empty = "|  ";
		int dayStart = 6;
		int currentIndex = 0;
		dayStart += addDaysSinceYear() + addDaysSinceMonth();

		for (int times = 0; times < (dayStart % 7); times++)
		{
			/*
			 * dayList.add(empty);
			 */
			currentIndex++;

			dayList.add("  ");
		}

		for (int day = 1; day < daysInMonth(month) + 1; day++)
		{
			String currentDay = day + "";
			/*
			 * if(day < 10) { currentDay += " "; }
			 * 
			 * if(currentIndex%7 == 6) { dayList.add("|" + currentDay+"|"); } else {
			 * dayList.add("|" + currentDay); }
			 */
			currentIndex++;

			dayList.add(currentDay);
		}

		int spaceLeft = (dayStart + daysInMonth(month)) % 7;
		if (spaceLeft > 0)
		{
			for (int times = 0; times < (7 - spaceLeft); times++)
			{

				/*
				 * if(currentIndex%7 == 6) { dayList.add( empty+"|"); } else {
				 * dayList.add(empty); }
				 */

				dayList.add("  ");
			}
		}
		return dayList;
	}

	/**
	 * A helper method used in the {@link #printDays()} method. Calculates how many
	 * empty spaces to fill in order to have the calendar line up
	 * 
	 * @param days
	 *            the number of days that have past before/after the current/last
	 *            day
	 * @param first
	 *            if true, it will calculate the space before, else it will
	 *            calculate the space at the end
	 * @return a String of emptySpaces that lines up for printDays()
	 */
	private String makeEmptySpace(int days, boolean first)
	{
		int daySpot = (days % 7);
		String emptySpace = "|  ";
		String spaces = "";
		if (first)
		{
			for (int times = 0; times < daySpot; times++)
			{
				spaces += emptySpace;
			}

		}
		else
		{
			for (int times = 0; times < (7 - daySpot); times++)
			{
				spaces += emptySpace;
			}
			if (daySpot != 0)
			{
				spaces += "|";
			}
		}
		return spaces;

	}

	/**
	 * adds up all the days before the store year
	 * 
	 * @return the number of days since that year
	 */
	private int addDaysSinceYear()
	{
		int daysSince = 0;
		for (int currentYear = 1583; currentYear < year; currentYear++)
		{
			if (isLeapYear(currentYear))
			{
				daysSince += 366;
			}
			else
			{
				daysSince += 365;
			}
		}

		return daysSince;
	}

	/**
	 * adds up how many days have past before the current month in the given year
	 * 
	 * @return the number of days since that year
	 */
	private int addDaysSinceMonth()
	{
		int daysSince = 0;

		for (int currentMonth = 1; currentMonth < month; currentMonth++)
		{
			daysSince += daysInMonth(currentMonth);
		}

		return daysSince;
	}

	/**
	 * retrieves how many days are in that month
	 * 
	 * @param month
	 *            the month you want to select
	 * @return the number of days in that month
	 */
	private int daysInMonth(int month)
	{
		int numberOfDays = 0;

		if (month == 2)
		{
			if (isLeapYear(year))
			{
				numberOfDays = 29;
			}
			else
			{
				numberOfDays = 28;
			}
		}
		else
		{
			for (int indexedMonth : months31Days)
			{
				if (month == indexedMonth)
				{
					numberOfDays = 31;
				}
			}
			for (int indexedMonth : months30Days)
			{
				if (month == indexedMonth)
				{
					numberOfDays = 30;
				}
			}
		}

		return numberOfDays;
	}

	/**
	 * calls {@link #makeDaysAsArray()} and prints the String stored in each spot.
	 * Prints very similar to {@link #printDays()}
	 * 
	 * @return a formatted String calendar
	 */
	public String printDayArray()
	{
		String[] dayArray = makeDaysAsArray();
		String display = getMonthName() + "\n";

		for (int index = 0; index < dayArray.length; index++)
		{
			display += dayArray[index] + " ";
			if ((index + 1) % 7 == 0)
			{
				display += "|\n";
			}
		}

		return display;
	}

	/**
	 * calls {@link #printDays()}
	 */
	public String toString()
	{
		return printDays();
	}

	// --[GET]--
	public int getMonth()
	{
		return month;
	}

	public String getMonthName()
	{
		return monthList.get(month);
	}

	public int getYear()
	{
		return year;
	}

	public boolean getValidMonth()
	{
		return validMonth;
	}

	public boolean getValidYear()
	{
		return validYear;
	}

	public String[] getDayArray()
	{
		return makeDaysAsArray();
	}

	public ArrayList<String> getDayList()
	{
		return makeDaysAsList();
	}

	// --[SET]--
	public void setMonth(int month)
	{
		this.month = month;
	}

	public void setYear(int year)
	{
		this.year = year;
	}

	public void setValidMonth(boolean valid)
	{
		this.validMonth = valid;
	}

	public void setValidYear(boolean valid)
	{
		validYear = valid;
	}
}
