package teht2;

import teht2.Item;

public class LinkedList {
	
	/*
	 * [0] Tail  =>  [n] Head
	 */
	private Item head = null;
	private Item tail = null;
	private Item current = null;
	private int size = 0;
	

	public void push(String aData) {
		if(head == null ) {
			head = new Item(null, aData);
			tail = head;
			current = head;
		} else {
			Item newItem = new Item(head, aData);
			head.setNext(newItem);
			head = newItem;
		}
		size++;
	}
	
	
	public Item pop() {
		Item temp = head.clone();
		head = head.last();
		size--;
		return temp;
	}
	
	
	public Item getCurrent() {
		return current;
	}
	
	
	public Item select(int i) {
		if(i>size) {
			throw new IndexOutOfBoundsException();
		}
		current = tail;
		while(i>0) {
			current = current.next();
			i--;
		}
		return current;
	}
	
	
	public void printAll() {
		boolean printing = true;
		Item pointer = tail.clone();

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
