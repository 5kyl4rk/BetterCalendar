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

	public Calendar()
	{
		month = 0;
		year = 0;
		days = 0;
		monthName = "WhatMonth?";
		monthList = new ArrayList<String>(12);
		validMonth = false;

		buildMonths();
	}

	private void buildMonths()
	{
		monthList.add(0, "January");
		monthList.add(1, "February");
		monthList.add(2, "March");
		monthList.add(3, "April");
		monthList.add(4, "May");
		monthList.add(5, "June");
		monthList.add(6, "July");
		monthList.add(7, "August");
		monthList.add(8, "September");
		monthList.add(9, "October");
		monthList.add(10, "November");
		monthList.add(11, "December");
	}

	public void calculateMonth(String input)
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
			for (int index = 0; index < monthList.size(); index++)
			{
				String currentMonth = monthList.get(index).toLowerCase();
				if (input.toLowerCase().equals(currentMonth) || (currentMonth.startsWith(input) && !input.equals("Ma")))
				{
					setMonth(index + 1);
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
					JOptionPane.showMessageDialog(null, "Please try again","ERROR",JOptionPane.WARNING_MESSAGE);
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
}
