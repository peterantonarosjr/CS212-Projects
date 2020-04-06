
public class SortedCandleList extends CandleList{
	
	SortedCandleList(){
		super();
	}
	
	public void add(Candle c) {
		CandleNode curr = first;
		CandleNode look = first.next;
		CandleNode canNode = new CandleNode(c);
	
		if(length == 0) {
			append(c);
			return;
		}
		else if(c.getP()>=last.data.getP()) {
			append(c);
			
		}
		else {
			while(c.getP()>= look.data.getP()) {
				curr = look;
				look = look.next;
			}
			curr.next =  canNode;
			curr.next.next = look;
			length++;
			
		}
		
	}

}
