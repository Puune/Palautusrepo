package builder;

import java.util.Iterator;

import builder.parts.Content;
import builder.parts.Product;

public class Main {

	public static void main(String[] args) {
		Director mcD = new Director(new HamburgerBuilder.McDBuilder());
		Director hes = new Director(new HamburgerBuilder.HesBuilder());
		
		mcD.construct();
		Product a = mcD.getProduct();
		Iterator<Content> i = a.iterator();
		while(i.hasNext()) {
			System.out.println(i.next().getInfo());
		}
		
		System.out.println("\n\n");
		
		hes.construct();
		a = hes.getProduct();
		i = a.iterator();
		while(i.hasNext()) {
			System.out.println(i.next().getInfo());
		}
	}
}
