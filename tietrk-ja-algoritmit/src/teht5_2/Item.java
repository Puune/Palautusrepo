package teht5_2;

/**
 * @author Panu
 * Strting item
 */
public class Item {
	
	private String data;
	private Item nextItem = null;
	
	/**
	 * Create item with ref to next item
	 * @param next
	 */
	public Item(Item nextItem, String data) {
		this.nextItem = nextItem;
		this.data = data;
	}
	
	
	/**
	 * Create first item, ref to nextItem = null
	 */
	public Item() {}
	
	
	public String getData() {
		return data;
	}
	
	
	/**
	 * Get ref to next item
	 * @return item Item
	 */
	public Item next() {
		return nextItem;
	}
	
	
	/* 
	 * Create a clone instance
	 */
	public Item clone() {
		return new Item(nextItem, data);
	}
}
