/*Name: Haitong Wang     
NetID: 28246763
Assignment No.: Project 3
Lab section: MW 2:00pm
"I did not collaborate with anyone on this
assignment."*/
// This is main canvas class will extend JComponent class. 
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Canvas2 extends JPanel implements ActionListener {
	Trebuchet t1;
	Trebuchet t2;
	Color skycolor;
	Color c = new Color(135, 206, 250);
	//JPanel gamePanel = new JPanel();
	Canvas2a canvas2a;
	Canvas2b canvas2b;
	WallGraphics wallgraphics;
	Player p1, p2;
	Wall wall;
	boolean repaintControl = false;
	boolean gamecontrol = false;
	String input1, input2, input3, input4;
	int round = 1;
	int terminateround = 30;
	boolean isGame = true;
	JPanel endPanel;
	JLabel player1info;
	JLabel player2info;
	JLabel info;
	JLabel info2;
	JButton close;
	JPanel gamePanel;
	boolean removerow ;
	int removedRow;
	int TopRow,TopRow1;

	public Canvas2(Player p1, Player p2, Wall wall) {
		this.p1 = p1;
		this.p2 = p2;
		this.wall = wall;
		System.out.println("soyeahddddd");// delete
	}

	public void Game() {
		canvas2a = new Canvas2a(p1);
		canvas2b = new Canvas2b(p2);
		gamePanel = new JPanel();
		canvas2b.setPreferredSize(new Dimension(200, 400));
		canvas2a.setPreferredSize(new Dimension(200, 400));
		gamePanel.setPreferredSize(new Dimension(200, 400));
		gamePanel.setBackground(c);
		wallgraphics = new WallGraphics(wall);
		t1 = new Trebuchet(0, 400);
		t2 = new Trebuchet((200 - 52), 400);
		gamePanel.setLayout(new BoxLayout(gamePanel, BoxLayout.X_AXIS));
		gamePanel.add(t1);
		gamePanel.add(wallgraphics);
		gamePanel.add(t2);
		// gamePanel.setBorder(BorderFactory.createEmptyBorder(540,400,540,400));
		setLayout(new BorderLayout());
		add(canvas2a, BorderLayout.WEST);
		add(gamePanel, BorderLayout.CENTER);
		add(canvas2b, BorderLayout.EAST);
		// setLayout(new GridLayout(1,0));
		// add(canvas2a);
		// add(gamePanel);
		// add(canvas2b);
		canvas2a.button1.addActionListener(this);
		//canvas2b.button2.addActionListener(this);
		System.out.println("soyeahFUCK");// delete
	}
	
//	public class gamepanel extends JPanel{
//		public gamepanel(){
//			setVisible(true);
//			setBackground(c);
//		}
//		
//		public void drawProjectile(){
//			repaint();
//		}
//		@override
//		public void paintComponent(Graphics g){
//			super.paintComponent(g);
//			if(round!=1){
//			if(!p1.isPlayer2()){
//				System.out.println("projectile");//delete
//				int currentx = t1.xposition;
//				int currenty = 0;
//				int finaly = Integer.valueOf((int)p1.projectileHeight);
//				int finalx; 
//				int angle = p1.getAngle();
//				int speed = p1.getSpeed();
//				double gravity = 9.81;
//				System.out.println("currentx"+currenty);//delete
//				System.out.println("finaly"+finaly);//delete
//				//while(currenty<=finaly){
//					System.out.println("projectile"+currenty);//delete
//					g.setColor(Color.BLACK);
//					g.fillOval(currentx+400, currenty+400, 1, 1);
//					double radian = (angle * (Math.PI/180));
//					currentx++;
//					currenty = Integer.valueOf((int) ((currentx*Math.tan(radian )) - (gravity*Math.pow(currentx, 2))/(2*Math.pow((speed*Math.cos(gravity)), 2))));
//				//}	
//			}
//			if(p2.isPlayer2()){	// player true 
//				System.out.println("projectile");//delete
//				int currentx = t2.xposition;
//				int currenty = 0;
//				int finaly = Integer.valueOf((int)p2.projectileHeight);
//				int angle = p2.getAngle();
//				int speed = p2.getSpeed();
//				double gravity = 9.81;
//				//while(currenty<=finaly){
//					g.setColor(Color.BLACK);
//					g.fillOval(currentx+400, currenty+400, 1, 1);
//					double radian = (angle * (Math.PI/180));
//					currentx--;
//					currenty = Integer.valueOf((int) ((currentx*Math.tan(radian )) - (gravity*Math.pow(currentx, 2))/(2*Math.pow((speed*Math.cos(gravity)), 2))));
//				//}	
//				
//			}
//				
//			}
//			revalidate();
//			
//		}
		
//	}

	public void paintComponent(Graphics g) {
		// update painting here
		super.paintComponent(g);
		if (repaintControl) {
			
			gamePanel.removeAll();
			System.out.println("wwww");// delete
			wallgraphics.paintAll(g);
			// t1 = new Trebuchet(0,390);
			// t2 = new Trebuchet(149,390);
			if (p1.isDefeated()) {
				gamePanel.setLayout(new BoxLayout(gamePanel, BoxLayout.X_AXIS));
				g.setColor(Color.PINK);
				g.fillOval(0, 400, 30, 15);
				gamePanel.add(wallgraphics);
				gamePanel.add(t2);
			} else if (p2.isDefeated()) {
				gamePanel.setLayout(new BoxLayout(gamePanel, BoxLayout.X_AXIS));
				gamePanel.add(t1);
				gamePanel.add(wallgraphics);
				g.setColor(Color.PINK);
				g.fillOval((200 - 52), 400, 30, 15);
			} else {
				gamePanel.setLayout(new BoxLayout(gamePanel, BoxLayout.X_AXIS));
				gamePanel.add(t1);
				// add trajectory here
				gamePanel.add(wallgraphics);
				gamePanel.add(t2);
				//gamePanel.drawProjectile();
			}
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(canvas2a.button1)) {
			// need to add another button 2 control the other things
			// System.out.println("bomblocation"+wall.getBombLocation());//delete
			gamecontrol = true;
			if (round != 1) {// make brick transparent
				for (int i = 0; i < wall.getNumBrick()[1]; i++) {
					for (int j = 0; j < wall.getNumBrick()[0]; j++) {
						if (wall.getBrick()[i][j] == 2) {
							wall.TransparentBrick(i, j);
						}

					}
				}

			}
			
			//check if there is empty row of brick 
			// check if the brick is hit by bomb
			if(p1.getAward()==3 ||p2.getAward()==3){
				for(int i=0; i<(wall.getNumBrick()[1]-wall.getBombLocation()[1]-3);i++){
					for(int j =0; j<wall.getNumBrick()[0];i++){
						wall.resetBrick((wall.getBombLocation()[1]+1-i), j, wall.getBrick()[(wall.getBombLocation()[1]-3-i)][j]);	
					}
				}
				for(int i =0; i<wall.getNumBrick()[0];i++){
					for(int j =0; j<wall.getNumBrick()[1];j++){
						if(wall.getBrick()[j][0]!=3){
							TopRow1 = j;
							break;
						}
					}
				}
				for(int i =0; i<TopRow1+5;i++){
					for(int j =0; j<wall.getNumBrick()[0];j++){
					wall.TransparentBrick(i, j);
					}
				}
			}
			
			
			
			removerow = false;
			for (int i = 0; i < wall.getNumBrick()[1]; i++) {	
						if(wall.getBrick()[i][0] ==3){	
							if(wall.getBrick()[i][1] ==3){
								if(wall.getBrick()[i][2] ==3){
									if(wall.getBrick()[i][3] ==3){
										if(wall.getBrick()[i][4] ==3){
											if(wall.getBrick()[i][5] ==3){
												if(wall.getBrick()[i][6] ==3){
													removerow = true;
													removedRow = i;
												}
											}
										}
									}
								}
							}
						}
			}
					
						}
		if(removerow){
			for(int i =0; i<removedRow;i++){
				for(int j =0; j<wall.getNumBrick()[1];j++){
					wall.resetBrick(i+1, j, wall.getBrick()[i][j]);	
				}
			}
			for(int i =0; i<wall.getNumBrick()[0];i++){
				for(int j =0; j<wall.getNumBrick()[1];j++){
					if(wall.getBrick()[j][0]!=3){
						TopRow = j;
						break;
					}
				}
			wall.TransparentBrick(TopRow, i);
			}
			
		}

		

		if (gamecontrol) {
			// round
			System.out.println(gamecontrol + "222");// delete
			input2 = canvas2a.inputText2.getText().trim();
			input1 = canvas2a.inputText1.getText().trim();
			input3 = canvas2b.inputText3.getText().trim();
			input4 = canvas2b.inputText4.getText().trim();
			p1.setAngle(Integer.parseInt(input2));
			p1.setSpeed(Integer.parseInt(input1));
			p2.setAngle(Integer.parseInt(input4));
			p2.setSpeed(Integer.parseInt(input3));
			
			p1.FireTrebuchets(wall, gamePanel);
			p2.FireTrebuchets(wall, gamePanel);
			if (round == 30 && wall.isBomb()) {
				p1.setScore(p1.getScore() - 400);
				p2.setScore(p2.getScore() - 400);
				isGame = false;
				// enter a new panel and display score and end the game
			} else if (p1.isDefeated()) {
				// enter a new panel and display score and end the game
				isGame = false;
			} else if (p2.isDefeated()) {
				// enter a new panel and display score and end the game
				isGame = false;
			} else {
				isGame = true;
				 System.out.println(input2+p1.getName());//delete
				 System.out.println(p1.getName()+p1.getAngle()+p1.getSpeed());//delete
				 System.out.println(p2.getName()+p2.getAngle()+p2.getSpeed());//delete
				 //System.out.println(input3+p2.getName());//delete
				// System.out.println(Integer.parseInt(canvas2a.inputText2.getText()));//delete
				System.out.println("round" + round);// delete
				System.out.println("p1score" + p1.getScore());// delete
				System.out.println("p2score" + p2.getScore());// delete
				canvas2b.label7 = new JLabel("Total Score: "+p2.getScore());
				canvas2b.label8 = new JLabel("Current Round Score: "+p2.getAward());
				canvas2a.label4 = new JLabel("Total Score: "+p1.getScore());
				canvas2a.label5 = new JLabel("Current Round Score: "+p1.getAward());
				repaintControl = true;
				repaint();
				round++;
				if (!isGame) {
					endPanel = new JPanel();
					info = new JLabel("GAME OVER");
					info.setFont(new Font("Times New Roman", Font.BOLD, 30));
					player1info = new JLabel("Player " + p1.getName()
							+ ": You final score is " + p1.getScore());
					player1info.setFont(new Font("Times New Roman", Font.BOLD,
							16));
					player2info = new JLabel("Player " + p2.getName()
							+ ": You final score is " + p2.getScore());
					player2info.setFont(new Font("Times New Roman", Font.BOLD,
							16));
					removeAll();
					info2 = new JLabel("Now you may exit");
					setLayout(new BorderLayout());
					add(info, BorderLayout.NORTH);
					add(player1info, BorderLayout.CENTER);
					add(player2info, BorderLayout.SOUTH);
					gamecontrol = false;
					repaintControl = false;
					revalidate();
					repaint();
				}
			}

		}

	}

}
