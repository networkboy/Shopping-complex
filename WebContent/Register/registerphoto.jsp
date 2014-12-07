<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
       
       <% 
       Integer Onlinenum=(Integer) application.getAttribute("Onlinenum");
	   application.setAttribute("Onlinenum",++Onlinenum);	
	   System.out.println("修改图片"+Onlinenum);   
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="../Register/addphoto.do" method="post" enctype="multipart/form-data">
用户名:<input type="text" name="name" /><br/>
头像:<input type="file" name="photo"><br/>
<input type="submit" value="提交"><br/>

</form>
<br/>
</body>
</html>