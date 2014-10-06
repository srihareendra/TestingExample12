package com.tutorials4u.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.tutorials4u.domain.User;

public class MyUserDAOImpl implements UserDAO {
	

	  public static long cnt=0;
	  
	 public  static List<User> usrList=new ArrayList<User>();
	public MyUserDAOImpl(){
		/*
	    try {
	    	 // Load the JDBC driver.
	    	
		    Class.forName("org.hsqldb.jdbcDriver");
		    System.out.println(" MyUserDAOImpl HSQLDriver Loaded.");
		    // Establish the connection to the database.
		    String url = "jdbc:hsqldb:data/tutorial";
		    Connection conn = DriverManager.getConnection(url, "sa", "");
		    System.out.println(" MyUserDAOImpl Got Connection.");
			Statement st = conn.createStatement();
			//DROP TABLE <table>
			Thread.sleep(10000);
			System.out.println("dropping table ...");
			st.executeUpdate("DROP TABLE User;");
			System.out.println("dropped table and recreating it ..");
			
			st.executeUpdate("create table User (USER_ID int,USER_NAME varchar" +
					",USER_GENDER varchar,USER_COUNTRY varchar,USER_ABOUT_YOU varchar" +
					",USER_MAILING_LIST varchar);");
			
		}   catch ( Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(" MyUserDAOImpl()  ...caught exception e = "+e.getCause());
		}*/
	}

	/**
	 * Used to save or update a user.
	 */
	public synchronized void saveOrUpdateUser(User user) {
		
		System.out.println(" MyUserDAOImpl synchronized saveOrUpdateUser...user = "+user);
		System.out.println("MyUserDAOImpl synchronized : saveOrUpdateUser--> user = "+user);
		System.out.println("MyUserDAOImpl : synchronized saveOrUpdateUser--> user.getName() = "+user.getName());
		user.setId(cnt+1);
		
		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		usrList.add(user);

	}
 
	/**
	 * Used to delete a user.
	 */
	public synchronized void deleteUser(Long userId) {
		System.out.println(" MyUserDAOImpl synchronized deleteUser...userId = "+userId);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		User usr = null;
		if(usrList!=null){
			Iterator<User> iter = usrList.iterator();
			
			while(iter.hasNext()){
				  usr = (User) iter.next();
				if(usr.getId().longValue()==userId.longValue()){
					usrList.remove(usr);
				}
			}
		}

	}
	
	/**
	 * Used to list all the users.
	 */
	public synchronized List<User> listUser() {
		System.out.println(" MyUserDAOImpl synchronized listUser...usrList = "+usrList);

		return usrList;
	}

	/**
	 * Used to list a single user by Id.
	 */
	public synchronized User listUserById(Long userId) {
		User usr = null;
		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(" MyUserDAOImpl synchronized  listUserById...userId = "+userId);
		if(usrList!=null){
			Iterator<User> iter = usrList.iterator();
			
			while(iter.hasNext()){
				  usr = (User) iter.next();
				if(usr.getId().longValue()==userId.longValue()){
					break;
				}
				
			}
		}
		return usr;
	}

}
