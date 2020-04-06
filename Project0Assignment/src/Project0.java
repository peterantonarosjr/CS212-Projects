/**<h1>Checking for (E/e) Project<h1>
 * @Author Peter Antonaros
 * Lab Section : 11F
 * 
 * Program that takes in user defined string, counts the amount
 * of times upper case and lower case (E/e) appear and 
 * displays to screen using a Graphical User Interface.
 */

//Import necessary library for program
import javax.swing.JOptionPane;

public class Project0 {
	
	/**
	 * This is the main method which is responsible for collecting user input
	 * and uses a For loop to check for the case sensitive (E/e) character.
	 * @param args Unused.
	 * @return Nothing.
	 * 
	 */

	public static void main(String[] args) {
		//Declare string variable
		String userInput;
		//Declare integer variables
		int upperCase;
		int lowerCase;
		while(true) {
			//Initialize string variable to the string entered by the user
			userInput = JOptionPane.showInputDialog(null, "Enter a word in all lower case:");
			//Initialize integer variables to 0 every time program is closed and run again
			upperCase=0;
			lowerCase=0;
			//Checks if stop condition is provided by user in order to close GUI
			if(userInput.equalsIgnoreCase("stop")){
				System.exit(0);
			}
			//Iterates through the user provided string. Checks for E's and e's, increments respective variable
			for(int i=0; i<userInput.length(); i++) {
				if(userInput.charAt(i)=='E') {
					upperCase++;
				}else if(userInput.charAt(i)=='e') {
					lowerCase++;
				}
			}
			//Display pop-up showing the amount of upperCase(E's) and lowerCase(e's)
		JOptionPane.showMessageDialog(null, "Number of lower case e's:  " + lowerCase + "\n" 
			+ "Number of upper case e's: " + upperCase);
		}
	} //End of main
}//End of Project0 class