package avanta;

import java.util.ArrayList;

public class MessageManager {
	private int ownerUID;
	private ArrayList<Message> messageList;
	
	public MessageManager() {
		ownerUID = 0;
	}
	
	public void setOwnerUID(int newOwnerUID) {
		if (ownerUID == 0) {
			ownerUID = newOwnerUID;
		}
	}
	public void composeNewMessage(int receiver, String message) {
		messageList.add(new Message(ownerUID, receiver, message));
	}
	/*
	 * Didn't include sendMessage and viewMessage because I realized the two methods
	 * would need to be implemented by the main class since two instances interact
	 * for sendMessage and viewMessage just needs changes in the UI, done by main -Chris
	 */
}