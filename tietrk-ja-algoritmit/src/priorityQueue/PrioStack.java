package priorityQueue;

import java.util.Iterator;

public class PrioStack implements Iterable<PrioItem>{
	private PrioItem top=null;
	private PrioItem rear=null;
	private int stackSize = 0;
	
	public void insert(String data, int priority) {
		if(stackSize==0) {
			top = rear = new PrioItem(data, priority);
			
		} else {
			Iterator<PrioItem> it = iterator();
			PrioItem toBePrevious = null;
			PrioItem newItem = new PrioItem(data, priority);
			boolean willExit = false;
			
			while(it.hasNext() && !willExit) {
				PrioItem current = it.next();
				
				if(current.priority()<=priority) {
					toBePrevious = current;
					
					
				} else if(current.priority()>priority) {
					newItem.setNext(current);

					if(toBePrevious==null) {
						top = newItem;
					} else {
						newItem.setPrevious(toBePrevious);
						toBePrevious.setNext(newItem);
					}
					
					willExit = true;
				}
				
				if(!it.hasNext()) {
					toBePrevious.setNext(newItem);
					newItem.setPrevious(current);
					rear = newItem;
				}
			}
		}
		
		stackSize++;
	}
	
	public PrioItem dequeue() {
		PrioItem toReturn = top;
		if(top!=null)
			top = top.getNext();
		return toReturn;
	}
	

	public int getSize() {
		return stackSize;
	}
	
	@Override
	public Iterator<PrioItem> iterator() {
		return new Iterator<PrioItem>() {
			private PrioItem current = top;

			@Override
			public boolean hasNext() {
				return current != null;
			}

			@Override
			public PrioItem next() {
				PrioItem toReturn = current;
				current = current.getNext();
				return toReturn;
			}
			
		};
	}
}
