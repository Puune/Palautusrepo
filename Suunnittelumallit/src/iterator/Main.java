package iterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Main {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8));
		
//		Iterator<Integer> it = new Iterator<Integer>() {
//			Iterator<Integer> unmodified = list.iterator();
//			
//			@Override
//			public synchronized boolean hasNext() {
//				return unmodified.hasNext();
//			}
//
//			@Override
//			public synchronized Integer next() {
//				if(unmodified.hasNext()) {
//					return unmodified.next();
//				}
//				return null;
//			}
//			
//		};
		
		Iterator<Integer> it = list.iterator();
		
		TaskRunner t1, t2;
		t1 = new TaskRunner(it, list);
		t2 = new TaskRunner(it, list);
		
		t1.start();
		t2.start();
		
		while(t1.isAlive()) { //&& t2.isAlive()) {
			Thread.yield();
		}
		
//		while(it.hasNext()) {
//			it.next();
//			it.remove();
//		}
		
		StringBuilder sb = new StringBuilder();
		for(Integer i : list) {
			sb.append(i + ",");
		}
		
		System.out.println(sb.toString());
	}
}
