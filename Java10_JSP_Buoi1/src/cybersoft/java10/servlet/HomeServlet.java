package cybersoft.java10.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.rmi.server.Dispatcher;

public class HomeServlet extends HttpServlet{
	/*
	 * Cấu hình servlet tên là homeServlet
	 * có đường dẫn /home
	 * 
	 * Khi người dùng truy cập địa chỉ /home
	 * in ra câu tiêu đề " Welcome to my class"
	 */
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("WEB-INF/baitap.jsp").forward(req, resp);
	}
}
