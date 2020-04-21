package builder;


public class Director {
	private HamburgerBuilder hb;
	
	public Director(HamburgerBuilder hb) {
		this.hb = hb;
	}
	
	public HamburgerBuilder getBuilder() {
		return hb;
	}
	
	public void construct() {
		hb.buildBun();
		hb.buildSalad();
		hb.buildSteak();
		hb.buildSauce();
		hb.buildBun();
	}
	
}
