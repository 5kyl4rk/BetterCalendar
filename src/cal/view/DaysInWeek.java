package cal.view;

import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class DaysInWeek extends JPanel
{
	private JLabel[] labelArray;
	private GridLayout appLayout;
	
	public DaysInWeek()
	{
		super();
		
		appLayout = new GridLayout(1,7);
		labelArray = new JLabel[7];
		setupDays();
		setupLayout();
		
	}
	
	private void setupDays()
	{
		labelArray[0] = new JLabel("Sun");
		labelArray[1] = new JLabel("Mon");
		labelArray[2] = new JLabel("Tues");
		labelArray[3] = new JLabel("Wed");
		labelArray[4] = new JLabel("Thurs");
		labelArray[5] = new JLabel("Fri");
		labelArray[6] = new JLabel("Sat");
		
		
	}
	private void setupLayout()
	{
		this.setLayout(appLayout);
		for(int index = 0; index < labelArray.length; index++)
		{
			this.add(labelArray[index]);
		}
	}
}
