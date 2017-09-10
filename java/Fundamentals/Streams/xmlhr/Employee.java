package hr;

import javax.xml.bind.annotation.*;

public class Employee{

	private String code;
	private String password;
	private int experience;
	private double salary;

	@XmlAttribute
	public final String getCode(){
		return code;
	}

	public final void setCode(String value){
		code = value;
	}
	
	@XmlTransient
	public final String getPassword(){
		return password;
	}

	public final void setPassword(String value){
		password = value;
	}

	@XmlElement(name="extra")
	public final byte[] getEncodedPassword(){
		byte[] extra = password.getBytes();
		for(int i = 0; i < extra.length; ++i)
			extra[i] = (byte) (extra[i] ^ '#');
		return extra;
	}

	public final void setEncodedPassword(byte[] extra){
		for(int i = 0; i < extra.length; ++i)
			extra[i] = (byte) (extra[i] ^ '#');
		password = new String(extra);	
	}

	public final int getExperience(){
		return experience;
	}

	public final void setExperience(int value){
		experience = value;
	}

	public final double getSalary(){
		return salary;
	}

	public final void setSalary(double value){
		salary = value;
	}

	@Override
	public String toString(){
		return String.format("%s\t%d\t%.2f\t%s", code, experience, salary, 
			password);
	}
	
}




















