package com.poly.bai3;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.mbeans.MBeanUtils;
import org.apache.commons.beanutils.BeanUtils;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet({"/user/index","/user/edit/*","/user/create/*","/user/update","/user/delete/*"})
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	@Override
	protected void service(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
		UserDAO dao= new UserDAO();
		User user= new User();
		String uriString=req.getRequestURI();
		if (uriString.contains("edit")) {
			String idString=uriString.substring(uriString.lastIndexOf("/")+1);
			user = dao.findByID(idString);
		}else if(uriString.contains("create")) {
			try {
				req.setCharacterEncoding("UTF-8");
				resp.setCharacterEncoding("UTF-8");
				BeanUtils.populate(user, req.getParameterMap());
				dao.create(user);
				req.setAttribute("message", "Them thanh cong");
			} catch (Exception e) {
				// TODO: handle exception
				req.setAttribute("message", "Them that bai");
			}
		}else if(uriString.contains("update")) {
			try {
				req.setCharacterEncoding("UTF-8");
				resp.setCharacterEncoding("UTF-8");
				BeanUtils.populate(user, req.getParameterMap());
				dao.update(user);
				req.setAttribute("message", "Cập nhật thành công");
			} catch (Exception e) {
				// TODO: handle exception
				req.setAttribute("message", "Cập nhật thất bại");
			}
		}else if(uriString.contains("delete")) {
			try {
				req.setCharacterEncoding("UTF-8");
				resp.setCharacterEncoding("UTF-8");
			//	String idString=uriString.substring(uriString.lastIndexOf("/")+1);
				String idString=req.getParameter("id");
				System.out.println(idString);
				dao.remove(idString);
				req.setAttribute("message", "Xóa thành công");
			} catch (Exception e) {
				// TODO: handle exception
				req.setAttribute("message", "Xóa thất bại");
			}
			
		}
		req.setAttribute("form", user);
		req.setAttribute("items", dao.findAll());
		req.getRequestDispatcher("/views/user.jsp").forward(req, resp);
	}
	
	

}
