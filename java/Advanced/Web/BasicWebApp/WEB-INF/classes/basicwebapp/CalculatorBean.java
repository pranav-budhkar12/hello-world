package basicwebapp;

public class CalculatorBean implements java.io.Serializable{

	private double firstValue = 0.0;
	private double secondValue = 0.0;
	private String command = "Add";

	public final double getFirstValue(){
		return firstValue;
	}

	public final void setFirstValue(double value){
		firstValue = value;
	}

	public final double getSecondValue(){
		return secondValue;
	}

	public final void setSecondValue(double value){
		secondValue = value;
	}

	public final String getCommand(){
		return command;
	}

	public final void setCommand(String value){
		command = value;
	}

	public double getResult(){
		switch(command.charAt(0))
		{
			case 'A': return firstValue + secondValue;
			case 'S': return firstValue - secondValue;
			case 'M': return firstValue * secondValue;
			case 'D': return firstValue / secondValue;
		}
		return 0;
	}
}















