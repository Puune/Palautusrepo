package composite.parts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public abstract class Component implements Comparable<Component> {
	
	ArrayList<Component> parts = new ArrayList<>();
	String price;
	String model;
	
	public Component(String model, String price) {
		this.price = price;
		this.model = model;
	}
	
	
	public void printDescription() {	
		for(Component c : parts) {
			c.printDescription();
		}
		System.out.println(model + " || price: " + price);
	}
	
	
	public float getCombinedPrice() {
		float temp = 0;
		try {
			temp = Float.parseFloat(price);
		} catch (Exception e) {
			//not a price
		}
		
		for(Component c : parts) {
			temp += c.getCombinedPrice();
		}
		
		temp *= 100;
		Math.round(temp);
		temp /= 100;
		
		return temp;
	}
	
	
	/**
	 * why not
	 */
	public void sort() {
		for(Component c : parts) {
			c.sort();
		}
		Collections.sort(parts, new Comparator<Component>() {
			@Override
			public int compare(Component o1, Component o2) {
				return o1.model.compareTo(o2.model);
			}
		});
	}
	
	
	@Override
	public int compareTo(Component c) {
		return this.model.toString().compareTo(c.model.toString());
	}
	
	
	/**
	 * default response
	 * @param c Component
	 */
	public void addPart(Component c) {
		System.out.println("Can't add subcomponents to this part");
	}
}
