<%@ page language="java" import="java.util.*,com.bookshop.value.*" pageEncoding="utf-8"%>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
//取出要显示的信息(goodsBean)
GoodValue gv=(GoodValue)request.getAttribute("gv");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	
	<!--
		//响应点击返回购物大厅的事件
		
		function returnHall(){
			window.open("../Mainbook/mainbook.jsp","_self");
		}
		
		//响应点击购买货物的事件
		function addGoods(goodsId){
			
		   window.open("../Showcart/ShopingDeal.do?type=addGoods&goodsId="+goodsId,"_self");
		}
	
	-->
	</script>
 </head>
  
  <body topmargin="0" background="images/bg.bmp">
   <center>
   <table width="80%" class="abc" border="1" cellspacing="0" cellpadding="0">
  <tr>
    <td align="center">
    <jsp:include flush="true" page="../Mainbook/head.jsp"></jsp:include>
    </td>
  </tr>
  <tr>
    <td align="center"><table class="abc" width="100%" border="1" cellspacing="0" cellpadding="0">
      <tr>
        <td height="15" colspan="2">&nbsp;</td>
        </tr>
      <tr>
    <td width="25%" rowspan="8"><img src="../images/<%=gv.getPhoto() %>"  width="136" height="169" /></td>
    <td align="center"><%=gv.getGoodsName() %></td>
  </tr>
  <tr>
    <td>价格：¥<%=gv.getGoodsPrice() %></td>
  </tr>
  <tr>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>ISBN：<%=gv.getGoodsId() %></td>
  </tr>
  <tr>
    <td>类型：<%=gv.getType() %></td>
  </tr>
  <tr>
    <td>出版商：<%=gv.getPublisher() %></td>
  </tr>
  <tr>
    <td>&nbsp;</td>
  </tr>
   <tr>
        <td height="76" align="left" valign="top"><%=gv.getGoodsIntro() %></td>
      </tr>
  <tr>
    <td height="76" align="left" valign="top"></td>
  </tr>
  <tr>
    <td height="23" colspan="2"><input type="button" onclick="addGoods(<%=gv.getGoodsId() %>)" name="Submit" value="购买" />
        <input name="Submit2" type="button" onclick="returnHall();" value="返回购物大厅" /></td>
  </tr>
  <tr>
    <td height="15" colspan="2">&nbsp;</td>
  </tr>
</table>
</body>
</html>

