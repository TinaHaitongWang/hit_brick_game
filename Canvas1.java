/*Name: Haitong Wang    
NetID: 28246763
Assignment No.: Project 3
Lab section: MW 2:00pm
"I did not collaborate with anyone on this
assignment."*/
// This is canvas class will extend JComponent class. 

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
public class Canvas1 extends JComponent implements ActionListener{
	JLabel label1;
	JLabel label2a, label2b, label2c, label2d, label2e, label2f, label2g,label2h;
	JLabel label3;
	JLabel label4; 
	JLabel label5; 
	JTextField user1; 
	JTextField user2; 
	JButton button1;
	Player p1,p2;
	Wall wall;

	
	public Canvas1(){ 
		setVisible(true);
		setOpaque(false);
		label1 = new JLabel("Welcome to the Wall Revenge Game!\n");
		label1.setFont(new Font ("Times New Roman", Font.BOLD,28));
		label2a = new JLabel("Here are some general rules to this game! ");
		label2b = new JLabel("(1) This a game of cooperation and fight, so it is a 2 person game.");
		label2c = new JLabel("(2) Two players must work together to fire shots to chip away at the");
		label2d = new JLabel("     brick of wall in an attempt to safety detonate the bomb before it goes off.");
		label2e = new JLabel("(3) Each round each player can only fire once by giving the firing angle and speed.");
		label2f = new JLabel("(4) Bomb will detonate at least 15 attempts. The exact number is randomly generated between 15 to 50.");
		label2g = new JLabel("(5) Each player will have a basic score of 0, and based on the performance of each round, points will");
		label2h = new JLabel("     be subtracted or added.");
		label2a.setFont(new Font ("Times New Roman", Font.BOLD,12));
		label2b.setFont(new Font ("Times New Roman", Font.BOLD,12));
		label2c.setFont(new Font ("Times New Roman", Font.BOLD,12));
		label2d.setFont(new Font ("Times New Roman", Font.BOLD,12));
		label2e.setFont(new Font ("Times New Roman", Font.BOLD,12));
		label2f.setFont(new Font ("Times New Roman", Font.BOLD,12));
		label2g.setFont(new Font ("Times New Roman", Font.BOLD,12));
		label2h.setFont(new Font ("Times New Roman", Font.BOLD,12));
		label3 = new JLabel("Now are you ready to play? Please enter your names!");
		label3.setFont(new Font ("Times New Roman", Font.BOLD,12));
		this.add(label1);
		this.add(label2a);
		this.add(label2b);
		this.add(label2c);
		this.add(label2d);
		this.add(label2e);
		this.add(label2f);
		this.add(label2g);
		this.add(label2h);
		this.add(label3);
		label4 = new JLabel ("Player Name:");
		label5 = new JLabel ("Player Name:");
		p1 = new Player (label4.getText());
		p2 = new Player (label5.getText());
		wall = new Wall(400);
		wall.CalculateNumberBrick();
		wall.GenerateBrick();
		wall.GenerateBombLocation();
		p2.setPlayer2(true);
		add(label4);
		user1 = new JTextField("   ",5);
		add(user1);
		add(label5);
		user2 = new JTextField("   ",5);
		add(user2);
		button1 = new JButton("OK");
		add(button1);
		button1.addActionListener(this);
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(button1)){
				p1.setName(user1.getText());
				p2.setName(user2.getText());
			}
			removeAll();
			Canvas2 canvas2 = new Canvas2(p1,p2,wall);
			canvas2.setPreferredSize(new Dimension(760, 400));
			add(canvas2);
			canvas2.Game();
			validate();
			revalidate();
			repaint();
		}
	
	public static void main(String[] args){
		
		Canvas1 canvas1 = new Canvas1();
		JFrame frame = new JFrame(); 
		frame.add(canvas1);
		frame.setSize(945,440);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.repaint();
		frame.validate();
		
	
	}

	}


