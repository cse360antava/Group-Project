package antava;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MessageManager {
	private int messageCount;
	private int ownerUID;
	String baseDir;
	private File msgDir;
	private File ownerDir;
	private File inDir;
	private File outDir;
	/*
	 * Commenting because I changed quite a bit about this
	 * Firstly, this creates a folder, messaging, to hold ALL of the users' messages
	 * The folder structure looks like this:
	 * main - messaging -
	 * 		|		 	| user1 -
	 * 		|			|       | in -
	 * 		|			|		|	 | message1.txt
	 * 		|			|		|	 | message2.txt
	 * 		|			|		|	 | ...
	 * 		|			|		| out -
	 *		|			|		|	  | message1.txt
	 * 		|			|		|	  | ...
	 * 		|			| user2 -
	 * 		|			|		...
	 * 		|			| ...
	 * The main two interface methods are composeNewMessage() and getMessages(),
	 * their respective descriptions are just above their declarations
	 */
	
	public MessageManager() {
		ownerUID = 0;
		//baseDir is the directory that you want to put your files in - so if testing
		//change this to be whatever directory you want the files to be in
		baseDir = "C:\\Users\\chris\\Downloads\\College\\2024 Spring Sem\\CSE 360\\groupProjectPhase3Testing";
		msgDir = new File(String.format("%s\\messaging", baseDir));
		ownerDir = new File(String.format("%s\\messaging\\%d", baseDir, ownerUID));
		inDir = new File(String.format("%s\\messaging\\%d\\in", baseDir, ownerUID));
		outDir = new File(String.format("%s\\messaging\\%d\\out", baseDir, ownerUID));
		//find relevant messaging folders, create if none
		if (!msgDir.exists()) {
			msgDir.mkdir();
		}
		if (!ownerDir.exists()) {
			ownerDir.mkdir();
		}
		if (!inDir.exists()) {
			inDir.mkdir();
		}
		if (!outDir.exists()) {
			outDir.mkdir();
		}
	}
	
	public void setOwnerUID(int newOwnerUID) {
		if (ownerUID == 0) {
			ownerUID = newOwnerUID;
		}
	}
	public int getNextMessageCount() {
		messageCount++;
		return messageCount;
	}
	
	/*
	 * Takes a MessageManager recipient, their UID as an int, and the message to be sent as a String
	 * Writes the message to the recipient's in folder and the sender's out folder
	 * returns true if message was successfully written to both, otherwise returns false
	 */
	public boolean composeNewMessage(MessageManager receiver, int receiverUID, String message) {
		//first check if receiver exists, if not, then return false
		File receiverDir = new File(String.format("%s\\%d\\in", msgDir, receiverUID));
		if (!receiverDir.exists()) {
			return false;
		}
		//create a file with sender, receiver, message in BOTH sender out and receiver in
		try {
			FileWriter senderOut = new FileWriter(String.format("%s\\message%d", outDir, ++messageCount));
			senderOut.write(((Integer)ownerUID).toString() + "\n");
			senderOut.write(((Integer)receiverUID).toString() + "\n");
			senderOut.write(message);
			senderOut.close();
			FileWriter receiverIn = new FileWriter(String.format("%s\\message%d", receiverDir, receiver.getNextMessageCount()));
			receiverIn.write(((Integer)ownerUID).toString() + "\n");
			receiverIn.write(((Integer)receiverUID).toString() + "\n");
			receiverIn.write(message);
			receiverIn.close();
		} catch (IOException e) {
			return false;
		}
		return true;
		
	}
	/*
	 * Returns an ArrayList of messages from the MessageManager's in folder
	 * side note - not 100% sure what order they appear in,
	 * I think they should appear in newest->oldest 
	 */
	public ArrayList<Message> getMessages() {
		ArrayList<Message> messageList = new ArrayList<Message>();
		//loop through all the messages and create messages based on parse, add to arraylist
		File[] messageFileList = inDir.listFiles();
		for (int i = 0; i < messageFileList.length; i++) {
			File fileListMessage = messageFileList[i];
    		Scanner scanner;
			try {
				scanner = new Scanner(fileListMessage);
				int tempSender = Integer.parseInt(scanner.nextLine());
				int tempReceiver = Integer.parseInt(scanner.nextLine());
				String tempMessage = scanner.nextLine();
				Message tempMessageFile = new Message(tempSender, tempReceiver, tempMessage);
				messageList.add(tempMessageFile);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		return messageList;
	}
}

/*public class MessageManager {
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