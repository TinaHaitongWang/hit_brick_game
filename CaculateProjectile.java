/*Name: Haitong Wang   
NetID: 28246763
Assignment No.: Project 1 
Lab section: MW 2:00pm
"I did not collaborate with anyone on this
assignment."*/
// This class will calculate the projectile.  
public class CaculateProjectile {
	double speed; // meter/second 
	double angle; // degree
	int distance; // actual distance from the wall
	int height; // actual height of the wall
	double gravity= 9.8; // unit: m/s2
	double projectileHeight; // calculate height of projectile 
	double projectileHeightPeak;
	double distancePeak;
	
	public CaculateProjectile(int speed, int angle, int distance, int height){
		this.speed = speed;
		this.angle = angle;
		this.distance = distance;
		this.height = height;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	// ********************************calculate projection high********************************
	public double projectileY(){
		//projectile motion formula
		angle = angle * (Math.PI/180);
		projectileHeight = (distance*Math.tan(angle)) - (gravity*Math.pow(distance, 2))/(2*Math.pow((speed*Math.cos(gravity)), 2)); 
		return projectileHeight;
	}
	


	
}
