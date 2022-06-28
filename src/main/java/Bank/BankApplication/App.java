package Bank.BankApplication;

import connectionUtil.ConnectionUtil;
import service.AccountService;
import service.UserService;
import models.Role;
import models.Users;

import java.util.Scanner;





public class App {
	
	static Scanner scan = new Scanner(System.in);
  public static void main(String[] args) {
	  //ConnectionUtil.getConnection();
	 
 
    // Let's just fetch account to test
    AccountService as = new AccountService();
    as.viewAllAccounts();
    startup();
  }
  
  public static void startup() {
	  String username;
	  String password;
	  UserService us = new UserService();
	  System.out.println("Welcome to Steven's Bank");
	  System.out.println("Please define your role:\n"
			  			+ "Push 1 if you are a existing Customer.\n" 
			  			+ "Push 2 if you would like to register for a new account. \n" 
			  			+ "Push 3 if you are a Employee. \n"
			  			+ "Push 4 if you are a Bank Admin.");
	  int selection = scan.nextInt();
	  
	  if (selection == 1) {
			  System.out.println("Please enter your username.");
			  username = scan.next();
			  System.out.println("Please enter your password.");
			  password = scan.next();
			  
			
		  } else if(selection == 2) {
			  System.out.println("Please enter a username.");
			   username = scan.next();
			  System.out.println("Please enter a password.");
			  password = scan.next();
			  
			  Users u = new Users(username, password, Role.Customer, null);
			  
			
			  
			  us.register(u);
		  }
	  }
  

  }

