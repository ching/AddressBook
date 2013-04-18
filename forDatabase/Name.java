package forDatabase;
import java.io.*;

//Ching Yu

/**
 * A Name class has a <code>Name</code> object consisting first name/last name pair, 
 * which both first name and last name are of <code>String</code> objects.
 */
public class Name implements Serializable, Comparable<Name>{
	/**
	 * The first name.
	 */
	private String myFirst; //reference to the first name
	/**
	 * The last name.
	 */
	private String myLast; //reference to the last name
	
	/**
	 * Constructs a new <code>Name</code> with the given last name and first name.
	 * @param theLast The given last name.
	 * @param theFirst The given first name.
	 */
	public Name(String theLast, String theFirst) {
		myLast = theLast;
		myFirst = theFirst;
	}//2-parameter constructor
	
	/**
	 * Returns the first name of a <code>Name</code>.
	 */
	public String getFirst() {
		return myFirst;
	}//access method for first name instance variable
	
	/**
	 * Modifies the first name of a <code>Name</code>.
	 * @param theFirst The given first name.
	 */
	public void setFirst(String theFirst ) {
		myFirst = theFirst;
	}//modifier method for first name instance variable
	
	/**
	 * Returns the last name of <code>Name</code>.
	 */
	public String getLast() {
		return myLast;
	}//access method for family name instance variable
	
	/**
	 * Modifies the last name of a <code>Name<code>.
	 * @param theLast The given last name.
	 */
	public void setLast(String theLast ) {
		myLast = theLast;
	}//modifier method for family name instance variable
	
	/**
	 * Compares names to see if they are identical. Overrides the
	 * <code>equals</code> method of the <code>Object</code> class.
	 * @param theOther The given object being compared to
	 * (will be casted as a  <code>Name</code> object.
	 * @return Returns true if the given name is identical as the name
	 *  being compared to. Returns false if the given name is not identical
	 *  as the name being compared to.
	 */
	public boolean equals(Object theOther) {
		Name theName = (Name)theOther;
		return compareTo(theName)==0;
	}//boolean method: if two names are identical
	
	/**
	 * Compares names to see if one is alphabetically before the other.
	 * @param theName The given name used to compare.
	 * @return Returns true if the compare value is less than 0, meaning
	 * the given name is alphabetically before the name being compared to.
	 * Returns false if the compare value is not less than 0, meaning the
	 * given name is not alphabetically before the name being compared to.
	 */
	public boolean before(Name theName) {
		return compareTo(theName)<0;
	}//boolean method: true if the invoking object is before
	
	/**
	 * Compares names to see if one is alphabetically before, after, or 
	 * identical as the other. The last name is the prior determinant, and
	 * the first name is the secondary determinant to compare. 
	 * @param theName The given name used to compare.
	 * @return Returns a negative value if the given name is alphabetically before
	 * the name being compared to. Returns a positive value if the given name is
	 * alphabetically after the name being compared to. Returns the value 0 if the
	 * given name is identical to the name being compared to.
	 */
	 public int compareTo(Name theName){
		 int compareLast = myLast.compareTo(theName.myLast);
		 if (compareLast != 0){
			 return compareLast;
		 }//if
		return myFirst.compareTo(theName.myFirst);
	 }//compareTo method
	 
	 /**
	  * Returns the name in the string format: last name, first name.
	  */
	 public String toString() {
		return myLast + ", " + myFirst;
	}//toString method
	 
}//Name class
