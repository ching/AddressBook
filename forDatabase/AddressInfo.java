package forDatabase;

//Ching Yu


import java.util.*;
import java.io.*;

/**
 * An AddressInfo class has an <code>Address</code> object consisting of a static address comparator,
 * name, and address. The address comparator is of a <code>Comparator</code> object.
 * The name is of a <code>Name</code> object. The address is of a <code>Address</code> object.
 */
public class AddressInfo implements Serializable,Comparable<AddressInfo>{ //1b
	/**
	 * The unchangeable address comparator of the <code>AddressComp</code> class
	 * used to compare by address ordering..
	 */
	public static final AddressComp 
		ADDRESS_COMPARATOR  = new AddressComp();
	/**
	 * The name of an <code>AddressInfo</code>.
	 */
	private Name myName;
	/**
	 * The address of an <code>AddressInfo</code>.
	 */
	private Address myAddress;

	/**
	 * Constructs a new <code>AddressInfo</code> with the given last name,
	 * first name, street, optional line, city, state, and zipcode. The given last name
	 * and first name are passed as parameters to construct a new <code>Name</code>
	 * object. The street, optional line, city, state, and zipcode are passed as parameters
	 * to construct a new <code>Address</code> object.
	 * @param theLast The given last name.
	 * @param theFirst The given first name.
	 * @param theStreet The given street address.
	 * @param theLine The given optional address line.
	 * @param theCity The given city of the.
	 * @param theState The given state.
	 * @param theZipCode The given zipcode.
	 */
	public AddressInfo(String theLast, String theFirst, 
			String theStreet, String theLine, String theCity, 
			String theState, String theZipCode) {
		myName = new Name(theLast, theFirst);
		myAddress = new Address(theStreet, theLine, theCity, 
				theState, theZipCode);
	}//7-parameter constructor

	/**
	 * Constructs a new <code>AddressInfo</code> with the given last name,
	 * first name, street, optional line, city, state, and zipcode. The last name
	 * and the first name are passed as parameters to construct a new <code>Name</code>
	 * object. The street, city, state, and zipcode are passed as parameters to
	 * construct a new <code>Address</code> object; optional line is set to empty
	 * string as a default.
	 * @param theLast The given last name.
	 * @param theFirst The given first name.
	 * @param theStreet The given street address.
	 * @param theCity The given city of the.
	 * @param theState The given state.
	 * @param theZipCode The given zipcode.
	 */
	public AddressInfo(String theLast, String theFirst, 
			String theStreet, String theCity, 
			String theState, String theZipCode) {
		myName = new Name(theLast, theFirst);
		myAddress = new Address(theStreet, theCity, 
				theState, theZipCode);
	}//6-parameter constructor

	/**
	 * Constructs a new <code>AddressInfo</code> with the given last name
	 * and first name only. The last name and first name are passed as parameters
	 * to construct a new <code>Name</code> object; also constructs a default
	 * <code>Address</code> object with no parameters.
	 * @param theLast The given last name.
	 * @param theFirst The given first name.
	 */
	public AddressInfo(String theLast, String theFirst) {
		myName = new Name(theLast, theFirst);
		myAddress = new Address();
	}//2-parameter constructor

	/**
	 * Returns the name from the <code>AddressInfo</code>.
	 */
	public Name getName() {
		return myName;
	}//access method for name instance variable

	/**
	 * Returns the address  from the <code>AddressInfo</code>.
	 */
	public Address getAddress() {
		return myAddress;
	}//access method for address instance variable

	/**
	 * Modifies the name from the <code>AddressInfo</code> with the given name.
	 * @param theName The given name.
	 */
	public void setName(Name theName) {
		myName = theName;
	}//modifier method for name instance variable

	/**
	 * Modifies the address from the <code>AddressInfo</code> with the given address.
	 * @param theAddress The given address.
	 */
	public void setAddress(Address theAddress) {
		myAddress = theAddress;
	}//modifier method for address instance variable

	/**
	 * Returns the AddressInfo in the string format: name address.
	 */
	public String toString() {
		return myName + " " + myAddress;
	} //toString method to return data in String format

	/**
	 * Compares AddressInfos to see if they are identical.
	 * @param theOther The given object to compare (will be
	 * casted as an <code>AddressInfo</code> object.
	 * @return Returns true if the given AddressInfo is identical to the 
	 * AddressInfo being compared to. Returns false if the given AddressInfo 
	 * is not identical to the AddressInfo being compared to.
	 */
	public boolean equals(Object theOther) {
		AddressInfo theAddressInfo = (AddressInfo)theOther;
		return myName.equals(theAddressInfo.myName);
	}//equals boolean method: if two names are identical

	/**
	 * Compares AddressInfos to see if one is alphabetically before the other.
	 * @param theAddressInfo The given AddressInfo to compare,
	 * @return Returns true if the compare value is less than 0, meaning the
	 * given AddressInfo is alphabetically before the AddressInfo being compared to.
	 * Returns false if the compare value is not less than 0, meaning the given
	 * AddressInfo is not alphabetically before the AddressInfo being compared to.
	 */
	public boolean beforeAlpha(AddressInfo theAddressInfo) {
		return compareTo(theAddressInfo)<0;
	}//beforeAlpha boolean method: true if the invoking object is before

	/**
	 * Compares the AddressInfo to see if one is before the other by address ordering.
	 * @param theAddressInfo The given AddressInfo to compare.
	 * @return Returns true if the compare value is less than 0, meaning the given
	 * AddressInfo is before the AddresInfo being compared to by address ordering.
	 * Returns false if the compare value is not less than 0, meaning the given
	 * AddressInfo is not before the AddressInfo being compared to by address ordering.
	 */
	public boolean beforeAddress(AddressInfo theAddressInfo) {
		return myAddress.before(theAddressInfo.myAddress) 
		|| (myAddress.equals(theAddressInfo.myAddress)
				&& compareTo(theAddressInfo)<0);
	}//beforeAddress boolean method: true if the Address is before

	/**
	 * Compares AddressInfos to see if one is alphabetically before, after, 
	 * or identical as the other.
	 * @param theAddressInfo The given AddressInfo to compare.
	 * @return Returns a negative value if the given AddressInfo is alphabetically
	 *  before the AddressInfo being compared to. Returns a positive value if the
	 *  given AddressInfo is after the AddressInfo being compared to. Returns the 
	 *  value 0 if the given AddressInfo is identical to the AddressInfo being comared to.
	 */
	public int compareTo(AddressInfo theAddressInfo){
		return myName.compareTo(theAddressInfo.myName);
	}//compareTo method

	/**
	 *An unchangeable <code>AddressComp</code> class that has a comparator
	 *to compare <code>AddressInfo</code> objects. 
	 */
	private static class AddressComp implements Comparator<AddressInfo>{
		/**
		 * Compares one given AddressInfo to the second given AddressInfo to
		 * see if one is before, after, or identical to the other by address ordering
		 * as the first determinant and alphabetical ordering as the secondary
		 * determinant .
		 * @param a1 The first given AddressInfo to compare.
		 * @param a2 The second given AddressInfo to compare.
		 * @return Returns a negative value if the first given AddressInfo is 
		 * before the second given AddressInfo. Returns a positive value if 
		 * the first given AddressInfo is after the second given AddressInfo
		 * Returns the value 0 if the two given AddressInfos are identical.
		 */
		public int compare(AddressInfo aI1, AddressInfo aI2){
			int resultOfAddressCompareTo = 
				aI1.myAddress.compareTo(aI2.myAddress);
			if(resultOfAddressCompareTo != 0){
				return resultOfAddressCompareTo;
			}//if
			return aI1.myName.compareTo(aI2.myName);
		}//compare
	}//AddressComp class
	
}//AddressInfo class
