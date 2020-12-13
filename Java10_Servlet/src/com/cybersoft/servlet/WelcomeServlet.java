package com.cybersoft.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WelcomeServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//System.out.println("Check when this method is call!");
		
		PrintWriter writer = resp.getWriter();
		
		resp.setContentType("text/html");
		
		writer.print("<h1>Welcome " + req.getParameter("username") + " to my class</h1>");
	}
}
