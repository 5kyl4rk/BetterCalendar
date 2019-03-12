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
		
		
		days = new DisplayDays(app);
		monthLabel = new JLabel("null-vember");
		input = new JTextField();
		setupPanel();
		setupListeners();
		setupLayout();
	}
	
	private void setupPanel()
	{
		this.setLayout(appLayout);
		
		this.add(days);
		this.add(input);
		this.add(monthLabel);
	}
	
	private void setupListeners()
	{
		
	}
	
	private void setupLayout()
	{
		
	}

}
