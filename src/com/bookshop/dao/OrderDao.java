package com.bookshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.bookshop.business.MycartBusiness;
import com.bookshop.factory.ConnectionFactory;
import com.bookshop.value.GoodValue;
import com.bookshop.value.OrderInfoValue;

public class OrderDao {

//	定义一些变量[]
	private ResultSet rs=null;
	private Connection ct=null;
	private PreparedStatement ps=null;
	
	
	
	
	/**
	 * 生成订单
	 * @param mbo 用户的购物车
	 * @param userId 用户 id
	 * @return 返回一个订单详细信息bean【OrderInfoBean】
	 */
	public OrderInfoValue addOrder(MycartBusiness mb,String userId){
		
		OrderInfoValue oiv=new OrderInfoValue();
	    boolean b=true;
		try {
			
			ct = ConnectionFactory.getConnection();
			ps=ct.prepareStatement("insert into orders (userId,isPayed,totalPrice)  values(?,?,?)");
			ps.setString(1, userId);
			ps.setByte(2, (byte)0);
			ps.setFloat(3, mb.getAllPrice());
			
			int a=ps.executeUpdate();
			
			if(a==1){
				
				
				//必须取出刚刚添加到orders表的那个订单号
				//取出最后那条的orders的id就是
				
				ps=ct.prepareStatement("select max(ordersId) from orders");
				
				rs=ps.executeQuery();
				
				int orderId=0;
				if(rs.next()){
					
					orderId=rs.getInt(1);
					
				}
				
				
				//orders表添加ok
				//添加ordersDetail表
				
				//从购物车中取出所有选购的商品
				ArrayList al=mb.showMyCart();
				
				//循环的添加到orderDetail表//!!!
				//我们可以使用批量操作数据库的方法，提供操作数据库的效率.
				Statement sm=ct.createStatement();
				for(int i=0;i<al.size();i++){
					
					GoodValue gb=(GoodValue)al.get(i);
					sm.addBatch("insert into orderDetail values('"+orderId+"','"+gb.getGoodsId()+"','"+mb.getGoodsNumById(gb.getGoodsId()+"")+"')");		
				}
				
				//批量执行添加任务呢
				sm.executeBatch();
				String sql="select ordersId ,truename,address,postcode,phone,totalPrice,username,email from users,orders"+ 
						" where ordersId=? and users.userid = (select orders.userid from orders where ordersId=?)";
				ps=ct.prepareStatement(sql);
				ps.setInt(1,orderId);
				ps.setInt(2,orderId );
				rs=ps.executeQuery();
				
				if(rs.next()){
					oiv.setOrdersId(rs.getInt(1));
					oiv.setTruename(rs.getString(2));
					oiv.setAddress(rs.getString(3));
					oiv.setPostcode(rs.getString(4));
					oiv.setPhone(rs.getString(5));
					oiv.setTotalPrice(rs.getFloat(6));
					oiv.setUsername(rs.getString(7));
					oiv.setEmail(rs.getString(8));
				}
			}
				
		} catch (Exception e) {
		    b=false;
			e.printStackTrace();
			// TODO: handle exception
		}finally{
			
			//关闭资源
			this.close();
		}
		if(b){
			return oiv;
		}else{
			return null;
		}
		
	
	}
	
	
//关闭函数
	
	public void close(){
		
		try {
			
			if(rs!=null){
				
				rs.close();
				rs=null;//
			}
			if(ps!=null){
				
				ps.close();
				ps=null;
			}
			
			if(!ct.isClosed()){
				
				ct.close();
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
}
