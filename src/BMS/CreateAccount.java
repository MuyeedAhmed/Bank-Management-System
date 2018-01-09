package BMS;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class CreateAccount implements ActionListener,ItemListener {
	JFrame window = new JFrame();
	JMenuBar jbar = new JMenuBar();
	JMenu file = new JMenu("File");
	JMenu about = new JMenu("About");
	JMenuItem exit = new JMenuItem("Exit");
	JMenuItem aboutFile = new JMenuItem("About The File");
	
	Font font = new Font("Papyrus", Font.BOLD, 15);
	String accountType = null;
	JLabel pageImage = new JLabel();
	JLabel name = new JLabel("Name");
	JTextField name_txt = new JTextField();
	JLabel dob = new JLabel("Date Of Birth");
	JTextField dob_txt = new JTextField();
	JLabel type = new JLabel("Account Type");
	JLabel savings = new JLabel("Savings Account");
	JLabel checking = new JLabel("Checking Account");
	JCheckBox savingsbtn = new JCheckBox();
	JCheckBox checkingbtn = new JCheckBox();
	ButtonGroup group = new ButtonGroup();
	JLabel password = new JLabel("Choose A Password");
	JPasswordField pass_txt = new JPasswordField();
	JLabel rePass = new JLabel("Retype Your Password");
	JPasswordField rePass_txt = new JPasswordField();
	JLabel accId = new JLabel("Choose An Account ID");
	JTextField accId_txt = new JTextField();
	JButton create = new JButton("");
	JButton clear = new JButton("");
	JButton backHome = new JButton("");
	
	JLabel background = new JLabel();
	public CreateAccount(){}
	
	public void CAFrame(){
		window.setJMenuBar(jbar);
		jbar.add(file);
		jbar.add(about);
		file.add(exit);
		about.add(aboutFile);
		window.setLayout(null);
		
		name.setForeground(Color.white);
		dob.setForeground(Color.white);
		password.setForeground(Color.white);
		rePass.setForeground(Color.white);
		accId.setForeground(Color.white);
		type.setForeground(Color.white);
		savings.setForeground(Color.white);
		checking.setForeground(Color.white);
		
		name.setFont(font);
		dob.setFont(font);
		password.setFont(font);
		rePass.setFont(font);
		accId.setFont(font);
		type.setFont(font);
		savings.setFont(font);
		checking.setFont(font);
		
		savings.setBackground(null);
		name.setBounds			(400, 150, 200, 25);
		name_txt.setBounds		(600, 150, 150, 25);
		dob.setBounds			(400, 190, 200, 25);
		dob_txt.setBounds		(600, 190, 150, 25);
		type.setBounds			(400, 230, 200, 25);
		savings.setBounds		(625, 230, 150, 25);
		checking.setBounds		(625, 270, 150, 25);
		savingsbtn.setBounds	(600, 235, 15, 15);
		checkingbtn.setBounds	(600, 275, 15, 15);
		password.setBounds		(400, 310, 200, 25);
		pass_txt.setBounds		(600, 310, 150, 25);
		rePass.setBounds		(400, 350, 200, 25);
		rePass_txt.setBounds	(600, 350, 150, 25);
		accId.setBounds			(400, 390, 200, 25);
		accId_txt.setBounds		(600, 390, 150, 25);
		
		create.setIcon(new ImageIcon("Images\\Buttons\\Create Account\\Create.jpg"));
		clear.setIcon(new ImageIcon("Images\\Buttons\\Create Account\\Clear.jpg"));
		backHome.setIcon(new ImageIcon("Images\\Buttons\\Create Account\\Home.jpg"));
		create.setBounds(400, 450, 150, 30);
		clear.setBounds(600, 450, 150, 30);
		backHome.setBounds(400, 500, 350, 30);
		group.add(checkingbtn);
		group.add(savingsbtn);
		window.add(name);
		window.add(name_txt);
		window.add(dob);
		window.add(dob_txt);
		window.add(type);
		window.add(savings);
		window.add(checking);
		window.add(savingsbtn);
		window.add(checkingbtn);
		window.add(password);
		window.add(pass_txt);
		window.add(rePass);
		window.add(rePass_txt);
		window.add(accId);
		window.add(accId_txt);
		window.add(create);
		window.add(clear);
		window.add(backHome);
		pageImage.setIcon(new ImageIcon("Images\\Pages\\Create.png"));
		pageImage.setBounds(50,200,300,120);
		background.setIcon(new ImageIcon("Images\\Background\\Braavos Back.jpg"));
		background.setBounds(0, 0, 800, 600);
		window.add(pageImage);
		window.add(background);
		savingsbtn.addItemListener(this);
		checkingbtn.addItemListener(this);
		create.addActionListener(this);
		clear.addActionListener(this);
		backHome.addActionListener(this);
		exit.addActionListener(this);
		aboutFile.addActionListener(this);
		window.setSize(800,600);
		window.setLocation(250,100);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		window.setResizable(false);
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getSource() == savingsbtn && savingsbtn.isSelected() == true)
			accountType = "Savings";
		else if(e.getSource() == checkingbtn && checkingbtn.isSelected() == true)
			accountType = "Checking";
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == create){
			String name = name_txt.getText();
			String dob = dob_txt.getText();
			String password = pass_txt.getText();
			String rePass = rePass_txt.getText();
			String accId = accId_txt.getText();
			if(password.equals(rePass)){
				if(name.equals("") || dob.equals("") || password.equals("") || rePass.equals("") || accId.equals("")){
					JOptionPane.showMessageDialog(null, "Some Information Is Missing", "", JOptionPane.PLAIN_MESSAGE);
				}
				else{
					if(bookId(accId) == true){
						write(name, dob, password, accId,accountType);
						JOptionPane.showMessageDialog(null, "Your Account Has Been Created", "", JOptionPane.PLAIN_MESSAGE);
					
						Home l = new Home();
						l.search(accId, password);
						window.dispose();
					}
					else{
						JOptionPane.showMessageDialog(null, "This ID Is Already Taken", "Error", JOptionPane.PLAIN_MESSAGE);
					}
				}
			}
			else{
				JOptionPane.showMessageDialog(null, "Retype Your Password", "ERROR", JOptionPane.PLAIN_MESSAGE);
			}
		}
		if(e.getSource() == clear){
			name_txt.setText(null);
			dob_txt.setText(null);
			pass_txt.setText(null);
			rePass_txt.setText(null);
			accId_txt.setText(null);
		}
		if(e.getSource() == backHome){
			Welcome w = new Welcome();
			w.login();
			window.dispose();
		}
		if(e.getSource() == aboutFile){
			About a = new About();
			a.AboutFrame();
		}
		if(e.getSource() == exit){
			System.exit(0);
		}
	}
	
	public boolean bookId(String accountId){
		File file = new File("Information_Save.txt");
		ArrayList<Account> accounts = new ArrayList<Account>();
		if(file.exists() == true){
			FileInputStream fis = null;
			ObjectInputStream in = null;
			
			try{
				fis = new FileInputStream(file);
				in = new ObjectInputStream(fis);
				Account a = null;
		
					while(true){
						a = (Account)in.readObject();
						accounts.add(a);
					}
			} catch(Exception i){
				try{
					in.close();
					fis.close();
				} catch(IOException e){System.out.println("Error at close");}
			}
			for(Account a : accounts){
				if(accountId.equals(a.getId())){
					if(a.isFilled() == true)
						return false;
					else{
						a.setFilled(true);
						return true;
					}
				}
			}
		}
		return true;
	}
	
	public void write(String name, String dob, String password,String accId, String type){
		File file = new File("Information_Save.txt");
		ArrayList<Account> accounts = new ArrayList<Account>();
		if(file.exists() == true){
			FileInputStream fis = null;
			ObjectInputStream in = null;
			
			try{
				fis = new FileInputStream(file);
				in = new ObjectInputStream(fis);
				Account a = null;
		
					while(true){
						a = (Account)in.readObject();
						accounts.add(a);
					}
			} catch(Exception i){
				try{
					in.close();
					fis.close();
				} catch(IOException e){System.out.println("Error at close");}
			}
		}
		try{
			
			FileOutputStream fout = new FileOutputStream(file);
			ObjectOutputStream out = new ObjectOutputStream(fout);
			ArrayList<Account> addAccounts = new ArrayList<Account>();
			accounts.add(new Account(name, dob, password, accId, type));
			addAccounts.addAll(accounts);
			for(Account a : addAccounts){
				out.writeObject(a);
			}
			out.close();
			fout.close();
		} catch(Exception e){e.printStackTrace();}
	}
}
