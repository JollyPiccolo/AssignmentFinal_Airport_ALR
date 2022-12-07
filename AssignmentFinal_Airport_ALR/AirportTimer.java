/**
 * 
 */
import java.io.IOException;
import java.util.*;
/**
 * @author AdelineLR
 *
 */
public class AirportTimer {
	/**
	 * Variable instantiation
	 */
	private Timer time = new Timer();	
	private int day = 1;
	private AirportTasks tasklist = new AirportTasks();
	
	/**
	 * constructor
	 */
	public AirportTimer() {
		
	}
	
	/**
	 * startSim
	 * Begins the timer, and starts the simulation
	 */
	public void startSim() {
		System.out.println("Beginning Simulation");
		this.main();
	}
	
	/**
	 * main
	 * Task responsible for running the simulation - repetitively loops through a set of commands each hour
	 * every 12 hours - prompts the user to continue the sim or stop the program
	 */
	
	public void main() {				
		TimerTask main = new TimerTask(){	
			//main task instantiation
			public void run(){
			
				//hour count instantiation
				int count = 1;
					
				//resets all queues each run
				 tasklist.annihilateQueues();
					
				//main loop - repeats the list of tasks each hour throughout the run, ending once the simulated day is over
				while(count < 25) {
					//spawns the chance for random-based events occurring for the hour
					int chance = (int) (Math.random() * 100);
					
					//Prints the current hour/tick
					System.out.println("\n---> Hour: " + count + ":00\n");
					
					//2 second pause
					
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					/*
					 * Lane Printing
					 * prints the status of each lane
					 */
					
					tasklist.laneStatus();
					
					
					//2 second pause
					
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					/*
					 * Plane Generation
					 * Generates the chance of the plane spawning
					 */
					
					if(chance <= 75) {
						tasklist.generatePlane();
					
						//2 second pause - lets user read the new plane
						
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				
					
					/*
					 * Plane Flight
					 * calculates the plane's traveled distance if in-transit,
					 * or announces a plane's arrival to the waiting queue
					 */
					
					tasklist.flyPlanes();
					
					//3 second pause
					
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					/*
					 * landing check
					 * checks the waiting queue in tasklist to see if any planes need to be landed, skipping over the landing commands if they're not needed
					 */
					if(tasklist.waitingEmpty() == false) {
						
						/*
						 * Emergency spawner
						 * rolls to generate a random emergency in one of the waiting planes
						 */
						if(chance <= 10) {
							tasklist.spawnEmergency();
						}
						
						/*
						 * Waiting Summary
						 * prints the ID and Order of the planes waiting to land
						 */
					
						tasklist.printWaiting();
					
						//3 second pause
					
						try {
						Thread.sleep(3000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					
					
					
						/*
						 * Landing
						 * lands any planes in the waiting queue
						 */
					
						tasklist.landPlanes();
						
						//2 second pause
						
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}	
		
					/*
					 * Docking
					 * docks any planes in the toDock queue
					 */
				
					tasklist.clearRunways();
					
					/*
					 * Lane Checking
					 * checks the lanes with recently landed planes, and adds them to the toDock queue
					 */
						
					tasklist.checkRunways();
					 
					
						
					//End of Hour pause - 3 second delay per hour
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
					//END OF HOUR
		
					
					
					
					//Clears the screen every 4 simulated hours
					if((count%2) == 0) {
						try
				        {
				            if (System.getProperty("os.name").contains("Windows"))
				                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
				            else
				                Runtime.getRuntime().exec("clear");
				        } catch (InterruptedException | IOException ex) {}
						
						System.out.print("\033[H\033[2J");  
						System.out.flush();
					}
					
					//Progresses the hour count
					count++;
					
					//Announces the end of Day, and prompts the user to start the sim again
					if((count-1)%24 == 0) {
						System.out.println("\nDay " + day + " Finished; Go again? (Press Y to Continue, or any other key to end)");
						day++;
					}		
					}
					
				}
			
			};
			//Formally schedules the main task whenever the main method is called
			time.schedule(main, 2000);
		}	
	
	/**
	 * endSim
	 * stops the timer and the simulation, ending the application
	 */
	public void endSim(){
		System.out.println("Ending Simulation");
		time.cancel();
	}

}
