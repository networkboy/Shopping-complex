package com.bookshop.business;

import com.bookshop.dao.GoodDao;
import com.bookshop.factory.DaoFactory;
import com.bookshop.value.GoodValue;

public class  GoodBusinessImpl implements GoodBusiness {
	public void showdetail(GoodValue gv) throws Exception{
		GoodDao gd=DaoFactory.showdetailGoodDao();
		gd.showdetail(gv);
	}
}
