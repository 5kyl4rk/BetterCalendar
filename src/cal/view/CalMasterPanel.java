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
	private DisplayDays days;
	private SpringLayout appLayout;
	
	public CalMasterPanel(CalController app)
	{
		super();
		
		this.app = app;
		
		appLayout = new SpringLayout();
		
		days = new DisplayDays(app);
		appLayout.putConstraint(SpringLayout.WEST, days, 72, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, days, -91, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.EAST, days, -40, SpringLayout.EAST, this);
		monthLabel = new JLabel("null-vember");
		appLayout.putConstraint(SpringLayout.WEST, monthLabel, 164, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.NORTH, days, 0, SpringLayout.SOUTH, monthLabel);
		appLayout.putConstraint(SpringLayout.NORTH, monthLabel, 11, SpringLayout.NORTH, this);
		monthLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		monthInput = new JTextField();
		appLayout.putConstraint(SpringLayout.WEST, monthInput, 114, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, monthInput, -35, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.EAST, monthInput, 304, SpringLayout.WEST, this);
		setupPanel();
		setupListeners();
		setupLayout();
	}
	
	private void setupPanel()
	{
		this.setLayout(appLayout);
		this.add(monthLabel);
		this.add(monthInput);
		this.add(days);
		
		
	}
	
	private void setupListeners()
	{
		
	}
	
	private void setupLayout()
	{
		
	}

}
