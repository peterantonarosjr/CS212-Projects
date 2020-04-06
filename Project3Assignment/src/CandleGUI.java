import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextArea;
import javax.swing.JFrame;
import javax.swing.*;

public class CandleGUI extends JFrame{
	TextArea uCandles = new TextArea();
	TextArea sCandles = new TextArea();
	public CandleGUI(String title, int width, int height) {
		this.setTitle(title);
		this.setSize(width,height);
		this.setLocationRelativeTo(null);
		this.setLayout(new GridLayout(1, 2));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container myContentPane = this.getContentPane();
	    Font font1 = new Font("SansSerif", Font.BOLD, 12);	
	     
	    uCandles.setFont(font1);
	    uCandles.setText("Unsorted Candles"+"\n");
	    uCandles.setEditable(false);
	      
	    sCandles.setFont(font1);
	    sCandles.setText("Sorted Candles"+"\n");
	    sCandles.setEditable(false);
	      
	    myContentPane.add(uCandles);
	    myContentPane.add(sCandles);
	      
		//Call method to do all the main work
		createFileMenu();
		//Display everything
		this.setVisible(true);
		
	}
	
	private void createFileMenu() {
		
		JMenuItem item;
	    JMenuBar menuBar  = new JMenuBar();
	    JMenu fileMenu = new JMenu("File");
	    JMenu editMenu = new JMenu("Edit");
	    FileMenuHandler fmh  = new FileMenuHandler(this,sCandles,uCandles);
	    EditMenuHandler emh  = new EditMenuHandler(this,sCandles,uCandles);
	    item = new JMenuItem("Open");
	    item.addActionListener( fmh );
	    fileMenu.add(item);
	    fileMenu.addSeparator();
	    
	    item = new JMenuItem("Quit");
	    item.addActionListener( fmh );
	    fileMenu.add(item);
	    
	    item = new JMenuItem("Insert");
	    item.addActionListener(emh);
	    editMenu.add(item);
	    
	    setJMenuBar(menuBar);
	    menuBar.add(fileMenu);
	    menuBar.add(editMenu);
	}
		
}
