package chainOfResponsibility;

public class Yksikönpäällikkö extends Handler {

	public Yksikönpäällikkö(Handler s) {
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
