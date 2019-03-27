package cal.view;

import cal.controller.CalController;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.Border;


public class DisplayDays extends JPanel
{
	
	private ArrayList<JLabel> daysLabel;
	private CalController app;
	private GridLayout appLayout;
	private Border labelBorder;
	public DisplayDays(CalController app)
	{
		super();
		
		this.app = app;
		appLayout = new GridLayout(5,7);
		daysLabel = new ArrayList<JLabel>(35);
		labelBorder = BorderFactory.createLineBorder(Color.BLACK, 2);
		for(int index = 0; index < daysLabel.size(); index++)
		{
			daysLabel.set(index, new JLabel("|  "));
			daysLabel.get(index).setBorder(labelBorder);
		}
		
		setupPanel();
		setupListeners();
	}
	
	public DisplayDays(CalController app, ArrayList<String> days)
	{
	super();
		
		this.app = app;
		int updateRow = days.size()/7;
		appLayout = new GridLayout(updateRow,7);
		daysLabel = new ArrayList<JLabel>(days.size());
		
		for(int index = 0; index < daysLabel.size(); index++)
		{
			daysLabel.set(index, new JLabel(days.get(index)));
			daysLabel.get(index).setBorder(labelBorder);
		}
		
		setupPanel();
	}
	
	private void setupPanel()
	{
		this.setLayout(appLayout);
		for(int index = 0; index < daysLabel.size(); index++)
		{
			this.add(daysLabel.get(index));
		}
		
	}
	
	private void setupListeners()
	{
		for(int index = 0; index < daysLabel.size(); index ++)
		{
			int current = index;
			daysLabel.get(index).addMouseListener(new MouseAdapter()
					{
						public void mouseClicked(MouseEvent click)
						{
							JLabel og = (JLabel) click.getComponent();
							og.setBackground(Color.RED);
						}
					});
		}
	}
	
	private void changeColor(int index)
	{
		daysLabel.get(index).setBackground(new Color(255,0,0));
	}
	public void updateDays(ArrayList<String> days)
	{
		int updateRow = days.size()/7;
		appLayout.setRows(updateRow);
		appLayout.setColumns(7);
		for(int index = 0; index < daysLabel.size(); index++)
		{
			this.remove(daysLabel.get(index));
		}
		daysLabel.clear();
		for(int index = 0; index < days.size(); index++)
		{
			daysLabel.add(new JLabel(days.get(index)));
			daysLabel.get(index).setBorder(labelBorder);
			this.add(daysLabel.get(index));
		}
		setupListeners();
	}
}
