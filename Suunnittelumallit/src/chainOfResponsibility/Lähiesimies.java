package chainOfResponsibility;

public class Lähiesimies extends Handler{

	public Lähiesimies(Handler s) {
		super(s);
	}
	
	@Override
	public void handle(double amount) {
		if(amount<2) {
			System.out.println("Lähiesimies hyväksyy " + amount + " % palkankorotuksen");
		} else {
			super.handle(amount);
		}
	}
}
