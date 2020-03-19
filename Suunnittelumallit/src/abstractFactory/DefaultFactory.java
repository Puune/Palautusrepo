package abstractFactory;

import abstractFactory.clothes.DefaultCap;
import abstractFactory.clothes.DefaultJeans;
import abstractFactory.clothes.DefaultTShirt;
import abstractFactory.clothes.IHat;
import abstractFactory.clothes.IPants;
import abstractFactory.clothes.IShirt;
import abstractFactory.clothes.IShoes;

public class DefaultFactory implements AbstractClothesFactory{

	@Override
	public IHat getCap() {
		return new DefaultCap();
	}

	@Override
	public IShirt getShirt() {
		return new DefaultTShirt();
	}

	@Override
	public IPants getPants() {
		return new DefaultJeans();
	}

	@Override
	public IShoes getShoes() {
		return null;
	}

}
