package iterator;

import java.util.ArrayList;
import java.util.Iterator;

public class TaskRunner extends Thread {
	private Iterator<?> it;
	private ArrayList<Integer> list;
	
	public TaskRunner(Iterator<Integer> it, ArrayList<Integer> list) {
		this.list = list;
		this.it = it;
	}
	
	ArrayList<Integer> resultList = new ArrayList<>();
	
	public void run() {
		while(it.hasNext()) {
			try {
				Integer i = (Integer) it.next();
				if(i % 3 == 0) {
//					list.set(i-1, new Integer(3));
//					i = 0;
					it.remove();
				}
				resultList.add(i);
			} catch (NullPointerException ne) {
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(Integer i : resultList) {
			sb.append(i + ",");
		}
		
		System.out.println(sb.toString());
	}
}
