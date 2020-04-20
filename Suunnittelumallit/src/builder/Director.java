package builder;

import builder.parts.Product;

public class Director {
	private HamburgerBuilder hb;
	
	public Director(HamburgerBuilder hb) {
		this.hb = hb;
	}
	
	public Product getProduct() {
		return hb.getProduct();
	}
	
	public void construct() {
		hb.createNewProduct();
		hb.buildBun();
		hb.buildSalad();
		hb.buildSteak();
		hb.buildSauce();
		hb.buildBun();
	}
	
}
