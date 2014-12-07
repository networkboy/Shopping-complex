package com.bookshop.factory;

import com.bookshop.dao.CustomDao;
import com.bookshop.dao.CustomDaoImpl;
import com.bookshop.dao.GoodDao;
import com.bookshop.dao.GoodDaoImpl;
import com.bookshop.value.GoodValue;




public class DaoFactory
{
	public static CustomDao createCustomDao()
	{
		return new CustomDaoImpl();
	}
	public static CustomDao checkusernameCustomDao()
	{
		return new CustomDaoImpl();
	}
	public static CustomDao checkloginCustomDaol()
	{
		return new CustomDaoImpl();
	}
	public static GoodDao showdetailGoodDao(){
		return new GoodDaoImpl();
	}
	public static CustomDao selectallCustomDao(){
		return new CustomDaoImpl();
	}
	public static CustomDao updateCustomDaol()
	{
		return new CustomDaoImpl();
	}
	public static CustomDao addphotoCustomDaol()
	{
		return new CustomDaoImpl();
	}
}
