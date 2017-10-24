package com.d;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PreparedStatement pst = null;
	Connection conection=null;
	String uemail,pass;
	String query="SELECT EmailId,Password FROM details where EmailId=? AND Password=?";

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		PrintWriter writer = response.getWriter();
		
		///ResultSet rs = null;
		
		//boolean flag;
		uemail = request.getParameter("email");
		pass = request.getParameter("pass");
		
		try {
		
			conection = Dbutil.getConnection();
			System.out.println(conection);
			pst = conection.prepareStatement(query);
			pst.setString(1, uemail);
			pst.setString(2, pass);
			ResultSet rs = pst.executeQuery();
			//System.out.println(rs);
			if(rs.next()) {
				HttpSession session = request.getSession();
				session.setAttribute("semail", uemail);
				System.out.println("Logged in Successfully!!");
				/*RequestDispatcher rd = request.getRequestDispatcher("LoginJSP.jsp");
				rd.include(request, response);*/
				response.sendRedirect("/LoginRegistrationNew/Welcome");
			}
			else
			{
				response.setContentType("text/html");
				writer.print("<script>alert('Login failed! try again');</script>");
				RequestDispatcher rd = request.getRequestDispatcher("/index.html");
				rd.include(request, response);
			}
				
			}
			catch (SQLException e) {
				
				System.out.println(e);
			}
		
		finally {	
			
			
			if(pst!=null) {
				try {
					pst.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
			if(conection!=null) {
				try {
					conection.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}	
			}
			
		}
	
	}

}
