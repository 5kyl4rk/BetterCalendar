package cal.view;

import cal.controller.CalController;

import java.awt.GridLayout;

import javax.swing.*;

public class DisplayDays extends JPanel
{
	
	private JLabel[] daysLabel;
	private CalController app;
	private GridLayout appLayout;
	
	public DisplayDays(CalController app)
	{
		super();
		
		this.app = app;
		appLayout = new GridLayout(5,7);
		daysLabel = new JLabel[35];
		
		for(int index = 0; index < daysLabel.length; index++)
		{
			daysLabel[index] = new JLabel("|  ");
		}
		
		setupPanel();
	}
	
	private void setupPanel()
	{
		this.setLayout(appLayout);
		for(int index = 0; index < daysLabel.length; index++)
		{
			this.add(daysLabel[index]);
		}
		
	}
}
