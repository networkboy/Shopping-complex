package com.bookshop.factory;

import com.bookshop.business.CustomBusinessImpl;
import com.bookshop.business.CustomBusiness;
import com.bookshop.business.GoodBusiness;
import com.bookshop.business.GoodBusinessImpl;
import com.bookshop.dao.CustomDao;
import com.bookshop.value.CustomValue;


public class BusinessFactory 
{
	public static CustomBusiness createProductBusiness()
	{
		return new CustomBusinessImpl();
	
	}
	public static CustomBusiness checkusername()
	{
		return new CustomBusinessImpl();
	}
	public static CustomBusiness checklogin()
	{
		return new CustomBusinessImpl();
	}
	public static GoodBusiness showdetail()
	{
		return new GoodBusinessImpl();
	}
	public static CustomBusiness selectall(){
		return new CustomBusinessImpl();
	}
	public static CustomBusiness update(){
		return new CustomBusinessImpl();
	}
	public static CustomBusiness addphoto(){
		return new CustomBusinessImpl();
	}
}
