class ThreadLocalTest{

	/*
	static class PrintItem{

		private static String text;

		public static void setText(String value){
			text = value;
		}

		public static String getText(){
			return text;
		}
	}
	*/

	static class PrintItem{

		private static ThreadLocal<String> textSlot = 
			new ThreadLocal<String>();

		public static void setText(String value){
			textSlot.set(value);
		}

		public static String getText(){
			return textSlot.get();
		}
	}

	static class Printer{
		
		public static void print(int copies){
			for(int i = 1; i <= copies; ++i){
				System.out.printf(
					"Printing copy:%d of %s for thread<%x>%n",
					i, PrintItem.getText(), 
					Thread.currentThread().hashCode());
				Worker.doWork(100 * i);
			}
		}
	}

	public static void main(String[] args) throws Exception{
		Thread child = new Thread(new Runnable(){
			public void run(){
				PrintItem.setText("Hello");
				Printer.print(10);
			}
		});
		child.start();
		PrintItem.setText("Welcome");
		Printer.print(10);
	}
}
















