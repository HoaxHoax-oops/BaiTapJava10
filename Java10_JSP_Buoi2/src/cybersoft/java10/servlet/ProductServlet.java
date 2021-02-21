package cybersoft.java10.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cybersoft.java10.model.Product;
import cybersoft.java10.service.*;
import cybersoft.java10.util.*;

@WebServlet(name = "productServlet", urlPatterns = { ServletConstant.PATH_PRODUCT, 
		ServletConstant.PATH_PRODUCT_ADD,
		ServletConstant.PATH_PRODUCT_EDIT, 
		ServletConstant.PATH_PRODUCT_DELETE,
		"/test"})
public class ProductServlet extends HttpServlet {
	ProductService service;

	@Override
	public void init() throws ServletException {
		super.init();
		service = new ProductService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String contextPath = req.getContextPath();

		switch (req.getServletPath()) {
		case ServletConstant.PATH_PRODUCT: // homepage
			req.setAttribute("products", service.getAllProducts());
			req.setAttribute("message", "hello from servlet");
			req.getRequestDispatcher(ProductConstant.URL_PRODUCT_HOMEPAGE).forward(req, resp);
			break;

		case ServletConstant.PATH_PRODUCT_DELETE:
			/*
			 * sao khi delete product sẽ quay về url là /product
			 */
			int id = Integer.parseInt(req.getParameter("id"));
			service.remove(id);
			resp.sendRedirect(contextPath + ServletConstant.PATH_PRODUCT);
			break;

		case ServletConstant.PATH_PRODUCT_ADD:
			/*
			 * hiển thị trang product-add.jsp
			 */
			req.setAttribute("command", "add");
			req.getRequestDispatcher(ProductConstant.URL_PRODUCT_ADD).forward(req, resp);
			break;

		case ServletConstant.PATH_PRODUCT_EDIT:
			String strId = req.getParameter("id");
			
			if(strId == null) {
				resp.sendRedirect(contextPath + ServletConstant.PATH_PRODUCT);
				break;
			}
				
			int editId = Integer.parseInt(strId);
			
			Product product = service.getProductById(editId);
			
			if(product == null) {
				resp.sendRedirect(contextPath + ServletConstant.PATH_PRODUCT);
				break;
			}
			
			req.setAttribute("command", "EDIT");
			req.setAttribute("product", product);
			req.getRequestDispatcher(ProductConstant.URL_PRODUCT_ADD).forward(req, resp);
			break;
		case "/test":
			service.testConnection();
		default:
			break;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String contextPath = req.getContextPath();
		
		Product product = extractProductFromRequest(req);
		
		switch (req.getServletPath()) {
		case ServletConstant.PATH_PRODUCT_ADD:
			if(service.add(product))
				break;
			
			req.setAttribute("addingFalse", "Duplicate ID. Fail to add a new product!");
			req.getRequestDispatcher(ProductConstant.URL_PRODUCT_ADD).forward(req, resp);
			return;
		case ServletConstant.PATH_PRODUCT_EDIT:
			service.update(Integer.parseInt(req.getParameter("productId")), product);
			break;
		default:
			break;
		}
		
		resp.sendRedirect(contextPath + ServletConstant.PATH_PRODUCT);
	}
	
	private Product extractProductFromRequest(HttpServletRequest req) {
		Product product = new Product();

		product.setId(Integer.parseInt(req.getParameter("productId")));
		product.setName(req.getParameter("productName"));
		product.setCode(req.getParameter("productCode"));
		product.setDescription(req.getParameter("description"));
		product.setPrice(Float.parseFloat(req.getParameter("productPrice")));
		
		return product;
	}
}
