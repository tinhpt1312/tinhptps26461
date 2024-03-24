package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.UserDAO;
import Model.User;

public class UserController {
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			String type = request.getParameter("_type");
			System.out.println(type);

			switch (type) {
			case "Update":
				update(request, response);
				break;
			case "Delete":
				deleteUser(request, response);
				break;
			case "Insert":
				insertUser(request, response);
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void update(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		
		int id = Integer.parseInt(request.getParameter("id"));
		int role = Integer.parseInt(request.getParameter("role"));
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String fullname = request.getParameter("fullname");
		
		UserDAO userDao = new UserDAO();
		User user = new User(id, username, null, fullname, phone, email, role);
		
		if(userDao.update(user)) {
			request.getSession().setAttribute("message", "Cập nhật thành công");
			request.getSession().setAttribute("status","success");
		}else {
			request.getSession().setAttribute("message","Cập nhật thất bại");
			request.getSession().setAttribute("status", "danger");
		}
		
		response.sendRedirect("showUser.jsp?id=" + id);

	}

	private void insertUser(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		UserDAO userDao = new UserDAO();
		User user = new User();
		
		int role = Integer.parseInt(request.getParameter("role"));
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String fullname = request.getParameter("fullname");
		String password = request.getParameter("password");
		
		user.setFullname(fullname);
		user.setUsername(username);
		user.setEmail(email);
		user.setPhone(phone);
		user.setPassword(password);
		user.setRole(role);
		
		userDao.insertUser(user);
		response.sendRedirect("showUser.jsp");
	}

	private void deleteUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("iddelete"));
		UserDAO userDao = new UserDAO();
		userDao.deleteUser(id);
		response.sendRedirect("showUser.jsp");
	}
}
