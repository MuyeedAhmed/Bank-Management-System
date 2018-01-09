package BMS;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Report implements ActionListener {
	JFrame window = new JFrame();
	JMenuBar jbar = new JMenuBar();
	JMenu file = new JMenu("File");
	JMenu about = new JMenu("About");
	JMenuItem close = new JMenuItem("Close Window");
	JMenuItem aboutFile = new JMenuItem("About The File");
	
	Font font = new Font("Papyrus", Font.BOLD, 15);
	JLabel nameL = new JLabel("Name");
	JLabel dobL = new JLabel("Date Of Birth");
	JLabel accIdL = new JLabel("Account ID");
	JLabel typeL= new JLabel("Account Type");
	JLabel amountL = new JLabel("Amount Available");
	JLabel timeCreatedL = new JLabel("Account Created");
	JLabel name;
	JLabel dob;
	JLabel accId;
	JLabel type;
	JLabel amount;
	JLabel timeCreated;
	
	JLabel pageImage = new JLabel();
	JLabel background = new JLabel();
	public void ReportFrame(Account a){
		name = new JLabel(a.getName());
		dob = new JLabel(a.getDob());
		accId = new JLabel(a.getId());
		String cAmount = "" + a.getAmount();
		amount = new JLabel(cAmount);
		type = new JLabel(a.getAccountType());
		java.util.Date date = new java.util.Date(a.getTimeCreated());
		String time = date.getDate() + " / " + (date.getMonth() + 1) + " / " + (date.getYear()+1900);
		timeCreated = new JLabel(time);
		
		pageImage.setIcon(new ImageIcon("Images\\Pages\\Report.png"));		
		background.setIcon(new ImageIcon("Images\\Background\\Braavos Back.jpg"));
		
		window.setJMenuBar(jbar);
		jbar.add(file);
		jbar.add(about);
		file.add(close);
		about.add(aboutFile);
		nameL.setForeground(Color.white);
		name.setForeground(Color.white);
		dobL.setForeground(Color.white);
		dob.setForeground(Color.white);
		accIdL.setForeground(Color.white);
		accId.setForeground(Color.white);
		typeL.setForeground(Color.white);
		type.setForeground(Color.white);
		amountL.setForeground(Color.white);
		amount.setForeground(Color.white);
		timeCreatedL.setForeground(Color.white);
		timeCreated.setForeground(Color.white);
		
		nameL.setFont(font);
		name.setFont(font);
		dobL.setFont(font);
		dob.setFont(font);
		accIdL.setFont(font);
		accId.setFont(font);
		typeL.setFont(font);
		type.setFont(font);
		amountL.setFont(font);
		amount.setFont(font);
		timeCreatedL.setFont(font);
		timeCreated.setFont(font);
		nameL.setBounds			(400, 150, 150, 30);
		name.setBounds			(550, 150, 150, 30);
		dobL.setBounds			(400, 200, 150, 30);
		dob.setBounds			(550, 200, 150, 30);
		accIdL.setBounds		(400, 250, 150, 30);
		accId.setBounds			(550, 250, 150, 30);
		typeL.setBounds			(400, 300, 150, 30);
		type.setBounds			(550, 300, 150, 30);
		amountL.setBounds		(400, 350, 150, 30);
		amount.setBounds		(550, 350, 450, 30);
		timeCreatedL.setBounds	(400, 400, 150, 30);
		timeCreated.setBounds	(550, 400, 250, 30);
		pageImage.setBounds		(50,200,300,85);
		background.setBounds	(0, 0, 800, 600);
		window.add(nameL);
		window.add(name);
		window.add(dobL);
		window.add(dob);
		window.add(accIdL);
		window.add(accId);
		window.add(typeL);
		window.add(type);
		window.add(amountL);
		window.add(amount);
		window.add(timeCreatedL);
		window.add(timeCreated);
		window.add(pageImage);
		window.add(background);
		close.addActionListener(this);
		aboutFile.addActionListener(this);
		window.setSize(800,600);
		window.setLocation(250,100);
		window.setVisible(true);
		window.setResizable(false);	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == aboutFile){
			About a = new About();
			a.AboutFrame();
		}
		if(e.getSource() == close){
			window.dispose();
		}
		
	}
}
