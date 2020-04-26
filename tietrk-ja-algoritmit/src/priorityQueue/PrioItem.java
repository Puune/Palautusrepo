package priorityQueue;

import java.util.Iterator;

public class PrioItem {
	private String name;
	private int priority;
	private PrioItem next = null;
	private PrioItem previous = null;
	
	/**
	 * @param name 
	 * @param priority smaller is better than higher
	 * @param next
	 * @param previous
	 */
	public PrioItem(String name, int priority) {
		this.name = name;
		this.priority = priority;
	}
	
	public void setNext(PrioItem item) {
		next = item;
	}
	public PrioItem getNext() {
		if(next!=null)
			return next;
		else
			return null;
	}
	
	public void setPrevious(PrioItem item) {
		previous = item;
	}
	public PrioItem getPrevious() {
		if(previous!=null)
			return previous;
		else
			return null;
	}
	
	public int priority() {
		return priority;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
}
