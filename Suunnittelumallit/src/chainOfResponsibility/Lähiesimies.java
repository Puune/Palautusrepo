package chainOfResponsibility;

public class L�hiesimies extends Handler{

	public L�hiesimies(Handler s) {
		super(s);
	}
	
	@Override
	public void handle(double amount) {
		if(amount<2) {
			System.out.println("L�hiesimies hyv�ksyy " + amount + " % palkankorotuksen");
		} else {
			super.handle(amount);
		}
	}
}
