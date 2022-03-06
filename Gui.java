package project;


import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.List;
import java.io.*;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Gui extends JFrame
{
	JTextArea studentTextArea = new JTextArea();
	
	JLabel idLabel = new JLabel("ID ");
	JTextField idTextField = new JTextField(8);
	JLabel nameLabel = new JLabel("NAME ");
	JTextField nameTextField = new JTextField(8);
	JLabel deptLabel = new JLabel("DEPARTMENT ");
	JTextField deptTextField = new JTextField(8);

	JButton addb = new JButton("ADD");
	JButton updateb = new JButton("UPDATE");
	JButton saveb = new JButton("SAVE");
	JButton deleteb = new JButton("DELETE");
//	JButton displayAllb = new JButton("displayall");
	JButton findb = new JButton("FIND");
   JButton exitb = new JButton("EXIT");
   
	private LinkedList<Student> studentList = new LinkedList<Student>();

	public Gui() {
		JPanel flow1Panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel flow2Panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel gridPanel = new JPanel(new GridLayout(2, 1));

		flow1Panel.add(idLabel);
		flow1Panel.add(idTextField);
		flow1Panel.add(nameLabel);
		flow1Panel.add(nameTextField);
		flow1Panel.add(deptLabel);
		flow1Panel.add(deptTextField);
		flow2Panel.add(addb);
		flow2Panel.add(findb);
       flow2Panel.add(updateb);
		flow2Panel.add(saveb);
		flow2Panel.add(deleteb);
		//flow2Panel.add(displayAllb);
		flow2Panel.add(exitb);

		gridPanel.add(flow1Panel);
		gridPanel.add(flow2Panel);

		loaddb();

		add(studentTextArea, BorderLayout.CENTER);
		studentTextArea.setEditable(false);
		add(gridPanel, BorderLayout.NORTH);
		  
		addb.addActionListener(event -> addstudent());
		findb.addActionListener(event -> findstd());
       updateb.addActionListener(event -> updatestd());
		saveb.addActionListener(event -> savedb());
		//displayAllb.addActionListener(event -> displayAll());
		exitb.addActionListener(event -> exitApplication());
		deleteb.addActionListener(event -> deleteStudent());
	}

	private boolean isStudentIDLinkedList(String idstr) 
	{
		boolean inList = false;
		for (Student stud : studentList) {
			if (stud.getid().compareTo(idstr) == 0)
			{
				inList = true;
			}
		}
		return inList;
	}

	private Student findStudentID(String idstr) 
	{
		Student inList = null;
		for (Student stud : studentList) {
			if (stud.getid().compareTo(idstr) == 0)
			{
				inList = stud;
			}
		}
		return inList;
	}

	public void findstd()
	{
		if (isStudentIDLinkedList(idTextField.getText()) == false)
		{
			JOptionPane.showMessageDialog(null, "Error :student is not in the database.");
		} else {
			Student show = findStudentID(idTextField.getText());
			JOptionPane.showMessageDialog(null, "ID: " + show.getid() + "\n" + "Name: " + show.getName() + "\n"
					+ "Department: " + show.getDept() + "\n" + "Time of registration: " + show.getDate() + "\n");
		}
	}

	public void loaddb() 
	{
		try {
			BufferedReader in = new BufferedReader(new FileReader("saved.txt"));
			int size = Integer.parseInt(in.readLine());
			String line;
			String[] splt;
			for (int j = 0; j < size; j++) {
				line = in.readLine();
				splt = line.split(" ");
				studentList.add(new Student(splt[1], splt[0], splt[2],   splt[3] + "      " + splt[4]));
			}
		} catch (Exception e) {  
			e.printStackTrace();
		}
		displayAll();
	}

	private void addstudent() {
		if (isStudentIDLinkedList(idTextField.getText()) == true) {
			JOptionPane.showMessageDialog(null, "Error :student is already in the database.");
		} else {
			studentList.add(new Student(nameTextField.getText(), idTextField.getText(), deptTextField.getText()));
			displayAll();

		}
	}

	private void updatestd() 
	{
		if (isStudentIDLinkedList(idTextField.getText()) == false)
		{
			JOptionPane.showMessageDialog(null, "Error :student is not in the database.");
		}
		else 
		{
			for (int s = 0; s < studentList.size(); s++)
			{
				String currId = studentList.get(s).getid();
				if (currId.compareTo(idTextField.getText()) == 0) 
				{
					studentList.set(s,
							new Student(nameTextField.getText(), idTextField.getText(), deptTextField.getText()));
				}
			}
			displayAll();
		}
	}

	private void savedb() 
	{
		BufferedWriter out = null;
		try 
		{
			out = new BufferedWriter(new FileWriter("saved.txt"));
			out.write(String.valueOf(studentList.size()));
			for (int s = 0; s < studentList.size(); s++) {
				out.newLine();
				out.write(studentList.get(s).getid() + " " + studentList.get(s).getName() + " "
						+ studentList.get(s).getDept() + " " + studentList.get(s).getDateobj());
			}
			out.close();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}

	}

	private void deleteStudent() 
	{

		if (isStudentIDLinkedList(idTextField.getText()) == false) 
		{
			JOptionPane.showMessageDialog(null, "Error :student is not in the database.");
		}
		else 
		{
			for (int s = 0; s < studentList.size(); s++)
			{
				String currId = studentList.get(s).getid();
				if (currId.compareTo(idTextField.getText()) == 0)
				{
					studentList.remove(s);
				}
			}

			displayAll();
		}
	}

	private void displayAll() 
	{
		studentTextArea.setText(" ");
		studentTextArea.append("ID" + "\t" + "Name" + "\t" + "Dept" + "\t" + " Date             Time" + "\n");
		studentTextArea.append(
				"--------------------------------------------------------------------------------------------------------------------\n");
		for (Student stud : studentList) 
		{
			studentTextArea.append(stud + "\n");
		}
	}

	private void exitApplication() 
	{
		System.exit(0);
	}

}
