import java.awt.TextArea;
import java.awt.event.*;

import javax.swing.JOptionPane;

public class EditMenuHandler implements ActionListener {
	CandleGUI cGUI;
	TextArea sortedArea;
	TextArea unsortedArea;
	public EditMenuHandler (CandleGUI GUI, TextArea sorted, TextArea unsorted) {
		cGUI = GUI;
		sortedArea = sorted;
		unsortedArea = unsorted;
	}
	@Override
	public void actionPerformed(ActionEvent e) {	
	    String menuName = e.getActionCommand();
	    if(menuName.equals("Insert")) {
	    	String s= JOptionPane.showInputDialog(null,"Enter a candle of form int,int,float","Inserter",JOptionPane.INFORMATION_MESSAGE);
	    	String[] temp = s.split(",");
	    	int height = Integer.parseInt(temp[0]);
			int width = Integer.parseInt(temp[1]);
			float price = Float.parseFloat(temp[2]);
			Candle c = new Candle(height,width,price);
			FileMenuHandler.printInsertToGUI(c,sortedArea,unsortedArea);
	    }
	    	   
	 }//End of Action Performed
}
