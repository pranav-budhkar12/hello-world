package controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet({"/home", "/login", "/order", "/logout"})
public class SalesServlet extends HttpServlet{

	@Override
	public void doGet(HttpServletRequest request, 
	HttpServletResponse response) throws IOException, ServletException{
		String path = request.getServletPath();
		String view = null;
		if(path.equals("/home"))
			view = processHomeGet(request);
		else if(path.equals("/login"))
			view = processLoginGet(request);
		if(view == null){
			response.sendError(405, path);
			return;
		}
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, 
	HttpServletResponse response) throws IOException, ServletException{
		String path = request.getServletPath();
		String view = null;
		if(path.equals("/login"))
			view = processLoginPost(request);
		if(view == null){
			response.sendError(405, path);
			return;
		}
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}

	private String processHomeGet(HttpServletRequest request){
		return "/view/product.jspx";
	}

	private String processLoginGet(HttpServletRequest request){
		return "/view/customer.jspx";
	}

	private String processLoginPost(HttpServletRequest request){
		HttpSession session = request.getSession(true);
		String customerId = request.getParameter("customerId");
		String password = request.getParameter("password");
		model.CustomerBean cb = new model.CustomerBean();
		if(cb.authorize(customerId, password)){
			session.setAttribute("login", cb);
			return "/view/order.jspx";
		}
		request.setAttribute("failed", true);
		return "/view/customer.jspx";
	}
}

















