package com.bookshop.dao;
import com.bookshop.value.CustomValue;
public interface CustomDao {
	public void create(CustomValue cv) throws Exception;
	public void checkusername(CustomValue cv) throws Exception;
	public void checklogin(CustomValue cv) throws Exception;
	public void selectall(CustomValue cv) throws Exception;
	public void update(CustomValue cv)throws Exception;
	public void addphoto(CustomValue cv)throws Exception;
}
