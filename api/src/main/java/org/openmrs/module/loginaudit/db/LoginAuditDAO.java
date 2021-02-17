package org.openmrs.module.loginaudit.db;

import java.util.Date;
import java.util.List;


import org.openmrs.api.db.DAOException;
import org.openmrs.api.db.hibernate.DbSessionFactory;
import org.openmrs.module.loginaudit.model.LoginUser;

public interface LoginAuditDAO {

	
public void setSessionFactory(DbSessionFactory sessionFactory) throws DAOException;
	
	public  List<LoginUser> listUserLoginDetail(String userID, Date startDate , Date endDate) throws DAOException;
	
	public void saveLoginDetail(Integer userID) throws DAOException;
	public void saveLogoutDetail(Integer userID) throws DAOException;
	
}
