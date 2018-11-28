package cal.model;

import java.util.ArrayList;

import javax.swing.JOptionPane;

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

	public Calendar()
	{
		month = 0;
		year = 0;
		days = 0;
		monthName = "WhatMonth?";
		monthList = new ArrayList<String>(13);
		validMonth = false;
		validYear = false;
		months31Days = new int[7];
		months30Days = new int[4];
		buildMonths();

	}

	private void buildMonths() // index matches actual month
	{
		monthList.add(0, "WhatMonth?");
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

	public void processMonth(String input)
	{
		int monthNumber = 0;
		boolean isNumber = false;

		if (input == null || input.equals(""))
		{
			JOptionPane.showMessageDialog(null, "Please enter something", "ERROR", JOptionPane.WARNING_MESSAGE);
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
					JOptionPane.showMessageDialog(null, "Try again!", "ERROR", JOptionPane.WARNING_MESSAGE);
				}

				if (isNumber)
				{
					if (monthNumber <= 0 || monthNumber > 12)
					{
						JOptionPane.showMessageDialog(null, "Month doesn't exist", "ERROR", JOptionPane.ERROR_MESSAGE);
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

	public void processYear(String input)
	{
		int yearNumber = 0;
		boolean isNumber = false;

		if (input == null || input.equals(""))
		{
			JOptionPane.showMessageDialog(null, "Please enter something", "ERROR", JOptionPane.WARNING_MESSAGE);
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
				JOptionPane.showMessageDialog(null, "Try Again!", "ERROR", JOptionPane.WARNING_MESSAGE);
			}
			if (isNumber)
			{
				if (yearNumber < 1583)
				{
					JOptionPane.showMessageDialog(null, "Year doesn't exist", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					setYear(yearNumber);
					setValidYear(true);
				}
			}
		}
	}

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

	private String printDays()
	{
		int dayStart = 6;
		String days = "";
		dayStart += addDaysSinceYear() + addDaysSinceMonth();

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

		return days;

	}

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

	private int addDaysSinceMonth()
	{
		int daysSince = 0;

		for (int currentMonth = 1; currentMonth < month; currentMonth++)
		{
			daysSince += daysInMonth(currentMonth);
		}

		return daysSince;
	}

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
	

	public String toString()
	{
		return printDays();
	}

	// --[GET]--
	public int getMonth()
	{
		return month;
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
