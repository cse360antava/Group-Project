package antava;

public class Message {
	//uses UID for sender and receiver
	public String sender;
	public String receiver;
	public String message;
	public String subject;	
	public String path; // optional
	
	public Message(String sender, String receiver, String subject, String message) {
		this.sender = sender;
		this.receiver = receiver;
		this.message = message;
		this.subject = subject;
	}
	
	public String toString() {
		return "To: " + receiver
				+ "\nFrom: " + sender
				+ "\nSubject: " + (subject.isEmpty() ? "(no subject)" : subject)
				+ "\n\n" + message;
	}
	
	public static Message parseMessage(String c) {
		try {
			String[] s = c.split("\n\n", 2);
			String message = s[1];
			String[] meta = s[0].split("\n");
			String to = meta[0].split(": ",2)[1];
			String from = meta[1].split(": ",2)[1];
			String sub = meta[2].split(": ",2)[1];
			return new Message(from, to, sub, message);
		} catch (Exception e) {
			return null;
		}
	}
}