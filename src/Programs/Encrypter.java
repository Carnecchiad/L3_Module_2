package Programs;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Encrypter {
	public static void main(String[] args) {
	String s = "";	
	try {
		FileReader fr = new FileReader("src/intro_to_file_io/test.txt");
		int c = fr.read();
		while(c != -1){
			s+=(char)c;
			c = fr.read();
			
		}
		fr.close();
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	char[] c = s.toCharArray();
	s = "";
	for (int i = 0; i < c.length; i++) {
		
		s += (char)(c[i] +1);
	}
	try {
		FileWriter fw = new FileWriter("src/intro_to_file_io/test.txt");
		
		/*
		NOTE: To append to a file that already exists, add true as a second parameter when calling the
		      FileWriter constructor.
		      (e.g. FileWriter fw = new FileWriter("src/intro_to_file_io/test2.txt", true);)
		*/
		
		fw.write(s);
			
		fw.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
	}
}
