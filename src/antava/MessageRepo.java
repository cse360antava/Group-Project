package antava;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.util.ArrayList;

public class MessageRepo {
	public static void compose(Message message) {
		int i = 0;
		File f = null;
		while (f == null || f.isFile()) {
			f = new File(message.receiver + "$" + i);
		}
		try {
			FileWriter fw = new FileWriter(f);
			fw.write(message.toString());
			fw.close();
		} catch (Exception e) {}
	}
	
	public static ArrayList<Message> getTo(String receiver) {
		ArrayList<Message> res = new ArrayList<Message>();
		File folder = new File("src/messages");
        File[] fileList = folder.listFiles();
        for (File file : fileList) {
        	if (file.isFile()) {
        		String n = file.getName().split("$")[0];
        		if (n == receiver) {
        			// good to go, read it
        			try {
        				String c = Files.readString(file.toPath());
        				res.add(Message.parseMessage(c));
        			} catch (Exception e) {}
        		}
        	}
        }
        return res;
	}
}
