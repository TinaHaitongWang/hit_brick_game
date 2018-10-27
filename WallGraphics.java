/*Name: Haitong Wang     
NetID: 28246763
Assignment No.: Project 3
Lab section: MW 2:00pm
"I did not collaborate with anyone on this
assignment."*/
// This is graphic canvas for wall display  and will extend JComponent class.
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;
public class WallGraphics extends JComponent {
	Wall wall; 
	Integer[][] bricktemp;
	Color c = new Color(135,206,250);
	
	public WallGraphics(Wall wall){
		this.wall = wall;
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
//		bricktemp = new Integer[wall.getNumBrick()[0]][wall.getNumBrick()[1]];
//		for(int j = 0; j <wall.getBrick().length; j++){
//		    for(int i = 0; i < wall.getBrick()[j].length; i++) {
//		    	bricktemp[wall.getBrick().length-j-1][wall.getBrick()[j].length-i-1] = wall.getBrick()[j][i]; 
//		    	}
//		}
//		wall.setBrick(bricktemp);
		for(int i = 0; i<wall.getBrick().length;i++){
			for(int j =0; j <wall.getBrick()[0].length;j++){
			if(wall.getBrick()[i][j]==1){	
				g.setColor(Color.YELLOW);
			    g.drawRect((j+1)*wall.getBrickDimension()[0],(i+1)*wall.getBrickDimension()[1],wall.getBrickDimension()[0],wall.getBrickDimension()[1]);	
			    g.setColor(Color.red);
		        g.fillRect(((j+1)*wall.getBrickDimension()[0]+1),((i+1)*wall.getBrickDimension()[1]+1), wall.getBrickDimension()[0]-1, wall.getBrickDimension()[1]-1);
			}
			else if(wall.getBrick()[i][j]==0){
				g.setColor(Color.BLACK);
			    g.drawRect(((j+1)*wall.getBrickDimension()[0]),((i+1)*wall.getBrickDimension()[1]),wall.getBrickDimension()[0]+1,wall.getBrickDimension()[1]+1);
				g.setColor(Color.GREEN);
			    g.fillRect(((j+1)*wall.getBrickDimension()[0]+1),((i+1)*wall.getBrickDimension()[1]), wall.getBrickDimension()[0]-1, wall.getBrickDimension()[1]-1);	
			}
			else if(wall.getBrick()[i][j]==3){
				g.setColor(c);
			    g.drawRect(((j+1)*wall.getBrickDimension()[0]),((i+1)*wall.getBrickDimension()[1]),wall.getBrickDimension()[0]+1,wall.getBrickDimension()[1]+1);
				g.setColor(c);
			    g.fillRect(((j+1)*wall.getBrickDimension()[0]+1),((i+1)*wall.getBrickDimension()[1]), wall.getBrickDimension()[0]-1, wall.getBrickDimension()[1]-1);
			}
			else if(wall.getBrick()[i][j]==2){
				g.setColor(Color.MAGENTA);
			    g.fillRect(((j+1)*wall.getBrickDimension()[0]),((i+1)*wall.getBrickDimension()[1]), wall.getBrickDimension()[0]-1, wall.getBrickDimension()[1]-1);
			}
			
		}
		}
	}

}
