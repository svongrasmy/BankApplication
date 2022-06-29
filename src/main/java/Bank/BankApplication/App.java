package Bank.BankApplication;

import connectionUtil.ConnectionUtil;
import service.AccountService;
import service.UserService;
import models.Role;
import models.Users;

import java.nio.channels.SelectionKey;
import java.util.Scanner;






public class App {
	
	static Scanner scan = new Scanner(System.in);
  public static void main(String[] args) {
	  //ConnectionUtil.getConnection();
	 AccountService as = new AccountService(); 
	  as.viewAllAccounts();
    // Let's just fetch account to test
   
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
			  us.login(username, password);
			  CustomerMenu();
		  } else if(selection == 2) {
			  System.out.println("Please enter a username.");
			   username = scan.next();
			  System.out.println("Please enter a password.");
			  password = scan.next();
			  
			  Users u = new Users(username, password, Role.Customer, null);
			  
			  us.register(u);
		  }
	  }
  
  
  public static void CustomerMenu() {
	  
	  System.out.println("Select one of the following actions: \n" 
			  			+"Push 1 to view account balance. \n" 
			  			+"Push 2 to withdraw funds. \n" 
			  			+"Push 3 to deposit funds. \n" 
			  			+"Push 4 to transfer funds between another customer account.");
	  int selection = scan.nextInt();
	  
  }

  }

