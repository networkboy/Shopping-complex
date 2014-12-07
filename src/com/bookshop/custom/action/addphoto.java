package com.bookshop.custom.action;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookshop.business.CustomBusiness;
import com.bookshop.factory.BusinessFactory;
import com.bookshop.factory.ConnectionFactory;
import com.bookshop.value.CustomValue;
import com.jspsmart.upload.File;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

/**
 * Servlet implementation class addphoto
 */
@WebServlet("/Register/addphoto.do")
public class addphoto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletConfig config=null;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addphoto() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init(ServletConfig config) throws ServletException
    {
    	this.config=config;
    	
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		SmartUpload mySmartUpload = new SmartUpload();
        //鍒濆鍖�
        mySmartUpload.initialize(config,request,response);
     
        try {
			mySmartUpload.upload();
		} catch (SmartUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //寤虹珛File瀵硅薄
        try{
        	String username=mySmartUpload.getRequest().getParameter("name");
        com.jspsmart.upload.File   file   =   mySmartUpload.getFiles().getFile(0);  
        String name=file.getFileName();
        String contentType=mySmartUpload.getFiles().getFile(0).getContentType();
        int   size   =   file.getSize();     
        byte[]   image   =   new   byte[size];
        //杞寲鎴愪簩杩涘埗   
        for(int   i   =   0;   i   <   size;   i++)   
        {   
        	image[i]   =   file.getBinaryData(i);   
        }   
        String sql="insert into custom (username,photo,PhotoFileName,photoContentType) values (?,?,?,?)";
		Connection cn = null;
			cn = ConnectionFactory.getConnection();
			PreparedStatement ps=cn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setBytes(2, image);
			ps.setString(3,name);
	        
	    	ps.setString(4,contentType);
			ps.executeUpdate();
			ps.close();
			request.getRequestDispatcher("../Mainbook/userphoto.jsp").forward(request, response);
		}catch(Exception e){
			System.out.println("sql"+e.getMessage());
		//	cn.close();
		}
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
