package Bank.BankApplication;

import connectionUtil.ConnectionUtil;
import java.util.Scanner;



public class App {
	static Scanner scan = new Scanner(System.in);
  public static void main(String[] args) {
	  //ConnectionUtil.getConnection();
	 
    startup();
  }
  
  public static void startup() {
	 
	  System.out.println("Welcome to Steven's Bank");
	  System.out.println("Please define your role:\n"
			  			+ "Push 1 if you are a Customer or wanting to become a new Customer. \n" 
			  			+ "Push 2 if you are a Employee. \n" 
			  			+ "Push 3 if you are a Bank Admin. \n");
	  int selection = scan.nextInt();
	  
	  if (selection == 1) {
		  System.out.println("Are you an existing Customer? \n" 
				  			+ "Push 1 for Yes. \n" 
				  			+ "Push 2 for No.");
		  selection = scan.nextInt();
		  if(selection == 1){
			  System.out.println("Please enter a username.");
			  String username = scan.next();
			  System.out.println("Please enter a password.");
			  String password = scan.next();
		  }
	  }
  }
}
