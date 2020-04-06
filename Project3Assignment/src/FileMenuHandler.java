import java.awt.TextArea;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView;

public class FileMenuHandler implements ActionListener {
	CandleGUI cGUI;
	static TextArea sortedArea;
	static TextArea unsortedArea;
	static UnsortedCandleList unsortedCandleList = new UnsortedCandleList();
	static SortedCandleList sortedCandleList = new SortedCandleList();
	
	public FileMenuHandler (CandleGUI GUI, TextArea sorted, TextArea unsorted) {
		cGUI = GUI;
		sortedArea = sorted;
		unsortedArea = unsorted;
	}
	@Override
	public void actionPerformed(ActionEvent event) {
		String menuAction = event.getActionCommand();
		if(menuAction=="Open") {
			openAndDisplayFile(cGUI,unsortedArea,sortedArea);
		}else if(menuAction=="Quit") {
			System.exit(0);
		}
		
	}//End of actionPerformed
	public void openAndDisplayFile(CandleGUI gui, TextArea u, TextArea s) {
		File selectedFile = null;
		JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		int returnValue = jfc.showOpenDialog(null);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			selectedFile = jfc.getSelectedFile();
			JOptionPane.showMessageDialog(null,"Path: "+selectedFile.getAbsolutePath(),"Finder",JOptionPane.INFORMATION_MESSAGE);			
			try{
				BufferedReader myScan = new BufferedReader(new FileReader(selectedFile));
				String currentLine = myScan.readLine();
				int lineNumber = 1;
				while(currentLine!=null) {
					String[] temp = currentLine.split(",");
					if(temp.length==3) {
						int height = Integer.parseInt(temp[0]);
						int width = Integer.parseInt(temp[1]);
						float price = Float.parseFloat(temp[2]);
						Candle c = new Candle(height,width,price);
						unsortedCandleList.add(c);
						sortedCandleList.add(c);
						currentLine = myScan.readLine();
						lineNumber++;
					}
					else {
						System.out.println("Expected 3 tokens at line: "+ lineNumber);
						currentLine = myScan.readLine();
						lineNumber++;
					}
				}
				
				myScan.close();
				
			}catch(IOException e){
				e.printStackTrace();
			}
			CandleNode point1 = unsortedCandleList.first.next;
		    while(point1!=null) {
		    	u.append((point1.data).toString(point1.data)+"\n");
		    	point1 = point1.next;
		    }
		    CandleNode point2 = sortedCandleList.first.next;
		    while(point2!=null) {
		    	s.append((point2.data).toString(point2.data)+"\n");
		    	point2 = point2.next;
		    }
			
		}
		
	}
	public static void printInsertToGUI(Candle c, TextArea sortedArea2, TextArea unsortedArea2) {
		unsortedCandleList.add(c);
		unsortedArea.setText("Unsorted Candles"+"\n");
		CandleNode point3 = unsortedCandleList.first.next;
	    while(point3!=null) {
	    	unsortedArea.append((point3.data).toString(point3.data)+"\n");
	    	point3 = point3.next;
	    }
		sortedCandleList.add(c);
		sortedArea.setText("Sorted Candles"+"\n");
		CandleNode point4 = sortedCandleList.first.next;
	    while(point4!=null) {
	    	sortedArea.append((point4.data).toString(point4.data)+"\n");
	    	point4 = point4.next;
	    }
	}

}//End of FileMenuHandler
