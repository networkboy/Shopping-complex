<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
       
       <% 
       Integer Onlinenums=(Integer) application.getAttribute("Onlinenums");
	   application.setAttribute("Onlinenums", ++Onlinenums);	
	   System.out.println("显示图片"+Onlinenums);   
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="../show.action" method="post" >
用户名:<input type="text" name="name" /><br/>

<input type="submit" value="提交"><br/>

</form>
</body>
</html>