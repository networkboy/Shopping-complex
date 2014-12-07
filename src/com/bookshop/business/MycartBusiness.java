package com.bookshop.business;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import com.bookshop.factory.ConnectionFactory;
import com.bookshop.value.GoodValue;

public class MycartBusiness {
	HashMap<String,String> hm=new HashMap<String,String>();
	private ResultSet rs=null;
	private Connection ct=null;
	private PreparedStatement ps=null;
	
	//购物车的总价
	
	private float allPrice=0.0f;
	//返回总价
     public float getAllPrice(){
		
		return this.allPrice;
	}
	
	// 根据id返回货物的数量
   public String getGoodsNumById(String goodsId){
		
		return (String)hm.get(goodsId);
	}
	
	
	public void addGoods(String goodsId, String goodsNum)  {
		// TODO Auto-generated method stub
		hm.put(goodsId, goodsNum);
	}
	
	public void delGoods(String goodsId){
		// TODO Auto-generated method stub
		hm.remove(goodsId);
	}
	
	public void clear() {
		hm.clear();
	}
	public void upGoods(String goodsId, String newNum){
		// TODO Auto-generated method stub
		hm.put(goodsId, newNum);
	}
	
	public ArrayList showMyCart(){
		// TODO Auto-generated method stub
		ArrayList <GoodValue> al=new ArrayList <GoodValue>();
		
		try {
			
			//组织 sql
			
			String sql="select * from goods where goodsId in";
			
	
			
			Iterator it=hm.keySet().iterator();
			
			String sub="(";
			while(it.hasNext()){
				
				//取出goodsId
				String goodsId=(String)it.next();
				//判断goodsId是不是最后id
				if(it.hasNext()){
				sub+=goodsId+",";
				}else{
					
					sub+=goodsId+")";
				}
			}
			
			sql+=sub;
			
			ct = ConnectionFactory.getConnection();
			
			ps=ct.prepareStatement(sql);
			
			rs=ps.executeQuery();
			
			//把总价清空
			this.allPrice=0.0f;
			while(rs.next()){
				
				
				GoodValue gb=new GoodValue();
				int goodsId=rs.getInt(1);
				gb.setGoodsId(goodsId);
				gb.setGoodsName(rs.getString(2));
				gb.setGoodsIntro(rs.getString(3));
				float unit=rs.getFloat(4);
				gb.setGoodsPrice(unit);
				gb.setGoodsNum(rs.getInt(5));
				gb.setPublisher(rs.getString(6));
				gb.setPhoto(rs.getString(7));
				gb.setType(rs.getString(8));
				
				this.allPrice=this.allPrice+unit*Integer.parseInt(this.getGoodsNumById(goodsId+""));
				
				al.add(gb);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally{
			this.close();
			
		}
		
		return al;
	}
	
	

	public void close(){
		// TODO Auto-generated method stub
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
