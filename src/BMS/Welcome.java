package BMS;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;


public class Welcome implements ActionListener {
	JFrame window = new JFrame();
	JMenuBar jbar = new JMenuBar();
	JMenu file = new JMenu("File");
	JMenu about = new JMenu("About");
	JMenuItem exit = new JMenuItem("Exit");
	JMenuItem aboutFile = new JMenuItem("About The File");
	
	Font font = new Font("Papyrus", Font.BOLD, 15);
	
	JLabel pageImage = new JLabel();
	JLabel accImage = new JLabel();
	JLabel accId = new JLabel("Account ID");
	JTextField accId_txt = new JTextField();
	JLabel passImage = new JLabel();
	JLabel password = new JLabel("Password");
	JPasswordField pass_txt = new JPasswordField();
	JButton login = new JButton("");
	JLabel samMsg1 = new JLabel("If You Dont Have An Account");
	JLabel samMsg2 = new JLabel("Create An Account");
	JButton create = new JButton("");
	
	JLabel background = new JLabel();
	public Welcome(){}
	public void login(){
		window.setJMenuBar(jbar);
		jbar.add(file);
		jbar.add(about);
		file.add(exit);
		about.add(aboutFile);
		//Icons
		accImage.setIcon(new ImageIcon("Images\\Icons\\account.png"));
		passImage.setIcon(new ImageIcon("Images\\Icons\\password.png"));
		//BackGround
		background.setIcon(new ImageIcon("Images\\Background\\Braavos Back.jpg"));
		pageImage.setIcon(new ImageIcon("Images\\Pages\\Welcome.png"));
		//Buttons
		login.setIcon(new ImageIcon("Images\\Buttons\\Welcome\\Login.jpg"));
		create.setIcon(new ImageIcon("Images\\Buttons\\Welcome\\Create.jpg"));
		window.setLayout(null);
		accId.setForeground(Color.white);
		password.setForeground(Color.white);
		samMsg1.setForeground(Color.white);
		samMsg2.setForeground(Color.white);
		accId.setFont(font);
		password.setFont(font);
		samMsg1.setFont(font);
		samMsg2.setFont(font);
		accImage.setBounds(425, 180, 25, 25);
		accId.setBounds(475, 180, 100, 25);
		accId_txt.setBounds(600, 180, 150, 25);
		passImage.setBounds(425, 230, 25, 25);
		password.setBounds(475, 230, 100, 25);
		pass_txt.setBounds(600, 230, 150, 25);
		login.setBounds(600, 280, 150, 30);
		samMsg1.setBounds(475, 330, 300, 20);
		samMsg2.setBounds(475, 380, 300, 20);
		create.setBounds(600, 420, 150, 30);
		pageImage.setBounds(450,100,300,70);
		background.setBounds(0, 0, 800, 600);
		window.add(accImage);
		window.add(accId);
		window.add(accId_txt);
		window.add(passImage);
		window.add(password);
		window.add(pass_txt);
		window.add(login);
		window.add(samMsg1);
		window.add(samMsg2);
		window.add(create);
		window.add(pageImage);
		window.add(background);
		
		create.addActionListener(this);
		login.addActionListener(this);
		exit.addActionListener(this);
		aboutFile.addActionListener(this);
		window.setSize(800,600);
		window.setLocation(250,100);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		window.setResizable(false);	
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == create){
			CreateAccount ca = new CreateAccount();
			ca.CAFrame();
			window.dispose();
		}
		if(e.getSource() == login){
			String acc = accId_txt.getText();
			String pass = pass_txt.getText();
			Home h = new Home();
			boolean b = h.search(acc,pass);
			
			if(b == true)
				window.dispose();
			else
				JOptionPane.showMessageDialog(null, "No match found", "Error", JOptionPane.PLAIN_MESSAGE);
		}
		if(e.getSource() == aboutFile){
			About a = new About();
			a.AboutFrame();
		}
		if(e.getSource() == exit){
			System.exit(0);
		}
	}
}
