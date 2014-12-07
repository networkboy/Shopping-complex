<%@ page language="java" import="java.util.*,java.sql.*,com.bookshop.value.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
       <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body topmargin="0" background="images/bg.bmp">
   <center>
   <table width="80%" class="abc" border="1" cellspacing="0" cellpadding="0">
  <tr>
    <td align="center">
    <jsp:include flush="true" page="../Mainbook/head.jsp"></jsp:include>
    </td>
  </tr>
  <tr>
   <p class="style1"><a href="userphoto.jsp">用户设置</a></p>
    <td align="center"><table class="abc" width="100%" border="1" cellspacing="0" cellpadding="0">
      <tr>
        <td height="15" colspan="2">&nbsp;</td>
        </tr>
      <tr>
	<TBODY>
	<tr>
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
			<TD align=right background=../images/bg.bmp height=120>&nbsp;</TD>
		</TR>
	</TBODY>
</TABLE>

<TABLE height=15 cellSpacing=0 cellPadding=0 width=778 border=0>
	<TBODY>
	</TBODY>
</TABLE>
<TABLE cellSpacing=0 cellPadding=0 width=778 bgColor=#ffffff border=0>
	<TBODY>
		<TR>
			<TD vAlign=top width=168 height=400>
			<TABLE class=center height="100%" cellSpacing=0 cellPadding=0
				width=168 bgColor=#ffffff background=../images/bg.bmp border=0>
				<TBODY>

					<TR>
						<TD class=lefttd vAlign=top align=middle><p><BR> 
						    <a href="1" class="style1">外国小说</a></p>
					    <p><a href="../Art/art.jsp" class="style1">艺术</a></p>
					    <p class="style1"><a href="../Electronbook/electronbook.jsp">电子书</a></p>
					    <p class="style1"><a href="1">生活</a></p>
					    <p class="style1"><a href="1">少儿</a></p>
					    <p class="style1"><a href="1">科学</a></p>
					    <p class="style1"><a href="1">音像</a></p>
					    <p>&nbsp;</p></TD>
					</TR>
				</TBODY>
			</TABLE>
			</TD>
		  <TD width=610 align=middle vAlign=top class="style1">
			<TABLE cellSpacing=0 cellPadding=0 width="98%"
				background=/store/images/top01.gif border=0>
				<TBODY>
					<TR>
						<TD align=left height=25><span class="style2"> 图书列表</span></TD>
					</TR>
				</TBODY>
			</TABLE>
			<BR>
			<TABLE style="TEXT-ALIGN: center" cellSpacing=0 cellPadding=0
				width=590 border=0>
				<TBODY>
				<!--   显示内容开始  -->

      <TD>
						<p><img src="../images/01.jpg" width="183" height="238"><span class="style3">
                        <a href="../Showbook/Showdetail.do?id=1">xml 30	</a><img src="../images/02.jpg" width="179" height="238"><a href="../Showbook/Showdetail.do?id=2">java 40</a></span></p>
						<p><img src="../images/03.jpg" width="179" height="238">
                            <span class="style3"><a href="../Showbook/Showdetail.do?id=3">c++ 40</a></span> <img src="../images/04.jpg" width="176" height="238"><span class="style3"><a href="../Showbook/Showdetail.do?id=5">java2 50 </a></span> </p>
						<img src="../images/06.jpg" width="176" height="238"> <span class="style3"><a href="../Showbook/Showdetail.do?id=6">web 50</a>                        <img src="../images/05.jpg" width="176" height="238"><a href="../Showbook/Showdetail.do?id=4">C 50</a>  </span>                        
						<TABLE cellSpacing=0 cellPadding=0 width=180
							background=/store/images/bg.jpg border=0>
							<TBODY>
								<TR>
									<TD vAlign=bottom height=30>&nbsp; </TD>
								</TR>
								<TR align=middle>
									<TD height=120>&nbsp;</TD>
								</TR>
							</TBODY>
				</TABLE>		                        <BR>				</TD>
      
    


					<!--   显示内容结束  -->
				</TBODY>
			</TABLE>
			<BR>
		</TR>
	</TBODY>
</TABLE>
<TABLE class=center cellSpacing=0 cellPadding=0 width=778
	bgColor=#ffffff border=0>
	<TBODY>
	</TBODY>
</TABLE>

</CENTER>
</BODY>
</html>,