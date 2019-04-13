package cal.view;

import cal.controller.CalController;
import javax.swing.*;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class CalMasterPanel extends JPanel
{
	private CalController app;

	private JLabel monthLabel;
	private JTextField monthInput;
	private JTextField yearInput;
	private JLabel yearLabel;
	private JButton changeValues;
	private JLabel inputInfoYear;
	private JLabel inputInfoMonth;
	private SpringLayout appLayout;
	private DaysInWeek weekDays;
	private DisplayDays days;
	private InputDays infoPopup;
	private JButton timeSince;

	public CalMasterPanel(CalController app)
	{
		super();

		this.app = app;

		appLayout = new SpringLayout();

		days = new DisplayDays(app);
		appLayout.putConstraint(SpringLayout.NORTH, days, 75, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.WEST, days, 40, SpringLayout.WEST, this);
		weekDays = new DaysInWeek();
		infoPopup = new InputDays(app);
		appLayout.putConstraint(SpringLayout.WEST, weekDays, 0, SpringLayout.WEST, days);
		appLayout.putConstraint(SpringLayout.SOUTH, weekDays, -6, SpringLayout.NORTH, days);
		appLayout.putConstraint(SpringLayout.EAST, weekDays, 0, SpringLayout.EAST, days);
		monthLabel = new JLabel(app.getMonth());
		appLayout.putConstraint(SpringLayout.WEST, monthLabel, 0, SpringLayout.WEST, days);
		appLayout.putConstraint(SpringLayout.SOUTH, monthLabel, -7, SpringLayout.NORTH, weekDays);

		monthInput = new JTextField();
		yearLabel = new JLabel(app.getYear());
		appLayout.putConstraint(SpringLayout.NORTH, yearLabel, 0, SpringLayout.NORTH, monthLabel);
		appLayout.putConstraint(SpringLayout.EAST, yearLabel, 0, SpringLayout.EAST, days);

		changeValues = new JButton("Change date");
		timeSince = new JButton("Calculate");
		appLayout.putConstraint(SpringLayout.WEST, timeSince, 0, SpringLayout.WEST, changeValues);
		appLayout.putConstraint(SpringLayout.EAST, timeSince, 0, SpringLayout.EAST, changeValues);
		appLayout.putConstraint(SpringLayout.WEST, changeValues, 75, SpringLayout.EAST, monthInput);
		inputInfoYear = new JLabel("Year:");
		inputInfoMonth = new JLabel("Month:");
		yearInput = new JTextField();
		appLayout.putConstraint(SpringLayout.NORTH, timeSince, 0, SpringLayout.NORTH, yearInput);
		
		setupPanel();
		setupListeners();
		setupLayout();

	}

	private void setupPanel()
	{
		this.setLayout(appLayout);
		this.add(monthLabel);
		monthLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		this.add(monthInput);
		this.add(yearInput);
		this.add(yearLabel);
		yearLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		this.add(inputInfoYear);
		this.add(inputInfoMonth);
		this.add(changeValues);
		this.add(timeSince);
		this.add(days);
		this.add(weekDays);

	}

	private void setupListeners()
	{
		changeValues.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String yearData = yearInput.getText();
				String monthData = monthInput.getText();
				app.sendCalendarData(monthData, yearData);
				yearInput.setText("");
				monthInput.setText("");
				updateDisplayInfo();
			}
		});

		timeSince.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String[] option = {"Calculate"};
				int response = JOptionPane.showOptionDialog(app.getFrame(),infoPopup, "Day Calculator", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, option, option[0]);
				if (response == 0)
				{
					infoPopup.sendDataToController();
				}
			}
		});
	}

	protected void updateDisplayInfo()
	{
		ArrayList<String> updatedDays = app.getCalendarDays();
		monthLabel.setText(app.getMonth());
		yearLabel.setText(app.getYear());
		days.updateDays(updatedDays);
	}

	private void setupLayout()
	{
		appLayout.putConstraint(SpringLayout.EAST, days, -40, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, yearInput, 6, SpringLayout.SOUTH, monthInput);
		appLayout.putConstraint(SpringLayout.WEST, yearInput, 0, SpringLayout.WEST, monthInput);
		appLayout.putConstraint(SpringLayout.EAST, yearInput, 0, SpringLayout.EAST, monthInput);
		appLayout.putConstraint(SpringLayout.NORTH, inputInfoMonth, 5, SpringLayout.NORTH, monthInput);
		appLayout.putConstraint(SpringLayout.EAST, inputInfoMonth, -6, SpringLayout.WEST, monthInput);
		appLayout.putConstraint(SpringLayout.WEST, monthInput, 114, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, monthInput, -35, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.EAST, monthInput, 304, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, inputInfoYear, 0, SpringLayout.EAST, inputInfoMonth);
		appLayout.putConstraint(SpringLayout.SOUTH, inputInfoYear, -10, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.NORTH, changeValues, 0, SpringLayout.NORTH, monthInput);
		appLayout.putConstraint(SpringLayout.SOUTH, days, -30, SpringLayout.NORTH, monthInput);

	}

}
