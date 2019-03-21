package cal.view;

import cal.controller.CalController;

import java.awt.BorderLayout;

import javax.swing.*;
import java.awt.Font;
import java.awt.GridLayout;

public class CalMasterPanel extends JPanel
{
	private CalController app;
	
	private JLabel monthLabel;
	private JTextField monthInput;
	private JTextField yearInput;
	private JLabel yearLabel;
	private JButton changeValues;
	private DisplayDays days;
	private JLabel inputInfoYear;
	private JLabel inputInfoMonth;
	private SpringLayout appLayout;
	
	public CalMasterPanel(CalController app)
	{
		super();
		
		this.app = app;
		
		appLayout = new SpringLayout();
		
		days = new DisplayDays(app);
		
		monthLabel = new JLabel("null-vember");
		
		monthInput = new JTextField();
		yearLabel = new JLabel("-9999");
		
		changeValues = new JButton("Change date");
		inputInfoYear = new JLabel("Year:");
		inputInfoMonth = new JLabel("Month:");
		yearInput = new JTextField();
		
		setupPanel();
		setupListeners();
		setupLayout();
	}
	
	private void setupPanel()
	{
		this.setLayout(appLayout);
		this.add(monthLabel);
		monthLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		this.add(monthInput);
		this.add(yearInput);
		this.add(yearLabel);
		yearLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		this.add(inputInfoYear);
		this.add(inputInfoMonth);
		this.add(changeValues);
		this.add(days);
		
		
	}
	
	private void setupListeners()
	{
		
	}
	
	private void setupLayout()
	{
		appLayout.putConstraint(SpringLayout.NORTH, days, 47, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.WEST, days, 72, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, days, -40, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, yearInput, 6, SpringLayout.SOUTH, monthInput);
		appLayout.putConstraint(SpringLayout.WEST, yearInput, 0, SpringLayout.WEST, monthInput);
		appLayout.putConstraint(SpringLayout.EAST, yearInput, 0, SpringLayout.EAST, monthInput);
		appLayout.putConstraint(SpringLayout.NORTH, inputInfoMonth, 5, SpringLayout.NORTH, monthInput);
		appLayout.putConstraint(SpringLayout.EAST, inputInfoMonth, -6, SpringLayout.WEST, monthInput);
		appLayout.putConstraint(SpringLayout.WEST, monthInput, 114, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, monthInput, -35, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.EAST, monthInput, 304, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, inputInfoYear, 0, SpringLayout.EAST, inputInfoMonth);
		appLayout.putConstraint(SpringLayout.SOUTH, inputInfoYear, -10, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.NORTH, changeValues, 0, SpringLayout.NORTH, monthInput);
		appLayout.putConstraint(SpringLayout.EAST, changeValues, 0, SpringLayout.EAST, yearLabel);
		appLayout.putConstraint(SpringLayout.NORTH, yearLabel, 0, SpringLayout.NORTH, monthLabel);
		appLayout.putConstraint(SpringLayout.EAST, yearLabel, 0, SpringLayout.EAST, days);
		appLayout.putConstraint(SpringLayout.SOUTH, days, -30, SpringLayout.NORTH, monthInput);
		appLayout.putConstraint(SpringLayout.WEST, monthLabel, 0, SpringLayout.WEST, days);
		appLayout.putConstraint(SpringLayout.SOUTH, monthLabel, -1, SpringLayout.NORTH, days);
		
		
	}

}
