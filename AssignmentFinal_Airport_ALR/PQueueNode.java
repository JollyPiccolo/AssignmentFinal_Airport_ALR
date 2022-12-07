/**
 * 
 */

/**
 * @author AdelineLR
 *
 */
public class PQueueNode<T>{
	
	/**
	 * Variable Instantiation
	 */
	private T data;
	private int priority;
	protected PQueueNode<T> nextNode;
	
	/**
	 * Constructor Instantiation - Empty
	 */
	public PQueueNode(){
		nextNode = null;
		data = null;
	}
	
	/**
	 * setData()
	 * modifies the data tied to the node
	 * @param T data
	 */
	public void setData(T data) {
		this.data = data;
	}
	
	/**
	 * getData()
	 * returns the data within the node 
	 * @return T data
	 */
	public T getData() {
		return data;
	}	
	
	/**
	 * setPriority()
	 * modifies the priority of the node
	 * @param T data
	 */
	public void setPriority(int p) {
		this.priority = p;
	}
	
	/**
	 * getPriority()
	 * returns the priority of the node
	 * @return T data
	 */
	public int getPriority() {
		return this.priority;
	}
	
	/**
	 * getNode()
	 * returns the node itself as a value
	 * @return PQueueNode this
	 */
	public PQueueNode<T> getNode() {
		return this;
	}
	
	/**
	 * getNextNode()
	 * returns the node linked to nextNode 
	 * @return GenNode nextNode
	 */
	public PQueueNode<T> getNextNode() {
		return nextNode;
	}	
	
	/**
	 * setNextNode()
	 * sets the target of the current node's pointer
	 * @param PQueueNode nextNode
	 */
	public void setNextNode(PQueueNode<T>nextNode)
	{
		this.nextNode=nextNode;
	}

	/**
	 * toString()
	 * creates a string version of the GenNode
	 * @return String node
	 */
	public String toString(){
		String node = "";
		node += data;
		return node;
	}
	
}
