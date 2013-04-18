package forDatabase;

//Ching Yu


import java.io.EOFException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * An AddressInfoCollection class has an <code>AddressInfoCollection</code>
 * object consisting of a name/alphabetical list and an address list. Both lists
 * are of the <code>List&lt;AddressInfo&gt;</code> objects.
 */
public class AddressInfoCollection {
	/**
	 * The list of <code>AddressInfo</code> that can be ordered alphabetically.
	 */
	private List<AddressInfo> myAlphaList;
	/**
	 * The list of <code>AddressInfo</code> that can be ordered by address.
	 */
	private List<AddressInfo> myAddList;

	/**
	 * Constructs a new <code>AddressInfoCollection</code> with
	 * no parameters, but constructs a new alphabetical list with no
	 * comparators and a new address list with an address comparator.
	 */
	public AddressInfoCollection(){
		myAlphaList = new List<AddressInfo>();
		myAddList = new List<AddressInfo>(
				AddressInfo.ADDRESS_COMPARATOR);
	}//0 parameter constructor
	
	/**
	 * Searches the alphabetical list from the <code>AddressInfoCollection</code>
	 * to see if the given <code>AddressInfo</code> object is in the collection or not.
	 * @param findMe The given <code>AddressInfo</code> object to search for.
	 * @return Returns the returned value obtained from using the
	 * alphabetical list's search method.
	 */
	public AddressInfo search(AddressInfo findMe){
		return myAlphaList.search(findMe);
	}//search by name
	
	/**
	 * Inserts the given <code>AddressInfo</code> object in
	 * both the alphabetical and address lists in the <code>AddressInfoCollection</code>.
	 * @param insertMe The given <code>AddressInfo</code> object to insert
	 * into both the alphabetical list and the address list.
	 * @return Returns false if there are duplicates and the given <code>AddressInfo</code>
	 * object is not added into both the alphabetical list and address list. Returns true if
	 * there are no duplicates and the given <code>AddressInfo</code> object is added into
	 * both the alphabetical list and address list.
	 */
	public boolean insert(AddressInfo insertMe){
		AddressInfo found = search(insertMe);
		if(found != null){
			return false;
		}//if there are duplicates
		return myAlphaList.add(insertMe) &&
					myAddList.add(insertMe);
	}//insert in both lists
	
	/**
	 * Removes the given <code>AddressInfo</code> object from both 
	 * the alphabetical and address lists in the <code>AddressInfoCollection</code>.
	 * @param deleteMe The given <code>AddressInfo</code> object to be removed
	 * from both the alphabetical list and the address list.
	 * @return Returns false if the given <code>AddressInfo</code>
	 * object is not found in both the alphabetical list and address list, and is not removed
	 * from the lists. Returns true if the given <code>AddressInfo</code> object is found
	 * and removed from both the alphabetical list and address list.
	 */
	public boolean delete(AddressInfo deleteMe){
		AddressInfo found = search(deleteMe);
		if(found == null){
			return false;
		}//if duplicate
		return myAlphaList.delete(deleteMe) &&
					myAddList.delete(deleteMe);
	}//delete from both lists
	
	/**
	 * Sorts the alphabetical list by natural ordering (alphabetically)
	 * and returns the alphabetical list in string format.
	 * @return Returns the alphabetical list in string format after
	 * sorting by natural order.
	 */
	public String toStringAlphabetical(){
		myAlphaList.sort();
		return myAlphaList.toString();
	}//toStringAlphabetical
	
	/**
	 * Sorts the address list by address ordering (using address comparator)
	 * and returns the address list in string format.
	 * @return Returns the address list in string format after sorting by
	 * address order.
	 */
	public String toStringByAddress(){
		myAddList.sort();
		return myAddList.toString();
	}//toStringByAddress
	
	/**
	 * Saves the data of the alphabetical list to a given
	 * file name.
	 * @param fileName The given file name of a <code>String</code> format.
	 * @return Returns value from the alphabetical search method:  an error message 
	 * if there is any. Returns an empty string for the error message if there are none. 
	 */
	public String saveToFile(String fileName){
		return myAlphaList.saveToFile(fileName);
	}//saveToFile
	
	/**
	 * Loads the data of the AddressInfoCollection from the file
	 * with the specified given file name.
	 * @param fileName The given file name of an <code>String</code> format.
	 * @return Returns the data of the <code>AddressInfoCollection</code>
	 * from a file in a <code>String</code> format.
	 */
	public String loadFromFile(String fileName){
		String toReturn = "";
		try {
			ObjectInputStream oIS = 
				new ObjectInputStream(new FileInputStream(fileName));
			while(true) {
				AddressInfo fromFile = (AddressInfo)(oIS.readObject());
				AddressInfo found = search(fromFile);
				if(found == null) { // not found
					if(insert(fromFile)) {
						toReturn += fromFile + " successfully added.\n";
					} else {
						toReturn += fromFile + "not successfully added.\n";
					} // inner if/else
				} else {
					toReturn += found + "already found. \n Record not added.\n";
				} //if/else
			} //while
		} //try
		catch(EOFException eOF){	
		}//catch
		catch(Exception e){
			toReturn += e;
		} //catch
		return toReturn;
	}//loadFromFile
	
	/**
	 * Determines if the <code>AddressInfoCollection</code> is 
	 * full by calling the isFull method from both the alphabetical and
	 * address lists.
	 * @return Returns the returned values from isFull methods of
	 * alphabetical and address list: true if either lists are full, false if
	 * either lists have space.
	 */
	public boolean isFull(){
		return myAlphaList.isFull()
				||myAddList.isFull();
	}//isFull method
	
}//AddressInfoCollection class
