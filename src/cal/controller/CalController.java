package cal.controller;

import javax.swing.JOptionPane;
import cal.model.Calendar;

public class CalController
{
	private Calendar appCalendar;

	public CalController()
	{
		appCalendar = new Calendar();
	}

	public void start()
	{
		inputData();
	}

	private void inputData()
	{
		String inputMonth;
		
		while (!appCalendar.getValidMonth())
		{
			inputMonth = JOptionPane.showInputDialog(null, "Please enter a month:", "[Enter Month]", JOptionPane.QUESTION_MESSAGE);
			appCalendar.calculateMonth(inputMonth);
			
		}
		

	}

}
