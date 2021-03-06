package cal.view;

import cal.controller.CalController;

import java.awt.Dimension;

import javax.swing.JFrame;

public class CalFrame extends JFrame
{
	private CalController app;
	private CalMasterPanel appPanel;
	
	public CalFrame(CalController app)
	{
		super();
		this.app = app;
		appPanel = new CalMasterPanel(app);
		
		setupFrame();
	}
	
	private void setupFrame()
	{	
		this.setContentPane(appPanel);
		this.setSize(500, 500);
		this.setVisible(false);
		this.setResizable(true);
		this.setLocationRelativeTo(null);
		this.setMinimumSize(new Dimension(500,500));
		this.setTitle("Calendar");
	}
	
	public void setVisiblity(boolean state)
	{
		this.setVisible(state);
	}
	
	public void updateDisplay()
	{
		appPanel.updateDisplayInfo();
	}
}
