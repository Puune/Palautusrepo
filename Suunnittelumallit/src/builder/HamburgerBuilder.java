package builder;

import java.util.ArrayList;

public abstract class HamburgerBuilder {	
	
	public abstract void buildBun();
	public abstract void buildSteak();
	public abstract void buildSalad();
	public abstract void buildSauce();
	
	abstract Object getProduct();
}
