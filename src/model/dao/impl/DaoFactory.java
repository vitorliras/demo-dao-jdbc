package model.dao.impl;

import model.dao.SellerDao;

public class DaoFactory {

	public static SellerDao createSellerDao() {
		return new SellerDaoJDBC();
	}
	
}
