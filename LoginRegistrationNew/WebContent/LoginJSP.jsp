<%@page import="com.d.Dbutil"%>
<%@page import="java.sql.SQLException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.lang.ClassNotFoundException" %>
<%@ page import="java.sql.ResultSet" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Welcome to Bridgelabz</title>
<script>

</script>
</head>
<body>
<% 

	ResultSet rs = null;
	String query = "SELECT * FROM userdetails WHERE uname = ? AND pass = ?";
	PreparedStatement pst = null;
	Connection conection = Dbutil.getConnection();
	
	pst = conection.prepareStatement(query);
	pst.setString(1, request.getParameter("uname"));
	pst.setString(2, request.getParameter("pass"));
	rs = pst.executeQuery();
	
	


	
	
	
	
%>


<div id="display">
<center>
<fieldset>
<h1>Welcome</h1>
<br>
<br>
<!--<p align="middle"><a href="index.html">Go To Login page</a>  -->
<% String uname=null; 
	session=request.getSession();
	if(session.getAttribute("sname")!=null)
		{

			uname=(String)session.getAttribute("sname");
			System.out.println(uname);
		}

	else{
		System.out.println("ok");
		response.sendRedirect("index.html");
		}
		
		%>

</fieldset>
<br><br>
<form action="Logout" method="post">
		<input type="submit" value="Logout">
	</form>


</center>
</div>
</body>
</html>