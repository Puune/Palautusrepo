package hajautustaulu;

public class Item {
	private Item next = null;
	private int data;
	
	public Item(int data) {
		this.data = data;
	}
	
	public Item getNext() {
		return next;
	}
	public void setNext(Item item) {
		next = item;
	}
	
	public int getData() {
		return data;
	}
}
