package BMS;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class About extends JFrame{
	 public void AboutFrame(){
		setLayout(null);
      	JLabel image = new JLabel();
      	image.setIcon(new ImageIcon("Images\\Background\\About.jpg"));
      	image.setBounds(0, 0, 700, 400);
      	add(image);
      	setSize(700,400);
		setLocation(250,100);
		setVisible(true);
		setResizable(false);	
    }
}
