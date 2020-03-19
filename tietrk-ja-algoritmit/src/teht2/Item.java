package teht2;


/**
 * @author Panu
 */
public class Item {
	
	private String data;
	private Item nextItem = null;
	private Item lastItem = null;
	
	
	/**
	 * private constructor for cloning
	 * @param nextItem
	 * @param lastItem
	 * @param data
	 */
	private Item(Item nextItem, Item lastItem, String data) {
		this.nextItem = nextItem;
		this.lastItem = lastItem;
		this.data = data;
	}
	
	
	/**
	 * Create item with refs to last item
	 * @param next
	 */
	public Item(Item lastItem, String data) {
		this.lastItem = lastItem;
		this.data = data;
	}
	
	
	/**
	 * When new item is added, give this item ref
	 * @param item
	 */
	public void setNext(Item item) {
		nextItem = item;
	}
	
	
	/**
	 * @return String data
	 */
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
	
	
	public Item last() {
		return lastItem;
	}
	
	
	/* 
	 * Create a clone instance
	 */
	public Item clone() {
		return new Item(nextItem, lastItem, data);
	}
	
}
