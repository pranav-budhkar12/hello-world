import java.awt.*;
import java.util.*;
import javax.swing.*;

class JFCPaintTest{

	static class MainFrame extends JFrame{
	
		public MainFrame(){
			super("Hello JFC");
			setSize(400, 400);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setContentPane(new DrawingPane());
		}

		class DrawingPane extends JPanel{
			
			@Override
			public void paintComponent(Graphics g){
				Date today = new Date();
				g.setColor(Color.RED);
				g.drawRect(20, 20, 200, 20);
				g.setColor(Color.BLUE);
				g.drawString(today.toString(), 30, 35);
			}
		}
	}

	public static void main(String[] args) throws Exception{
		final MainFrame frame = new MainFrame();
		frame.setVisible(true);
		for(;;){
			Thread.sleep(1000);
			SwingUtilities.invokeLater(new Runnable(){
				public void run(){
					frame.repaint();
				}
			});
		}
	}

}















