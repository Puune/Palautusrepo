package visitor;

/**
 * TaskRunner creates chaos for balancer, by adding or removing numbers
 * @author Panu Lindqvist
 */
public class TaskRunner extends Thread{
	private int change;
	private Balancer balancer;
	public TaskRunner(int c, Balancer b) {
		change = c;
		balancer = b;
	}
	
	public void run() {
		delay();
		for(int i=0; i<5; i++){
			balancer.changeAmount(change);
			delay();
		}
	}
	
	private void delay() {
		try {
			Thread.sleep((long) Math.floor(Math.random() * 2500));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
