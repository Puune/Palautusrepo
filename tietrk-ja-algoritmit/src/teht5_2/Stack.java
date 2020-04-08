/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teht5_2;

import java.util.LinkedList;

interface Iterator{
	boolean hasNext();
	Item next();
}


/**
 *
 * @author kamaj
 */
public class Stack {
	private LinkedList<String> items = null;
	private Item topItem = null;
	private int size = 0;
	
	public Stack() {
		items = new LinkedList<>();
	}
	
	
	/**
	 * get iterator
	 * @return iterator Iterator
	 */
	public java.util.Iterator<String> getIterator() {
//		return new Iterator() {
//			
//			Item pointer = topItem;
//			
//			@Override
//			public Item next() {
//				Item current = pointer;
//				pointer = pointer.next();
//				return current;
//			}
//			
//			@Override
//			public boolean hasNext() {
//				return pointer != null;
//			}
//		};	
		
		return items.iterator();
	}
	
	
	
	public void push(String aData) {
//		topItem = new Item(topItem, aData);
//		size++;
		
		items.push(aData);
	}
	
	
	public Item pop() {
//		Item temp = topItem.clone();
//		topItem = topItem.next();
//		size--;
		
		Item temp = new Item(null, items.removeLast());
		
		return temp;
	}
	
	
	public void printAll() {
//		boolean printing = true;
//		Item pointer = topItem.clone();
//
//		while(printing) {
//			System.out.println(pointer.getData());
//		
//			pointer = pointer.next();
//			printing = pointer != null;
//		}
		
		for(String s : items) {
			System.out.println(s);
		}
		
	}
	
	public int getSize() {
//		return size;
		return items.size();
	}
}
