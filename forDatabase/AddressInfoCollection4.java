package forDatabase;

//Ching Yu

import java.io.*;
import java.util.*;

/**
 * An AddressInfoCollection4 class has an <code>AddressInfoCollection4</code>
 * object consisting of a hash set. The hash set is a 
 * <code>HashSet&lt;AddressInfo&gt;</code> object.
 */
public class AddressInfoCollection4 {
	/**
	 * The hash set of the type <code>AddressInfo</code>.
	 */
	private HashSet<AddressInfo>mySet;
	
	/**
	 * Constructs a new <code>AddressInfoCollection4</code> with
	 * no parameters.
	 */
	public AddressInfoCollection4(){
		mySet = new HashSet<AddressInfo>();
	}//0-parameter constructor
	
	/**
	 * Searches the hash set from the <code>AddressInfoCollection4</code>
	 * to see if the given <code>AddressInfo</code> object is in the collection or not
	 * with the hash set's iterator.
	 * @param findMe The given <code>AddressInfo</code> object to search for.
	 * @return Returns null when the given object is not found using the contains method.
	 * Otherwise, returns the returned value obtained from using the hash set's contains method.
	 */
	public AddressInfo search(AddressInfo findMe){
		if(mySet.contains(findMe)){
			return null;
		}//if findMe is not in the HashSet
		Iterator<AddressInfo> itr =
			mySet.iterator();
		while(itr.hasNext()){
			AddressInfo fromHashSet =
				itr.next();
			if(fromHashSet.equals(findMe)){
				return fromHashSet;
			}//found findMe
		}//while
		System.out.println("contains " +
				"and equals not conmpatible");
		return null;
	}//search method 
	
	/**
	 * Inserts the given <code>AddressInfo</code> object in
	 *the hash set in the <code>AddressInfoCollection4</code>
	 * only if there are no duplicates found using the contains and add method.
	 * @param insertMe The given <code>AddressInfo</code> object to insert
	 * into the hash set.
	 * @return Returns false if there are duplicates and the given <code>AddressInfo</code>
	 * object is not added into the hash tree set. Returns true if
	 * there are no duplicates and the given <code>AddressInfo</code> object is added into
	 * the hash set.
	 */
	public boolean insert(AddressInfo insertMe){
		if(mySet.contains(insertMe)){
			return false;
		}//if duplicate is found
		return mySet.add(insertMe);
	}//insert method
	
	/**
	 * Removes the given <code>AddressInfo</code> object from 
	 * hash set in the <code>AddressInfoCollection4</code>
	 * only if it is found by using the hash set's contains method.
	 * @param deleteMe The given <code>AddressInfo</code> object to be removed
	 * from the hash set.
	 * @return Returns false if the given <code>AddressInfo</code>
	 * object is not found in the hash set, and is not removed
	 * from the hash set. Returns true if the given <code>AddressInfo</code> object is found
	 * and removed from the hash set.
	 */
	public boolean delete(AddressInfo deleteMe){
		if(!mySet.contains(deleteMe)){
			return false;
		}//if info is not in hash set
		return mySet.remove(deleteMe);
	}//delete method
	
	/**
	 * Sorts the hash set by alphabetical order by constructing a
	 * local <code>TreeSet&lt;AddressInfo&gt;</code> with no parameters
	 * (to use its addAll method to insert all information from the hash set 
	 * to the alphabetical tree set for sorting alphabetically)
	 * and returns the hash set in string format, using an enhanced for loop.
	 * @return Returns the alphabetical tree set in string format after
	 * sorting by alphabetical order.
	 */
	public String toStringAlphabetical(){
		TreeSet<AddressInfo> myAlphaList =
			new TreeSet<AddressInfo>();
		myAlphaList.addAll(mySet);
		String toReturn = "";
		for(AddressInfo fromTree :myAlphaList){
			toReturn += fromTree + "\n";
		}//for
		return toReturn;
	}//toStringAlphabetical method by natural ordering
	
	/**
	 * Sorts the hash set by address order by constructing a
	 * local <code>TreeSet&lt;AddressInfo&gt;</code> with an address comparator
	 * (to use its addAll method to insert all information from the hash set 
	 * to the address tree set for sorting by address order)
	 * and returns the hash set in string format, using an enhanced for loop.
	 * @return Returns the address tree set in string format after
	 * sorting by address order.
	 */
	public String toStringByAddress(){
		TreeSet<AddressInfo> myAddList =
			new TreeSet<AddressInfo>(AddressInfo.ADDRESS_COMPARATOR);
		myAddList.addAll(mySet);
		String toReturn = "";
		for(AddressInfo fromTree :myAddList){
			toReturn += fromTree + "\n";
		}//for
		return toReturn;
	}//toStringByAddress method by address ordering
	//using enhanced for loop
	
	/**
	 * Saves the data of the hash set to a given
	 * file name using the hash set's iterator for every array indices.
	 * @param fileName The given file name of a <code>String</code> format.
	 * @return Returns an error message if there is any. Otherwise, 
	 * returns an empty string for the error message if there are none. 
	 */
	public String saveToFile(String fileName){
		String messageFromSave = "";
		try {
			ObjectOutputStream oOS = 
				new ObjectOutputStream 
				(new FileOutputStream(fileName));
			Iterator<AddressInfo> itr =
				mySet.iterator();
			while(itr.hasNext()){
				oOS.writeObject(itr.next())	;	
			}//while
			oOS.flush(); 
			oOS.close(); 
		} //try
		catch(Exception e) {
			messageFromSave += e.toString();
		} //catch
		return messageFromSave;
	}//saveToFile method
	
	/**
	 * Loads the data of the AddressInfoCollection4 from the file
	 * with the specified given file name.
	 * @param fileName The given file name of an <code>String</code> format.
	 * @return Returns the data of the <code>AddressInfoCollection4</code>
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
						toReturn += fromFile + " successfully added to the database.\n";
					}else {
						toReturn += fromFile + " not successfully added to the database.\n";
					}//inner else
				}else {
					toReturn += found + " already in database.\n"
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
	
}//AddressInfoCollection4 class

