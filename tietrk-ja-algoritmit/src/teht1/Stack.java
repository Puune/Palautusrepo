package teht1;

public class Stack {
	
	private Item topItem = null;
	private int size = 0;
	
	public Stack() {
		
	}
	
	public void push(String aData) {
		topItem = new Item(topItem, aData);
		size++;
	}
	
	
	public Item pop() {
		Item temp = topItem.clone();
		topItem = topItem.next();
		size--;
		return temp;
	}
	
	
	public void printAll() {
		boolean printing = true;
		Item pointer = topItem.clone();

		while(printing) {
			System.out.println(pointer.getData());
		
			pointer = pointer.next();
			printing = pointer != null;
		}
	}
	
	public int getSize() {
		return size;
	}
}
