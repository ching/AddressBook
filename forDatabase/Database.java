package forDatabase;

//Ching Yu

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.io.*;


/**
 * A Database extends the <code>JFrame</code> class and
 * consists of text fields, labels, buttons, a combination box,
 * a container, a text area, and an address info collection that all makes
 * up a visible window of a database. Text fields are of the <code>JTextField</code>
 * objects. Labels are of the <code>JLabel</code> objects. Buttons are of the
 * <code>JButton</code> objects. The combination box is of the
 * <code>JComboBox</code> object. The container is of a <code>Container</code>
 * object. The text area is of a <code>JTextArea</code> object. The address info
 * collection is of the <code>AddressInfoCollection4</code> object.
 *
 */
public class Database extends JFrame implements Serializable {
	/**
	 * The container that holds and displays each button, text field, label, 
	 * combination box, and text area in place.
	 */
	private Container myCP;
	/**
	 * The combination box for a list of 50 states in abbreviation.
	 */
	private JComboBox stateCB;
	/**
	 * The text field for user to input their first name.
	 */
	private JTextField firstTF; 
	/**
	 * The text field for user to input their last name.
	 */
	private JTextField lastTF; 
	/**
	 * The text field for user to input their street address.
	 */
	private JTextField addressTF;
	/**
	 * The text field for user to input an optional line
	 * from their street address.
	 */
	private JTextField optionalTF;
	/**
	 * The text field for user to input their city.
	 */
	private JTextField cityTF;
	/**
	 * The text field for user to input their zipcode.
	 */
	private JTextField zipcodeTF;
	/**
	 * The text field for user to input a file name to save or load.
	 */
	private JTextField fileTF;
	/**
	 * The text field for user to input last name to search.
	 */
	private JTextField searchLastTF;
	/**
	 * The text field for user to input first name to search.
	 */
	private JTextField searchFirstTF;
	/**
	 * The label indicating where user should enter their first name;
	 * next to first name's text field.
	 */
	private JLabel firstL;
	/**
	 * The label indicating where user should enter their last name;
	 * next to the last name's text field.
	 */
	private JLabel lastL;
	/**
	 * The label indicating where user should enter their street address;
	 * next to the street address's text field.
	 */
	private JLabel addressL; 
	/**
	 * The label indicating where user should enter their optional line
	 * of street address; next to the optional line's text field.
	 */
	private JLabel optionalL;
	/**
	 * The label indicating where user should enter their city;
	 * next to the city's text field.
	 */
	private JLabel cityL;
	/**
	 * The label indicating where user should choose their state;
	 * next to the state's combination box.
	 */
	private JLabel stateL;
	/**
	 * The label indicating where user should enter their zipcode;
	 * next to the zipcode's text field.
	 */
	private JLabel zipcodeL;
	/**
	 * The label indicating where an error message, a prompt
	 * (informational) message, or a display of the database will
	 * appear; above the text area.
	 */
	private JLabel messageL;
	/**
	 * The label indicating where user should enter their file name
	 * to save or load;  next to the file name's text field.
	 */
	private JLabel fileL;
	/**
	 * The label indicating where user should enter their first
	 * name to search; next to the first name search text field.
	 */
	private JLabel searchFirstL;
	/**
	 * The label indicating what and where user should enter
	 * to search or delete address information; above the first
	 * and last name search text fields.
	 */
	private JLabel searchL;
	/**
	 * The label indicating where user should enter their last
	 * name to search; next to the last name search text field.
	 */
	private JLabel searchLastL;
	/**
	 * The text area that can display an error message, a prompt (informational)
	 * message, or the contents of the database itself. 
	 */
	private JTextArea messageTA;
	/**
	 * The scroll pane of the text area that allows messages to be scrolled
	 * up with a scroll bar if they exceed the height or width of the text area.
	 */
	private JScrollPane messageSP;
	/**
	 * The button that user presses to enter address information into
	 * the database; inserts into the <code>AddressInfoCollection2</code>.
	 */
	private JButton insertB;
	/**
	 * The button that user presses to load address information into the
	 * database.
	 */
	private JButton loadB;
	/**
	 * The button that user presses to save address information from the
	 * database into a physical file.
	 */
	private JButton saveB;
	/**
	 * The button that user presses to display address information from the
	 * <code>AddressInfoCollection2</code> by alphabetical orderring.
	 */
	private JButton alphaDispB;
	/**
	 * The button that user presses to display address information from the
	 * <code>AddressInfoCollection2</code> by address ordering.
	 */
	private JButton addressDispB;
	/**
	 * The button that user presses to search for a specific person and their
	 * address information from the database.
	 */
	private JButton searchB;
	/**
	 * The button that user presses to delete a specific person and their address
	 * information from the database.
	 */
	private JButton deleteB;
	/**
	 * The button that user presses to confirm a delete  or overwrite request.
	 */
	private JButton confirmB;
	/**
	 * The button that users presses to cancel a delete or overwrite request.
	 */
	private JButton cancelB;
	/**
	 * An indicator whether an <code>AddressInfo</code> object is found;
	 * defaulted to null.
	 */
	private AddressInfo found = null;
	/**
	 * An error message defaulted to an empty string; will be concatenated
	 * with an error message if any.
	 */
	private String errorMsg="";
	/**
	 * Tells whether a user has invoked a save request that requires
	 * an overwrite process; initialized to false.
	 */
	private boolean processingSave = false;
	/**
	 * Tells whether a user has invoked an insert request where two address
	 * information are the same (duplicates); initialized to false.
	 */
	private boolean duplicateRecord = false;
	/**
	 * Tells whether a user has invoked a delete request that requires
	 * user's confirmation; initialized to false.
	 */
	private boolean processingDelete = false;
	/**
	 * The collection of address information entered by user,
	 * can be sorted alphabetically or by address.
	 */
	private AddressInfoCollection4 myCollection;

	/**
	 * Construct a new <code>Database</code> object using
	 * utility methods to layout and construct the window (titled "Database GUI")
	 * ,text field, buttons, labels, collection, combination box, text
	 * area, and window listener.
	 */
	public Database() {
		super("Database GUI");
		setUpJFrame();
		allTextFields();
		allButtons();
		allLabels();
		
		myCollection = new AddressInfoCollection4();

		stateCB = new JComboBox(Address.STATE_ABBREVIATIONS);
		stateCB.setSize(70,20);
		stateCB.setLocation(170, 80);
		myCP.add(stateCB);
		stateCB.addActionListener(new StateCBHandler());

		messageTA = new JTextArea("Hello friend! " +
				"\n\nWelcome to the Database program." +
				"\n\nThis program allows you to enter and store your name and address information." +
				"\nYou have the ability to sort your entered information either alphabetically by  name " +
				"\nor by address. " +
				"\n\nLooking for information you've entered?" +
				"\nSure thing! Just type in the first and last name in the appropriate text fields below and" +
				"\nclick search! Deleting stored information is just as easy; click the delete button after" +
				"\nentering first and last names. Don't worry! There is also the confirm or cancel option if" +
				"\nyou want to make sure of what you're deleting." +
				"\n\n(Update on April 1, 2011)" +
				"\nNow you can save all your data! How? Simply finish inputting your data into the database" +
				"\nfirst and then a file name in the file text field. Then click save :D! You only need to type in" +
				"\nthe name you gave for the file in the same text field to load it. Go ahead, give it a try!" +
				"\n\nMistakes, mistakes, mistakes--they all can be fixed!" +
				"\nWe all make errors when we're typing, and we do not want to waste effort to start over;" +
				"\nSo what can we do? Overwrite! Yes, this database now allows you to overwrite your saved" +
				"\ndata. Type in the same name and a changed address and click on the insert button. To make" +
				"\nsure, the previous record of the same name is provided when you want to replace it. " +
				"\n\nThis message text area is pretty nifty too; Any database information or error message" +
				"\nwill be shown here to let you know what you're doing." +
				"\n\nHave fun with the program!" +
				"\n\n--Ching Yu");
		messageSP = new JScrollPane(messageTA,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		messageSP.setSize(new Dimension(545,350));
		messageSP.setLocation(5, 150);
		messageTA.setEditable(false);
		myCP.add(messageSP); 

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}//windowClosing
		}); //end of definition of WindowAdapter and semicolon to end the line 
		setVisible(true); //set all components to be visible
	}//Database constructor
	
	/**
	 * Clears all text fields by setting them all to empty strings.
	 */
	private void clearAllTextFields(){
		firstTF.setText("");
		lastTF.setText("");
		searchFirstTF.setText("");
		searchLastTF.setText("");
		addressTF.setText("");
		zipcodeTF.setText("");
		cityTF.setText("");
		stateCB.setSelectedIndex(0);
		optionalTF.setText("");
		fileTF.setText("");
	}//clearAllTextFields method
	
	/**
	 * Adjusts whether the buttons should be enabled/visible or not
	 * according to the given true or false value;  used when 
	 * processing save, delete, or duplicates. 
	 * @param tFValue The given true or false value.
	 */
	private void adjustButtons(boolean tFValue){
		alphaDispB.setEnabled(tFValue);
		addressDispB.setEnabled(tFValue);
		saveB.setEnabled(tFValue);
		loadB.setEnabled(tFValue);
		insertB.setEnabled(tFValue);
		searchB.setEnabled(tFValue);
		deleteB.setEnabled(tFValue);
		confirmB.setVisible(!tFValue);
		cancelB.setVisible(!tFValue);
	}//adjustButtons method
	
	/**
	 * Adjusts whether text fields should be enabled or not
	 * according to the given true or false value; used
	 * when processing save, delete, or duplicates.
	 * @param tFValue The given true or false value.
	 */
	private void adjustTextField(boolean tFValue){
		firstTF.setEnabled(tFValue);
		lastTF.setEnabled(tFValue);
		stateCB.setEnabled(tFValue);
		addressTF.setEnabled(tFValue);
		cityTF.setEnabled(tFValue);
		zipcodeTF.setEnabled(tFValue);
		optionalTF.setEnabled(tFValue);
		searchFirstTF.setEnabled(tFValue);
		searchLastTF.setEnabled(tFValue);
		fileTF.setEnabled(tFValue);
	}//adjustTextField method

	/**
	 * A utility method: makeTextField that is used to construct 
	 * text fields with their width, height, horizontal dimension,
	 * vertical dimension, and container.
	 */
	private void allTextFields(){
		firstTF = UtilityMethods.makeTextField(90, 20, 83, 5, myCP);
		lastTF = UtilityMethods.makeTextField(100, 20, 245, 5, myCP);
		addressTF = UtilityMethods.makeTextField(245, 20, 100, 30, myCP);
		optionalTF = UtilityMethods.makeTextField(255, 20, 90, 55, myCP);
		cityTF = UtilityMethods.makeTextField(95, 20, 35, 80, myCP);
		zipcodeTF = UtilityMethods.makeTextField(50, 20, 295, 80, myCP);
		fileTF = UtilityMethods.makeTextField(200, 20, 145, 105, myCP);
		searchFirstTF = UtilityMethods.makeTextField(150, 20, 40, 540, myCP);
		searchLastTF = UtilityMethods.makeTextField(125, 20, 220, 540, myCP);
	}//allTextFields method
	
	/**
	 * A utility method: makeLabel method that is used to construct 
	 * labels with their text, width, height, horizontal dimension,
	 * vertical dimension, and container.
	 */
	private void allLabels(){
		firstL = UtilityMethods.makeLabel("First name: ", 80, 20, 5, 5, myCP);
		lastL = UtilityMethods.makeLabel("Last name: ", 80, 20, 175, 5, myCP);
		addressL = UtilityMethods.makeLabel("Street Address: ", 100, 20, 5, 30, myCP);
		optionalL = UtilityMethods.makeLabel("Optional Line: ", 95, 20, 5, 55, myCP);
		cityL = UtilityMethods.makeLabel("City:", 35, 20, 5, 80, myCP);
		stateL = UtilityMethods.makeLabel("State:", 50, 20, 135, 80, myCP);
		zipcodeL = UtilityMethods.makeLabel("Zipcode:", 90, 20, 245, 80, myCP);
		fileL = UtilityMethods.makeLabel("File name to save/load: ", 160, 15, 5, 105, myCP);
		messageL = UtilityMethods.makeLabel("Message Text Area:", 125, 15, 5, 130, myCP);
		searchL = UtilityMethods.makeLabel("Type here to search and/or delete entry:", 300, 15, 5, 520, myCP);
		searchFirstL = UtilityMethods.makeLabel("First:", 50, 15, 5, 540, myCP);
		searchLastL = UtilityMethods.makeLabel("Last:", 50, 15, 190, 540, myCP);
	}//allLabels

	/**
	 * A utility method: allButtons method that is used to construct 
	 *  buttons with their text, width, height, horizontal dimension,
	 * vertical dimension, handler, and container.
	 */
	private void allButtons(){
		alphaDispB = UtilityMethods.makeButton("Alphabetical Order Display", 200, 20, 
				350, 5, new AlphaDispBHandler(), myCP);
		addressDispB = UtilityMethods.makeButton("Address Order Display", 200, 20, 350, 30,
				new AddressDispBHandler(), myCP);
		insertB = UtilityMethods.makeButton("Insert Info", 200, 20, 350, 55, new InsertBHandler(), myCP);
		saveB = UtilityMethods.makeButton("Save File", 200, 20, 350, 105, new SaveBHandler(), myCP);
		searchB = UtilityMethods.makeButton("Search", 100, 20, 350, 540, new SearchBHandler(), myCP);
		deleteB = UtilityMethods.makeButton("Delete", 95, 20, 455, 540, new DeleteBHandler(), myCP);
		confirmB = UtilityMethods.makeButton("Confirm", 270, 20, 5, 570, new ConfirmBHandler(), myCP);
		confirmB.setVisible(false);
		cancelB = UtilityMethods.makeButton("Cancel", 250, 20, 300, 570, new CancelBHandler(), myCP);
		cancelB.setVisible(false);
		loadB = UtilityMethods.makeButton("Load File", 200, 20, 350, 80, new LoadBHandler(), myCP);
	}//allButtons

	/**
	 * Layouts the <code>JFrame</code> object (visible window)
	 * by setting the content pane, size, and location.
	 */
	private void setUpJFrame(){
		myCP = getContentPane();
		myCP.setLayout(null);
		setSize(570,650);
		setLocation(400,20);
	}//setUpJFrame

	/**
	 * Checks to make sure user has entered all necessary
	 * fields (first name, last name, street address, city,
	 * state, and zipcode) before inserting it into the database. 
	 * If the user is missing any of the fields, an error message is
	 * prompted.
	 * @return Returns a new constructed <code>AddressInfo</code>
	 * object from the data given and an empty string when user
	 * has entered all required fields and no error message is prompted.
	 * Returns null and an error messages prompted when user has
	 * not entered the required fields before inserting.
	 */
	private AIAndErrorString processUserInput(){
		String errorString = "";
		String firstName = firstTF.getText();
		if(firstName.equals("")){
			errorString += "First Name missing \n";
		}//if first name missing
		String lastName = lastTF.getText();
		if(lastName.equals("")){
			errorString += "Last Name missing \n";
		}//if last name missing
		String address = addressTF.getText();
		if(address.equals("")){
			errorString += "Street Address missing \n";
		}//if street address missing
		String optional = optionalTF.getText();
		String city = cityTF.getText();
		if(city.equals("")){
			errorString += "City missing \n";
		}//if city missing
		String state = (String)stateCB.getSelectedItem();
		if(state.equals("")){
			errorString += "State missing \n";
		}//if state missing
		String zipcode = zipcodeTF.getText();
		if(zipcode.equals("")){
			errorString += "Zipcode missing \n";
		}//if zipcode missing
		return (errorString.equals("")
				? new AIAndErrorString 
						(new AddressInfo (lastName,firstName,address,optional,city,state,zipcode),"")
		: new AIAndErrorString (null,errorString));
	}//processUserInput method

	/**
	 * Checks to see if user has entered both the first and last
	 * name before invoking a search or delete request.
	 * @return Returns true if user has entered both first and
	 * last name to search/delete and there are no error messages.
	 * Returns false if user has not entered both first and last name
	 * to search/delete and there are error messages generated.
	 */
	private boolean validNameInput() {	
		errorMsg = "";
		String fName = firstTF.getText();
		String lName = lastTF.getText();
		if (fName.equals("")) {
			errorMsg = errorMsg +"You need to enter a First Name.\n";
		}// if - to check that there is something in the first name text field
		if (lName.equals("")) {
			errorMsg = errorMsg +"You need to enter a Last Name.\n";
		}// if - t check that there is something in the last name text field
		return (errorMsg.equals("") ? true : false);
	}// validNameInput method

	/**
	 * The InsertBHandler class for the insert button only inserts entered information
	 * into the collection when user has entered all required fields before inserting;
	 * and there are no duplicate information.
	 */
	public class InsertBHandler implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			AIAndErrorString result = processUserInput();
			String resultString = result.getErrorString();
			AddressInfo resultAI = result.getAI();
			if (validNameInput()&&resultString==("")){//considering valid name input
				found = myCollection.search(resultAI);
				if (found != null) { 
					duplicateRecord = true;
					adjustButtons(false);
					adjustTextField(false);
					messageTA.setText("\nThis record already exists:\n\n"+ found.toString()
							+ "\n\nPress Confirm to replace old record " +
								"or Cancel to cancel new entry.\n"); 
							//Assign08 - 1a: warns user if they want to overwrite
					}//person already in DB
				else{
					if (myCollection.insert(resultAI)) { //3b. add to collection
						messageTA.setText("Add of: \n\n " + resultAI.getName() + "\n"
								+ resultAI.getAddress() +	"\n\nis successful!"); 
						clearAllTextFields();
					}//add person to collection
					else {
					messageTA.setText("add of: \n\n " + resultAI.getName() + "\n" +
							resultAI.getAddress() + "\n\nis not successful!");
					}//cannot add person to collection
				}//if person is not already in DB
			}else { 
				messageTA.setText(resultString);
			}//there is an error message
		}//actionPerformed
	}//InsertBHandler class
	
	/**
	 * The StateCBHandler class for the state combination box
	 * allows user to select a state and uses the selection from the
	 * box as the state field of the address information in string format.
	 */
	public class StateCBHandler implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			stateCB = (JComboBox)e.getSource();
		}//actionPerformed
	}//StateCBHandler class

	/**
	 * The AlphaDispHandler class for the alphabetical display button
	 * sorts and display the information in the collection alphabetically.
	 */
	public class AlphaDispBHandler implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			if (myCollection.toStringAlphabetical().equals("")){
				messageTA.setText("There are no data to be alphabetically sorted; Please add" +
						"\nsome information into the database by filling out the indicated" +
						"\ntext fields and click the insert button when you are done :]" +
						"\nYou can click the Alphabetically Order Display again once you've " +
				"\nadded information to sort.");
			}else{
				messageTA.setText("The database after alphabetically sorted: \n\n" + 
						myCollection.toStringAlphabetical());
			}//else
		}//actionPerformed
	}//AlphaDispBHandler class

	/**
	 * The AddressDispHandler class for the address display button
	 * sorts and display the information in the collection by address ordering.
	 */
	public class AddressDispBHandler implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			if (myCollection.toStringByAddress().equals("")){
				messageTA.setText("There are no data to be sorted by address; Please add" +
						"\nsome information into the database by filling out the indicated" +
						"\ntext fields and click the insert Order Display again once you've " +
				"\nadded information to sort.");
			}else{
				messageTA.setText("The database after sorted by address: \n\n" + 
						myCollection.toStringByAddress());
			}//else
		}//actionPerformed
	}//AddressDispBHandler class
	
	/**
	 * The SearchBHandler class of the search button 
	 * uses the search method to look for address information
	 * of a specified person with first name and last name. 
	 * If found, the address information of that person will
	 * be given. If not found, an error message will be prompted.
	 */
	public class SearchBHandler implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			String theFirst = searchFirstTF.getText();
			String theLast = searchLastTF.getText();
			AddressInfo findMe = processSearchorDeleteInput();
			AddressInfo theInfo = new AddressInfo(theLast, theFirst);
			if (findMe == null){
				messageTA.setText(errorMsg);
			}else{
				if (myCollection.search(theInfo)==null){
					messageTA.setText("Your search is not in the database!");
					clearAllTextFields();
				}else {
					messageTA.setText("Your search result is: \n\n " + myCollection.search(theInfo));
				}//else
			}//else
		}//actionPerformed
	}//SearchBHandler class

	/**
	 * Concatenates an error message for each of the given
	 * required address fields are missing upon inserting. 
	 * @param theTF The given text field to identify which data field(s)
	 * is missing. 
	 * @param forErrorMsg The given error message to concatenate
	 * pertaining to each missing data field. 
	 * @return Returns an error message in string format.
	 */
	private String processInputTF(JTextField theTF, String forErrorMsg){
		String toReturn = theTF.getText();
		if (toReturn.equals("")){
			errorMsg +="You need to enter a " + forErrorMsg + "\n";
		}//if 
		return toReturn;
	}//processInputTF

	/**
	 * Determines if the first name and/or last name
	 * are missing when processing a search or delete request.
	 * @return Returns the error message pertaining to whether
	 * the first name and/or last name are missing. Returns null
	 * if there are no error message such that neither first and last
	 * name are missing.
	 */
	private AddressInfo processSearchorDeleteInput(){
		errorMsg = "";
		String firstName = processInputTF(searchFirstTF, "first name");
		String lastName = processInputTF(searchLastTF, "last name");
		if (errorMsg.equals("")){
			return new AddressInfo(lastName, firstName);
		}//if
		return null;
	}//processSearchorDeleteInput method

	/**
	 * The DeleteBHandler class for the delete button looks for
	 * the specified name in the collection to be removed. When
	 * the information is found for the specified person, the confirm
	 * button is enabled. When the name is not found, an error
	 * message is prompted to user to try again.
	 */
	public class DeleteBHandler implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			AddressInfo findMe = processSearchorDeleteInput();
			//getting using input and store in findMe for search
			clearAllTextFields();
			if (findMe == null){
				messageTA.setText(errorMsg);
			}//error message if name cannot be found
			else{
				found = myCollection.search(findMe);
				if (found==null){
					messageTA.setText("Your search to delete is not in database! ");
				}//when searched data is not in the database
				else{
					messageTA.setText("Info found; You can confirm your delete now or cancel it.");
					adjustButtons(false);
					adjustTextField(false);
					processingDelete=true;
					found = myCollection.search(findMe);
				}//when findMe is found
			}//outer else
		}//actionPerformed
	}//DeleteBHandler

	/**
	 * The ConfirmBHandler class for the confirm button deletes
	 * the specified person's address information from the collection
	 * when processing a delete request. It overwrites a file with the 
	 * new data when processing a saving request. It overwrites an
	 * address information for a specified name when processing duplicate
	 * records in the collection.
	 */
	public class ConfirmBHandler implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			String fileName = fileTF.getText();
			AIAndErrorString result = processUserInput();
			AddressInfo resultAI = result.getAI();
			if(processingSave) {
				String error = myCollection.saveToFile(fileName);
				messageTA.setText("The file: " + fileName + " is now over written.\n"
						+ error + "\n");
				adjustButtons(true);
				adjustTextField(true);
				processingSave = false;
			} //when processing save
			else if (duplicateRecord) {
				if(myCollection.delete(resultAI)){
					messageTA.setText(resultAI +  " is deleted");
				}else{
					messageTA.setText(resultAI +  " is not deleted");
				}///check if deleted
				if(myCollection.search(found) != null) {
					myCollection.delete(found);
					if(myCollection.insert(resultAI)){
						messageTA.setText("\nThe record for: \n\n " + resultAI.getName() + 
								"\n\nhas been changed.\n");
					}else {
						messageTA.setText("\nError in adding new record. " +
							 "Person deleted from Database.\n");
					}//else
					duplicateRecord = false;
				}//if delete possible, then overwrite
				else {
					messageTA.setText("\nError in deleting old record. " +
							"There is no change in Database.\n");
				}//if delete impossible, then cannot overwrite
				adjustButtons(true);
				adjustTextField(true);
			} //when processing duplicate record
			else if (processingDelete) {
				if (myCollection.delete(found)) {	
					messageTA.setText("The data for: \n" + found + 
							"\n\nis now deleted from database!" );
					myCollection.delete(found);
					//3c. delete from collection
				}//delete when possible 
				else {
					messageTA.setText("Failure occurred in deleting: \n\n" + found + ".\n");
				}//error in deleting
				adjustButtons(true);
				adjustTextField(true);
				processingDelete = false;
			}//when processing delete
			else {
				System.out.println("Confirm Button is being handled at an inappropriate time."
					+ e.toString());
				adjustButtons(true);
				adjustTextField(true);
			}//else
		}//actionPerformed
	}//ConfirmBHandler class

	/**
	 * The CancelBHandler class cancels all processing delete, save, duplicate
	 * requests without any change to the collection. It sets all the text fields
	 * and buttons enabled except for cancel and confirm button.
	 */
	public class CancelBHandler implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			String fileName = fileTF.getText();
			AIAndErrorString result = processUserInput();
			AddressInfo resultAI = result.getAI();
			if(processingSave) {
				messageTA.setText("Save request was cancelled. " 
							+ "The file: " + fileName + " is unchanged.\n");
				adjustButtons(true);
				adjustTextField(true);
				processingSave = false;
			} else if (duplicateRecord) {
				messageTA.setText("Information about "
						+ resultAI.getName() +  "  is unchanged.\n");
				adjustButtons(true);
				adjustTextField(true);
				duplicateRecord = false;
			}else if(processingDelete){
				messageTA.setText("You have canceled your delete request. No" +
				" data in the database have been deleted.");
				adjustButtons(true);
				adjustTextField(true);
				processingDelete = false;
			}else {
				System.out.println("Cancel Button is being handled at an inappropriate time!"
						+ e.toString());
				adjustButtons(true);
				adjustTextField(true);
			}//else
		}//actionPerformed
	}//CancelBHandler class

	/**
	 * The SaveBHandler for the save button uses the file
	 * name entered by user as a file name and saves the 
	 * database collection into a physical file.
	 */
	public class SaveBHandler implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			String fileName = fileTF.getText();
			String message = "";
			if(fileName.compareTo("") > 0){
				File theFile = new File(fileName);
				if(!theFile.exists()) {
					message = myCollection.saveToFile(fileName);
					messageTA.setText("Data saved to the file: "+fileName+".\n"
							+ message + "\n");
				} //Assign08 - 1c: saving to file is successful
				else if (!theFile.canWrite()) {
					messageTA.setText("Cannot write data to the file: "+fileName+".\n");
					fileTF.setText("");
				} //Assign08 - 1b: warns user that a file is locked, cannot be overwritten
				else {
					adjustButtons(false);
					adjustTextField(false);
					processingSave = true;
					messageTA.setText("\nPress Confirm to overwrite the file: "+
						fileName + " or press Cancel to cancel the save request.\n");
				}//else
			} else {
				messageTA.setText("You must enter a file name in order to save a file.");
			}//else
		}//actionPerformed
	}//SaveBHandler class

	/**
	 * The LoadBHandler for the load button users the file
	 * name entered by user to look for a physical file with 
	 * the same name to load into the database.
	 */
	public class LoadBHandler implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			String fileName = fileTF.getText();
			if(fileName.compareTo("") > 0){
				File theFile = new File(fileName);
				if(!theFile.exists()) {
					messageTA.setText("The file: " + fileName + 
							" does not exist! It cannot load data!\n");
				}//Assign08 - 2a: warns user when file does not exist
				else if(!theFile.canRead()) {
					messageTA.setText("Cannot read from the file: " + fileName+".\n");
				}//Assign08 - 2c: reading from an existing file is not possible.
				else if(theFile.isDirectory()) {
					messageTA.setText(fileName + " is a directory; not a file!\n" +
							"Please enter a file name and try again.");
				}//Assign08 - 2b: warns user that they are loading 
					//from a directory, not file
				else {
					String fromLoad = myCollection.loadFromFile(fileName);
					messageTA.setText("Data loaded from the file: "+fileName+".\n\n"
							+ fromLoad + "\n\n");
				}//Assign08 - 2d: reading from an existing file is successful.
			} else {
				messageTA.setText("You must enter a file name " +
							"in order to load a file!");
			}//else
		}//actionPerformed
	}//LoadBHandler class

	public static void main(String[] args) {
		Database myApp = new Database();
	}//main class
	
}//Database class
