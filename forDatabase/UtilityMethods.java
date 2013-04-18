package forDatabase;

//Ching Yu

import java.awt.Container;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * A UtilityMethods class consists of static methods that construct text fields of 
 * <code>JTextField</code> objects, labels of <code>JLabel</code> objects, and 
 * buttons of <code>JButton</code> objects.
 */
public class UtilityMethods {
	
	/**
	 * Constructs a text field with the given width, height, horizontal-dimension 
	 * value, vertical-dimension value, and container. 
	 * @param theWidth The given width to determine how wide the text field is.
	 * @param theHeight The given height to determine how tall the text field is.
	 * @param theX The given horizontal-dimension value to move text field left or right.
	 * @param theY The given vertical-dimensional value to move text field up or down.
	 * @param theCP The given container of the text field.
	 * @return Returns the newly constructed text field.
	 */
	public static JTextField makeTextField(int theWidth, 
			int theHeight, int theX, int theY, Container theCP){
		JTextField tfReturn = new JTextField ();
		tfReturn.setSize(theWidth, theHeight);
		tfReturn.setLocation(theX, theY);
		theCP.add(tfReturn);
		return tfReturn;
	}//makeTextField method
	
	/**
	 * Constructs a new label with the given text, width, height, horizontal-dimension
	 * value, vertical-dimension value, and container of the label.
	 * @param theLabel The given text to set the words that appear on the label..
	 * @param theWidth The given width to determine how wide the label is.
	 * @param theHeight The given height to determine how tall the label is.
	 * @param theX The given horizontal-dimension value to move label left or right.
	 * @param theY The given vertical-dimension value to move label up or down.
	 * @param theCP The given container of the label.
	 * @return Returns the newly constructed label.
	 */
	public static JLabel makeLabel(String theLabel, int theWidth, 
			int theHeight, int theX, int theY, Container theCP){
		JLabel laReturn = new JLabel (theLabel);
		laReturn.setSize(theWidth, theHeight);
		laReturn.setLocation(theX, theY);
		theCP.add(laReturn);
		return laReturn;
	}//makeLabel method

	/**
	 * Constructs a new button with the given text, width, height, horizontal-dimension
	 * value, vertical-dimension value, and handler of the button.
	 * @param theLabel The given text to set the words that appear on the button.
	 * @param theWidth The given width to determine how wide the button is.
	 * @param theHeight The given height to determine how tall the button is.
	 * @param theX The given horizontal-dimension value to move button left or right.
	 * @param theY The given vertical-dimension value to move button up or down.
	 * @param theHandler The given handler to determine what button does.
	 * @param theCP The given container of the button.
	 * @return Returns the newly constructed button.
	 */
	public static JButton makeButton(String theLabel, int theWidth,
			int theHeight, int theX, int theY, ActionListener theHandler,
			Container theCP){
		JButton toReturn = new JButton (theLabel);
		toReturn.setSize(theWidth, theHeight);
		toReturn.setLocation(theX, theY);
		toReturn.addActionListener(theHandler);
		theCP.add(toReturn);
		return toReturn;
	}//makeButton method

}//UtlilityMethods class
