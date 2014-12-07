package com.bookshop.custom.action;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookshop.factory.ConnectionFactory;

/**
 * Servlet implementation class customphoto
 */
@WebServlet("/customphoto.action")
public class customphoto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public customphoto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String sql="select photoContentType,photo from custom where username=?";
		int len=0;
		byte[] data=new byte[300];
		try{
			Connection cn = null;
			cn = ConnectionFactory.getConnection();
			PreparedStatement ps=cn.prepareStatement(sql);
			String id1=request.getParameter("id");
			ps.setString(1, id1);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				String fileType=rs.getString("photoContentType");
				response.setContentType(fileType);
				OutputStream out=response.getOutputStream();
				InputStream in=rs.getBinaryStream("photo");
				while((len=in.read(data))!=-1){
					out.write(data,0,len);
				}
				in.close();
				out.close();
			}
			rs.close();
			ps.close();
		}catch(Exception e){
			System.out.println("È¡µÃ¼ÇÂ¼´íÎó£º"+e.getMessage());
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
