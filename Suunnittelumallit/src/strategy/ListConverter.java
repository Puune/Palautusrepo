package strategy;

import java.util.Collection;

public class ListConverter {
	private IListStrategy strategy;
	
	public ListConverter(IListStrategy ls) {
		strategy = ls;
	}
	
	public void setStrategy(IListStrategy ls) {
		strategy = ls;
	}
	
	public String listToString(Collection<String> list) {
		return strategy.listToString(list);
	}
}
