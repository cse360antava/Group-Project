package antava;
//parent class, for inheritance and grouping purposes, of patient/nurse/doctor
public class User {
	public Account account;
	public MessageManager messager;
	
	public Account getAccount() {
		return this.account;
	}

	public MessageManager getMessageManager() {
		return this.messager;
	}
}