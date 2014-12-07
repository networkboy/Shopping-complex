package com.bookshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bookshop.factory.ConnectionFactory;
import com.bookshop.value.GoodValue;
public class GoodDaoImpl implements GoodDao {
	public void showdetail(GoodValue gv) throws Exception{
		String sql="select * from goods where goodsId=?";
		Connection cn = null;
		try{
			cn = ConnectionFactory.getConnection();
		    PreparedStatement ps=cn.prepareStatement(sql);
			ps.setLong(1,gv.getGoodsId());
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				gv.setGoodsName(rs.getString(2));
				gv.setGoodsIntro(rs.getString(3));
				gv.setGoodsPrice(rs.getFloat(4));
				gv.setGoodsNum(rs.getInt(5));
				gv.setPublisher(rs.getString(6));
				gv.setPhoto(rs.getString(7));
				gv.setType(rs.getString(8));
				ps.close();
			}
			}catch(Exception e){
				cn.close();
			}
	}
}

