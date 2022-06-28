package service;

import dao.IUserDao;
import dao.UserDao;
import exceptions.RegisterUserFailedException;
import models.Users;

public class UserService {
	
	// Dependency Injection
	public IUserDao udao = new UserDao();
	
	public Users register(Users u) {
		
		System.out.println("Returning user....");
		
		// Let's make sure the registering user has an id of 0 before trying to register
		// This is just an additional layer of data validation
		
		if(u.getId()!=0) {
			throw new RegisterUserFailedException("User not valid to register because Id was not 0");
			
		}
		// If the id is 0, we can call the dao to create a new objects
		int generateId = udao.insert(u);
		
		// Lets do some checking before finishing
		
		if(generateId != -1 && generateId != u.getId()) {
			u.setId(generateId);
			
		}else {
			throw new RegisterUserFailedException("User's Id was neither -1 or did not change after insertion");
		}
		System.out.println("Successfully registered user with the Id of " + u.getId());
		
		return u;
	}
public Users login(String username, String password) {
		
		// We now need to call upon our userDAO to get us some information about the user with this specific username
		
		Users returnedUser = udao.findByUsername(username);
		
		
		
		
		// Check to see if returned password matches the entered password
		
		if (returnedUser.getPassword().equals(password)) {
			
			System.out.println("Successfully Logged in!");
			
			System.out.println("Reached the inside of the if statement");
			return returnedUser;
		}
		
		// Otherwise the password is not equal
		return null;
	}
	
}
