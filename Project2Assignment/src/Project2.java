import java.util.StringTokenizer;
public class Project2 {
	static CandleGUI myGUI;
	
	public static void main(String[] args) {
		CandleGUI.candleToGUI(myGUI, readFromFile(args[0]));//Setup of the GUI and data input
	}
	
	public static String[] readFromFile(String file) {
		//Sees how many valid inputs there are to create proper size Candle Array
		int count=0;
		int numOfTokens=0;
		
		TextFileInput in = new TextFileInput(file);
		String currentLine = in.readLine();
		while(currentLine!=null) {
			StringTokenizer token = new StringTokenizer(currentLine,",");
			numOfTokens+=token.countTokens();
			if(numOfTokens<3) {
				System.out.println("Expected 3 tokens, "+numOfTokens+" token(s) at line: "+ in.getLineCount());
				currentLine=in.readLine();
			}
			currentLine = in.readLine();
			count++;
			numOfTokens=0;
			
		}//End of While
		
		String[] data = new String[count];
		
		int position=0;
		int numOfTokens2=0;
		
		TextFileInput in2 = new TextFileInput(file);
		String currentLine2 = in2.readLine();
		while(currentLine2!=null) {
			StringTokenizer token2 = new StringTokenizer(currentLine2,",");
			numOfTokens2+=token2.countTokens();
			if(numOfTokens2<3) {
				currentLine2=in2.readLine();
			}
			data[position++]=currentLine2;
			currentLine2 = in2.readLine();
			
			numOfTokens2=0;
		}//End of While
		return data;
	}//End of readFromFile

}