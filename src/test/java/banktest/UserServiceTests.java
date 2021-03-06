package banktest;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.nullable;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.LinkedList;
import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dao.UserDao;
import models.Account;
import models.Role;
import models.Users;
import net.bytebuddy.description.type.TypeDescription.Generic.LazyProjection.WithEagerNavigation;
import service.UserService;
import exceptions.RegisterUserFailedException;



public class UserServiceTests {
	// Declare a vaiable of the calss to be tested
	private UserService us;

	// Declare the dependencies of the class to be tested
	private UserDao mockDao;
	// Let's create a before to set up before our tests
	
	private Users dummyUser;

	@Before
	public void setup() {
		us = new UserService();
		// Let's mock the class that's being injected
		mockDao = mock(UserDao.class);
		
		// Let's set the user dao inside of the userservice to this mocked one
		us.udao = mockDao;
		
		// Lets also set up a stub user for passing in and stuff
		dummyUser = new Users();
		dummyUser.setAccounts(new LinkedList<Account>());
		dummyUser.setId(0); // We're doing to emulate a user generated form the console
		
		

	}

	@After
	public void teardown() {
		us = null;
		dummyUser = null;
		mockDao = null; 
	}
	
	// Let's look at testing
	// Test register new user, every time we should register the primary key (id) that's generated by the DB
	
	
	@Test
	public void tesRegisterUserReturnNewPKId() {
		// Let's make a user object to test
		dummyUser = new Users(0, "spongebob", "pass", Role.Admin, new LinkedList<Account>());
		Random r = new Random();
		int fakePK = r.nextInt(100);
		
		when(mockDao.insert(dummyUser)).thenReturn(fakePK);
		
		// The registered user of our register method should have the id that's returned form insert
		
		Users registeredUser = us.register(dummyUser);
		
		// The final things to do is call our assert method and the id of the registered user
		// To see if it matches the fakePK
		
		assertEquals(registeredUser.getId(), fakePK);
		
	}
// Let's test our exception stuff as well
// We want to make sure All the funtionality of the method is tested
	@Test(expected = RegisterUserFailedException.class)
	public void testRegisterUserWithNonZeroId() {
		dummyUser.setId(1);
		
		us.register(dummyUser); // Should throw exception
		
	}
	
// Let's test our other branch to be thorough
// This one comes after insert so we'll have to mock it again
	
@Test(expected = RegisterUserFailedException.class)
public void testInsertedUserReturnedNegativeOne() {
	// Dummy user we're passting to the insert mehtod
	dummyUser = new Users(0, "spongebob", "pass", Role.Admin, new LinkedList<Account>());

		//Returning this value form the insert method to cause an exception
	int fakePK = -1;
	
	
	//Mock insert mehtod and return fakepk
	when(mockDao.insert(dummyUser)).thenReturn(fakePK);
	
	//This hsould return an exception
	Users registeredUser = us.register(dummyUser);

}

@Test
public void testLoginReturnsUser() {
	dummyUser = new Users(0, "spongebob", "pass", Role.Admin, new LinkedList<Account>());
	
	String username = "spongebob";
	String password = "pass";
	
	when(mockDao.findByUsername(username)).thenReturn(dummyUser);
	
	Users loggedIn = us.login(username,password); 
	assertEquals(loggedIn.getUsername(), username);
	
}








}
