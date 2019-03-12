package cal.view;

import cal.controller.CalController;

import java.awt.GridLayout;

import javax.swing.*;

public class DisplayDays extends JPanel
{
	private Box[] weekBox;
	private JLabel[][] daysLabel;
	private CalController app;
	private GridLayout appLayout;
	
	public DisplayDays(CalController app)
	{
		super();
		
		this.app = app;
		appLayout = new GridLayout(5,7);
		weekBox = new Box[5];
		daysLabel = new JLabel[5][7];
		
		for(int row = 0; row < daysLabel.length; row++)
		{
			for(int col = 0; col < daysLabel[0].length; col++)
			{
				daysLabel[row][col] = new JLabel("|  ");
			}
		}
		
		setupPanel();
	}
	
	private void setupPanel()
	{
		this.setLayout(appLayout);
		for(JLabel[] row : daysLabel)
		{
			for(JLabel current : row)
			{
				this.add(current);
			}
		}
		
	}
}
