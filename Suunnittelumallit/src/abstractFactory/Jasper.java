package abstractFactory;

import java.util.ArrayList;

import abstractFactory.clothes.AdidasCap;
import abstractFactory.clothes.AdidasShoes;
import abstractFactory.clothes.IApparel;
import abstractFactory.clothes.IHat;
import abstractFactory.clothes.IPants;
import abstractFactory.clothes.IShirt;
import abstractFactory.clothes.IShoes;

public class Jasper {
	
	//The default setup
	private IHat hat = new AdidasCap();
	private IShirt shirt = null;
	private IPants pants = null;
	private IShoes shoes = new AdidasShoes();		
	
	private IApparel[] clothes = { hat, shirt, pants, shoes };
	
	
	/**
	 * Describe what Jasper is wearing
	 */
	public void describe() {
		
		System.out.println("I'm wearing:");
		
		for(IApparel apparel : clothes) {
			if(apparel != null) {
				System.out.println(apparel);
			}
		}
	}
	
	
	/**
	 * Give jasper a clothesFactory
	 * @param factory
	 */
	public void wear(AbstractClothesFactory factory) {
		clothes[0] = factory.getCap();
		clothes[1] = factory.getShirt();
		clothes[2] = factory.getPants();
		clothes[3] = factory.getShoes();
	}
	
}
