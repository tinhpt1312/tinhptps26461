package servelet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import UI.CookieUtils;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = CookieUtils.get("username", request);
		String password = CookieUtils.get("password", request);
		
		request.setAttribute("username", username);
		request.setAttribute("password", password);
		
		request.getRequestDispatcher("view/Login/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String remember = request.getParameter("remember");
		
		if(!username.equalsIgnoreCase("poly")) {
			request.setAttribute("message", "Sai tên đăng nhập");
			
		}
		else if(password.length() < 6 ) {
			request.setAttribute("message","Sai mật khẩu");
		}else {
			request.setAttribute("message","Đăng nhập thành công");
			
			int hours = (remember == null)?0:30*24;
			
			CookieUtils.add("username",username, hours, response);
			CookieUtils.add("password", password, hours, response);
		}
		
		request.getRequestDispatcher("view/Login/login.jsp").forward(request, response);
		doGet(request, response);
	}

}
