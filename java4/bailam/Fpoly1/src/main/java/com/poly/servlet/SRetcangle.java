package com.poly.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SRetcangle
 */
@WebServlet("/SRetcangle")
public class SRetcangle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SRetcangle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/view/SHCN/formS.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int a, b, dt, cv;
		a = Integer.parseInt(request.getParameter("chieudai"));
		b = Integer.parseInt(request.getParameter("chieurong"));
		dt = a * b;
		cv = (a+b) * 2;
		request.setAttribute("dientich", dt);
		request.setAttribute("chuvi", cv);
		request.getRequestDispatcher("/view/SHCN/resultS.jsp").forward(request, response);
	}

}
