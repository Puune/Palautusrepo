package builder;

import java.util.ArrayList;
import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		Director mcD = new Director(new McDBuilder());
		Director hes = new Director(new HesBuilder());
		
		mcD.construct();
		ArrayList<Content> list = (ArrayList<Content>) mcD.getBuilder().getProduct();
		for(Content c : list) {
			System.out.println(c.getInfo());
		}
		
		System.out.println("\n");
		
		hes.construct();
		String res = (String) hes.getBuilder().getProduct();
		System.out.println(res);
	}
}
