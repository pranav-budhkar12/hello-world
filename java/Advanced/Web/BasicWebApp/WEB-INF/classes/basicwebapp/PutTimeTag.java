package basicwebapp;

import java.io.*;
import java.util.*;
import java.text.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public class PutTimeTag extends SimpleTagSupport{

	private SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");

	public void setFormat(String pattern){
		formatter.applyPattern(pattern);
	}

	@Override
	public void doTag() throws IOException, JspException{
		JspContext context = super.getJspContext();
		JspWriter out = context.getOut();
		Date now = new Date();
		out.print(formatter.format(now));
		context.setAttribute("ticks", System.currentTimeMillis());
	}
}



















