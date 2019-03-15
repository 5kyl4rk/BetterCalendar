package cal.view;

import cal.controller.CalController;

import java.awt.BorderLayout;

import javax.swing.*;

public class CalMasterPanel extends JPanel
{
	private CalController app;
	
	private JLabel monthLabel;
	private JTextField input;
	private DisplayDays days;
	private SpringLayout appLayout;
	
	public CalMasterPanel(CalController app)
	{
		super();
		
		this.app = app;
		
		appLayout = new SpringLayout();
		
		days = new DisplayDays(app);
		appLayout.putConstraint(SpringLayout.NORTH, days, 81, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.WEST, days, 118, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, days, -63, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.EAST, days, 296, SpringLayout.WEST, this);
		monthLabel = new JLabel("null-vember");
		appLayout.putConstraint(SpringLayout.WEST, monthLabel, 167, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, monthLabel, -17, SpringLayout.NORTH, days);
		input = new JTextField();
		setupPanel();
		setupListeners();
		setupLayout();
	}
	
	private void setupPanel()
	{
		this.setLayout(appLayout);
		this.add(monthLabel);
		this.add(input);
		this.add(days);
		
		
	}
	
	private void setupListeners()
	{
		
	}
	
	private void setupLayout()
	{
		
	}

}
