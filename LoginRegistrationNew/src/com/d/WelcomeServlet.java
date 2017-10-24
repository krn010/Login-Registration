package com.d;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String email;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			
			PrintWriter out=response.getWriter();
			util u=new util();
			
			HttpSession session=request.getSession();
			if(session.getAttribute("semail")!=null)
			{
			email=(String) session.getAttribute("semail");
			System.out.println("id is "+email);
			}
			else 
			{
				response.sendRedirect("index.html");
			}
			Connection conn = null;
			PreparedStatement pstmt =null;
			
			try {
				conn=Dbutil.getConnection();
				String query="select * from details where EmailId = ?";
				pstmt=conn.prepareStatement(query);
				pstmt.setString(1, email);
				ResultSet r =pstmt.executeQuery();
				
				while(r.next()){
				u.setUsername(r.getString("Username"));
					u.setGender(r.getString("Gender"));
					u.setEmailId(r.getString("EmailId"));
					u.setCountry(r.getString("Country"));
					//System.out.println("email is "+r.getString("EmailId"));
					
				}
				request.setAttribute("user",u);
				System.out.println(u);
				RequestDispatcher rd = request.getRequestDispatcher("/Welcome.jsp");
				rd.forward(request, response);
				
				
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
