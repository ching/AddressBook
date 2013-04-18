package forDatabase;

//Ching Yu


/**
 * An AIAndErrorString class has an <code>AIAndErrorString</code> object consisting
 * the address information and error message. The address information an <code>AddressInfo</code> object,
 * and the error message is a <code>String</code> object.
 */
public class AIAndErrorString {
	/**
	 * The address information.
	 */
	private AddressInfo myAI;
	/**
	 * The error message.
	 */
	private String myErrorString;
	
	/**
	 * Constructs a new <code>AIAndErrorString</code> object with the given address 
	 * information and error message.
	 * @param theAI The given address information.
	 * @param theString The given error message.
	 */
	public AIAndErrorString(AddressInfo theAI,
			String theString){
		myAI = theAI;
		myErrorString = theString;
	}//2 parameter constructor
	
	/**
	 * Returns the address information.
	 */
	public AddressInfo getAI(){
		return myAI;
	}//getAI
	
	/**
	 * Returns the error message.
	 */
	public String getErrorString(){
		return myErrorString;
	}//getErrorString
	
}//AIAndErrorString class
