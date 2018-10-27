/*Name: Haitong Wang     
NetID: 28246763
Assignment No.: Project 3
Lab section: MW 2:00pm
"I did not collaborate with anyone on this
assignment."*/
// This is right canvas class will extend JComponent class. 
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class Canvas2a extends JComponent implements ActionListener{
	JButton button1;
	JTextField inputText1; 
	JTextField inputText2;
	JLabel label1;
	JLabel label2;
	JLabel label3;
	JLabel label4;
	JLabel label5;
	JLabel label6;
	JPanel rightspeedpanel; 
	JPanel rightanglepanel;  
	
	public Canvas2a(Player p1){
		this.setOpaque(false);
		setVisible(true);
		label1 = new JLabel("Player "+p1.getName());
		label2 = new JLabel("Speed");
		inputText1 = new JTextField(" ",5);
		label3= new JLabel("Angle");
		inputText2 = new JTextField(" ",5);
		button1 = new JButton("Fire");
		button1.addActionListener(this);
		label4 = new JLabel("Total Score: "+p1.getScore());
		label5 = new JLabel("Current Round Score: "+p1.getAward());
		//label6 = new JLabel("Round"+p1.getScore());
		rightspeedpanel = new JPanel();
		rightanglepanel = new JPanel();
		rightspeedpanel.add(label2); 
		rightspeedpanel.add(inputText1);
		rightspeedpanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		rightanglepanel.add(label3);
		rightanglepanel.add(inputText2);
		rightanglepanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		add(label1);
		add(rightspeedpanel);
		add(rightanglepanel);
		add(button1);
		add(label4);
		add(label5);
		add(Box.createRigidArea(new Dimension(0,200)));
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(button1)){
			// initiate repaint of canvas2b the wall and trabuchet parts 
			// also need some sort of control to check whether repaint 
			
			
			
		}
		
	}

}
