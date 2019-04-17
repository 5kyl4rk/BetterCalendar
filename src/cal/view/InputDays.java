package cal.view;

import java.awt.Dimension;

import javax.swing.*;
import cal.controller.CalController;

public class InputDays extends JPanel
{
	private SpringLayout appLayout;
	private CalController app;
	private JLabel startInfo;
	private JLabel startMonth;
	private JLabel startYear;
	private JLabel startDay;
	private JLabel endInfo;
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
		
		startInfo = new JLabel("Start Date:");
		startMonth = new JLabel("Month:");
		startYear = new JLabel("Year:");
		startDay = new JLabel("Day:");
		endInfo = new JLabel("End Date:");
		endMonth = new JLabel("Month:");
		endYear = new JLabel("Year:");
		endDay = new JLabel("Day:");
		startMonthInput = new JTextField();
		startYearInput = new JTextField();
		startDayInput = new JTextField();
		endMonthInput = new JTextField();
		endYearInput = new JTextField();
		endDayInput = new JTextField();
		
		
		setupPanel();
		setupLayout();
	}
	
	public void setupPanel()
	{
		this.setLayout(appLayout);
		this.add(startInfo);
		this.add(startMonth);
		this.add(startYear);
		this.add(startDay);
		this.add(endInfo);
		this.add(endMonth);
		this.add(endYear);
		this.add(endDay);
		
		this.add(startMonthInput);
		this.add(startYearInput);
		this.add(startDayInput);
		this.add(endMonthInput);
		this.add(endYearInput);
		this.add(endDayInput);
		
		
	}
	
	public void sendDataToController()
	{
		app.sendStartDate(startMonthInput.getText(),startYearInput.getText(),startDayInput.getText());
		startMonthInput.setText("");
		startYearInput.setText("");
		startDayInput.setText("");
		app.sendEndDate(endMonthInput.getText(),endYearInput.getText(),endDayInput.getText());
		endMonthInput.setText("");
		endYearInput.setText("");
		endDayInput.setText("");
		
	}
	public void setupLayout()
	{
		this.setPreferredSize(new Dimension (450,300));
		appLayout.putConstraint(SpringLayout.NORTH, endDayInput, 0, SpringLayout.NORTH, endDay);
		appLayout.putConstraint(SpringLayout.WEST, endDayInput, 22, SpringLayout.EAST, endDay);
		appLayout.putConstraint(SpringLayout.SOUTH, endDayInput, 0, SpringLayout.SOUTH, endDay);
		appLayout.putConstraint(SpringLayout.EAST, endDayInput, -91, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, endYearInput, 0, SpringLayout.NORTH, endYear);
		appLayout.putConstraint(SpringLayout.WEST, endYearInput, 19, SpringLayout.EAST, endYear);
		appLayout.putConstraint(SpringLayout.SOUTH, endYearInput, 0, SpringLayout.SOUTH, endYear);
		appLayout.putConstraint(SpringLayout.EAST, endYearInput, -91, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.EAST, endMonthInput, 0, SpringLayout.EAST, endYearInput);
		appLayout.putConstraint(SpringLayout.NORTH, endMonthInput, 0, SpringLayout.NORTH, endMonth);
		appLayout.putConstraint(SpringLayout.WEST, endMonthInput, 6, SpringLayout.EAST, endMonth);
		appLayout.putConstraint(SpringLayout.SOUTH, endMonthInput, 0, SpringLayout.SOUTH, endMonth);
		appLayout.putConstraint(SpringLayout.SOUTH, startYearInput, -16, SpringLayout.NORTH, startDayInput);
		appLayout.putConstraint(SpringLayout.EAST, startDay, -22, SpringLayout.WEST, startDayInput);
		appLayout.putConstraint(SpringLayout.NORTH, startDayInput, 0, SpringLayout.NORTH, startDay);
		appLayout.putConstraint(SpringLayout.SOUTH, startDayInput, 0, SpringLayout.SOUTH, startDay);
		appLayout.putConstraint(SpringLayout.WEST, startDayInput, 86, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, startDayInput, -304, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, startYearInput, 0, SpringLayout.NORTH, startYear);
		appLayout.putConstraint(SpringLayout.EAST, startYear, -19, SpringLayout.WEST, startYearInput);
		appLayout.putConstraint(SpringLayout.WEST, startYearInput, 86, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, startYearInput, -304, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, startMonthInput, 0, SpringLayout.NORTH, startMonth);
		appLayout.putConstraint(SpringLayout.EAST, startMonth, -6, SpringLayout.WEST, startMonthInput);
		appLayout.putConstraint(SpringLayout.SOUTH, startMonthInput, 0, SpringLayout.SOUTH, startMonth);
		appLayout.putConstraint(SpringLayout.WEST, startMonthInput, 86, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, startMonthInput, -304, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, endDay, 0, SpringLayout.NORTH, startDay);
		appLayout.putConstraint(SpringLayout.WEST, endDay, 0, SpringLayout.WEST, endInfo);
		appLayout.putConstraint(SpringLayout.NORTH, startMonth, 93, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.WEST, startMonth, 36, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, startInfo, -16, SpringLayout.NORTH, startMonth);
		appLayout.putConstraint(SpringLayout.NORTH, endYear, 0, SpringLayout.NORTH, startYear);
		appLayout.putConstraint(SpringLayout.WEST, endYear, 0, SpringLayout.WEST, endInfo);
		appLayout.putConstraint(SpringLayout.NORTH, endMonth, 0, SpringLayout.NORTH, startMonth);
		appLayout.putConstraint(SpringLayout.WEST, endMonth, 0, SpringLayout.WEST, endInfo);
		appLayout.putConstraint(SpringLayout.NORTH, startInfo, 26, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.WEST, startInfo, 36, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.NORTH, startDay, 16, SpringLayout.SOUTH, startYear);
		appLayout.putConstraint(SpringLayout.WEST, startDay, 36, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, startDay, -126, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.NORTH, endInfo, 17, SpringLayout.NORTH, startInfo);
		appLayout.putConstraint(SpringLayout.EAST, endInfo, -141, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, startYear, 16, SpringLayout.SOUTH, startMonth);
		appLayout.putConstraint(SpringLayout.WEST, startYear, 36, SpringLayout.WEST, this);
		
	}
	
}
