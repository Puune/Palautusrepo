package strategy;

import java.util.Collection;
import java.util.LinkedList;

public class Main {
	static IListStrategy one = new IteratorStrategy();
	static IListStrategy two = new ArrayStrategy();
	static IListStrategy three = new GetStrategy();
	
	static Collection<String> list = new LinkedList<String>();
	
	public static void main(String[] args) {
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("1");
		list.add("2");
		list.add("3");
		
		String print;
		
		ListConverter lc = new ListConverter(one);
		print = lc.listToString(list);
		System.out.println(print +"\n");
		
		lc.setStrategy(two);
		print = lc.listToString(list);
		System.out.println(print + "\n");
		
		lc.setStrategy(three);
		print = lc.listToString(list);
		System.out.println(print + "\n");
	}
}
