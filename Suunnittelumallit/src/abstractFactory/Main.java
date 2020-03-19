package abstractFactory;

public class Main {

	public static void main(String[] args) {
		Jasper jasper = new Jasper();
		
		System.out.println("Perus jasperi");
		jasper.describe();
		
		
		System.out.println("Jasperille uudet kuteet..");
		AbstractClothesFactory tavikset = new DefaultFactory();
		jasper.wear(tavikset);
		jasper.describe();
		
		
		System.out.println("Jasperista tuli inssi..");
		AbstractClothesFactory bossit = new BossFactory();
		jasper.wear(bossit);
		jasper.describe();
	}

}
