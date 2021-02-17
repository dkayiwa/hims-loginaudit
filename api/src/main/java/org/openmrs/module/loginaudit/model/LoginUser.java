package org.openmrs.module.loginaudit.model;

import java.io.Serializable;
import java.util.Date;

import org.openmrs.User;

public class LoginUser  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer loginauditID;
	private String name;
	private User user;
	private Date startDateTime;
	private Date endtDateTime;
	private String ipAdd;
	
	public Integer getLoginauditID() {
		return loginauditID;
	}
	public void setLoginauditID(Integer loginauditID) {
		this.loginauditID = loginauditID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Date getStartDateTime() {
		return startDateTime;
	}
	public void setStartDateTime(Date startDateTime) {
		this.startDateTime = startDateTime;
	}
	public Date getEndtDateTime() {
		return endtDateTime;
	}
	public void setEndtDateTime(Date endtDateTime) {
		this.endtDateTime = endtDateTime;
	}
	public String getIpAdd() {
		return ipAdd;
	}
	public void setIpAdd(String ipAdd) {
		this.ipAdd = ipAdd;
	}
	
	
	
}
