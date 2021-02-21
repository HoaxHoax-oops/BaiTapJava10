package cybersoft.java10.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "loginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO: show form Login
		req.getRequestDispatcher("WEB-INF/login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO: xử lý đăng nhập
		/*
		 * nếu username và password đều là admin -> chuyển tới trang home.jsp
		 * nếu sai -> show lại form đăng nhập và hiện dòng chữ
		 * "Sau username hoặc mật khẩu" ở trên form đăng nhập
		 */
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		if("admin".equalsIgnoreCase(username)
				&& "admin".equalsIgnoreCase(password)) {
			req.getRequestDispatcher("home.jsp").forward(req, resp);
			return;
		}
		
		req.setAttribute("message", "Sai username hoặc mật khẩu.");
		req.getRequestDispatcher("WEB-INF/login.jsp").forward(req, resp);
	}
}
