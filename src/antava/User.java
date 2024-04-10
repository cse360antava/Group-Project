package antava;
//parent class, for inheritance and grouping purposes, of patient/nurse/doctor
public class User {
	public Account account;
	
	public Account getAccount() {
		return this.account;
	}
	
	public String getID() {
		return "override";
	}
}