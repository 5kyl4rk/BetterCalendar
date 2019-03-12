package cal.controller;

import javax.swing.JOptionPane;
import cal.model.Calendar;
import cal.view.CalFrame;

public class CalController
{
	private Calendar appCalendar;
	private CalFrame appFrame;
	
	public CalController()
	{
		appCalendar = new Calendar();
		appFrame = new CalFrame(this);
	}

	public void start()
	{
		//inputData();
		//JOptionPane.showMessageDialog(null,appCalendar);
		//System.out.println(appCalendar);
	}

	private void inputData()
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

}
