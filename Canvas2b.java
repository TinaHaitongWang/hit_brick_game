/*Name: Haitong Wang     
NetID: 28246763
Assignment No.: Project 3
Lab section: MW 2:00pm
"I did not collaborate with anyone on this
assignment."*/
// This is left canvas class will extend JComponent class. 
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Canvas2b extends JComponent implements ActionListener{
	JButton button2;
	JTextField inputText3; 
	JTextField inputText4;
	JLabel label4;
	JLabel label5;
	JLabel label6;
	JLabel label7;
	JLabel label8;
	JPanel leftspeedpanel; 
	JPanel leftanglepanel; 
	
	public Canvas2b(Player p2){
		setOpaque(false);
		setVisible(true);
		leftspeedpanel = new JPanel();
		leftanglepanel = new JPanel();
		label4 = new JLabel("Player "+p2.getName());
		label5 = new JLabel("Speed");
		inputText3 = new JTextField(" ",5);
		label6= new JLabel("Angle");
		inputText4 = new JTextField(" ",5);
		button2 = new JButton("Fire");
		//button2.addActionListener(this);
		label7 = new JLabel("Total Score: "+p2.getScore());
		label8 = new JLabel("Current Round Score: "+p2.getAward());
		leftspeedpanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		leftspeedpanel.add(label5); 
		leftspeedpanel.add(inputText3); 
		leftanglepanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		leftanglepanel.add(label6);
		leftanglepanel.add(inputText4);
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		add(label4);
		add(leftspeedpanel);
		add(leftanglepanel);
		add(label7);
		add(label8);
		//add(button2);
		add(Box.createRigidArea(new Dimension(0,200)));
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	

}
