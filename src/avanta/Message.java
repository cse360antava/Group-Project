package avanta;

public class Message {
	//uses UID for sender and receiver
	public int sender;
	public String message;
	public int receiver;
	
	public Message(int sender, int receiver, String message) {
		this.sender = sender;
		this.receiver = receiver;
		this.message = message;
	}
	/*
	 * IMPLEMENTATION NOTE (Chris):
	 * I was thinking of doing another hashmap in main, mapping the account UID to the account
	 * for easier access to the recepient's messageManager, just wanted to get it out there
	 * in case I forget 
	 * */
}