/*Name: Haitong Wang   
NetID: 28246763
Assignment No.: Project 1 
Lab section: MW 2:00pm
"I did not collaborate with anyone on this
assignment."*/
// This is wall class. It has two subclasses, and they are bricks and bombs 
import java.util.Random;
public class Wall {
	private int width = 150; // actual width from the wall
	private int height; // actual height of the wall
	private Integer[] numBrick = new Integer [2]; // [x direction, y direction]
	private Integer[] brickDimension= {20,10};//[width, height] 
	Random random = new Random();
	Integer[][] brick ;
	private boolean isBomb = true; 
	private Integer[] bombLocation = new Integer [2]; // [x direction, y direction]
	int count =0; 
	
	
	public Wall(int height){ // wall height depends on the canvas size 
		this.height = height;
	}
	 // *****************************getter and setter*****************************
	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}

	public Integer[] getBrickDimension() {
		return brickDimension;
	}

	public void setBrickDimension(Integer[] brickDimension) {
		this.brickDimension = brickDimension;
	}

	public Integer[] getNumBrick() {
		return numBrick;
	}

	public void setNumBrick(Integer[] numBrick) {
		this.numBrick = numBrick;
	}

	public boolean isBomb() {
		return isBomb;
	}

	public void setBomb(boolean isBomb) {
		this.isBomb = isBomb;
	}

	public Integer[] getBombLocation() {
		return bombLocation;
	}
	public void setBombLocation(Integer[] bombLocation) {
		this.bombLocation = bombLocation;
	}
	public Integer[][] getBrick() {
		return brick;
	}

	public void setBrick(Integer[][] brick) {
		this.brick = brick;
	}

	
	// *************************************** find out how many brick bricks **************************************
	public Integer[] CalculateNumberBrick(){
		numBrick[0] = getWidth()/brickDimension[0];// column
		numBrick[1] = getHeight()/brickDimension[1];// row
		System.out.println(getNumBrick()[0]+"000"+getNumBrick()[1]);//delete
		return numBrick;
	}
	
	// ****************************************** Generate bricks ****************************************************
	public Integer[][] GenerateBrick(){
		brick = new Integer[numBrick[1]][numBrick[0]];
		for(int i = 0; i<numBrick[0];i++){
			for(int j =0; j<numBrick[1];j++){
				brick[j][i] = 1; 
			}
		}
		return brick;
	}
	
	// *************************************** Generate bomb location and bomb**************************************
	public void GenerateBombLocation(){
		bombLocation[0] = random.nextInt((numBrick[0]-2)-2+1)+2;
		bombLocation[1] = random.nextInt((numBrick[1]-6)-6+1)+6;
		brick[bombLocation[1]][bombLocation[0]] = 0;
		System.out.println(bombLocation[0]+"bomb"+bombLocation[1]);
		count ++;
	}
	
	// ****************************************** destroy bricks ****************************************************
	public void DestroyBrick(int positionX, int positionY){
		brick[positionX][positionY] = 2;
	}
	
	public void TransparentBrick(int x, int y){
		brick[x][y] =3; 
	}
	
	public void resetBrick(int x, int y, int status){
		brick[x][y] = status ; 
	}
	
 
}
