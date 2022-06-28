package service;

import dao.IUserDao;
import dao.UserDao;
import models.Users;

public class UserService {
	
	// Dependency Injection
	private IUserDao udao = new UserDao();
	
	public Users register(Users u) {
		
		System.out.println("Returning user....");
		return null;
	}
	
}
