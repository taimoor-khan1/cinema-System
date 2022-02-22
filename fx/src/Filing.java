

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Filing {
	String tic="tickets.txt";
	void write(String data) throws IOException{
		FileWriter file=new FileWriter(tic,true);
		BufferedWriter write=new BufferedWriter(file);
	
		write.write(data);
		write.newLine();
		write.close();
	}
}
