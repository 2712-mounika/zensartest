package com.test.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.entity.TestEmployee;
import com.test.service.TestService;
import com.test.service.TestServiceInterface;

/**
 * Servlet implementation class GlobalServlet
 */
public class GlobalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<html><body>");
		
		
		String s=request.getParameter("ac");
		if(s.equals("login"))
		{
			String email=request.getParameter("email");
			String password= request.getParameter("password");
			TestEmployee te=new TestEmployee();
			
			te.setEmail(email);
			te.setPassword(password);
			TestServiceInterface ts=TestService.createServiceObject();
			int i=ts.createProfile(te);
			if(i>0)
			{
				out.println("create profile");
			}
			else
			{
				out.println("could not create profile");
			}
		}
		out.println("</body></html>");
	}

}
