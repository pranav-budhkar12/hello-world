import java.awt.*;
import java.awt.event.*;

class AWTPlainTest{

	static class MainFrame extends Frame{
	
		public MainFrame(){
			super("Hello AWT");
			setSize(400, 400);
			enableEvents(AWTEvent.WINDOW_EVENT_MASK);
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
	}
}


















