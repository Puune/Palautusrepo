package abstractFactory;

import abstractFactory.clothes.IHat;
import abstractFactory.clothes.IPants;
import abstractFactory.clothes.IShirt;
import abstractFactory.clothes.IShoes;

public interface AbstractClothesFactory {

	public IHat getCap();
	
	public IShirt getShirt();
	
	public IPants getPants();
	
	public IShoes getShoes();
}
