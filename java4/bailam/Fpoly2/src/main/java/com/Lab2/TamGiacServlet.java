package com.Lab2;

import java.io.IOException;
import java.lang.Math;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TamGiac
 */
@WebServlet({"/TamGiacServlet", "/dientich", "/chuvi"})
public class TamGiacServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TamGiacServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("view/param/TamGiac.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		double a = Double.parseDouble(request.getParameter("a"));
		double b = Double.parseDouble(request.getParameter("b"));
		double c = Double.parseDouble(request.getParameter("c"));
		
		if((a + b >c) && (a + c > b) && (b + c > a)) {
			
			double chuVi = a + b + c;
			double p = chuVi / 2;
			double dienTich = Math.sqrt(p*(p-a)*(p-b)*(p-c));
			String uri = request.getRequestURI();
			
			if(uri.contains("dientich")) {
				request.setAttribute("message","Diện tích tam giác là: " + dienTich);
			}
			else {
				request.setAttribute("message","Chu vi tam giác là: " + chuVi);
			}
		}else {
			request.setAttribute("message","Không thỏa mãn các cạnh trong 1 tam giác");
			
		}
		request.getRequestDispatcher("view/param/TamGiac.jsp").forward(request, response);
		doGet(request, response);
	}

}
