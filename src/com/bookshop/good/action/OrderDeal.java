package com.bookshop.good.action;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookshop.business.MycartBusiness;
import com.bookshop.dao.*;
import com.bookshop.value.CustomValue;
import com.bookshop.value.OrderInfoValue;
/**
 * Servlet implementation class OrderDeal
 */
@WebServlet("/Order/OrderDeal.action")
public class OrderDeal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderDeal() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		OrderDao ada = new OrderDao();
		MycartBusiness mb =(MycartBusiness)request.getSession().getAttribute("mycart");
		long userId= ((CustomValue)request.getSession().getAttribute("userInfo")).getUserid();
		OrderInfoValue oiv=ada.addOrder(mb, userId+"");
		if(oiv!=null){
			//SendMailtos sd;
		
			try{
			
				Properties p = System.getProperties();
				//p.put("mail.transport.protocol", "smtp");
				p.put("mail.smtp.host", "smtp.163.com");
				p.put("mail.smtp.port", "25");
				p.put("mail.smtp.auth", "true");
				MailAuth auth=new MailAuth("uit_ceshi@163.com", "q123456");
				Session session=Session.getDefaultInstance(p,auth);
			    Message message = new MimeMessage(session);
			    message.setFrom(new InternetAddress("uit_ceshi@163.com"));
			    message.setRecipient(Message.RecipientType.TO,new InternetAddress(oiv.getEmail()));
			    message.setSubject(oiv.getTruename()+"你好");
			    message.setText("购物"+oiv.getTotalPrice());
			    System.out.println("ok");
			    Transport.send(message);
			    System.out.println("ok send"+oiv.getEmail());
				}catch(Exception e){
					
				}
			request.setAttribute("detailbean", oiv);
			request.getRequestDispatcher("../Order/Order.jsp").forward(request, response);
			
			//request.getRequestDispatcher("../Order/Order.jsp").forward(request, response);
		
		}else{
			request.getRequestDispatcher("../Login/loginsucess.jsp").forward(request, response);
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
