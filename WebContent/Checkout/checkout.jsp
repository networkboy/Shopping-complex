<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

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
			<TD align=middle width=150><IMG title="" height=100
				src="images/logo.jpg" width=100 border=0></TD>
			<TD width=58>&nbsp;</TD>
			<TD vAlign=top width=110><IMG height=90 src="images/top1.jpg"
				width=70 border=0></TD>
			<TD vAlign=top width=110><IMG height=90 src="images/top2.jpg"
				width=70 border=0></TD>
			<TD vAlign=top width=110><IMG height=90 src="images/top3.jpg"
				width=70 border=0></TD>
			<TD vAlign=top width=110><IMG height=90 src="images/top4.jpg"
				width=70 border=0></TD>
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
				<TABLE cellSpacing=0 cellPadding=0 width="98%" background=images/top01.gif border=0>
					<TBODY>
						<TR>
							<TD align=left height=25><IMG height=11
								src="images/icon1.gif" width=31>&nbsp;&nbsp;&nbsp;请填写结账信息</TD>
						</TR>
					</TBODY>
				</TABLE>
				<TABLE style="TEXT-ALIGN: center" cellSpacing=0 cellPadding=0
					width=590 border=0>
					<TBODY>
						<!--   显示内容开始  -->
						<div>
						<form action="chechOut.store" method="post">
							<input type="hidden" name="action" value="checkout">
							<input type="hidden" name="userId" value="${logUser.userId}">
							<label for="userId">用户：</label><input type="text" value="${logUser.username }" disabled="disabled"><br>
							<label for="creditcard">信用卡：</label><input type="text" name="creditcard" maxlength="16"><br>
							<label for="phone">电话：</label><input type="text" name="phone" maxlength="11"><br>
							<label for="zipcode">邮编：</label><input type="text" name="zipcode" maxlength="6"><br>
							<label for="total">金额：</label><input type="text" name="total" value="${sessionScope.total }" readonly="readonly"><br>
							<input type="submit" value="结账">
						</form>	
						</div>
						<br />
						<br />
						<!--   显示内容结束  -->
				</TABLE>
			</TD>
		</TR>
	</TBODY>
</TABLE>
<TABLE class=center cellSpacing=0 cellPadding=0 width=778
	bgColor=#ffffff border=0>
		<TR>
			<TD align="middle" background="images/bk.gif" height="50"><img src="images/bk.gif"/></TD>
		</TR>
</TABLE>

</CENTER>
</BODY>
</HTML>
</html>