package Programs;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

public class Todo implements ActionListener{
	ArrayList<String> list = new ArrayList<String>();
	
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton add = new JButton();
	JButton remove = new JButton();
	JButton save = new JButton();
	JButton load = new JButton();
	public Todo(){
		
		frame.add(panel);
		frame.setVisible(true);
		frame.setSize(100,100);
		panel.add(add);
		panel.add(remove);
		panel.add(save);
		panel.add(load);
		add.setText("Add");
		add.addActionListener(this);
		remove.setText("Remove");
		remove.addActionListener(this);
		save.setText("Save");
		save.addActionListener(this);
		load.setText("Load");
		load.addActionListener(this);
		frame.pack();	
	}
	
	public static void main(String[] args) {
		Todo t = new Todo();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == add) {
			String resp = JOptionPane.showInputDialog("Add a task");
			list.add(resp);
		}
		if(e.getSource() == remove) {
			String s = new String();
			for (int i = 0; i < list.size(); i++) {
				s+=list.get(i) + "\n";  
			}
			if(s.length() > 0) {
			JOptionPane.showMessageDialog(null, s);
			String resp = JOptionPane.showInputDialog("Which response would you like to remove?");
			int i = Integer.parseInt(resp);
			list.remove(i - 1);
			}
		}
		if(e.getSource() == save) {
			String s = new String();
			for (int i = 0; i < list.size(); i++) {
				s+= list.get(i) + "\n";  
			}
			try {
			FileWriter fw = new FileWriter("src/intro_to_file_io/test2.txt");
			fw.write(s);
			fw.close();
			}catch (IOException e1) {
				e1.printStackTrace();
			}
			
		}
		if(e.getSource() == load) {
			JFileChooser jfc = new JFileChooser();
			int returnVal = jfc.showOpenDialog(null);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				String fileName = jfc.getSelectedFile().getAbsolutePath();
				try {
					BufferedReader br = new BufferedReader(new FileReader(fileName));
					String s = new String();
					String line = br.readLine();
					while(line != null){
						System.out.println(line);
						list.add(line);
						JOptionPane.showMessageDialog(null, line);
						line = br.readLine();
						
					}
					
					br.close();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		
	}
}
