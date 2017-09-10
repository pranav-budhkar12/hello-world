package basicwebapp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class GreetingServlet extends HttpServlet{

	private String greet;
	
	@Override
	public void init(ServletConfig cfg) throws ServletException{
		super.init(cfg);
		greet = cfg.getInitParameter("greet");
		if(greet == null)
			greet = "Welcome";
	}

	@Override
	public void doGet(HttpServletRequest request, 
	HttpServletResponse response) throws IOException, ServletException{
		String name = request.getParameter("user");
		if(name == null) name = "";
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>BasicWebApp - Greetings</title></head>");
		out.println("<body>");
		out.printf("<h1>%s Visitor %s</h1>%n", greet, name);
		out.printf("<b>Time on server: </b>%s%n", new Date());
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

}


















