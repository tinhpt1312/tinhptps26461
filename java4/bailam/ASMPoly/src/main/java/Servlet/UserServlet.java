package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet({"/UserServlet" , "/UserServlet/login"})
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		if(uri.contains("login")) {
			this.doSignin(req, resp);
//			req.getRequestDispatcher("/view/user/index.jsp").forward(req, resp);
		}else {
			req.getRequestDispatcher("/view/user/login.jsp").forward(req, resp);
		}
		
	}
	
	private void doSignin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method = req.getMethod();
		if(method.equalsIgnoreCase("POST")) {
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			if(username.equals("tinh") && password.equals("123")) {
				req.getRequestDispatcher("/view/user/index.jsp").forward(req, resp);
			}else {
				req.setAttribute("message", "Login fail");
				req.getRequestDispatcher("/view/user/login.jsp").forward(req, resp);
			}
			
		}
	}

}
