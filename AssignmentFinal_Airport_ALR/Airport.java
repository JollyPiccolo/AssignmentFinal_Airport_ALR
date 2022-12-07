/**
 * 
 */

/**
 * @author AdelineLR
 *
 */
public class Airport {
	/**
	 * Variable Instantiation
	 */

	private Runway[] lanes = new Runway[3];
	
	/**
	 * Constructor
	 */
	
	public Airport() {
		Runway lane1 = new Runway();
		Runway lane2 = new Runway();
		Runway lane3 = new Runway();
		
		lanes[0] = lane1;
		lanes[1] = lane2;
		lanes[2] = lane3;
	}
	
	/**
	 * landPlane - Lands the plane at any available Runway
	 * @param Plane landed
	 */
	
	public void landPlane(Plane landed) {
		int count = 0;
		while (count < 3) {
			if(lanes[count].isEmpty()) {
				lanes[count].land(landed);
				System.out.println("Plane " + landed.getID() + " has landed in Runway " + (count+1) );
				return;
			}
			count++;
		}
		
	}
	/**
	 * dock - causes the plane to exit the Runway, and enter the Airport
	 * @param Runway lane
	 */
	
	public void dock(int lane) {
		lanes[lane].exit();
			
	}
	
	/**
	 * allLanesFull
	 * returns a boolean if all lanes are full
	 * @return result true if all lanes are full, false if otherwise
	 */
	
	public boolean allLanesFull() {
		boolean result = true;
		int count = 0;
		while (count < 3) {
			if(lanes[count].isEmpty()) {
				result = false;
			}
			count++;
		}
		return result;
	}
	/**
	 * laneEmpty
	 * checks a particular lane to see if it's occupied
	 * @param int lane
	 * @return true, if the lane is empty; false, if otherwise
	 */
	public boolean laneEmpty(int lane) {
		return lanes[lane].isEmpty();
	}
	
	/**
	 * printLanes
	 * prints the status of each lane in the runway system
	 * 
	 */
	public void printLanes() {
		int count = 0;
		
		while (count < 3) {
			if(lanes[count].isEmpty()) {
				System.out.println("Lane " + (count+1) + " is Empty");
			}else {
				System.out.println("Lane " + (count+1) + " is Full; Occupied by Plane #" + lanes[count].getID());
				System.out.println("One Hour until Lane "+ (count+1) + " is Clear");
			}
			count++;
		}	
	}
}
