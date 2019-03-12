package cal.view;

import cal.controller.CalController;
import javax.swing.JFrame;

public class CalFrame extends JFrame
{
	private CalController app;
	private CalPanel appPanel;
	
	public CalFrame(CalController app)
	{
		super();
		this.app = app;
		appPanel = new CalPanel(app);
		
		setupFrame();
	}
	
	private void setupFrame()
	{	
		this.setContentPane(appPanel);
		this.setSize(500, 500);
		this.setVisible(true);
		this.setResizable(true);
		this.setTitle("Calendar");
	}
}
