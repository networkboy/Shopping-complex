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

//	����һЩ����[]
	private ResultSet rs=null;
	private Connection ct=null;
	private PreparedStatement ps=null;
	
	
	
	
	/**
	 * ���ɶ���
	 * @param mbo �û��Ĺ��ﳵ
	 * @param userId �û� id
	 * @return ����һ��������ϸ��Ϣbean��OrderInfoBean��
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
				
				
				//����ȡ���ո���ӵ�orders����Ǹ�������
				//ȡ�����������orders��id����
				
				ps=ct.prepareStatement("select max(ordersId) from orders");
				
				rs=ps.executeQuery();
				
				int orderId=0;
				if(rs.next()){
					
					orderId=rs.getInt(1);
					
				}
				
				
				//orders�����ok
				//���ordersDetail��
				
				//�ӹ��ﳵ��ȡ������ѡ������Ʒ
				ArrayList al=mb.showMyCart();
				
				//ѭ������ӵ�orderDetail��//!!!
				//���ǿ���ʹ�������������ݿ�ķ������ṩ�������ݿ��Ч��.
				Statement sm=ct.createStatement();
				for(int i=0;i<al.size();i++){
					
					GoodValue gb=(GoodValue)al.get(i);
					sm.addBatch("insert into orderDetail values('"+orderId+"','"+gb.getGoodsId()+"','"+mb.getGoodsNumById(gb.getGoodsId()+"")+"')");		
				}
				
				//����ִ�����������
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
			
			//�ر���Դ
			this.close();
		}
		if(b){
			return oiv;
		}else{
			return null;
		}
		
	
	}
	
	
//�رպ���
	
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
