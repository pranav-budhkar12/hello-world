package browser;

import java.util.*;
import java.text.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GreetingApplet extends JApplet implements ActionListener{

	JLabel outputLabel = new JLabel("Welcome Visitor");
	JButton timeButton = new JButton("Show Time");
	SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");

	@Override
	public void init(){
		setLayout(new BorderLayout());
		outputLabel.setHorizontalAlignment(JLabel.CENTER);
		outputLabel.setFont(new Font("Helvetica", Font.BOLD, 18));
		add(outputLabel);
		JPanel p = new JPanel();
		p.add(timeButton);
		add(p, BorderLayout.SOUTH);
		timeButton.addActionListener(this);
		String pattern = getParameter("timeFormat");
		if(pattern != null)
			formatter.applyPattern(pattern);
	}

	public void actionPerformed(ActionEvent ae){
		Date now = new Date();
		outputLabel.setText(formatter.format(now));
	}

	public void resetOutput(String text){
		outputLabel.setText(text);
	}
}




















