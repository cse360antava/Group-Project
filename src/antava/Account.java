package antava;

public class Account {
	private String username;
	private String password;
	private String accountType;
	private int UID; //unique ID per account, separate from patient ID system
	private static int UIDCount;
	public Account(String username, String password, String accountType) {
		this.username = username;
		this.password = password;
		this.accountType = accountType;
		this.UID = ++UIDCount;
	}
	public String getUsername() {
		return username;
	}
	public String getAccountType() {
		return accountType;
	}
	public boolean login(String username, String password) {
		return (username.equals(this.username) && password.equals(this.password));
	}
	public int getUID() {
		return UID;
	}
}