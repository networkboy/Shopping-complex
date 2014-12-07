package com.bookshop.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bookshop.dao.CustomDao;
import com.bookshop.value.CustomValue;
import com.bookshop.factory.ConnectionFactory;



public class CustomDaoImpl implements CustomDao {
	public void create(CustomValue cv) throws Exception{
		String sql="insert into users (username,truename,passwd,email,phone,address,postcode) values (?,?,?,?,?,?,?)";
		Connection cn = null;
		try{
			cn = ConnectionFactory.getConnection();
		    PreparedStatement ps=cn.prepareStatement(sql);
			ps.setString(1,cv.getUsername());
			ps.setString(2,cv.getTruename());
			ps.setString(3,cv.getPasswd());
			ps.setString(4,cv.getEmail());
			ps.setString(5,cv.getPhone());
			ps.setString(6,cv.getAddress());
			ps.setString(7,cv.getPostcode());
			
			ps.executeUpdate();
			ps.close();
			}catch(Exception e){
				System.out.println("sql"+e.getMessage());
				cn.close();
			}
		String sql1="insert into custom (username) values (?)";
		Connection cn1 = null;
		try{
			cn1 = ConnectionFactory.getConnection();
		    PreparedStatement ps1=cn1.prepareStatement(sql1);
			ps1.setString(1,cv.getUsername());
			
			ps1.executeUpdate();
			ps1.close();
			}catch(Exception e){
				System.out.println("sql"+e.getMessage());
				cn.close();
			}
	}
	public void addphoto(CustomValue cv)throws Exception{
		String sql="update custom set Photo=?,PhotoFileName=?,PhotoContentType=? where username=?";
		
	}
	
	public void checkusername(CustomValue cv) throws Exception{
		String sql="select * from users where username = ?";
		Connection cn = null;
		try{
			cn = ConnectionFactory.getConnection();
		    PreparedStatement ps=cn.prepareStatement(sql);
			ps.setString(1,cv.getUsername());
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				cv.setCheckusername(true);
			}
			}catch(Exception e){
				cn.close();
			}
	}
	public void selectall(CustomValue cv) throws Exception{
		String sql="select  * from users where username=?";
		Connection cn = null;
		try{
			cn = ConnectionFactory.getConnection();
			PreparedStatement ps=cn.prepareStatement(sql);
			ps.setString(1,cv.getUsername());
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				cv.setUserid(rs.getLong(1));
				cv.setUsername(rs.getString(2));
				cv.setTruename(rs.getString(3));
				cv.setPasswd(rs.getString(4));
				cv.setEmail(rs.getString(5));
				cv.setPhone(rs.getString(6));
				cv.setAddress(rs.getString(7));
				cv.setPostcode(rs.getString(8));
				cv.setGrade(rs.getInt(9));
			}
			}catch(Exception e){
				System.out.println("selectallsql"+e.getMessage());
				cn.close();
			}
	}
	
	public void checklogin(CustomValue cv) throws Exception{
		
		String sql="select passwd from users where username=?";
		Connection cn = null;
		try{
			cn = ConnectionFactory.getConnection();
			PreparedStatement ps=cn.prepareStatement(sql);
			ps.setString(1,cv.getUsername());
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				
				String dbPasswd = rs.getString(1);
				if(dbPasswd.equals(cv.getPasswd())){
					cv.setChecklogin(true);
				}
			}
			}catch(Exception e){
				System.out.println("sql"+e.getMessage());
				cn.close();
			}
	}
	public void update(CustomValue cv)throws Exception{
		String sql="update users set truename=?,email=?,phone=?,address=?,postcode=? where username=?";
		Connection cn = null;
		try{
			cn = ConnectionFactory.getConnection();
			PreparedStatement ps=cn.prepareStatement(sql);
			ps.setString(1, cv.getTruename());
			ps.setString(2, cv.getEmail());
			ps.setString(3, cv.getPhone());
			ps.setString(4, cv.getAddress());
			ps.setString(5, cv.getPostcode());
			ps.setString(6, cv.getUsername());
			ps.executeUpdate();
			ps.close();
		}catch(Exception e){
			System.out.println("sql"+e.getMessage());
			cn.close();
		}

	}
	
}