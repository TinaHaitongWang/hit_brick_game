import javax.swing.JPanel;

/*Name: Haitong Wang   
NetID: 28246763
Assignment No.: Project 1 
Lab section: MW 2:00pm
"I did not collaborate with anyone on this
assignment."*/
// This is player class. 
public class Player { 
	private String name; 
	private int score;
	private int award =0; // 1: shot miss; 2: hit brick; 3: shot bomb; 4: shot frenemy's trebuchet before the bomb 
	// 5: shot frenemy's trebuchet after the bomb; 6: bomb detonate 
	private boolean isTrebuchets = true; 
	private int speed; // meter/second 
	private int angle; // degree
	private int distanceToWall; 
	private Integer[]destoryBrickPosition = new Integer[2];// (x,y) 
	private boolean isPlayer2 = false; 
	CaculateProjectile cp1;
	private boolean isDefeated =false;
	double projectileHeight;
 
	
	public Player(String name){
		this.name = name; 
	}
	
    // *****************************getter and setter*****************************
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public boolean isTrebuchets() {
		return isTrebuchets;
	}

	public void setTrebuchets(boolean isTrebuchets) {
		this.isTrebuchets = isTrebuchets;
	}
	
	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getAngle() {
		return angle;
	}

	public void setAngle(int angle) {
		this.angle = angle;
	}

	public boolean isPlayer2() {
		return isPlayer2;
	}

	public void setPlayer2(boolean isPlayer2) {
		this.isPlayer2 = isPlayer2;
	}

	public Integer[] getDestoryBrickPosition() {
		return destoryBrickPosition;
	}

	public void setDestoryBrickPosition(Integer[] destoryBrickPosition) {
		this.destoryBrickPosition = destoryBrickPosition;
	}

	public boolean isDefeated() {
		return isDefeated;
	}

	public void setDefeated(boolean isDefeated) {
		this.isDefeated = isDefeated;
	}

	public int getDistanceToWall() {
		return distanceToWall;
	}

	public void setDistanceToWall(int distanceToWall) {
		this.distanceToWall = distanceToWall;
	}

	public int getAward() {
		return award;
	}

	public void setAward(int award) {
		this.award = award;
	}

	// *****************************fire trebuchets method and define the award *****************************
	public void FireTrebuchets(Wall wall, JPanel gamePanel){
		System.out.println("in player class");//delete 
		distanceToWall =(gamePanel.getWidth()-wall.getWidth())/2;
		cp1 = new CaculateProjectile(speed, angle,distanceToWall,wall.getHeight());
		projectileHeight = cp1.projectileY(); 
		int projectileHeightRow = Integer.valueOf((int)projectileHeight/wall.getBrickDimension()[0]);
		if(projectileHeight<=0 ||projectileHeight>wall.getHeight()){
			// escape the gravity or hit ground 
			award =1;
		}
		else{
			// hit brick, other player or bomb 
			if(!isPlayer2){//player 2 start from the left side 
				//System.out.println(wall.getNumBrick()[0]-1);//delete
				System.out.println("projectileHeightRow"+projectileHeightRow);//delete
				System.out.println("projectileHeight"+projectileHeight);//delete
					if(wall.getBrick()[wall.getNumBrick()[1]-(projectileHeightRow-1)][wall.getNumBrick()[0]-1]==1){
						   System.out.println("zzzz"+ (wall.getNumBrick()[0]-1));//delete
						   System.out.println("zzzz"+(projectileHeightRow-1));//delete
							wall.DestroyBrick(wall.getNumBrick()[1]-(projectileHeightRow-1),wall.getNumBrick()[0]-1);
							award = 2; 
					
					}
					else if(wall.getBrick()[wall.getNumBrick()[1]-(projectileHeightRow-1)][wall.getNumBrick()[0]-1]==0){
						award = 3;
					}
					else if(wall.getBrick()[ wall.getNumBrick()[1]-(projectileHeightRow-1)][wall.getNumBrick()[0]-1]==2 ||wall.getBrick()[ wall.getNumBrick()[1]-(projectileHeightRow-1)][wall.getNumBrick()[0]-1]==3){
						if(wall.getBrick()[wall.getNumBrick()[1]-projectileHeightRow][wall.getNumBrick()[0]-2]==1){
							System.out.println("fff"+ (wall.getNumBrick()[0]-2));//delete
							System.out.println("fff"+(projectileHeightRow));//delete
							wall.DestroyBrick(wall.getNumBrick()[1]-projectileHeightRow,wall.getNumBrick()[0]-2);
							award = 2; 
					
						}
						else if(wall.getBrick()[wall.getNumBrick()[1]-projectileHeightRow][wall.getNumBrick()[0]-2]==0){
							award = 3;
						}
						else if(wall.getBrick()[wall.getNumBrick()[1]-projectileHeightRow][wall.getNumBrick()[0]-2]==2||wall.getBrick()[ wall.getNumBrick()[1]-projectileHeightRow][wall.getNumBrick()[0]-2]==3){
							for(int i=0; i<(wall.getNumBrick()[0]-2);i++){
								if(wall.getBrick()[wall.getNumBrick()[1]-(projectileHeightRow-i-1)][wall.getNumBrick()[0]-3-i]==1){
									System.out.println(i+"hhh"+ (wall.getNumBrick()[0]-3-i));//delete
									System.out.println(i+"hhh"+(projectileHeightRow-i));//delete
									wall.DestroyBrick(wall.getNumBrick()[1]-(projectileHeightRow-i-1),wall.getNumBrick()[0]-3-i);
									award = 2; 
									break;
								}
								else if(wall.getBrick()[wall.getNumBrick()[1]-(projectileHeightRow-i-1)][wall.getNumBrick()[0]-3-i]==0){
									award = 3;
									break;
								}
								else if(wall.getBrick()[wall.getNumBrick()[1]-(projectileHeightRow-i-1)][wall.getNumBrick()[0]-3-i]==2){
									if(i==0){
										wall.DestroyBrick(wall.getNumBrick()[1]-(projectileHeightRow-i-1),wall.getNumBrick()[0]-4-i);
										award = 2; 
										break;
									}
									
								}
							}
							
						}
					}
					
				
			}
			else{//player 1 start from the right side 
				if(wall.getBrick()[wall.getNumBrick()[1]- (projectileHeightRow-1)][0]==1){
						wall.DestroyBrick(wall.getNumBrick()[1]-(projectileHeightRow-1),0);
						award = 2; 
				}
				else if(wall.getBrick()[wall.getNumBrick()[1]-( projectileHeightRow-1)][0]==0){
					award = 3;
				}
				else if(wall.getBrick()[wall.getNumBrick()[1]-(projectileHeightRow-1)][0]==2 ||wall.getBrick()[ wall.getNumBrick()[1]-(projectileHeightRow-1)][0]==3){
					if(wall.getBrick()[wall.getNumBrick()[1]- projectileHeightRow][1]==1){
						wall.DestroyBrick(wall.getNumBrick()[1]-projectileHeightRow,1);
						award = 2; 
						
					}
					else if(wall.getBrick()[wall.getNumBrick()[1]-projectileHeightRow][1]==0){
						award = 3;
					}
					else if(wall.getBrick()[wall.getNumBrick()[1]-projectileHeightRow][1]==2||wall.getBrick()[ wall.getNumBrick()[1]-projectileHeightRow][1]==3){
						for(int i=0; i<(wall.getNumBrick()[0]-2);i++){
								if(wall.getBrick()[wall.getNumBrick()[1]-(projectileHeightRow-1-i)][2+i]==0){
									award = 3;
									break;
								}
								else if(wall.getBrick()[wall.getNumBrick()[1]-(projectileHeightRow-1-i)][2+i]==1){
								wall.DestroyBrick(wall.getNumBrick()[1]-(projectileHeightRow-1-i),2+i);
								award = 2; 
								break;
								}
								else if(wall.getBrick()[wall.getNumBrick()[1]-(projectileHeightRow-1-i)][2+i]==2){
									if(i==0){
										wall.DestroyBrick(wall.getNumBrick()[1]-(projectileHeightRow-1-i),3+i);
									}
								}
								
							}
						}
						
					}
				}
				
			}
			
		if(award==3){
			int x1= wall.getBombLocation()[1]-2;
			for(int i=0; i<5; i++){
				for(int j=0;j<wall.getNumBrick()[0];j++){
				wall.DestroyBrick(wall.getNumBrick()[1]-(x1+i-1),j);
				}
			}
			wall.setBomb(false);
		}
		// check if player hit another player 
		if(award ==0){
			//check 2 possibility straight shooting 
			double displacement = (speed*speed)/9.81*(Math.sin(2*angle*Math.PI/180));
			if(Math.abs(displacement-gamePanel.getWidth())<3){//check if it hits other player 
				
			if(wall.isBomb()){
				award = 4;
			}
			else {
				award = 5;
			}
			isDefeated = true; 
			}
			else{
				award =1;
			}
		}
		// assign score 
		switch(award){
		case 1: score = score -10; 
		case 2: score = score +10;
		case 3: score = score +200;
		case 4: score = score +500;
		case 5: score = score +150; 
		case 6: score = score -400;
		}	



	}

}
