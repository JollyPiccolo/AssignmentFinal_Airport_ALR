/**
 * 
 */

/**
 * @author AdelineLR
 *
 */
public class Plane {

	/**
	 * Variable Instantiation
	 */
	private int distance;
	private int ID;

	
	/**
	 * Constructor - Empty
	 */
	
	public Plane() {
		distance = 0;
		ID = 0;
	}
	
	/**
	 * Constructor - With Data
	 * @param int miles, int name
	 */
	
	public Plane(int name, int miles) {
		distance = miles;
		ID = name;
	}
	
	/**
	 * Constructor - Cloned Data
	 * @param Plane p
	 */
	
	public Plane(Plane p) {
		distance = p.getDistance();
		ID = p.getID();
	}
	
	/**
	 * randPlane
	 * assigns a plane a random set of data
	 */
	
	public void randPlane() {
		distance = (int) ((Math.random() * 3000)+1);
		ID = (int) ((Math.random() * 100)+1000);
	}
	
	/**
	 * setID
	 * Sets the plane's ID
	 * @param int name
	 */
	
	public void setID(int name) {
		ID = name;
	}
	
	/**
	 * setDistance
	 * Sets the plane's Distance
	 * @param miles
	 */
	
	public void setDistance(int miles) {
		distance = miles;
	}
	
	/**
	 * getID
	 * returns the ID of the plane
	 * @return ID
	 */
	
	public int getID() {
		return ID;
	}
	
	/**
	 * getDistance
	 * returns the Distance of the plane
	 * @return Distance
	 */
	
	public int getDistance() {
		return distance;
	}
	
	/**
	 * travel
	 * decreases the distance of the plane and prints a message, announcing either its remaining distance or that it's arrived
	 * @param int speed
	 */
	public void travel(int speed) {
		if(this.distance == 0) {
			System.out.print("Plane " + ID + " has arrived!");
			return;
		}
		else {
			System.out.println("\n~~> Plane #" + ID + " is " + distance + " miles away from the Airport, traveling at a speed of " + speed + " mph");
			distance = distance - speed;
			
			if(distance < 0) {
				distance = 0;
			}
			
			return;
		}
	}
	
	/**
	 * toString
	 * converts the Plane's ID into a printable String
	 * @return data
	 */
	
	public String toString() {
		String data = "";	
		data = "Plane #" + ID;
		return data;
	}
	
	/**
	 * proximityString
	 * returns the distance of the plane in a string format
	 * @return data
	 */
	
	public String proximityString() {
		String data = "";	
		if(distance == 0) {
			data += "Arrived and Ready to Land";
		}
		else {
			data += "Currently " + distance + " Miles Away";
		}
		return data;
	}
}
