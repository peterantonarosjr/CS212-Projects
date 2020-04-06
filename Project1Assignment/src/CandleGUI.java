import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextArea;
import javax.swing.JFrame;
public class CandleGUI extends JFrame{
	
	//Implement Selection Sort
	public static Candle[] sortCandles(Candle[] candles) {
		for(int last=candles.length-1;last>0;last--) {
			int max=0;
			for(int j=1;j<=last;j++) {
				if(candles[j].getP()>candles[max].getP()) {
					max = j;
				}
			}
			Candle c = candles[max];
			candles[max]=candles[last];
			candles[last]=c;
		}
		
		return candles;
	}
	
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
	    	  //System.out.println(height+" "+width+" "+price);
	    	  //System.out.println("Candle GUI : "+myCandles[i]);
	      }
	      //Appends unsortedCandles to Left Side of GUI
	      for(int x=0; x<unsortedCandles.length;x++) {
	    	  uCandles.append(unsortedCandles[x].toString(unsortedCandles[x])+"\n");
	      } 
	      //Call our sort method to actually sort the Candle object array
	      sortCandles(sortedCandles);
	      //Appends sortedCandkes to Right Side of GUI
	      for(int y=0; y<sortedCandles.length;y++) {
	    	  sCandles.append(sortedCandles[y].toString(sortedCandles[y])+"\n");
	      }
	      //Displays everything
	      myGUI.setVisible(true);
	}

}