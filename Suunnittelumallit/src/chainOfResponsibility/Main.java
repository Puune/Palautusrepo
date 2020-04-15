package chainOfResponsibility;

public class Main {

	public static void main(String[] args) {
		Toimitusjohtaja t = new Toimitusjohtaja(null);
		Yksikönpäällikkö yp = new Yksikönpäällikkö(t);
		Lähiesimies le = new Lähiesimies(yp);
		
		int i = 0;
		while(i<30) {
			double amount = Math.floor(Math.random() * 75) / 10;
			le.handle(amount);
			i++;
			delay();
		}
	}
	
	private static void delay() {
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
