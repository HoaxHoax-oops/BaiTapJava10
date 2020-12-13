package com.cybersoft.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	/*
	 * cấu hình để khi người dùng gọi đến đường dẫn "/home"
	 * thì sẽ gọi đến HomeServlet
	 */
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String contextPath = req.getContextPath();
		PrintWriter writer = resp.getWriter();
		
		resp.setContentType("text/html");
		
		writer.print("<form action=\"" + contextPath + "/home\" method=\"POST1\">\r\n"
				+ "        <input type=\"text\" name=\"username\" id=\"\">\r\n"
				+ "        <input type=\"submit\" value=\"send\">\r\n"
				+ "    </form>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = req.getParameter("username");
		
		System.out.println("username: " + username);
		
		//resp.sendRedirect(req.getContextPath() + "/welcome");
		RequestDispatcher dispatcher = req.getRequestDispatcher("/welcome");
		dispatcher.forward(req, resp);
	}
	
}
