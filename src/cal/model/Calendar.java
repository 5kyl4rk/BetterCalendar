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
	

	public Calendar()
	{
		month = 0;
		year = 0;
		days = 0;
		monthName = "WhatMonth?";
		monthList = new ArrayList<String>(13);
		validMonth = false;
		validYear = false;
		buildMonths();
	}

	private void buildMonths() //index matches actual month
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
					JOptionPane.showMessageDialog(null, "Try again!","ERROR",JOptionPane.WARNING_MESSAGE);
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
		
		if(input == null || input.equals(""))
		{
			JOptionPane.showMessageDialog(null,"Please enter something","ERROR",JOptionPane.WARNING_MESSAGE);
		}
		else
		{
			try
			{
				yearNumber = Integer.parseInt(input);
				isNumber = true;
			}
			catch(NumberFormatException nope)
			{
				JOptionPane.showMessageDialog(null,"Try Again!","ERROR",JOptionPane.WARNING_MESSAGE);
			}
			if(isNumber)
			{
				if(yearNumber < 1582)
				{
					JOptionPane.showMessageDialog(null,"Year doesn't exist","ERROR",JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					setYear(yearNumber);
					setValidYear(true);
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
