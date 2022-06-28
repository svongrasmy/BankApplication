package dao;

import java.util.List;

import models.Users;

public interface IUserDao {
	
	int insert(Users u);
	
	Users findBYId(int id);
	Users findByUsername(String username); // Return the user object with this username
	List<Users> findAll(); // Return a list of all user objects in DB
	
	// UPdate
	boolean update(Users u); // Updates a user in the Database and return true if successfull and false if nhot
	
	// Delete
	boolean delete(int id); // Delete user assiciated with the ID
	
	
}
