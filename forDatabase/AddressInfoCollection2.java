package forDatabase;

//Ching Yu


import java.io.*;

/**
 * An AddressInfoCollection2 class has an <code>AddressInfoCollection2</code>
 * object consisting of a name/alphabetical binary tree and an address binart tree. 
 * Both binary trees are of the <code>BinaryTree&lt;AddressInfo&gt;</code> objects.
 */
public class AddressInfoCollection2 {
	/**
	 * The binary tree of <code>AddressInfo</code> that can be ordered by address.
	 */
	private BinaryTree<AddressInfo> myAlphaTree; 
	/**
	 * The binary tree of <code>AddressInfo</code> that can be ordered alphabetically.
	 */
	private BinaryTree<AddressInfo> myAddTree;
	
	/**
	 * Constructs a new <code>AddressInfoCollection2</code> with
	 * no parameters, but constructs a new alphabetical binart tree with no
	 * comparators and a new address binary tree with an address comparator.
	 */
	public AddressInfoCollection2(){
		myAlphaTree = new BinaryTree<AddressInfo>();
		myAddTree = new BinaryTree<AddressInfo>(
				AddressInfo.ADDRESS_COMPARATOR);
	}//0-parameter constructor
	
	/**
	 * Searches the alphabetical binary tree from the <code>AddressInfoCollection2</code>
	 * to see if the given <code>AddressInfo</code> object is in the collection or not.
	 * @param findMe The given <code>AddressInfo</code> object to search for.
	 * @return Returns the returned value obtained from using the
	 * alphabetical binary tree's search method.
	 */
	public AddressInfo search(AddressInfo findMe){
		return myAlphaTree.search(findMe);
	}//search method 
	
	/**
	 * Inserts the given <code>AddressInfo</code> object in
	 * both the alphabetical and address binary trees in the <code>AddressInfoCollection2</code>.
	 * @param insertMe The given <code>AddressInfo</code> object to insert
	 * into both the alphabetical binary tree and the address binary tree.
	 * @return Returns false if there are duplicates and the given <code>AddressInfo</code>
	 * object is not added into both the alphabetical binary tree and address binary tree. Returns true if
	 * there are no duplicates and the given <code>AddressInfo</code> object is added into
	 * both the alphabetical binary tree and address binary tree.
	 */
	public boolean insert(AddressInfo insertMe){
		AddressInfo found = search(insertMe);
		if(found != null){
			return false;
		}//if
		return myAlphaTree.insert(insertMe)
		&& myAddTree.insert(insertMe);
	}//insert method
	
	/**
	 * Removes the given <code>AddressInfo</code> object from both 
	 * the alphabetical and address binary trees in the <code>AddressInfoCollection2</code>.
	 * @param deleteMe The given <code>AddressInfo</code> object to be removed
	 * from both the alphabetical binary tree and the address binary tree.
	 * @return Returns false if the given <code>AddressInfo</code>
	 * object is not found in both the alphabetical binary tree and address binary tree, and is not removed
	 * from the binary trees. Returns true if the given <code>AddressInfo</code> object is found
	 * and removed from both the alphabetical binary tree and address binary tree.
	 */
	public boolean delete(AddressInfo deleteMe){
		AddressInfo found = search(deleteMe);
		if(found == null){
			return false;
		}//if
		return myAlphaTree.delete(deleteMe) 
		&& myAddTree.delete(deleteMe);
	}//delete method
	
	/**
	 * Sorts the alphabetical binary tree by natural ordering (alphabetically)
	 * and returns the alphabetical binary tree in string format.
	 * @return Returns the alphabetical binary tree in string format after
	 * sorting by natural order.
	 */
	public String toStringAlphabetical(){
		return myAlphaTree.toString();
	}//toString method by natural ordering
	
	/**
	 * Sorts the address binary tree by address ordering (using address comparator)
	 * and returns the address binary tree in string format.
	 * @return Returns the address binary tree in string format after sorting by
	 * address order.
	 */
	public String toStringByAddress(){
		return myAddTree.toString();
	}//toString method by address ordering
	
	/**
	 * Saves the data of the alphabetical binary tree to a given
	 * file name.
	 * @param fileName The given file name of a <code>String</code> format.
	 * @return Returns value from the alphabetical search method:  an error message 
	 * if there is any. Returns an empty string for the error message if there are none. 
	 */
	public String saveToFile(String fileName){
		return myAlphaTree.saveToFile(fileName);
	}//saveToFile by natural ordering
	
	/**
	 * Loads the data of the AddressInfoCollection2 from the file
	 * with the specified given file name.
	 * @param fileName The given file name of an <code>String</code> format.
	 * @return Returns the data of the <code>AddressInfoCollection2</code>
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
	
}//AddressInfoCollection2 class
