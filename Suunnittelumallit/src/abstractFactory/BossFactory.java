package abstractFactory;

import abstractFactory.clothes.BossPants;
import abstractFactory.clothes.BossShoes;
import abstractFactory.clothes.BossSuit;
import abstractFactory.clothes.IHat;
import abstractFactory.clothes.IPants;
import abstractFactory.clothes.IShirt;
import abstractFactory.clothes.IShoes;

public class BossFactory implements AbstractClothesFactory{

	@Override
	public IHat getCap() {
		return null;
	}

	@Override
	public IShirt getShirt() {
		return new BossSuit();
	}

	@Override
	public IPants getPants() {
		return new BossPants();
	}

	@Override
	public IShoes getShoes() {
		return new BossShoes();
	}

}
