<%@page import="com.d.util" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>WELCOME!</title>
</head>
<body>
<% util u;
u=(util)request.getAttribute("user");
out.println(u.getUsername());
out.println(u.getGender());
out.println(u.getEmailId());
out.println(u.getCountry());

%>

<a href="LogoutServlet">Logout</a>|  




</body>
</html>