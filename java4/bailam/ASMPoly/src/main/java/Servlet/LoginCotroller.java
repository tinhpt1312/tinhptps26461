package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.UserDAO;
import Model.User;

@WebServlet("/login")
public class LoginCotroller {
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		response.setContentType("text/html;charset=UTF-8");
		request.getRequestDispatcher("view/user/login.jsp").forward(request, response);
		try(PrintWriter out = response.getWriter()){
			String username = (String) request.getParameter("username");
			String password = (String) request.getParameter("password");
			
			UserDAO usd = new UserDAO();
			User user = usd.checkLogin(username, password);
			if(user == null) {
				request.getSession().setAttribute("error", "Tài khoản hoặc mật khẩu không đúng");
				response.sendRedirect("view/user/login.jsp");
			}else {
				request.getSession().setAttribute("user", user);
				response.sendRedirect("view/user/index.jsp");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
