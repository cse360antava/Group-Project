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
			f = new File("src/messages/" + message.receiver + "$" + i);
			i++;
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
        
        if (fileList == null) {
        	fileList = new File[0];
        }
        
        for (File file : fileList) {
        	if (file.isFile() && file.getName().contains("$")) {
        		String n = file.getName().split("\\$")[0];
        		//System.out.println(n);
        		if (n.equals(receiver)) {
        			// good to go, read it
        			try {
        				String c = Files.readString(file.toPath());
        				Message m = Message.parseMessage(c);
        				m.path = file.getPath();
        				res.add(m);
        			} catch (Exception e) {}
        		}
        	}
        }
        return res;
	}
	
	public static void delete(Message m) {
		try {
			File f = new File(m.path);
			f.delete();
		} catch (Exception e) {}
	}
}
