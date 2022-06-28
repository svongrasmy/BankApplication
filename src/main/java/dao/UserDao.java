package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import connectionUtil.ConnectionUtil;
import models.Users;

public class UserDao implements IUserDao {

	@Override
	public int insert(Users u) {
		// Lets user insert to paractice creating a SQL operation
		// Step 1 capture the DB connection by using the connection util
		
		Connection conn = ConnectionUtil.getConnection(); // Pulls in current connection form connection util
		
		
		//Step 2 Generate a swl statement like "insert data
		
		String sql = "INSERT INTO users (username, pwd, user_role) values (?,?,?) RETURNING users. id";
		
		// Step 2b use a prepared statemen to avoud sql injection
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			// Start process to set the values we're enetering into the DB
			// Go through each ? and give it a value
			
			// Let's start with username
			
			stmt.setString(1, u.getUsername());
			
			// Let's do password as well
			
			stmt.setString(2, u.getPassword());
			
			// User role will be handled slightly since its a java enum
			stmt.setObject(3, u.getRole(), Types.OTHER);
			
			// Use a resultset to extracdt the primary key form the user object that was persisted
			ResultSet rs;
			
			if ((rs = stmt.executeQuery()) != null){
				//If we return data we can iterate over it
				rs.next();
				
				// We need to capture the first column of data return (which is the id of the return user object)
				
				int id = rs.getInt(1);
				
				System.out.println("We returned a user with id # " + id);
				
			}
			
		} catch (SQLException e) {
			System.out.println("Unable to insert user - sql exception");
			e.printStackTrace();
		}
		// If out database fails to enter someone in we should return an index that we know our DB could never generate
		
	
		
		return -1;
	}

	@Override
	public Users findBYId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Users findByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Users> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Users u) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}
	
	// Insert or create a user object
	
	
	
}
