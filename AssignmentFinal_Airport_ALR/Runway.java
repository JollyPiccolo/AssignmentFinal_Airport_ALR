/**
 * 
 */

/**
 * @author AdelineLR
 *
 */
public class Runway {
	/**
	 * Variable Instantiation
	 */
	private Plane landed = new Plane(0,0);
	
	/**
	 * Constructor
	 */
	public Runway() {
		
	}
	
	/**
	 * land
	 * Lands a plane, causing it to enter the Runway
	 * The Runway will announce the entrance of the Plane
	 * @param nextPlane
	 */
	public void land(Plane nextPlane) {
		landed = nextPlane;
		System.out.println("\n\\__Plane #" + landed.getID() + " Has Entered the Runway");
	}
	
	/**
	 * exit
	 * Docks the plane at the Airport, causing it to exit the Runway
	 * The Runway also announces the exiting of the plane
	 * @return Plane temp
	 */
	public Plane exit() {
		Plane temp = new Plane(landed);
		System.out.println("\n__/ Plane #" + landed.getID() + " Has Exited the Runway");
		
		landed.setDistance(0);
		landed.setID(0);
		return temp;
	}
	
	/**
	 * isEmpty
	 * returns a boolean variable - true if the runway is currently empty, false if not
	 * @return boolean result - true if empty, false if not
	 */
	
	public boolean isEmpty() {
		boolean result = false;
		if(landed.getDistance() == 0 && landed.getID() == 0) {
			result = true;
		}
		return result;
	}
	
	/**
	 * getID
	 * returns the ID of the plane currently occupying the runway
	 * @return int ID
	 */
	public int getID() {
		return landed.getID();
	}
	
}
