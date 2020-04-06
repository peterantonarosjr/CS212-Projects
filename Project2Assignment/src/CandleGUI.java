import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextArea;
import javax.swing.JFrame;
public class CandleGUI extends JFrame{
	
	public static void candleToGUI(CandleGUI myGUI, String[] myCandles) {
	      myGUI = new CandleGUI();
	      myGUI.setSize(400,300);
	      myGUI.setLocation(300, 300);
	      
	      myGUI.setLayout(new GridLayout(1, 2));
	      myGUI.setTitle("Candle Array Project");
	      
	      myGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      Container myContentPane = myGUI.getContentPane();
	      Font font1 = new Font("SansSerif", Font.BOLD, 12);	
	      
	      TextArea uCandles = new TextArea();
	      uCandles.setFont(font1);
	      uCandles.setText("Unsorted Candles"+"\n");
	      uCandles.setEditable(false);
	      
	      TextArea sCandles = new TextArea();
	      sCandles.setFont(font1);
	      sCandles.setText("Sorted Candles"+"\n");
	      sCandles.setEditable(false);
	      
	      myContentPane.add(uCandles);
	      myContentPane.add(sCandles);
	      
	      Candle[] unsortedCandles = new Candle[myCandles.length];
	      Candle[] sortedCandles = new Candle[myCandles.length];
	      //Create linked lists
	      UnsortedCandleList myUnsortedList = new UnsortedCandleList();
	      SortedCandleList mySortedList = new SortedCandleList();
	      
	      //Parse the myCandles array by creating a temporary String array to hold
	      //variables that will be used to Create candle object
	      String[] temp = new String[3];
	      for(int i=0; i<myCandles.length; i++) {
	    	  temp = myCandles[i].split(",");
	    	  int height= 0;
	    	  int width = 0;
	    	  float price = 0;
	    	  for(int j=0;j<temp.length;j++) {
	    		  height = Integer.parseInt(temp[0]);
	    		  width = Integer.parseInt(temp[1]);
	    		  price = Float.parseFloat(temp[2]);	    		  
	    	  }
  		  Candle candle = new Candle(height,width,price);
	    	  unsortedCandles[i]=candle;
	    	  sortedCandles[i]=candle;
	    	  //At this point both the unsorted and sorted candles are UNSORTED we just placed them in 2 separate arrays
	      }
	      //Create the Two Lists
	      for(int i=0; i<unsortedCandles.length; i++) {
	    	  myUnsortedList.add(unsortedCandles[i]);

	      }
	      for(int i=0; i<sortedCandles.length; i++) {
	    	  mySortedList.add(sortedCandles[i]);
	      }
	      //Append the Two Lists to text area
	      CandleNode point1 = myUnsortedList.first.next;
	      while(point1!=null) {
	    	  uCandles.append((point1.data).toString(point1.data)+"\n");
	    	  point1 = point1.next;
	      }
	      
	      CandleNode point2 = mySortedList.first.next;
	      while(point2!=null) {
	    	  sCandles.append((point2.data).toString(point2.data)+"\n");
	    	  point2 = point2.next;
	      }
	      
	      //Displays everything
	      myGUI.setVisible(true);
	}
}