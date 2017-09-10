import java.awt.*;
import java.awt.event.*;
import java.util.*;

class AWTPaintTest{

	static class MainFrame extends Frame{
	
		public MainFrame(){
			super("Hello AWT");
			setSize(400, 400);
			enableEvents(AWTEvent.WINDOW_EVENT_MASK);
		}

		@Override
		public void paint(Graphics g){
			Date now = new Date();
			g.setColor(new Color(255, 0, 0));
			g.drawRect(20, 40, 200, 20);
			g.setColor(Color.BLUE);
			g.drawString(now.toString(), 30, 55);
		}

		@Override
		public void processWindowEvent(WindowEvent we){
			if(we.getID() == WindowEvent.WINDOW_CLOSING)
				System.exit(0);
			super.processWindowEvent(we);
		}
	}

	public static void main(String[] args) throws Exception{
		MainFrame frame = new MainFrame();
		frame.setVisible(true);
		for(;;){
			Thread.sleep(1000);
			frame.repaint();
		}
	}
}


















