package forDatabase;

//Ching Yu


import java.io.*;
import java.util.*;
import java.util.TreeSet;

/**
 * An AddressInfoCollection3 class has an <code>AddressInfoCollection3</code>
 * object consisting of a name/alphabetical tree set and an address tree set. 
 * Both tree sets are of the <code>TreeSet&lt;AddressInfo&gt;</code> objects.
 */
public class AddressInfoCollection3 {
	/**
	 * The tree set of <code>AddressInfo</code> that can be ordered by address.
	 */
	private TreeSet<AddressInfo> myAddTree; 
	/**
	 * The tree set of <code>AddressInfo</code> that can be ordered alphabetically.
	 */
	private TreeSet<AddressInfo>  myAlphaTree;
	
	/**
	 * Constructs a new <code>AddressInfoCollection3</code> with
	 * no parameters, but constructs a new alphabetical tree set with no
	 * comparators and a new address tree set with an address comparator.
	 */
	public AddressInfoCollection3(){
		myAlphaTree = new TreeSet<AddressInfo>();
		myAddTree = new TreeSet<AddressInfo>(
				AddressInfo.ADDRESS_COMPARATOR);
	}//0-parameter constructor
	
	/**
	 * Searches the alphabetical tree set from the <code>AddressInfoCollection3</code>
	 * to see if the given <code>AddressInfo</code> object is in the collection or not with an iterator.
	 * @param findMe The given <code>AddressInfo</code> object to search for.
	 * @return Returns null when the given object is not found using the contains method.
	 * Returns the returned value obtained from using the alphabetical tree set's contains method.
	 */
	public AddressInfo search(AddressInfo findMe){
		if(!myAlphaTree.contains(findMe)){
			return null;
		}//if findMe is not in the TreeSet
		Iterator<AddressInfo> alphaItr =
			myAlphaTree.iterator();
		while(alphaItr.hasNext()){
			AddressInfo fromTreeSet =
				alphaItr.next();
			if(fromTreeSet.equals(findMe)){
				return fromTreeSet;
			}//found findMe
		}//while
		System.out.println("contains " +
				"and equals not conmpatible");
		return null;
	}//search method 
	
	/**
	 * Inserts the given <code>AddressInfo</code> object in
	 * both the alphabetical and address tree sets in the <code>AddressInfoCollection3</code>
	 * only if there are no duplicates found using the contains and add method.
	 * @param insertMe The given <code>AddressInfo</code> object to insert
	 * into both the alphabetical tree set and the address tree set.
	 * @return Returns false if there are duplicates and the given <code>AddressInfo</code>
	 * object is not added into both the alphabetical tree set and address tree set. Returns true if
	 * there are no duplicates and the given <code>AddressInfo</code> object is added into
	 * both the alphabetical tree set and address tree set.
	 */
	public boolean insert(AddressInfo insertMe){
		if(myAlphaTree.contains(insertMe)){
			return false;
		}//if duplicate
		return myAlphaTree.add(insertMe) &&
					myAddTree.add(insertMe);
	}//insert method
	
	/**
	 * Removes the given <code>AddressInfo</code> object from both 
	 * the alphabetical and address tree sets in the <code>AddressInfoCollection3</code>
	 * only if it is found by using the search method.
	 * @param deleteMe The given <code>AddressInfo</code> object to be removed
	 * from both the alphabetical tree set and the address tree set.
	 * @return Returns false if the given <code>AddressInfo</code>
	 * object is not found in both the alphabetical tree set and address tree set, and is not removed
	 * from the tree sets. Returns true if the given <code>AddressInfo</code> object is found
	 * and removed from both the alphabetical tree set and address tree set.
	 */
	public boolean delete(AddressInfo deleteMe){
		AddressInfo found = search(deleteMe);
		if(found == null){
			return false;
		}//if duplicate
		return myAlphaTree.remove(deleteMe) &&
					myAddTree.remove(deleteMe);
	}//delete method
	
	/**
	 * Sorts the alphabetical tree set by natural ordering (alphabetically)
	 * and returns the alphabetical tree set in string format, using an
	 * enhanced for loop.
	 * @return Returns the alphabetical tree set in string format after
	 * sorting by natural order.
	 */
	public String toStringAlphabetical(){
		String toReturn = "";
		for(AddressInfo fromTree: myAlphaTree){
			toReturn += fromTree + "\n\n";
		}//for
		return toReturn;
	}//toString method by natural ordering
	
	/**
	 * Sorts the address tree set by address ordering (using address comparator)
	 * and returns the address tree set in string format, using an enhanced for loop.
	 * @return Returns the address tree set in string format after sorting by
	 * address order.
	 */
	public String toStringByAddress(){
		String toReturn = "";
		for(AddressInfo fromTree: myAddTree){
			toReturn += fromTree + "\n\n";
		}//for
		return toReturn;
	}//toString method by address ordering
	
	/**
	 * Saves the data of the alphabetical tree set to a given
	 * file name using an iterator for every array indices.
	 * @param fileName The given file name of a <code>String</code> format.
	 * @return Returns value from the alphabetical search method:  an error message 
	 * if there is any. Returns an empty string for the error message if there are none. 
	 */
	public String saveToFile(String fileName){
		String messageFromSave = "";
		try {
			ObjectOutputStream oOS = 
				new ObjectOutputStream 
				(new FileOutputStream(fileName));
			Iterator<AddressInfo> alphaItr =
				myAlphaTree.iterator();
			while(alphaItr.hasNext()){
				oOS.writeObject(alphaItr.next())	;	
			}//while
			oOS.flush(); 
			oOS.close(); 
		} //try
		catch(Exception e) {
			messageFromSave += e.toString();
		} //catch
		return messageFromSave;
	}//saveToFile by natural ordering
	
	/**
	 * Loads the data of the AddressInfoCollection3 from the file
	 * with the specified given file name.
	 * @param fileName The given file name of an <code>String</code> format.
	 * @return Returns the data of the <code>AddressInfoCollection3</code>
	 * from a file in a <code>String</code> format.
	 */
	public String loadFromFile(String fileName){
		String toReturn = "";
		try {
			ObjectInputStream oIS = 
				new ObjectInputStream(new FileInputStream(fileName));
			while(true) {
				AddressInfo fromFile = (AddressInfo)(oIS.readObject());
				AddressInfo found = (AddressInfo)search(fromFile); 
				if( found == null) { //person not already in DB
					if (insert(fromFile)) {
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
	
}//AddressInfoCollection3 class

