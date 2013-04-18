package forDatabase;
import java.io.*;

//Ching Yu


/**
 * An Address class has an <code>Address</code> object consisting street, optional line, 
 * city, state, and zipcode--all of which are <code>String</code> objects.
 */
public class Address implements Serializable,Comparable<Address>{
	/**
	 * An unchangeable array of all 50 states abbreviations of the US. 
	 */
	public static final String
	STATE_ABBREVIATIONS[] =
	{"", "AL", "AK", "AR", "AZ", "CA", "CO", "CT", "DE", "FL", "GA",
	"HI", "IA", "ID", "IL", "IN", "KS", "KY", "LA", "MA", "MD", 
	"ME", "MI", "MN", "MO", "MS", "MT", "NC", "ND", "NE", "NH",
	"NJ", "NM", "NV", "NY", "OH", "OK", "OR", "PA", "RI", "SC",
	"SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY"};
	/**
	 * The street of an address.
	 */
	private String myStreet;
	/**
	 * The optional line of an address.
	 */
	private String myLine;
	/**
	 * The city of an address.
	 */
	private String myCity;
	/**
	 * The state of an address.
	 */
	private String myState; 
	/**
	 * The zipcode of an address.
	 */
	private String myZipCode;
	
	/**
	 * Constructs a new <code>Address</code> with the given street, optional line, city, state, and zipcode.
	 * @param theStreet The given street address.
	 * @param theLine The given optional line address.
	 * @param theCity The given city.
	 * @param theState The given state.
	 * @param theZipCode The given zipcode.
	 */
	public Address(String theStreet,String theLine, 
			String theCity, String theState, String theZipCode) {
		myStreet = theStreet;
		myLine = theLine;
		myCity = theCity;
		myState = theState;
		myZipCode = theZipCode;
	}//5-parameter constructor
	
	/**
	 * Constructs a new <code>Address</code> with the given street, city, state, and zipcode; no optional line.
	 * @param theStreet The given street address.
	 * @param theCity The given city.
	 * @param theState The given state.
	 * @param theZipCode The given zipcode.
	 */
	public Address(String theStreet, String theCity,
			String theState, String theZipCode) {
		myStreet = theStreet;
		myLine = "";
		myCity = theCity;
		myState = theState;
		myZipCode = theZipCode;
	}//4-parameter constructor
	
	/**
	 * Constructs a new <code>Address</code> with no parameters.
	 * The street, optional line, city, state, and zipcode are all set to an empty string.
	 */
	public Address() {
		myStreet = "";
		myLine = "";
		myCity = "";
		myState = "";
		myZipCode = "";
	}//0-parameter constructor
	
	/**
	 * Returns the street of an <code>Address</code>.
	 */
	public String getStreet() {
		return myStreet;
	}//access method for street instance variable
	
	/**
	 * Modifies the street address of an <code>Address</code>.
	 * @param theStreet The given street address.
	 */
	public void setStreet(String theStreet) {
		myStreet = theStreet;
	}//modifier method for street instance variable
	
	/**
	 * Returns the optional line of an <code>Address</code>.
	 */
	public String getLine() {
		return myLine;
	}//access method for optional line instance variable
	
	/**
	 * Modifies the optional line of an <code>Address</code>.
	 * @param theLine The given optional line.
	 */
	public void setLine(String theLine) {
		myLine = theLine;
	}//modifier method for optional line instance variable
	
	/**
	 * Returns the city of an <code>Address</code>.
	 */
	public String getCity() {
		return myCity;
	}//access method for city instance variable
	
	/**
	 * Modifies the city of an <code>Address</code>.
	 * @param theCity The given city.
	 */
	public void setCity(String theCity) {
		myCity = theCity;
	}//modifier method for city instance variable
	
	/**
	 * Returns the state of an <code>Address</code>.
	 */
	public String getState() {
		return myState;
	}//access method for state instance variable
	
	/**
	 * Modifies the state of an <code>Address</code>.
	 * @param theState The given state.
	 */
	public void setState(String theState) {
		myState = theState;
	}//modifier method for state instance variable
	
	/**
	 * Returns the zipcode of an <code>Address</code>.
	 */
	public String getZipCode() {
		return myZipCode;
	}//access method for zip code instance variable
	
	/**
	 * Modifies the zipcode of an <code>Address</code>.
	 * @param theZipCode The given zipcode.
	 */
	public void setZipCode(String theZipCode) {
		myZipCode = theZipCode;
	}//modifier method for zip code instance variable
	
	/**
	 * Compare addresses to see if they are identical. 
	 * @param theOther The given object being compared to (will be
	 * casted as an <code>Address</code>object.
	 * @return Returns true if the given address is identical to the street, 
	 * optional line, city, state, and zipcode of the address being compared to. 
	 * Returns false if  the given address is not identical to the street, optional
	 * line, city, state, and zipcode of the address being compared to.
	 */
	public boolean equals(Object theOther) {
		Address theAddress = (Address)theOther;
		return myStreet.equals(theAddress.myStreet)
		&& myLine.equals(theAddress.myLine)
		&& myCity.equals(theAddress.myCity)
		&& myState.equals(theAddress.myState)
		&& myZipCode.equals(theAddress.myZipCode);
	}//equals boolean method: if two addresses are the same
	
	/**
	 * Compares addresses to see if one is before the other.
	 * @param theAddress The given address to compare.
	 * @return Returns true if the compare value is less than 0, meaning the given
	 * address is before the address being compared to. Returns false if the compare
	 * value is not less than 0, meaning the given address is not before the address
	 * being compared to. 
	 */
	public boolean before(Address theAddress) {
		return compareTo(theAddress) <0;
	}//before boolean method: true if the invoking object is before
	
	/**
	 * Compares addresses to see if one is before, after, or identical as the other.
	 * The state is the prior determinant, the city is the second determinant, 
	 * the zipcode is the third determinant, the street is the fourth determinant,
	 * the optional line is the last determinant to compare. 
	 * @param theAddress The given address to compare.
	 * @return Returns a negative value if the given address is before the address
	 * being compared to. Returns a positive value if the given address is before the
	 * address being compared to. Returns the value 0 if the given address is identical
	 * to the address being compared to.
	 */
	 public int compareTo(Address theAddress){
		int compareValue = myState.compareTo(theAddress.myState);
		if (compareValue != 0){
			return compareValue;
		}//if states are different
		compareValue = myCity.compareTo(theAddress.myCity);
		if (compareValue != 0){
			return compareValue; 
		}//if cities are different
		compareValue = myZipCode.compareTo(theAddress.myZipCode);
		if (compareValue != 0){
			return compareValue; 
		}//if zip codes are different
		compareValue = myStreet.compareTo(theAddress.myStreet);
		if (compareValue != 0){
			return compareValue; 
		}//if streets are different
		return myLine.compareTo(theAddress.myLine);
	 }//compareTo method
	 
	 /**
	  * Returns the address in the string format: street, optional line, city, state, zipcode.
	  */
	 public String toString() {
		if (!myLine.equals("")) {
			return myStreet + "\n" + myLine + "\n" + myCity + ", " 
				+ myState + " " + myZipCode;
		}else {
			myLine = "";
		}//else
		if (!myStreet.equals("")) {
			return myStreet + "\n" + myLine + myCity + ", " 
			+ myState + " " + myZipCode;
		}//if
		return myStreet + myLine + myCity +  myState  + myZipCode;
	} //toString method to return address data in String format
	 
}//Address class
