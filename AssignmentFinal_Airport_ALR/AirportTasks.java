/**
 * 
 */

/**
 * @author AdelineLR
 *
 */
public class AirportTasks {

	/**
	 * Variable Instantiation
	 */
	private Airport airport =  new Airport();
	private Plane[] inFlight = new Plane[20];
	private WaitingQueue<Plane> waiting = new WaitingQueue<Plane>();
	private WaitingQueue<Integer> toDock = new WaitingQueue<Integer>();
	
	/**
	 * Constructor
	 */
	public AirportTasks() {
		
	}
	
	/**
	 * generatePlane
	 * generates a random plane, and inserts it into the inFlight stack
	 */
	public void generatePlane() {
		Plane newPlane = new Plane();
		newPlane.randPlane();
		
		System.out.println("\nNew Plane: " + newPlane + "; " + newPlane.proximityString() + "\n");
		this.addPlane(newPlane);
		
	}
	
	/**
	 * flyPlanes
	 * calls all the planes in the inFlight stack to fly
	 */
	public void flyPlanes() {
		int count = 0;
		while(count <= inFlight.length - 1) {
			
			if(inFlight[count] != null) {
		
				int speed = (int) ((Math.random() * 115) + 460);
				inFlight[count].travel(speed);
		
				if(inFlight[count].getDistance() == 0) {
					inFlight[count].travel(speed);
					System.out.println("\nAwaiting Landing: " + inFlight[count]);
					waiting.enqueue(inFlight[count]);
					inFlight[count] = null;
				}
			}
			count++;
		}
		
	}
	/**
	 * addPlane
	 * adds a plane to the first open spot in the inFlight array
	 */
	private void addPlane(Plane newPlane) {
		int count = 0;
		Plane occupant = new Plane();
		
		while(occupant != null && count <= inFlight.length){
			occupant = inFlight[count];
			count++;
		}
		
		if(count-1 < inFlight.length) {
			inFlight[count-1] = newPlane;
		}
	}
	
	/**
	 * landPlanes
	 * lands all the planes possible from the waiting queue
	 */
	public void landPlanes() {
		if(!airport.allLanesFull() && !waiting.isEmpty()) {
			while(!airport.allLanesFull() && !waiting.isEmpty()) {
				airport.landPlane(waiting.dequeue());
			}
		}
		else if(airport.allLanesFull()) {
			System.out.println("\nAll lanes are occupied!");
		}
	}
	
	/**
	 * clearRunway
	 * docks a plane in a specified runway, clearing the lane
	 * @param int target
	 */
	public void clearRunways() {		
		if(!toDock.isEmpty())
			while(!toDock.isEmpty()) {
				airport.dock(toDock.dequeue());
			}
	}
	
	/**
	 * checkRunway
	 * checks the runways to see which ones need to be cleared at the next hour, before adding the to toDock
	 */
	public void checkRunways(){
		
		Integer count = 0;
		while(count < 3) {
			if(airport.laneEmpty(count) == false) {
				toDock.enqueue(count);
			}
			count++;
		}
	}
	
	/**
	 * printWaiting
	 * prints all of the planes currently waiting to land
	 */
	public void printWaiting() {
		if(!waiting.isEmpty()) {
			System.out.println("\nCurrently Waiting to Land: ");
			waiting.printQueue();
		}
	}
	
	/**
	 * waitingEmpty
	 * checks to see if waiting is empty or full, and returns a boolean variable 
	 * @return boolean result - true, if waiting is empty, false, if otherwise
	 */
	public boolean waitingEmpty() {
		return waiting.isEmpty();
	}
	
	/**
	 * inFlightEmpty
	 * checks to see if waiting is empty or full, and returns a boolean variable 
	 * @return boolean result - true, if waiting is empty, false, if otherwise
	 */
	public void emptyInFlight() {
		int count = 0;
		
		while(count != (inFlight.length - 1)) {
			inFlight[count] = null;
			count++;
		}
	}
	
	/**
	 * annihilateQueues
	 * clears both waiting, toDock, and inFlight queues - reset for each run
	 */
	public void annihilateQueues() {
		waiting.clear();
		toDock.clear();
		this.emptyInFlight();
	}
	
	/**
	 * spawnEmergency
	 * creates an emergency on one of the planes in the waiting queue, bumping it's priority up to 1
	 */
	public void spawnEmergency() {
		waiting.emergency();
	}
	
	/**
	 * laneStatus
	 * check the status of each lane in the airport
	 */
	public void laneStatus() {
		airport.printLanes();
	}
	
}