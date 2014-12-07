<%@ page language="java" import="java.util.*,com.bookshop.value.*,com.bookshop.business.*"  contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";



//得到用户信息
CustomValue cv=(CustomValue)session.getAttribute("userInfo");
//得到购物车的内容
ArrayList al=(ArrayList)request.getAttribute("mycartInfo");

//得到购物车
MycartBusiness mb=(MycartBusiness)session.getAttribute("mycart");
%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <script type="text/javascript">
	
	<!--
		
		
		function alter(){
			window.open("../altermessage/Altermessage.do","_self");
		}
		
		//响应点击购买货物的事件
		function Register(){
			
		   window.open("../Register/register.jsp","_self");
		}
	
	-->
	</script>
  </head>
   <body topmargin="0" background="../images/bg.bmp">
    <center>
     <form action="../altermessage/Altermessage.do" method="post">
    <table width="80%" border="1" cellspacing="0" cellpadding="0">
  <tr>
    <td align="center">
    <jsp:include flush="true" page="../Mainbook/head.jsp"></jsp:include>
    </td>
  </tr>
  <tr>
    <td align="center"><table width="100%" border="1" cellspacing="0" cellpadding="0">
      <tr>
        <td align="center"><img src="../images/cartnavi-3.gif" width="599" height="49" /></td>
      </tr>
      <tr>
        <td align="center"><table width="70%" border="1" cellpadding="0" cellspacing="0" class="abc">
          <tr>
            <td colspan="2" align="center">购买人的信息</td>
            </tr>
          <tr>
            <td width="50%" align="right">用 户 名：</td>
            <td width="50%"><input type="text" name="username" value="<%=cv.getUsername() %>" /></td>
          </tr>
          <tr>
            <td align="right">*真实姓名：</td>
            <td><input type="text" name="truename" value="<%=cv.getTruename() %>" /></td>
          </tr>
          <tr>
            <td align="right">*家庭住址：</td>
            <td><input type="text" name="address" value="<%=cv.getAddress() %>" /></td>
          </tr>
          <tr>
            <td align="right">*联系电话：</td>
            <td><input type="text" name="phone" value="<%=cv.getPhone() %>" /></td>
          </tr>
          <tr>
            <td align="right">*电子邮件：</td>
            <td><input type="text" name="email" value="<%=cv.getEmail() %>" /></td>
          </tr>
          <tr>
            <td align="right">*邮　　编：</td>
            <td><input type="hidden" name="postcode" value="<%=cv.getPostcode() %>" /></td>
          </tr>
          <tr>
            <td align="right"><input type="submit" name="Submit" value="完成订单" /></td>
              <td align="right"><input type="submit" name="Submit" value="修改个人信息" /></td>
          </tr>
        </table> </td>
      </tr>
      
      <tr>
        <td align="center"><table width="70%" border="1" cellpadding="0" cellspacing="0" class="abc">
          <tr>
            <td colspan="4" align="center">我的购物车情况</td>
            </tr>
          <tr>
            <td align="center">编号</td>
            <td align="center">商品名称</td>
            <td>单价</td>
            <td>数量</td>
          </tr>
          <%
          //循环显示购物车的内容
          	for(int i=0;i<al.size();i++){
          		GoodValue gb=(GoodValue)al.get(i);
          		%>
          		<tr>
            <td align="center"><%=gb.getGoodsId() %></td>
            <td align="center"><%=gb.getGoodsName() %></td>
            <td><%=gb.getGoodsPrice() %></td>
            <td><%=mb.getGoodsNumById(gb.getGoodsId()+"") %></td>
          </tr>
          		<%
          	}
           %>
          <tr>
            <td colspan="4">您共选择了价值¥<%=mb.getAllPrice() %>的商品。</td>
            </tr>
          <tr>
            <td colspan="4" align="center"><input type="submit" name="Submit3" value="返回修改我的购物车" /></td>
            </tr>
        </table></td>
      </tr>
      <tr>
        <td align="right"><img src="../images/cartpre.gif" width="87" height="19" /><a href="../Order/OrderDeal.action"><img border="0" src="../images/cartnext.gif" width="87" height="19" /></a></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td align="center">
   
    </td>
  </tr>
</table>
</form>
    </center>
  </body>
</html>
