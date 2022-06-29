package service;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import dao.AccountDao;
import dao.IAccountDao;
import models.Account;

public class AccountService {
	// Let's inject our DAO to the service
	
	private IAccountDao adao= new AccountDao();
	
	Logger logger = Logger.getLogger(AccountService.class);
	
	private static Scanner scan = new Scanner(System.in);
	
	public void viewAllAccounts() {
		// Lets call upon our Dao to get all of our accouts
		//System.out.println("Fetching accounts .....");
		
		logger.info("Fetching Accounts...");
		
		List<Account> accList = adao.findAll();
		
		for(Account a: accList) {
			System.out.println(a);
		}
		
		
	}
}
