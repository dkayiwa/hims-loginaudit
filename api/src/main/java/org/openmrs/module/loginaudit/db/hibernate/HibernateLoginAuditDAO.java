package org.openmrs.module.loginaudit.db.hibernate;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.openmrs.User;
import org.openmrs.api.db.DAOException;
import org.openmrs.api.db.hibernate.DbSessionFactory;
import org.openmrs.module.loginaudit.db.LoginAuditDAO;
import org.openmrs.module.loginaudit.model.LoginUser;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class HibernateLoginAuditDAO implements LoginAuditDAO {

	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	SimpleDateFormat formatterExt = new SimpleDateFormat("dd/MM/yyyy");

	protected final Log log = LogFactory.getLog(getClass());
	
	private DbSessionFactory sessionFactory;

	@Override
	public void setSessionFactory(DbSessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<LoginUser> listUserLoginDetail(String userID, Date startDate, Date endDate) throws DAOException {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(LoginUser.class);
		criteria.add(Restrictions.eq("user.userID", Integer.parseInt(userID)));
		@SuppressWarnings("unchecked")
		List<LoginUser> l = criteria.list();
		return l;
	}

	@Override
	public void saveLoginDetail(Integer userID) throws DAOException {
		User user =(User) sessionFactory.getCurrentSession().load(User.class,userID);
		LoginUser loggeduser = new LoginUser();
		loggeduser.setUser(user);
		loggeduser.setStartDateTime(new Date());
		sessionFactory.getCurrentSession().merge(loggeduser);

	}

	
	public void saveLogoutDetail(Integer userID ) throws DAOException {
		User user =(User) sessionFactory.getCurrentSession().load(User.class, userID);
		LoginUser loggeduser = getLastLogin(user);
		loggeduser.setEndtDateTime(new Date());
		 sessionFactory.getCurrentSession().merge(loggeduser);

	}
	
	public LoginUser getLastLogin(User user) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(LoginUser.class);
		criteria.add(Restrictions.eq("user", user));
		criteria.addOrder(Order.desc("startDateTime")).setMaxResults(1);
		return (LoginUser)criteria.uniqueResult();
		
	}
}
