package com.cybersoft.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	/*
	 * khi người dùng truy cập đường dẫn website/welcome
	 * thì in ra dòng chữ "Welcome to my class" ra màn hình
	 * browser của người dùng
	 * 
	 * yêu cầu thêm: Người dùng sẽ truyền lên tên người dùng
	 * in ra dòng chữ "Welcome <tên-người-dùng> to my class"
	 * 
	 *  + để truyền tên lên 		 -> dùng query string
	 *  + để đọc được tên truyền lên -> req.getParameter
	 */
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO: trả về dòng chữ "Welcome to my class"
		String name = req.getParameter("name");
		
		PrintWriter writer = resp.getWriter();
		writer.print("<h1>Welcome " + name + " to my class</h1>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO: demo POST method
		super.doPost(req, resp);
	}

}
