/**
 * 
 */

/**
 * @author AdelineLR
 *
 */
public class PQueueList<T>{
	/**
	 * Variable Instantiation
	 */
	private PQueueNode<T> head;
	private int length;
	private PQueueNode<T> tail;
	
	/**
	 * Constructor Instantiation
	 */
	public PQueueList(){
		head = null;
		length = 0;
		tail = head;
	}
	
	/**
	 * isEmpty()
	 * checks the list to see if its empty
	 * @return True if the list is empty, otherwise returns false
	 */
	public boolean isEmpty()
	{
		if (head == null) { return true;}
		else return false;
	}
	
	/**
	 * getHead()
	 * Returns the first node in the list
	 * @return PQueueNode head
	 */
	public PQueueNode<T> getHead(){
		return head;
	}
	
	/**
	 * addNode()
	 * adds a node to the end of the list
	 * @param PQueueNode aNode
	 */
	public void addNode(PQueueNode<T> aNode){
		if (isEmpty() ) {
			head = aNode;
			tail=head;
			return;
		}
		tail.nextNode = aNode;
		tail = tail.nextNode;
		tail.nextNode = null;
		length++;
		
	}
	/**
	 * removeHead()
	 * removes a node from the front of the list
	 * @return PQueueNode output
	 */
	public PQueueNode<T> removeHead(){
		PQueueNode<T> output = head;
		
		if(head == tail) {
			head = null;
		}
		else{
			head = head.getNextNode();
		}
		length--;
		return output;
	}
	
	/**
	 * getSize()
	 * returns the number of entries in the List
	 * @return int size
	 */
	public int getSize() {
		int size = 1;
		
		if(this.isEmpty()) {
			size = 0;
			return size;
		}
		
		PQueueNode<T> target = new PQueueNode<T>();
		target = head;
		
		while(target != null) {
			target = target.getNextNode();
			size++;
		}

		return size;
	}
	
	/**
	 * contains
	 * checks the list to see if it contains a certain node within it
	 * @param PQueueNode key
	 * @returns true, if the key is present in the list; false, if not
	 */
	
	public boolean contains(PQueueNode<T> key) {
		boolean result = false; 
		PQueueNode<T> target = new PQueueNode<T>();
		
		target = head;
		while(target != null && result == false) {
			if(target == key) {
				result = true;
			}
			target = target.getNextNode();
		}
		return result;
	}
	
	/**
	 * getPriority
	 * returns the priority of a node within the list
	 * @param PQueueNode key
	 * @return int result
	 */
	
	public int getPriority(PQueueNode<T> key) {
		int result = -1;
		
		if (this.contains(key)){
			result = key.getPriority();
		}
		
		return result;
	}
	
	/**
	 * findPriority()
	 * searches the list for a node based on a given priority, and returns the node based on said priority
	 * @param int key
	 * @return PQueueNode result
	 */
	
	public PQueueNode<T> findPriority(int key) {
		PQueueNode<T> result = new PQueueNode<T>();
		boolean found = false;
		PQueueNode<T> target = new PQueueNode<T>();
		
		target = head;
		
		if(this.getSize() >= key) {
			while(target != null && found == false) {
				if(target.getPriority() == key) {
					result = target;
					found = true;
				}
				target = target.getNextNode();
			}
		}	
		
		return result;
	}
	
	/**
	 * switchNodes()
	 * switches the position of two nodes
	 * @param PQueueNode n1, PQueueNode p2
	 */
	
	public void switchNodes(PQueueNode<T> first, PQueueNode<T> second) {

		
		PQueueNode<T> afterSecond = second.getNextNode();
		
		PQueueNode<T> beforeFirst = this.getLastNode(first);

		
		if(first == head) {
			head = second;
		} 
		
		if(second == tail) {
			tail = first;
		} 
		
		second.setNextNode(first);
		first.setNextNode(afterSecond);
		beforeFirst.setNextNode(second);
		
	}
	
	/**
	 * getLastNode
	 * returns the node currently holding the target node as its nextNode
	 * @param PQueueNode key
	 */
	
	private PQueueNode<T> getLastNode(PQueueNode<T> key) {
		PQueueNode<T> result = new PQueueNode<T>();
		PQueueNode<T> target = new PQueueNode<T>();
		boolean found = false;
		
		target = head;
		
		if(target.getNextNode() == null) {
			result = null;
			found = true;
		}
		
		while(target != null && found == false) {
			if(target.nextNode == key) {
				result = target;
				found = true;
			}
			target = target.getNextNode();
		}
		
		return result;
	}

}
