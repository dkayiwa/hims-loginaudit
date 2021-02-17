package org.openmrs.module.loginaudit;

import java.util.Date;
import java.util.List;

import org.openmrs.api.APIException;
import org.openmrs.api.OpenmrsService;
import org.openmrs.module.loginaudit.model.LoginUser;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface LoginAuditService  extends OpenmrsService {
	
	@Transactional(readOnly = true)
	public List<LoginUser> listUserLoginDetail(String userID,Date StartDate, Date EndDate) throws APIException;	

	
	@Transactional(readOnly = false)
	public void saveLoginDetail(Integer userID) throws APIException;
	
	@Transactional(readOnly = false)
	public void saveLogoutDetail(Integer userID) throws APIException;

}
