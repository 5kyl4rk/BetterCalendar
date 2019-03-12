package cal.view;

import cal.controller.CalController;

import java.awt.BorderLayout;

import javax.swing.*;

public class CalPanel extends JPanel
{
	private CalController app;
	private JLabel[][] daysLabel;
	private JLabel monthLabel;
	private JTextField input;
	private Box[] weekBox;
	private SpringLayout appLayout;
	
	public CalPanel(CalController app)
	{
		super(new BorderLayout());
		
		this.app = app;
		
		daysLabel = new JLabel[5][7];
		weekBox = new Box[5];
		monthLabel = new JLabel("null-vember");
		input = new JTextField();
		setupPanel();
		setupListeners();
		setupLayout();
	}
	
	private void setupPanel()
	{
		//this.setLayout(appLayout);
		for(int row = 0; row < daysLabel.length; row++)
		{
			weekBox[row] = new Box(0);
			this.add(weekBox[row],BorderLayout.CENTER);
			for(int col = 0; col < daysLabel[0].length; col++)
			{
				daysLabel[row][col] = new JLabel("|  ");
				weekBox[row].add(daysLabel[row][col]);
			}
		}
		
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
