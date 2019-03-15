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
		monthLabel = new JLabel("null-vember");
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
