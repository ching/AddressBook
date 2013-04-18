package forDatabase;

//Ching Yu

/**
 * A Node class has a <code>Node</code> object consisting of the data of the
 * node and the link to the next node. The data is of a <code>String</code> object, and
 * the link is of a <code>Node&lt;E&gt;</code> object.
 */
public class Node<E> {
	/**
	 * The data of the node.
	 */
	E myData;
	/**
	 * The link to the next node. 
	 */
	Node<E> myLink;
	
	/**
	 * Constructs a new <code>Node</code> object with the given data and link.
	 * @param theData The given data of the node.
	 * @param theLink The given link of the node.
	 */
	public Node(E theData, Node<E> theLink){
		myData = theData;
		myLink = theLink;
	}//2-parameter constructor
	
	/**
	 * Constructs a new <code>Node</code> object with the given data. The link
	 * of the node is defaulted/initialized to null. 
	 * @param theData The given data of the node.
	 */
	public Node(E theData){
		myData = theData;
		myLink = null;
	}//1-parameter constructor

}//Node class
