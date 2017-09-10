package basicwebapp;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet({"/state"})
public class StateServlet extends HttpServlet{

	@Override
	public void doGet(HttpServletRequest request,
	HttpServletResponse response) throws IOException, ServletException{
		HttpSession session = request.getSession(true);
		Integer m = (Integer) session.getAttribute("uctr");
		if(m == null) m = 1;
		session.setAttribute("uctr", m + 1);
		if(m % 5 == 0){
			response.sendRedirect("hello");
			return;
		}
		ServletContext application = getServletContext();
		Integer n;
		synchronized(application){
			n = (Integer) application.getAttribute("gctr");
			if(n == null) n = 1;
			application.setAttribute("gctr", n + 1);
		}
		if(n % 8 == 0){
			RequestDispatcher rd = request.getRequestDispatcher(
				"/hello?user=Guest"); 
			rd.forward(request, response);
			return;
		}
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>BasicWebApp - State</title></head>");
		out.println("<body>");
		out.println("<h1>Welcome Visitor</h1>");
		out.printf("<b>Number of requests: </b>%d / %d%n", m, n);
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
}





























