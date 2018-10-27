/*Name: Haitong Wang    
NetID: 28246763
Assignment No.: Project 3
Lab section: MW 2:00pm
"I did not collaborate with anyone on this
assignment."*/
// This is canvas class  for trebuchet will extend JComponent class. 
import javax.swing.JComponent; 

import java.awt.Color;
import java.awt.Graphics;
public class Trebuchet extends JComponent {
	int xposition,yposition;
	int width = 30;
	int height = 15; 
	
	public Trebuchet(int xposition, int yposition){
		this.xposition = xposition;
		this.yposition = yposition;
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.fillRect(xposition, yposition, width, height);
		g.setColor(Color.magenta);
	}

}
