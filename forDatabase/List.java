package forDatabase;

//Ching Yu


import java.io.*;
import java.util.*;
/**
 *A List class has a <code>List</code> object consisting of an elements array,
 *a count of elements in array, a static final count of positions in array, and a
 *comparator. The array contains  <code>E</code> objects. the count of 
 *elements is of an <code>int</code> object. The set count of positions in array
 *is a static final  <code>int</code> object. The comparator is of the <code>
 *&lt;Comparator&gt;</code> object.
 * @param <E> The element type of this list.
 */
public class List <E extends Comparable<E>> { //2
	/**
	 * The array of type <code>E</code> objects.
	 */
	private E myElements[]; //refers to the array of E
	/**
	 * The count of how many actual elements  are in the array.
	 */
	private int records;
	/**
	 * The set count of positions in the array; this count is initialized to 4
	 * and does not change.
	 */
	private static final int MAXIMUM = 4;
	/**
	 * The comparator of the array to compare type <code>E</code> objects.
	 */
	private Comparator<E> myComparator; //2a instance variable
	
	/**
	 * Constructs a new <code>List</code> with a new elements array with the
	 * set count, count of elements initialized to 0, and no comparator.
	 */
	public List() {
		myElements = (E[])new Comparable [MAXIMUM];
		records = 0;
		myComparator = null;
	}//0-parameter constructor
	
	/**
	 * Constructs a new <code>List</code> with a new elements array with
	 * the set count, count of elements initialized to 0, and with the given
	 * comparator.
	 * @param theComparator The given comparator.
	 */
	public List(Comparator<E> theComparator) {
		myElements = (E[])new Comparable [MAXIMUM];
		records = 0;
		myComparator = theComparator;
	}//1-parameter constructor
	
	/**
	 * Determines if the array should be ordered by natural ordering
	 * or the ordering declared by the comparator; compares
	 * two given <code>E</code> objects to see if one is before,
	 * after, or identical to the other.
	 * @param obj1 The first given <code>E</code> object to compare.
	 * @param obj2 The second given <code>E</code> object to compare
	 * @return Returns a negative value if the first given object is
	 * before the second given object. Returns a positive value if the
	 * first given object is after the second given object. Returns the
	 * value 0 if both given objects are identical to each other.
	 */
	private int myCompare(E obj1, E obj2){
		if(myComparator == null){
			return obj1.compareTo(obj2);
		}//for natural ordering
		return myComparator.compare(obj1, obj2);
	}//myCompare method
	
	/**
	 * Inserts the given element according to the relative position
	 * by comparing the given element to elements already in the array.
	 * Insert the given element only if there is space in array.
	 * Checks to see if the given element is already in array.
	 * Checks to see if the given element is before or after the elements in array.
	 * @param addMe The given element to compare and add. 
	 */
	public void addInOrder(E addMe){
		if (records < myElements.length){
			if (myCompare(addMe,myElements[records-1])<0){
				myElements[records++] = myElements[records-1];
				myElements[records-1] = addMe;
			}//if addMe is before the object
			if (myCompare(addMe,myElements[records-1]) >0){
				myElements[records++] = addMe;
			}//if addMe is after the object
			System.out.println("Attempting to add duplicate in array");
		}//check for space in array
		System.out.println("Attempting to add to a full array");
	}//addInOrder method
	
	/**
	 * Inserts the given element in the array with no comparison made.
	 * Insert the given element only when there is space in the array.
	 * Checks to see if the given element is already in the array.
	 * @param theInfo The given element to insert.
	 * @return Returns true if the given element is successfully
	 * added into the array: when there is space in the array, and/or
	 * there are no duplicates. Returns false if the given element is 
	 * not successfully added into the array: when there is no space
	 * in the array and/or there are duplicates. 
	 */
	public boolean add(E theInfo){
		if (records < myElements.length ) {
			if(search(theInfo)==null){
				myElements[records++] = theInfo;
				return true;
			}//if the AI to be inserted is not already in list
			System.out.println("Attempting to add duplicate name to array");
			return false;
		} // there was space in the list
		System.out.println("Attempting to add to full array");
		return false;
	}//add method
	 
	
	/**
	 * Returns a <code>List</code> in the string format of all
	 * the elements in the array, starting from position 0.
	 */
	public String toString(){
		String toReturn = "";
		for (int i =0; i < records; i++){
			toReturn += myElements[i] + "\n\n";
		}//for
		return toReturn;
	}//toString method
	
	/**
	 * Determines whether all positions in the array are filled
	 * up with elements.
	 * Checks to see if the count of elements in array equals
	 * to the length of the array.
	 * @return Returns true if the count of elements in array
	 * equals to the length of the array. Returns false if the
	 * count of the elements in array does not equal to the
	 * length of the array.
	 */
	public boolean isFull(){
		if (records == myElements.length){
			return true;
		}//if
		return false;
	}//isFull method
	
	/**
	 * Sorts/orders all the elements in array according to their relative
	 * positions when comparing the previous element
	 * to the current one. Checks to see if the position of the current
	 * element is within the valid range of the count of the elements in
	 * the array. If the current element is before the previous element,
	 * swap the positions of the current element and the previous
	 * element to remain in order.
	 */
	public void sort(){
		for (int i = 1; i < records; i++) {
			E toBeInserted = myElements[i];
			int posToCompare = i;
			while ( posToCompare > 0 
					&& myCompare(toBeInserted,myElements[posToCompare - 1])<0){
				myElements[posToCompare] = myElements[posToCompare - 1];
				posToCompare--;
			} //while to slide down array members bigger than valueBeingInserted
			myElements[posToCompare] = toBeInserted;
		} //outer for
	}//sort method
	
	/**
	 * Searches the array to see if the given element is in the array or not.
	 * @param theInfo The given element  to search for.
	 * @return Returns the element in the array if it is identical to the
	 * given element. Returns null if the given element is not found in
	 * array or search position is no longer in valid range.
	 */
	public E search(E theInfo){
		int i = 0;
		while (i < records && !(myElements[i].equals(theInfo))){
			i++;
		}//while not found
		return (i < records && myElements[i].equals(theInfo)
				? myElements[i] : null);
	}//search method
	
	/**
	 * Determines whether a given element is deleted
	 * from the array..
	 * Checks to see if the given element is in the
	 * array, within the valid element count range of
	 * the array.
	 * @param theInfo The given element of <code>E</code> object.
	 * @return Returns true if an element in the array
	 * is identical to the given element, and is also in
	 * valid element position range in array. Returns
	 * false if all the elements in array is not identical
	 * to the given element, and/or not in the valid
	 * element position range in array.
	 */
	public boolean delete(E theInfo){
		for (int i = 0; i < myElements.length; i++){
			if (myElements[i].equals(theInfo)){
				return true;
			}//if elements are the same
		}//for
		return false;
	}//delete method
	
	/**
	 * Determines the position that indexes the given
	 * element in the array.
	 * @param theInfo The given element of <code>E</code> object.
	 * @return Returns the position/index of the
	 * element that is identical to the given element.
	 */
	public  int positionIndex(E theInfo) {
		int i = 0;
		while (i >= 0 && i<myElements.length && !myElements[i].equals(theInfo)) {
			i ++;
		}//while
		return i;
	}//position index
	
	/**
	 * Removes the given element from the array.
	 * @param theInfo The given element of an <code>E</code> object.
	 */
	public void removeFromList(E theInfo){
		int pos = positionIndex(theInfo);
		if (myElements[pos].equals(theInfo)){
			for (int start = pos; start<myElements.length-1; start++){
				myElements[start] = myElements[start+1];
			}//else
			records--;
		}//if
	}//remove from List method
	
	/**
	 * Loads the data of the List from the file with the specified,
	 * given file name.
	 * @param fileName The given file name of an <code>String</code> format.
	 * @return Returns the  data of the List from a file in a <code>String</code>
	 * format. 
	 */
	public String loadFromFile(String fileName) {
		String toReturn = "";
		try {
			ObjectInputStream oIS = 
				new ObjectInputStream(new FileInputStream(fileName));
			while(true) {
				E fromFile = (E)(oIS.readObject());
				E found = (E)search(fromFile);
				if( found == null) { //person not already in DB
					if (add(fromFile)) {
						toReturn += fromFile + " successfully added to DB.\n";
					}else {
						toReturn += fromFile + " not successfully added to DB.\n";
					}//inner else
				}else {
					toReturn += found + " already in DB.\n"
								+ "record not added from file!\n";
				}//else
			}//while
		}//try
		catch(EOFException eOF) {
		}//catch
		catch(Exception e) {
			toReturn += e;
		}//catch
		return toReturn;
	}//loadFromFile method
	
	/**
	 * Saves the data of the List to a given file name.
	 * @param fileName The given file name of a <code>String</code> object.
	 * @return Returns an error message if there is any.
	 * Returns an empty string for the error message if
	 * there are no error message.
	 */
	public String saveToFile(String fileName) {
		String messageFromSave = "";
		try{
			ObjectOutputStream oOS = new ObjectOutputStream(
					new	FileOutputStream(fileName));
			for(int i = 0; i < records  ; i++) {
				oOS.writeObject(myElements[i]);
			}//for
			oOS.flush();
			oOS.close();
		}//try
		catch(Exception e) {
			messageFromSave = e.toString();
		}//catch
		return messageFromSave;
	}//saveToFile method

}//List class
