package chainOfResponsibility;

public class Toimitusjohtaja extends Handler {

	public Toimitusjohtaja(Handler s) {
		super(s);
	}
	
	@Override
	public void handle(double amount) {
		System.out.println("Toimitusjohtaja ei hyväksy " + amount + " % palkankorotuspyyntöä");
	}

}
