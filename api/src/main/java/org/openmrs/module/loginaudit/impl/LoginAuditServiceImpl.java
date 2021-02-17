package org.openmrs.module.loginaudit.impl;

import java.util.Date;
import java.util.List;

import org.openmrs.api.APIException;
import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.loginaudit.LoginAuditService;
import org.openmrs.module.loginaudit.db.LoginAuditDAO;
import org.openmrs.module.loginaudit.model.LoginUser;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class LoginAuditServiceImpl extends BaseOpenmrsService implements LoginAuditService{

	public LoginAuditServiceImpl() {
	}
	
	protected LoginAuditDAO dao;
	
	public void setDao(LoginAuditDAO dao) {
		this.dao = dao;
	}
	
	
	@Override
	@Transactional(readOnly = true)
	public List<LoginUser> listUserLoginDetail(String userID,Date startDate,Date endDate) throws APIException {
		if(startDate==null) {
			throw new APIException("Start Date Cannot be null");
		}
		if(endDate==null) {
			endDate = new Date();
		}
		return dao.listUserLoginDetail(userID, startDate, endDate);
		
	}

	@Override
	@Transactional
	public void saveLoginDetail(Integer userID) throws APIException {
		dao.saveLoginDetail(userID);
		
	}
	
	@Override
	@Transactional
	public void saveLogoutDetail(Integer userID) throws APIException {
		dao.saveLogoutDetail(userID);
		
	}








}
