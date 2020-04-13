package chainOfResponsibility;

public abstract class Handler {
	private Handler successor;
	
	public Handler(Handler s) {
		successor = s;
	}
	
	public void handle(double amount) {
		if(successor != null) {
			successor.handle(amount);
		}
	}
}
