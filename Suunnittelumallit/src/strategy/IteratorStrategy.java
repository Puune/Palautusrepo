package strategy;

import java.util.Collection;
import java.util.Iterator;

public class IteratorStrategy implements IListStrategy{

	@Override
	public String listToString(Collection<String> list) {
		StringBuilder sb = new StringBuilder();
		Iterator<String> itr = list.iterator();
		
		while(itr.hasNext()) {
			sb.append(itr.next());
			sb.append("\n");
		}
		
		return sb.toString();
	}
}
