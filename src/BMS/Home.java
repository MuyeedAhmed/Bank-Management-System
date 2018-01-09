package BMS;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Home implements ActionListener {
	private Account a = null;
	
	File file = new File("Information_Save.txt");
	
	JFrame window = new JFrame();
	JMenuBar jbar = new JMenuBar();
	JMenu fileMenu = new JMenu("File");
	JMenu about = new JMenu("About");
	JMenuItem exit = new JMenuItem("Exit");
	JMenuItem aboutFile = new JMenuItem("About The File");
	
	Font font = new Font("Papyrus", Font.BOLD, 15);
	
	
	JLabel pageImage = new JLabel();
	
	JLabel name = new JLabel("Name");
	JLabel aName;
	JLabel dob = new JLabel("Date Of Birth");
	JLabel aDob;
	JLabel accId = new JLabel("Account ID");
	JLabel aAccId;
	JButton check = new JButton("");
	JButton deposit = new JButton("");
	JButton withdraw = new JButton("");
	JButton report = new JButton("");
	JButton transfer = new JButton("");
	JButton logout = new JButton("");
	JButton remove = new JButton("");
	
	JLabel warningmsg = new JLabel();
	JLabel background = new JLabel();
	public Home(){
		
	}
	
	public Home(String name, String dob, String accId){
		aName = new JLabel(name);
		aDob = new JLabel(dob);
		aAccId = new JLabel(accId);
	}
	
	public void HomeFrame(){
		aName = new JLabel(a.getName());
		aDob = new JLabel(a.getDob());
		aAccId = new JLabel(a.getId());
		name.setForeground(Color.white);
		aName.setForeground(Color.white);
		dob.setForeground(Color.white);
		aDob.setForeground(Color.white);
		accId.setForeground(Color.white);
		aAccId.setForeground(Color.white);
		
		name.setFont(font);
		aName.setFont(font);
		dob.setFont(font);
		aDob.setFont(font);
		accId.setFont(font);
		aAccId.setFont(font);
		
		window.setJMenuBar(jbar);
		jbar.add(fileMenu);
		jbar.add(about);
		fileMenu.add(exit);
		about.add(aboutFile);
		window.setLayout(null);
		pageImage.setIcon(new ImageIcon("Images\\Pages\\Home.png"));
		pageImage.setBounds(450,100,300,70);
		warningmsg.setIcon(new ImageIcon("Images\\Background\\Warning.png"));
		warningmsg.setBounds(50, 475, 393, 50);
		ImageIcon back = new ImageIcon("Images\\Background\\Braavos Back.jpg");
		background.setIcon(back);
		background.setBounds(0, 0, 800, 600);
		name.setBounds(50, 300, 200, 20);
		aName.setBounds(250, 300, 200, 20);
		dob.setBounds(50, 350, 200, 20);
		aDob.setBounds(250, 350, 200, 20);
		accId.setBounds(50, 400, 200, 20);
		aAccId.setBounds(250, 400, 200, 20);
		
		window.add(name);
		window.add(aName);
		window.add(dob);
		window.add(aDob);
		window.add(accId);
		window.add(aAccId);
		RightPanel rp = new RightPanel();
		rp.setBounds(450, 260, 350,210 );
		window.add(rp);
		window.add(pageImage);
		window.add(warningmsg);
		window.add(background);
		check.addActionListener(this);
		report.addActionListener(this);
		deposit.addActionListener(this);
		withdraw.addActionListener(this);
		transfer.addActionListener(this);
		logout.addActionListener(this);
		remove.addActionListener(this);
		exit.addActionListener(this);
		aboutFile.addActionListener(this);
		window.setSize(800,600);
		window.setLocation(250,100);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		window.setResizable(false);
	}
	
	class RightPanel extends JPanel {
		public RightPanel(){
			GridLayout gl = new GridLayout(7,1,0,0);
			setLayout(gl);
			check.setIcon(new ImageIcon("Images\\Buttons\\Home\\Check.jpg"));
			deposit.setIcon(new ImageIcon("Images\\Buttons\\Home\\Deposit.jpg"));
			withdraw.setIcon(new ImageIcon("Images\\Buttons\\Home\\Withdraw.jpg"));
			transfer.setIcon(new ImageIcon("Images\\Buttons\\Home\\Transfer.jpg"));
			report.setIcon(new ImageIcon("Images\\Buttons\\Home\\View Report.jpg"));
			logout.setIcon(new ImageIcon("Images\\Buttons\\Home\\Logout.jpg"));
			remove.setIcon(new ImageIcon("Images\\Buttons\\Home\\Remove.jpg"));
			add(check);
			add(deposit);
			add(withdraw);
			add(transfer);
			add(report);
			add(logout);
			add(remove);
		}
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == check){
			JOptionPane.showMessageDialog(null, "Current Balance " + a.getAmount(), "Amount Available", JOptionPane.PLAIN_MESSAGE);
		}
		if(e.getSource() == deposit){
			String sd = JOptionPane.showInputDialog("Enter The Amount Of Money You Want To Deposit");
			try{
				double d = Double.parseDouble(sd);
				if(d>=0){
					a.deposit(d);
					JOptionPane.showMessageDialog(null, "Current Balance " + a.getAmount(), "Amount Available", JOptionPane.PLAIN_MESSAGE);
				}
				else
					JOptionPane.showMessageDialog(null, "Invalid Amount", "ERROR", JOptionPane.ERROR_MESSAGE);
			}catch(Exception ex){
				JOptionPane.showMessageDialog(null, "ERROR","", JOptionPane.ERROR_MESSAGE);
			}
			
		}
		if(e.getSource() == withdraw){
			String sw = JOptionPane.showInputDialog("Enter The Amount Of Money You Want To Withdraw");
			try{
				double w = Double.parseDouble(sw);
				if(w>=0){
					boolean b = a.withdraw(w);
					if(b == false)
						JOptionPane.showMessageDialog(null, "You Dont Have That Much Amount", "ERROR", JOptionPane.ERROR_MESSAGE);
					else
						JOptionPane.showMessageDialog(null, "Current Balance " + a.getAmount(), "Amount Available", JOptionPane.PLAIN_MESSAGE);
				}
				else
					JOptionPane.showMessageDialog(null, "Invalid Amount", "ERROR", JOptionPane.ERROR_MESSAGE);
				
			}catch(Exception ex){
				JOptionPane.showMessageDialog(null, "ERROR","", JOptionPane.ERROR_MESSAGE);
			}
		}
		if(e.getSource() == report){
			Report r = new Report();
			r.ReportFrame(a);
		}
		if(e.getSource() == transfer){
			TransferAmount ta = new TransferAmount();
			ta.transferFrame();
			
		}
		if(e.getSource() == logout){
			if(a.getAccountType().equals("savings")){
				SavingsAccount sa = new SavingsAccount(a);
				sa.amountChange();
			}
			update(a);
			Welcome w = new Welcome();
			w.login();
			window.dispose();
		}
		if(e.getSource() == remove){
			remove(a);
			Welcome w = new Welcome();
			w.login();
			window.dispose();
		}
		if(e.getSource() == exit){
			System.exit(0);
		}
		if(e.getSource() == aboutFile){
			About a = new About();
			a.AboutFrame();
		}
	}
	
	public boolean search(String accountId, String password) {	
		FileInputStream fis = null;
		ObjectInputStream in = null;
		ArrayList<Account> accounts = new ArrayList<Account>();
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
			if(accountId.equals(a.getId()) && password.equals(a.getPassword())){
				this.a = a;
				HomeFrame();
				return true;
			}
		}
		return false;
	}
	
	public void write(ArrayList<Account>accounts){
		
		try{	
			FileOutputStream fout = new FileOutputStream(file);
			ObjectOutputStream out = new ObjectOutputStream(fout);
			ArrayList<Account> addAccounts = new ArrayList<Account>();
			addAccounts.addAll(accounts);
			for(Account a : addAccounts){
				out.writeObject(a);
			}
			out.close();
			fout.close();
		} catch(Exception e){e.printStackTrace();}
	}
	
	public void update(Account acc){
		FileInputStream fis = null;
		ObjectInputStream in = null;
		ArrayList<Account> accounts = new ArrayList<Account>();
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
		for(int i = 0; i < accounts.size(); i++){
			if(acc.getId().equals(accounts.get(i).getId())){
				accounts.set(i, acc);
				write(accounts);
			}
		}
	}
	
	public void remove(Account acc){	
		FileInputStream fis = null;
		ObjectInputStream in = null;
		ArrayList<Account> accounts = new ArrayList<Account>();
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
		for(int i = 0; i < accounts.size(); i++){
			if(acc.getId().equals(accounts.get(i).getId())){
				accounts.remove(accounts.get(i));
				write(accounts);
			}
		}
	}
	
	
	
	class TransferAmount extends JFrame implements ActionListener {
		
		Account destinationAccount = null;
		
		JLabel pageImageT = new JLabel();
		
		JLabel destination = new JLabel("Destination Account");
		JLabel amount = new JLabel("Amount");
		JTextField destination_txt = new JTextField();
		JTextField amount_txt = new JTextField();
		
		JButton transfer = new JButton("");
		
		JButton home = new JButton("");
		
		JLabel background = new JLabel();
		
		public void transferFrame(){
			setLayout(null);
			ImageIcon back = new ImageIcon("Images\\Background\\Braavos Back.jpg");
			background.setIcon(back);
			background.setBounds(0, 0, 800, 600);
			pageImageT.setIcon(new ImageIcon("Images\\Pages\\Transfer.png"));
			pageImageT.setBounds(50,200,300,130);
			destination.setForeground(Color.white);
			amount.setForeground(Color.white);
			destination.setFont(font);
			amount.setFont(font);
			destination.setBounds(375, 250, 200, 25);
			destination_txt.setBounds(625, 250, 150, 25);
			amount.setBounds(375, 300, 200, 25);
			amount_txt.setBounds(625, 300, 150, 25);
			
			transfer.setIcon(new ImageIcon("Images\\Buttons\\Transfer Amount\\Transfer.jpg"));
			home.setIcon(new ImageIcon("Images\\Buttons\\Transfer Amount\\Home.jpg"));
			transfer.setBounds(625, 350, 150, 30);
			home.setBounds(625, 400, 150, 30);
			
			add(destination);
			add(destination_txt);
			add(amount);
			add(amount_txt);
			add(transfer);
			add(home); 
			add(pageImageT);
			add(background);
			transfer.addActionListener(this);
			home.addActionListener(this);
		
			setSize(800,600);
			setLocation(250,100);
			setVisible(true);
			setResizable(false);
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == transfer){
				String destinationId = destination_txt.getText();
				
				boolean b = search(destinationId);
				if(b == true && destination_txt.getText() != null && amount_txt.getText() != null){
					try{
						double amount = Double.parseDouble(amount_txt.getText());
						if(amount>=0){
							boolean bo = a.withdraw(amount);
							if(bo == true){
								destinationAccount.deposit(amount);
								update(destinationAccount);
								dispose();
							}
							else
								JOptionPane.showMessageDialog(null, "You Dont Have That Much Amount", "ERROR", JOptionPane.ERROR_MESSAGE);
						}
						else
							JOptionPane.showMessageDialog(null, "Invalid Amount", "ERROR", JOptionPane.ERROR_MESSAGE);
					}catch(Exception ex){
						JOptionPane.showMessageDialog(null, "ERROR", "", JOptionPane.ERROR_MESSAGE);
					}
				}
				else
					JOptionPane.showMessageDialog(null, "Destination Account Not Found", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			
			if(e.getSource() == home){
				dispose();
			}
		}
		
		public boolean search(String destinationId) {
	
			File file = new File("Information_Save.txt");
			FileInputStream fis = null;
			ObjectInputStream in = null;
			ArrayList<Account> accounts = new ArrayList<Account>();
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
				if(destinationId.equals(a.getId())){
					this.destinationAccount= a;
					return true;
				}
			}
			return false;
		}
		
		public void update(Account acc){
			FileInputStream fis = null;
			ObjectInputStream in = null;
			ArrayList<Account> accounts = new ArrayList<Account>();
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
			for(int i = 0; i < accounts.size(); i++){
				if(acc.getId().equals(accounts.get(i).getId())){
					accounts.set(i, acc);
				}
			}
			try{	
				FileOutputStream fout = new FileOutputStream(file);
				ObjectOutputStream out = new ObjectOutputStream(fout);
				ArrayList<Account> addAccounts = new ArrayList<Account>();
				addAccounts.addAll(accounts);
				for(Account a : addAccounts){
					out.writeObject(a);
				}
				out.close();
				fout.close();
			} catch(Exception e){e.printStackTrace();}
		}
	}
}
