package com.tutorials4u.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.tutorials4u.dao.*;
import com.tutorials4u.domain.User;

public class UserAction extends ActionSupport implements ModelDriven<User> {

	private static final long serialVersionUID = -6659925652584240539L;

	private User user = new User();
	private List<User> userList = new ArrayList<User>();
	private UserDAO userDAO = new MyUserDAOImpl();
	
	public User getModel() {
		return user;
	}
	
	/**
	 * To save or update user.
	 * @return String
	 */
	public String saveOrUpdate()
	{	
		userDAO.saveOrUpdateUser(user);
		return SUCCESS;
	}
	
	/**
	 * To list all users.
	 * @return String
	 */
	public String list()
	{
		userList = userDAO.listUser();
		return SUCCESS;
	}
	
	/**
	 * To delete a user.
	 * @return String
	 */
	public String delete()
	{
		System.out.println(" UserAction-  delete()..  ");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		userDAO.deleteUser(Long.parseLong(request.getParameter("id")));
		return SUCCESS;
	}
	
	/**
	 * To list a single user by Id.
	 * @return String
	 */
	public String edit()
	{
		System.out.println(" UserAction-  edit()..  ");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		user = userDAO.listUserById(Long.parseLong(request.getParameter("id")));
		return SUCCESS;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

}
