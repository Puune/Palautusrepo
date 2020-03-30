package teht5;

import java.util.LinkedList;

public class LinkedListIterator implements Iterator {

	ListItem current;
	LinkedList<ListItem> list;
	
	public LinkedListIterator(LinkedList<ListItem> aList) {
		this.list = aList;
		current = aList.getFirst();
	}
	
	@Override
	public boolean hasNext() {
		if(current==null) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public ListItem next() {
		ListItem oldCurrent = current;
		int i;
		try {
			current = list.get(1 + list.indexOf(current));
		} catch(IndexOutOfBoundsException e) {
			current = null;
		}
		return oldCurrent;
	}

}
