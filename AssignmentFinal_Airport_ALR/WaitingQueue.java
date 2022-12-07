/**
 * 
 */

/**
 * @author AdelineLR
 *
 */

public class WaitingQueue<T> implements  PriorityQueueInterface<T>{
	/**
	 * Variable Instantiation 
	 */
	private PQueueList<T> queue = new PQueueList<T>();


	/**
	 * Constructor
	 */
	
	public WaitingQueue(){
		
	}
	/** 
	 * Adds a new entry to this priority queue.
	 * @param Plane newEntry - object to be added. 
	 */
	public void enqueue(T newEntry) {
		
		PQueueNode<T> newNode = new PQueueNode<T>();
		
		newNode.setData(newEntry);
		
		queue.addNode(newNode);
		
		newNode.setPriority(queue.getSize());
		
		if(queue.getSize() > 2) {
			this.prioritize();
		}	
	}

	/**
	 *  Removes and returns the entry having the highest priority.
	 * @return  Either the object having the highest priority or, if the
	 * priority queue is empty before the operation, null. 
	 */
	public T dequeue() {
		this.prioritize();
		
		PQueueNode<T> head = queue.removeHead();
		this.moveUp();
		
		return head.getData();
	}

	/** Retrieves the entry having the highest priority.
	* @return  Either the object having the highest priority or, if the
	* priority queue is empty, null. 
	*/
	public T peek() {
		return queue.getHead().getData();
	}

	/** Detects whether this priority queue is empty.
	* @return  True if the priority queue is empty, or false otherwise. 
	*/
	public boolean isEmpty() {
		return queue.isEmpty();
	}

	/** Gets the size of this priority queue
	* @return  The number of entries currently in the priority queue. 
	*/
	public int getSize() {
		return queue.getSize();
	}

	/** 
	 * clear
	 * Removes all entries from this priority queue.
	 */
	public void clear() {
		while(!queue.isEmpty()) {
			queue.removeHead();
		}
	}
	
	/**
	 * compareTo
	 * Compares two objects's priority values
	 * @param PQueueNode<T> ID1, PQueueNode<T> ID2
	 * @return PQueueNode<T> result
	 */
	
	private PQueueNode<T> comparePriority(PQueueNode<T> ID1, PQueueNode<T> ID2) {
		
		Integer priority1 = queue.getPriority(ID1);
		Integer priority2 = queue.getPriority(ID2);

		
		if (priority1.compareTo(priority2) > 0){
			return ID1;
		}
		else if (priority1.compareTo(priority2) < 0) {			
			return ID2;
		}
		else {
			return null;
		}
	}

	/**
	 * prioritize()
	 * sorts the queue by priority
	 */
	
	private void prioritize() {
		PQueueNode<T> target = new PQueueNode<T>();
		boolean sorted = false;
		
		
		
		while(sorted == false) {
			sorted = true;
			target = queue.getHead();
			
			while(target.getNextNode() != null) {
				
				if(this.comparePriority(target, target.getNextNode()) ==  target) {
					
					sorted = false;
					queue.switchNodes(target, target.getNextNode());
					}
				else {
					target = target.getNextNode();
				}
					
					
				
			}			
		}
	}
	
	/**
	 * moveUp()
	 * moves every node in the queue up in priority
	 */
	private void moveUp() {
		if(!queue.isEmpty()) {
			PQueueNode<T> target = queue.getHead();
			
			while(target != null) {
				if(target.getPriority() > 2) {
				target.setPriority(target.getPriority() - 1);
				}
				target = target.nextNode;
			}
		}
	}
	
	/**
	 * emergency()
	 * creates an emergency on a random plane, bumping it up to priority 1 and moving it to the front of the queue
	 */
	
	public void emergency() {
		PQueueNode<T> victim = new PQueueNode<T>();
		int target = (int) (Math.random() * queue.getSize() + 1);
		
		if (target == 1) {
			target++;
		}	
		
		if(!queue.isEmpty()) {
			
			victim = queue.findPriority(target);
			victim.setPriority(1);
			System.out.println("\n*****Emergency on " + victim.getData() + "; Prioritizing Plane's Landing!*****");
			
			this.prioritize();
		}
	}
	
	/**
	 * printQueue()
	 * Prints all of the planes in the queue
	 */
	
	public void printQueue() {
		PQueueNode<T> target = queue.getHead();
		System.out.println("");
		while(target != null) {
			System.out.println("  * " + target.toString());
			
			if(target == target.getNextNode()) {
				target = null;
			}
			else {
			target = target.getNextNode();
			}

		}
		
	}
	
}
