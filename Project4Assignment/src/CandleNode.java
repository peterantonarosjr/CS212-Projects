
public class CandleNode {
	protected Candle data;
	protected CandleNode next;
	
	public CandleNode(Candle data, CandleNode nextC) {
		this.data = data;
		this.next = nextC;
	}
	
	public CandleNode(Candle data) {
		this.data = data;
		this.next = null;
	}
	
	public CandleNode() {
		this.data = null;
		this.next = null;
	}

}
