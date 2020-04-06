
public abstract class CandleList {
	protected CandleNode first;
	protected CandleNode last;
	protected int length;
	
	CandleList(){
		CandleNode cn = new CandleNode();
		this.first = cn; 
		this.last = cn;
		this.length = 0;
		
	}
	public void append(Candle s) {
		CandleNode cn2 = new CandleNode(s);
		last.next = cn2;
		last = cn2;
		cn2.next = null;
		length++;
	}
	
}
		