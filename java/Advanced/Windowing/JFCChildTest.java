import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

class JFCChildTest{

	static class MainFrame extends JFrame implements ActionListener{
	
		JButton timeButton = new JButton("Time");
		JButton resetButton = new JButton("Reset");

		public MainFrame(){
			super("Hello JFC");
			setSize(400, 400);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setLayout(new FlowLayout());
			add(timeButton);
			timeButton.addActionListener(this);
			add(resetButton);
			resetButton.addActionListener(this);
		}

		public void actionPerformed(ActionEvent ae){
			if(ae.getSource() == timeButton){
				Date now = new Date();
				setTitle(now.toString());
				JOptionPane.showMessageDialog(this, now, "Hello JFC",
					JOptionPane.INFORMATION_MESSAGE, null);
			}else{
				setTitle("Hello JFC");
			}
		}
	}

	public static void main(String[] args) throws Exception{
		UIManager.setLookAndFeel(
			new com.sun.java.swing.plaf.motif.MotifLookAndFeel());
		MainFrame frame = new MainFrame();
		frame.setVisible(true);
	}

}















