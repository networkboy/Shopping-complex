package com.bookshop.factory;
import javax.naming.*;

import java.sql.*;

import javax.sql.*;

public class ConnectionFactory {
	public static Connection getConnection() throws Exception{
	    Connection cn=null;
	    try{
	    	InitialContext ctx = new InitialContext();
	    	DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/mysql5");
	    	cn =ds.getConnection();
	    	ctx.close();
	    }catch(Exception e){
	    	throw new Exception(""+e.getMessage());
	    }
		return cn;
	}
}
