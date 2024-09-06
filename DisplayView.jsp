<%@page import="org.apache.catalina.Session"%>

<%@page import="Bank.model.Register"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   
  
   <%
   List<Register> lst=null;
  Register reg=null;
   %>
   <%
      lst=(List<Register>)session.getAttribute("data");
       reg=lst.get(0);
   if(!session.isNew())
   {
	   out.println("reg no&nbsp  cust name &nbsp username  &nbsp balance");
	   for(Register regp:lst)
	   {
		  
		   out.println("<br>&nbsp &nbsp"+regp.getRegNo()+"&nbsp &nbsp"+regp.getCustName()+"&nbsp &nbsp"+regp.getUsername()+"&nbsp &nbsp"+regp.getAccBal()+"<br>");
	   }
	   session.invalidate();
   }
   %>
</body>
</html>