package chainOfResponsibility;

public class Yksik�np��llikk� extends Handler {

	public Yksik�np��llikk�(Handler s) {
		super(s);
	}
	
	@Override
	public void handle(double amount) {
		if(amount<5) {
			System.out.println("Yksik�n p��llikk� hyv�ksyy " + amount + " % palkankorotuksen");
		} else {
			super.handle(amount);
		}
	}

}
