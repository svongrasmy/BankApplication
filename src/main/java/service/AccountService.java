package service;

import java.util.List;
import java.util.Scanner;



import dao.AccountDao;
import dao.IAccountDao;
import models.Account;

public class AccountService {
	// Let's inject our DAO to the service
	
	private IAccountDao adao= new AccountDao();
	
	private static Scanner scan = new Scanner(System.in);
	
	public void viewAllAccounts() {
		// Lets call upon our Dao to get all of our accouts
		System.out.println("Fetching accounts .....");
		List<Account> accList = adao.findAll();
		
		for(Account a: accList) {
			System.out.println(a);
		}
		
		
	}
}
