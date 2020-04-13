package chainOfResponsibility;

public class Yksikönpäällikkö extends Handler {

	public Yksikönpäällikkö(Handler s) {
		super(s);
	}
	
	@Override
	public void handle(double amount) {
		if(amount<5) {
			System.out.println("Yksikön päällikkö hyväksyy " + amount + " % palkankorotuksen");
		} else {
			super.handle(amount);
		}
	}

}
