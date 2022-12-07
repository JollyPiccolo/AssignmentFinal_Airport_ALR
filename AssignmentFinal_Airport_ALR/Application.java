/**
 * 
 */
import java.util.*;
/**
 * @author AdelineLR
 *
 */

public class Application{
	public static void main(String args[]) {
		
		Scanner scan = new Scanner(System.in);
		String input = new String();
		int day = 1;
		
		
		AirportTimer application = new AirportTimer();
		
		System.out.println("Press Y to begin the Airport Simulator");
		input = scan.next();
		
		while(input.equalsIgnoreCase("y")) {
			System.out.println("Day " + day);
			application.startSim();
			input = scan.next();
			day++;
		}
		application.endSim();
		scan.close();
		
	}
}