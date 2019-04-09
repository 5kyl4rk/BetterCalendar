package cal.controller;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import cal.model.Calendar;
import cal.view.CalFrame;

public class CalController
{
	private Calendar appCalendar;
	private CalFrame appFrame;
	
	public CalController()
	{
		appCalendar = new Calendar(this);
		appFrame = new CalFrame(this);
	}

	public void start()
	{
		//System.out.println(appCalendar.printDayArray());
		firstInput();
		appFrame.updateDisplay();
		appFrame.setVisiblity(true);
		
		//JOptionPane.showMessageDialog(null,appCalendar);
		//System.out.println(appCalendar);
	}
	
	private void firstInput()
	{
		String inputMonth;
		String inputYear;
		
		while (!appCalendar.getValidMonth())
		{
			inputMonth = JOptionPane.showInputDialog(null, "Please enter a month:", "[Enter Month]", JOptionPane.QUESTION_MESSAGE);
			appCalendar.processMonth(inputMonth);
			
		}
		
		while(!appCalendar.getValidYear())
		{
			inputYear = JOptionPane.showInputDialog(null, "Please enter a year:", "[Enter Year]",JOptionPane.QUESTION_MESSAGE);
			appCalendar.processYear(inputYear);
		}
		
	}
	
	public void sendCalendarData(String month, String year)
	{
		appCalendar.processMonth(month);
		appCalendar.processYear(year);
	}
	
	public ArrayList<String> getCalendarDays()
	{
		return appCalendar.getDayList();
	}
	
	public String getMonth()
	{
		return appCalendar.getMonthName();
	}
	
	public String getYear()
	{
		return appCalendar.getYear() + "";
	}
	
	public CalFrame getFrame()
	{
		return appFrame;
	}
	
	public void errorManager(Exception problem)
	{
		JOptionPane.showMessageDialog(appFrame, problem.getMessage(), "[ERROR]: "+problem.getCause().getMessage(),JOptionPane.ERROR_MESSAGE);
	}
	

}
