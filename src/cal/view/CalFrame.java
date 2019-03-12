package cal.view;

import cal.controller.CalController;
import javax.swing.JFrame;

public class CalFrame extends JFrame
{
	private CalController app;
	private CalFrame appPanel;
	
	public CalFrame(CalController app)
	{
		super();
		this.app = app;
		appPanel = new CalFrame(app);
		
		setupFrame();
	}
	
	private void setupFrame()
	{
		this.setVisible(true);
		this.setResizable(true);
		this.setContentPane(appPanel);
		this.setTitle("Calendar");
	}
}
