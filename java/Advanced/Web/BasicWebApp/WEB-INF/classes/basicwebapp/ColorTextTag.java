package basicwebapp;

import java.io.*;
import java.util.*;
import java.text.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public class ColorTextTag extends SimpleTagSupport{

	private String[] colors = {"violet", "indigo", "blue",
		"green", "yellow", "orange", "red"};
	
	public void setColors(String value){
		colors = value.split(",");
	}

	@Override
	public void doTag() throws IOException, JspException{
		JspContext context = super.getJspContext();
		JspWriter out = context.getOut();
		JspFragment body = super.getJspBody();
		StringWriter writer = new StringWriter();
		body.invoke(writer);
		StringBuffer buffer = writer.getBuffer();
		int i = 0;
		for(int j = 0; j < buffer.length(); ++j){
			char ch = buffer.charAt(j);
			if(Character.isWhitespace(ch))
				out.print(ch);
			else{
				String markup = String.format(
					"<font color='%s'>%c</font>",
					colors[(i++) % colors.length], ch);
				out.print(markup);
			}
		}
	}
}



















