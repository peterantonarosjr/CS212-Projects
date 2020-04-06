/**
 * 
 * @author Peter Antonaros
 * LabSection: 11F
 * Class that defines a Candle object its attributes and behaviors
 * Each Candles has a height, width, price attribute along with an attribute to check 
 * if it is lit or not
 *
 */
public class Candle {
	private int h;
	private int w;
	private float p;
	private boolean litOrNot;
	
	/**
	 * Candle Class constructor taking in 2 Integer and 1 float parameters
	 * @param h Integer variable that represents the height of the candle.
	 * @param w Integer variable that represents the width of the candle.
	 * @param p Float variable that represents the price of the candle.
	 */
	public Candle(int h, int w, float p) {
		this.h = h;
		this.w = w;
		this.p = p;
		litOrNot = false;
	}
	/**
	 * Get function returning height attribute
	 * @return Integer attribute
	 */
	public int getH() {
		return h;
	}
	/**
	 * Set function, setting the height attribute to an integer
	 * @param h Integer attribute
	 */
	public void setH(int h) {
		this.h = h;
	}
	/**
	 * Get function returning width attribute
	 * @return Integer attribute
	 */
	public int getW() {
		return w;
	}
	/**
	 * Set function, setting the width attribute to an integer
	 * @param w Integer attribute
	 */
	public void setW(int w) {
		this.w = w;
	}
	/**
	 * Get function returning price attribute
	 * @return Float attribute
	 */
	public float getP() {
		return p;
	}
	/**
	 * Set function, setting the price attribute to a float
	 * @param p Float attribute
	 */
	public void setP(float p) {
		this.p = p;
	}
	/**
	 * Function to check candle lit or not
	 * @return Boolean attribute
	 */
	public boolean isLitOrNot() {
		return litOrNot;
	}
	/**
	 * Set function, setting the litOrNot attribute
	 * @param litOrNot  Boolean attribute
	 */
	public void setLitOrNot(boolean litOrNot) {
		this.litOrNot = litOrNot;
	}//Set & Get Methods
	/**
	 * Overridden toString function used in coordination with a candle object to print its attributes
	 * @param candle Candle object input used to collect its attributes
	 * @return Returns the 3 important attributes of a Candle object
	 */
	public String toString(Candle candle) {
		return h+","+w+","+p;
	}//Override toString method

}
