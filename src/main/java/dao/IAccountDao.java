package dao;

import java.util.List;

import models.Account;

public interface IAccountDao {

	
		int insert(Account a);
		
		List<Account> findAll();
		
		Account findById(int id);
		
		List<Account> findByOwner(int accOwnerId);
		
		boolean update(Account a);
		
		boolean delete(Account a);
		
}
