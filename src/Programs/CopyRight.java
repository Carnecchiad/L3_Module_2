package Programs;

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;

public class CopyRight {
public static void main(String[] args) {
	String fileName = "";
	JFileChooser jfc = new JFileChooser();
	int returnVal = jfc.showOpenDialog(null);
	if (returnVal == JFileChooser.APPROVE_OPTION) {
		fileName = jfc.getSelectedFile().getAbsolutePath();
		System.out.println(fileName);
	}
	
	try {
		FileWriter fw = new FileWriter(fileName,true);
		
		/*
		NOTE: To append to a file that already exists, add true as a second parameter when calling the
		      FileWriter constructor.
		      (e.g. FileWriter fw = new FileWriter("src/intro_to_file_io/test2.txt", true);)
		*/
		
		fw.write("\n //COPYRIGHT DANTE");
		fw.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
}
}
 
 //COPYRIGHT DANTE