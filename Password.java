package project;
import java.awt.EventQueue;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.JRadioButton;

public class Password extends JFrame 
{

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField textField_1;

	
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					Password frame = new Password();
					frame.setVisible(true);
				} 
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	
	public Password()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700,600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel UserName = new JLabel("User Name:");
		UserName.setFont(new Font("", Font.BOLD, 13));
		UserName.setBounds(70, 139, 80, 14);
		contentPane.add(UserName);
		
		JLabel UserPassword = new JLabel("Password");
		UserPassword.setFont(new Font("", Font.BOLD, 13));
		UserPassword.setBounds(70, 199, 80, 14);
		contentPane.add(UserPassword);
		
		textField = new JTextField();
		textField.setBounds(70, 168, 147, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(128, 193, -25, 20);
		contentPane.add(passwordField);
		
		textField_1 = new JTextField();
		textField_1.setBackground(Color.WHITE);
		textField_1.setBounds(70, 215, 143, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label = new JLabel("");
		label.setBounds(104, 11, 46, 14);
		contentPane.add(label);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		panel.setBounds(0, 0, 682, 25);
		contentPane.add(panel);
		
		JLabel lblNsuClubingAdmin = new JLabel("Nsu Clubing Admin");
		lblNsuClubingAdmin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		panel.add(lblNsuClubingAdmin);
		
		JButton LogIn = new JButton("Log In");
		LogIn.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				
		
				
				
				
				try 
				{
				JLabel Username = null;
				JLabel Password=null;
				
				if(Username.getText().equals("admin")&& Password.getText().equals("12345"))
				{
					if(Username.getText().equals("admin")&& Password.getText().equals("12345"))
					{
						 JOptionPane.showMessageDialog(null, "Logging successfully");
				}
				}
				
					
				else
				 {
				 JOptionPane.showMessageDialog(null, "incorrect password");
					 }
					
				}
				catch(Exception e1) 
				{
				 JOptionPane.showMessageDialog(null, "correct password");
					 }
					
				
					
				
					
				
				
			}
		});
		LogIn.setBackground(Color.PINK);
		LogIn.setBounds(70, 246, 89, 23);
		contentPane.add(LogIn);
		
		JLabel NewLabel = new JLabel("");
		NewLabel.setBackground(UIManager.getColor("CheckBox.interiorBackground"));
		NewLabel.setIcon(new ImageIcon("C:\\Users\\USER\\Desktop\\logo\\Logo.png"));
		NewLabel.setBounds(429, 25, 253, 273);
		contentPane.add(NewLabel);
		
		JLabel NewLabel_1 = new JLabel("");
		NewLabel_1.setBackground(Color.YELLOW);
		NewLabel_1.setBounds(42, 99, 180, 212);
		contentPane.add(NewLabel_1);
		
		JLabel Option = new JLabel("Option:");
		Option.setFont(new Font("Tahoma", Font.BOLD, 13));
		Option.setBounds(522, 328, 55, 14);
		contentPane.add(Option);
		
		JRadioButton radioApc = new JRadioButton("APC");
		radioApc.setBounds(522, 393, 109, 23);
		contentPane.add(radioApc);
		
		JRadioButton radioIbc = new JRadioButton("IBC");
		radioIbc.setBounds(522, 421, 109, 23);
		contentPane.add(radioIbc);
		
		JRadioButton radioDebating = new JRadioButton("Debating");
		radioDebating.setBounds(522, 448, 109, 23);
		contentPane.add(radioDebating);
		
		JRadioButton radioSocialService = new JRadioButton("Social service");
		radioSocialService.setBounds(522, 476, 109, 23);
		contentPane.add(radioSocialService);
		JRadioButton radioYesClub = new JRadioButton("Nsu yes!");
		radioYesClub.setBounds(522, 504, 109, 23);
		contentPane.add(radioYesClub);
		
		JRadioButton radioNsuHr = new JRadioButton("Nsu HR");
		radioNsuHr.setBounds(522, 365, 109, 23);
		contentPane.add(radioNsuHr);
		
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(radioApc);
		bg.add(radioDebating);
		bg.add(radioSocialService);
		bg.add(radioIbc);
		bg.add(radioYesClub);
		bg.add(radioNsuHr);
		
		
		
		
		
	}
}
