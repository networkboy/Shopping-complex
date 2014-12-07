package com.bookshop.business;
import com.bookshop.business.CustomBusiness;
import com.bookshop.factory.DaoFactory;
import com.bookshop.value.CustomValue;
import com.bookshop.dao.CustomDao;;
public class CustomBusinessImpl implements CustomBusiness{

	public void create(CustomValue cv) throws Exception {
		// TODO Auto-generated method stub
		CustomDao cd=DaoFactory.createCustomDao();
		cd.create(cv);
		
	}
	public void checkusername(CustomValue cv) throws Exception{
		CustomDao cd=DaoFactory.checkusernameCustomDao();
		cd.checkusername(cv);
	}
	public void checklogin(CustomValue cv) throws Exception{
		CustomDao cd=DaoFactory.checkloginCustomDaol();
		cd.checklogin(cv);
	}
	public void selectall(CustomValue cv) throws Exception{
		CustomDao cd=DaoFactory.selectallCustomDao();
		cd.selectall(cv);
	}
	public void update(CustomValue cv)throws Exception{
		CustomDao cd = DaoFactory.updateCustomDaol();
		cd.update(cv);
	}
	public void addphoto(CustomValue cv)throws Exception{
		CustomDao cd = DaoFactory.addphotoCustomDaol();
		cd.addphoto(cv);
	}
}
