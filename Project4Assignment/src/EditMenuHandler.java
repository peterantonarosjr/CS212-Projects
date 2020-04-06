import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.*;
import javax.swing.JOptionPane;

public class EditMenuHandler implements ActionListener {
	CandleGUI cGUI;
	TextArea sortedArea;
	TextArea unsortedArea;
	static UnsortedCandleList unsortedCandleList;
	static SortedCandleList sortedCandleList;
	
	public EditMenuHandler(CandleGUI GUI, TextArea sorted, TextArea unsorted, UnsortedCandleList uList, SortedCandleList sList) {
		cGUI = GUI;
		sortedArea = sorted;
		unsortedArea = unsorted;
		unsortedCandleList = uList;
		sortedCandleList = sList;
	}
	@Override
	public void actionPerformed(ActionEvent e) {	
	    String menuAction = e.getActionCommand();
	    if(menuAction.equals("Search")) {
	    	Font font1 = new Font("SansSerif", Font.BOLD, 12);
	    	unsortedArea.setFont(font1);
	    	sortedArea.setFont(font1);
	    	unsortedArea.setText("Unsorted Candles"+"\n");
	    	sortedArea.setText("Sorted Cndles"+"\n");
	    	float price = Float.parseFloat(JOptionPane.showInputDialog(null,"Candles at or below price","Inserter",JOptionPane.INFORMATION_MESSAGE));
			CandleNode point1 = unsortedCandleList.first;
		    while(point1.next!=null) {
		    	if((point1.next.data).getP()>price) {
		    		point1=point1.next;
		    	}else {
		    		unsortedArea.append((point1.next.data).toString(point1.next.data)+"\n");
		    		point1 = point1.next;
		    	}
		    	
		    }//End of While
			CandleNode point2 = sortedCandleList.first;
		    while(point2.next!=null) {
		    	if((point2.next.data).getP()>price) {
		    		point2=point2.next;
		    	}else {
		    		sortedArea.append((point2.next.data).toString(point2.next.data)+"\n");
		    		point2 = point2.next;
		    	}
		    	
		    }//End of While
	    }	   
	 }//End of Action Performed
}
