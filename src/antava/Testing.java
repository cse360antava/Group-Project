package antava;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.Test;

public class Testing {
	
	@Test
	public void AccountSetup() {
		UserList.init();
		
		assertEquals(UserList.userList.size(), 2);
	}
	
	@Test
	public void LoginSuccess() {
		UserList.init();
		
		System.out.println(UserList.userList.size());
		
		// attempts to log in as the Nurse
		// should be successful
		
		String username = "nurse";
		String password = "nurse321";
		
		boolean loginSuccess = false;
    	User user = null;
    	ArrayList<User> accountListLogin = new ArrayList<User>(UserList.userList.values());
    	for (int i = 0; i < accountListLogin.size(); i++) {
    		// once we find a match, attempt login
    		user = accountListLogin.get(i);
    		if (user.account.getUsername().equals(username)) {
    			loginSuccess = accountListLogin.get(i).account.login(username, password);
    			break;
    		}
    	}
    	// must successfully log in as the Nurse
    	assertTrue(loginSuccess && user instanceof Nurse);
	}
	
	@Test
	public void LoginFail() {
		UserList.init();
		
		// attempts to log in as the Nurse
		// should fail
		
		String username = "nurse";
		String password = "incorrect";
		
		boolean loginSuccess = false;
    	User user = null;
    	ArrayList<User> accountListLogin = new ArrayList<User>(UserList.userList.values());
    	for (int i = 0; i < accountListLogin.size(); i++) {
    		// once we find a match, attempt login
    		user = accountListLogin.get(i);
    		if (user.account.getUsername().equals(username)) {
    			loginSuccess = accountListLogin.get(i).account.login(username, password);
    			break;
    		}
    	}
    	// must be unsuccessful log in as the Nurse
    	assertFalse(loginSuccess);
	}
	
	@Test
	public void CreateAccount() {
		String createAccountPassword = "testUser1";
    	String createAccountUsername = "hello";
    	// loop through existing users to make sure there isn't a duplicate username
    	boolean alreadyExistingUsername = false;
    	ArrayList<User> accountListRegister = new ArrayList<User>(UserList.userList.values());
    	for (int i = 0; i < accountListRegister.size(); i++) {
    		if (accountListRegister.get(i).account.getUsername().equals(createAccountUsername)) {
    			alreadyExistingUsername = true;
    			//account with same username already created
    			break;
    		}
    	}
    	assertFalse(alreadyExistingUsername);
	}
	
	@Test
	public void CreateAccountLogin() {
		String createAccountPassword = "testUser2";
    	String createAccountUsername = "hello";
    	// loop through existing users to make sure there isn't a duplicate username
    	boolean alreadyExistingUsername = false;
    	ArrayList<User> accountListRegister = new ArrayList<User>(UserList.userList.values());
    	for (int i = 0; i < accountListRegister.size(); i++) {
    		if (accountListRegister.get(i).account.getUsername().equals(createAccountUsername)) {
    			alreadyExistingUsername = true;
    			//account with same username already created
    			break;
    		}
    	}
    	if (!alreadyExistingUsername) {
    		// if username is unique, create the account
    		Patient newPatient = new Patient(new Account(createAccountUsername, createAccountPassword, "patient"));
			UserList.userList.put(newPatient.account.getUID(), newPatient);
    	}
    	
    	boolean loginSuccess = false;
    	User user = null;
    	ArrayList<User> accountListLogin = new ArrayList<User>(UserList.userList.values());
    	for (int i = 0; i < accountListLogin.size(); i++) {
    		// once we find a match, attempt login
    		user = accountListLogin.get(i);
    		if (user.account.getUsername().equals(createAccountUsername)) {
    			loginSuccess = accountListLogin.get(i).account.login(createAccountUsername, createAccountPassword);
    			break;
    		}
    	}
    	// must successfully log in as a Patient
    	assertTrue(loginSuccess);
	}
	
	@Test
	public void CreateAccountDuplicate() {
		String createAccountPassword = "testUser3";
    	String createAccountUsername = "hello";
    	// loop through existing users to make sure there isn't a duplicate username
    	boolean alreadyExistingUsername = false;
    	ArrayList<User> accountListRegister = new ArrayList<User>(UserList.userList.values());
    	for (int i = 0; i < accountListRegister.size(); i++) {
    		if (accountListRegister.get(i).account.getUsername().equals(createAccountUsername)) {
    			alreadyExistingUsername = true;
    			//account with same username already created
    			break;
    		}
    	}
    	if (!alreadyExistingUsername) {
    		// if username is unique, create the account
    		Patient newPatient = new Patient(new Account(createAccountUsername, createAccountPassword, "patient"));
			UserList.userList.put(newPatient.account.getUID(), newPatient);
    	}
    	
    	// loop through existing users to make sure there isn't a duplicate username
    	 alreadyExistingUsername = false;
    	accountListRegister = new ArrayList<User>(UserList.userList.values());
    	for (int i = 0; i < accountListRegister.size(); i++) {
    		if (accountListRegister.get(i).account.getUsername().equals(createAccountUsername)) {
    			alreadyExistingUsername = true;
    			//account with same username already created
    			break;
    		}
    	}
    	assertTrue(alreadyExistingUsername);
	}

}
