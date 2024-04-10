package antava;

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
}