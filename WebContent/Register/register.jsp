<%@ page language="java" import="java.util.*,java.sql.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 <fmt:setBundle basename="com.bookshop.message.Info"/>
<CENTER>
<TABLE cellSpacing=0 cellPadding=0 width=778 bgColor=#ffffff
	background=images/top1bg.jpg border=0>
	<TBODY>
		<TR>
			<TD width=778>&nbsp;</TD>
		</TR>
	</TBODY>
</TABLE>
<TABLE class=center height=100 cellSpacing=0 cellPadding=0 width=778
	bgColor=#ffffff border=0>
	<TBODY>
		<TR>
			<TD align=middle width=150>&nbsp;</TD>
			<TD width=58>&nbsp;</TD>
			<TD vAlign=top width=110>&nbsp;</TD>
			<TD vAlign=top width=110>&nbsp;</TD>
			<TD vAlign=top width=110>&nbsp;</TD>
			<TD vAlign=top width=110>&nbsp;</TD>
			<TD width=130></TD>
		</TR>
	</TBODY>
</TABLE>

<TABLE class=center cellSpacing=0 cellPadding=0 width=778
	bgColor=#ffffff border=0>
	<TBODY>
		<TR>
			<TD style="FONT-SIZE: 1px" bgColor=#b0b0b0 colSpan=19 height=1></TD>
		</TR>
	</TBODY>
</TABLE>
<TABLE cellSpacing=0 cellPadding=0 width=778 bgColor=#ffffff border=0>
	<TBODY>
		<TR>
			<TD style="FONT-SIZE: 1px" bgColor=#dcdcdc height=3></TD>
		</TR>
		<TR>
			<TD align=right background=images/bn01.jpg height=120>&nbsp;</TD>
		</TR>
	</TBODY>
</TABLE>
<!-- 中间的蓝色条 -->
<TABLE height=10 cellSpacing=0 cellPadding=0 width=778 border=0>
	<TBODY>
		<TR>
			<TD style="FONT-SIZE: 10px; LINE-HEIGHT: 10px" background="images/bnbg1.gif" height="10"></TD>
		</TR>
	</TBODY>
</TABLE>
<TABLE cellSpacing=0 cellPadding=0 width=778 bgColor=#ffffff border=0>
	<TBODY>
		<TR>
			<TD vAlign=top width=168 height=400>
			<TABLE class=center height="100%" cellSpacing=0 cellPadding=0
				width=168 bgColor=#ffffff background=images/leftbg.gif border=0>
				<TBODY>

					<TR>
						<TD class=lefttd vAlign=top align=middle><BR>
						</TD>
					</TR>
				</TBODY>
			</TABLE>
			</TD>
			<TD vAlign=top align=middle width=610>
			<TABLE cellSpacing=0 cellPadding=0 width="98%"
				background=images/top01.gif border=0>
				<TBODY>
					<TR>
						<TD align=left height=25><IMG height=11
							src="images/icon1.gif" width=31>&nbsp;&nbsp;&nbsp;注册</TD>
					</TR>
      
				</TBODY>
			</TABLE>
			<BR>
			<p style="font-weight: bold">请输入你的注册信息：</p>
			<form method="post" action="Register.do" >
			<TABLE style="TEXT-ALIGN: center" cellSpacing=0 cellPadding=0
				width=590 border=0>
					<!--   显示内容开始  -->
					
						<input type="hidden" name="action" value="regist">
					<!-- table of form elements -->
					<table>
						<tr>
							<td class="left bold"><fmt:message key="com.bookshop.custom.action.custom.username"> </fmt:message>：</td>

							<td><input type="text" name="username" size="25" /></td>
								<td>${cv.nameexist}</td>
						</tr>

						<tr>
							<td>&nbsp;</td>
						</tr>
                        	<tr>
							<td class="left bold"><fmt:message key="com.bookshop.custom.action.custom.truename"> </fmt:message>：</td>

							<td><input type="text" name="truename" size="25" /></td>
							
						</tr>

						<tr>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td class="left bold"><fmt:message key="com.bookshop.custom.action.custom.password"> </fmt:message>：</td>

							<td><input type="password" name="password" size="25" /></td>
						</tr>
						<tr>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td class="left bold"><fmt:message key="com.bookshop.custom.action.custom.repassword"> </fmt:message>：</td>

							<td><input type="password" name="repassword" size="25" /></td> 
								<td>${cv.passerror }</td>
						</tr>

						<tr>
							<td>&nbsp;</td>
						</tr>
						<tr>
							
						</tr>

						<tr>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td class="left bold"><fmt:message key="com.bookshop.custom.action.custom.email"> </fmt:message>：</td>

							<td><input type="text" name="email" size="25" /></td>
							<td>${cv.emailerror }</td>
						</tr>

						<tr>
							<td>&nbsp;</td>
						</tr>
						  	<tr>
							<td class="left bold"><fmt:message key="com.bookshop.custom.action.custom.phone"> </fmt:message>：</td>

							<td><input type="text" name="phone" size="25" /></td>
							
						</tr>

						<tr>
							<td>&nbsp;</td>
						</tr>
							  	<tr>
							<td class="left bold"><fmt:message key="com.bookshop.custom.action.custom.address"> </fmt:message>：</td>

							<td><input type="text" name="address" size="25" /></td>
							
						</tr>

						<tr>
							<td>&nbsp;</td>
						</tr>
								  	<tr>
							<td class="left bold"><fmt:message key="com.bookshop.custom.action.custom.postcode"> </fmt:message>：</td>

							<td><input type="text" name="postcode" size="25" /></td>
							
						</tr>

						<tr>
							<td>&nbsp;</td>
						</tr>
						

						<tr>
							<td>&nbsp;</td>
						</tr>
					</table>
					
					<!-- enable user to submit the form  -->
					<p>
                    <input type="submit" value="提交" />
                    <input type="reset" value="重置" />
                    </p>
					
					<!--   显示内容结束  -->
			</TABLE>
            </form>
			</TD>
		</TR>
	</TBODY>
</TABLE>
<TABLE class=center cellSpacing=0 cellPadding=0 width=778
	bgColor=#ffffff border=0>

</TABLE>

</CENTER>
</BODY>
</html>