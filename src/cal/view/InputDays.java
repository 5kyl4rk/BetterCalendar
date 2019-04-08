package cal.view;

import javax.swing.*;
import cal.controller.CalController;

public class InputDays extends JPanel
{
	private SpringLayout appLayout;
	private CalController app;
	private JLabel startMonth;
	private JLabel startYear;
	private JLabel startDay;
	private JLabel endMonth;
	private JLabel endYear;
	private JLabel endDay;
	private JTextField startMonthInput;
	private JTextField startYearInput;
	private JTextField startDayInput;
	private JTextField endMonthInput;
	private JTextField endYearInput;
	private JTextField endDayInput;
	
	public InputDays(CalController app)
	{
		super();
		this.app = app;
		
		appLayout = new SpringLayout();
		
		startMonth = new JLabel();
		startYear = new JLabel();
		startDay = new JLabel();
		endMonth = new JLabel();
		endYear = new JLabel();
		endDay = new JLabel();
		
		startMonthInput = new JTextField();
		startYearInput = new JTextField();
		startDayInput = new JTextField();
		endMonthInput = new JTextField();
		endYearInput = new JTextField();
		endDayInput = new JTextField();
		
		setupLayout();
	}
	
	public void setupLayout()
	{
		this.setLayout(appLayout);
		
	}
	
}
