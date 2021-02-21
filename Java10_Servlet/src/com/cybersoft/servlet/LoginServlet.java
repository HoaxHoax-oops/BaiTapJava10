package com.cybersoft.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/*
	 * cấu hình LoginServlet sao cho - 
	 * khi người dùng vào đường dẫn "/login" 
	 * hiện ra form đăng nhập theo yêu cầu nhập username, mật khẩu, nút submit
	 * khi người dùng ấn nút submit 
	 * 		+ nếu username và mật khẩu là "admin"/"admin" 
	 * 		chuyển người dùng đến trang mới hiển thị tiêu đề "Welcome back." (tạo thêm WelcomeServlet)
	 * 		+ nếu nhập sai username, và mật khẩu thì hiển thị lại form đăng nhập
	 * 		(sendRedirect lại LoginService)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();

		resp.setContentType("text/html");

		writer.print("<form action=\"" + req.getContextPath() + "/login\" method=\"post\">\r\n"
				+ "        <p>Username:</p>\r\n" + "        <input type=\"text\" name=\"username\" id=\"\" />\r\n"
				+ "        <p>Password:</p>\r\n" + "        <input type=\"password\" name=\"password\" id=\"\" />\r\n"
				+ "        <input type=\"submit\" value=\"Submit\" />\r\n" + "      </form>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/welcome");

		if (!"admin".equals(req.getParameter("username")) 
			||	!"admin".equals(req.getParameter("password"))) {
			resp.sendRedirect(req.getContextPath() + "/login"); 
			return;
		}
		  
		dispatcher.forward(req, resp);	
	}
	
}
