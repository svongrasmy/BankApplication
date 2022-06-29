package dao;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.sql.ResultSet;
import connectionUtil.ConnectionUtil;
import models.Account;

public class AccountDao implements IAccountDao{

	@Override
	public int insert(Account a) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<Account> findAll() {
		// Instantiate linkedlist to store all of the objects that we retrieve
		
		List<Account> accList = new LinkedList<Account>();
		// Obtain a connection using try with resources
		
		try(Connection conn = ConnectionUtil.getConnection()){
			// Create a statement to execute against the DB
			Statement stmt = conn.createStatement();
			
			// lets create our sql query
			String sql = "SELECT * FROM accounts";
			
			// We'll return all of the data quaried so we need a Resultset obj to iterate over it
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				// Gather the id of the accounts, balance, accOwnerId, and isActive
				int id = rs.getInt("id"); // Capture value in id column
				double balance = rs.getDouble("balance");
				int accOwnerId = rs.getInt("acc_owner");
				boolean isActive = rs.getBoolean("active");
				
				// Let's create an Account object to stora all of this
				
				Account a = new Account(id,balance,accOwnerId,isActive);
				
				accList.add(a);
				
			}
			
			
		}catch(SQLException e) {
			System.out.println("Unable to retrieve accounts due to SQL Exception");
			e.printStackTrace();
			
		}
		return accList;
	}

	@Override
	public Account findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Account> findByOwner(int accOwnerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Account a) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Account a) {
		// TODO Auto-generated method stub
		return false;
	}

}
