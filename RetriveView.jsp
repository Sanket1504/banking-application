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
  <form action="retriveController">
  <table>
  <tr>
  <td>Search account no..</td>
  <td>
   <input  type="number" name="regNoSearch">
   </td>
   </tr>
   <tr>
			<td><input type="submit" value="Search"></td>
			</tr>
   </table>
   
  </form>
  <% 
    Register reg=null;
  %>
  <%if(!session.isNew()){
	List<Register> lstreg=(List<Register>)session.getAttribute("data");
    reg=lstreg.get(0);
    out.println("reg no&nbsp  cust name &nbsp username  &nbsp balance <br>");
    out.println(reg.getRegNo()+" &nbsp"+reg.getCustName()+" &nbsp"+reg.getUsername()+" &nbsp"+reg.getAccBal()+"<br>");
    session.invalidate();
  }
  %>
   <a href="Home.html">Home</a>
</body>
</html>