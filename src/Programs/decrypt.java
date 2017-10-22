package Programs;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;

public class decrypt {
	public static void main(String[] args) {
	String fileName = "";
	JFileChooser jfc = new JFileChooser();
	int returnVal = jfc.showOpenDialog(null);
	if (returnVal == JFileChooser.APPROVE_OPTION) {
		fileName = jfc.getSelectedFile().getAbsolutePath();
	}
	String s = "";
	try {
		FileReader fr = new FileReader(fileName);
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
		s+=(char)(c[i] - 1);
		}
	System.out.println(s);
	}
		
	
	
 	
}

