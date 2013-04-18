package forDatabase;

//Ching Yu

import java.util.*;
import java.io.*;

/**
 * An OrderedLinkedList has a <code>OrderedLinkedList</code> object
 * consisting of a head node and a comparator. The head node is of a <code>Node&lt;E&gt;</code>
 * object and the comparator is a <code>Comparator&lt;E&gt;</code> object.
 * @param <E> The element type of this linked list.
 */
public class OrderedLinkedList<E extends Comparable<E>> {
	/**
	 * The head node of the <code>OrderedLinkedList</code>; the first <code>Node&lt;E&gt;</code
	 * of an ordered linked list.
	 */
	private Node<E> myHead;
	/**
	 * Indicates whether a <code>Node&lt;E&gt;</code> object is
	 * successfully added into the ordered linked list or not. True if
	 * added; false if not added.
	 */
	private boolean addSuccessful;
	/**
	 * Indicates whether a <code>Node&lt;E&gt;</code> object is
	 * successfully removed from the ordered linked list or not.
	 * True if removed; false if not removed.
	 */
	private boolean deleteSuccessful;
	/**
	 * The element to be added into the ordered linked list.
	 */
	private E objectBeingInserted;
	/**
	 * The element to be removed from the ordered linked list.
	 */
	private E objectBeingDeleted;
	/**
	 * The element to search for in the ordered linked list.
	 */
	private E objectSearchingFor;
	/**
	 * The comparator of the ordered linked list to compare/order
	 * <code>Node&lt;E&gt;</code> objects.
	 */
	private Comparator<E> myComparator;
	
	/**
	 * Constructs a new <code>OrderedLinkedList</code> with
	 * the head node and the comparator defaulted to null.
	 */
	public OrderedLinkedList(){
		myHead = null;
		myComparator = null;
	}//0-parameter constructor

	/**
	 * Constructs a new <code>OrderedLinkedList</code> with the
	 * given comparator while the head node is defaulted to null.
	 * @param theComparator The given comparator to order the 
	 * ordered linked list.
	 */
	public OrderedLinkedList(Comparator<E> theComparator){
		myHead = null;
		myComparator = theComparator;
	}//1-parameter constructor
	
	/**
	 * Concatenates each <code>Node&lt;E&gt;</code>'s
	 * data into a <code>String</code> format.
	 * @return Returns the data from the ordered linked list
	 * in a <code>String</code> format.
	 */
	public String toString(){
		String toReturn = "";
		Node<E> mover = myHead;
		while(mover != null){
			toReturn += mover.myData;
			mover = mover.myLink;
		}//while move does not point to null
		return toReturn;
	}//toString method
	
	/**
	 * Invokes the private insert method starting from the head
	 * node to insert the given element. Initializes addSuccessful
	 * to false and passes the head node to be traced in the private
	 * insert method. Assigns the given element as objectBeingInserted.
	 * @param toInsert The given element to be added into the
	 * <code>OrderedLinkedList</code>.
	 * @return Returns addSuccessful: true if the given element
	 * is successfully added into the ordered linked list. Returns false
	 * if the given element is not successfully added into the ordered
	 * linked list.
	 */
	public boolean insert(E toInsert){
		addSuccessful = false;
		objectBeingInserted = toInsert;
		myHead = insert(myHead);
		return addSuccessful;
	}//insert method
	
	/**
	 * Inserts objectBeingInserted into the ordered linked list as a
	 * <code>Node&lt;E&gt;</code> object by tracing the ordered
	 * linked list with the given head node from the public insert
	 * method. Determines where to insert objectBeingInserted
	 * relative to the nodes in the linked list using comparison
	 * declared by the comparator. Sets addSuccessful to true if
	 * objectBeingInserted is added to the ordered linked list.
	 * @param currentHead The given head node of a <code>Node&lt;E&gt;</code>
	 * object used to trace through the ordered linked list.
	 * @return Returns the value of currentHead.
	 */
	private Node<E> insert(Node<E> currentHead){
		if (currentHead == null){
			addSuccessful = true;
			return new Node<E>(objectBeingInserted);
		}//if
		if (currentHead.myData.compareTo(objectBeingInserted) > 0){
			addSuccessful = true;
			return new Node<E>(objectBeingInserted, currentHead);
		}//if
		currentHead.myLink = insert(currentHead.myLink);
		return currentHead;
	}//insertInOrder method
	
	/**
	 * Determines if the ordered linked list should be ordered by
	 * natural ordering or the ordering declared by the comparator;
	 * compares two given <code>E</code> objects to see if one is
	 * before, after or identical to the other.
	 * @param obj1 The first given <code>E</code> object to compare.
	 * @param obj2 The second given <code>E</code> object to compare.
	 * @return Returns a negative value if the first given object is before 
	 * the second given object. Returns a positive value if the first given
	 * object is after the second given object. Returns the value 0 if
	 * both give objects are identical to each other.
	 */
	private int myCompare(E obj1, E obj2){
		if(myComparator == null){
			return obj1.compareTo(obj2);
		}//for natural ordering
		return myComparator.compare(obj1, obj2);
	}//myCompare method
	
	/**
	 * Invokes the private delete method starting from the
	 * head node to remove the given element. Initializes
	 * deleteSuccessful to false. Assigns the given element
	 * as objectToDelete. Passes the head node to be traced
	 * in the private delete method.
	 * @param toDelete The given element of a type <code>E</code>
	 * object to be deleted.
	 * @return Returns deleteSuccessful: true if objectToDelete is
	 * successfully removed from the ordered linked list; false if
	 * objectToDelete is not successfully removed from the ordered
	 * linked list.
	 */
	public boolean delete(E toDelete) {
		deleteSuccessful = false;
		objectBeingDeleted = toDelete;
		myHead = delete(myHead);
		return deleteSuccessful;
	}//public delete method
	
	/**
	 * Removes the objectToDelete from the ordered linked list as a
	 * <code>Node&lt;E&gt;</code> object by tracing the ordered linked
	 * list with the given head node from the public delete method. Uses
	 * the comparator to determine which <code>Node&lt;E&gt;</code>
	 * in the ordered linked list should be removed and which node to
	 * be re-linked after removal. Sets deleteSuccessful to true if objectToDelete 
	 * is removed from the ordered linked list.
	 * @param currentHead The given head node of a <code>Node&lt;E&gt;</code>
	 * object used to trace the ordered linked list.
	 * @return Returns the value of currentHead.
	 */
	private Node<E> delete(Node<E> currentHead) {
		if (currentHead == null) { 
			deleteSuccessful = false;
			return currentHead;
		} // We got to the end of the list.
		if (objectBeingDeleted.equals(currentHead.myData)) {
			deleteSuccessful = true;
			return currentHead;
		}//check if it is the first item
		if (myCompare (currentHead.myData, objectBeingDeleted) > 0) {
			deleteSuccessful = false;
			return currentHead;
		} //We no longer need to look anymore to delete
		//we need to continue looking for the correct position
		//currentHead's link field may be the pointer that needs
		//to be reassigned to point to the new Node 
		currentHead.myLink = delete(currentHead.myLink);
		return currentHead;
		}//private delete method

	/**
	 * Invokes the private search method starting from the head node to look for
	 * the given element. Passes the head node to be traced in the private search
	 * method and assigns the given element as objectSearchingFor.
	 * @param findMe The given element of type <code>E</code> object
	 * to be searched for. 
	 * @return Returns the returned value from the private search method.
	 */
	public E search(E findMe){
		objectSearchingFor = findMe;
		return search(myHead);
	}//search method
	
	/**
	 * Looks for objectSearchingFor in the ordered linked list as a <code>Node&lt;E&gt;</code>
	 * object by tracing the ordered linked list with the given head node from the public
	 * search method.
	 * @param currentHead The given head node of a <code>Node&lt;E&gt;</code> object
	 * used to trace the ordered linked list.
	 * @return Returns the value null if no <code>Node&lt;E&gt;</code> objects in the
	 * ordered linked list are identical to objectSearchingFor. Returns the <code>Node&lt;E&gt;</code>
	 * object in the ordered linked list if it is identical to the objectSearchingFor.
	 */
	private E search(Node<E> currentHead){
		if (currentHead == null || 
				myCompare(currentHead.myData, objectSearchingFor) >0){
			return null;
		}//if current list is empty, or first item is 
		//alphabetically greater than what we want to find
		if (currentHead.equals(objectSearchingFor)){
			return currentHead.myData;
		}//if the first item is the item we want to find
		currentHead = currentHead.myLink;
		search(objectSearchingFor);
		return null;
	}//search method
	
}//OrderedLinkedList class
