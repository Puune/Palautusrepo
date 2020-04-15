package visitor;

public class Main {
	
	public static void main(String[] args) {
		final int TARGET_VALUE = 15;
		final int INIT_VALUE = 30;
		final int BAL_ATTACK_TIME = 200;
		
		StateChangeVisitor.setStaticTarget(TARGET_VALUE);
		Balancer balancer = new Balancer(INIT_VALUE, BAL_ATTACK_TIME);

		balancer.start();

		TaskRunner t1 = new TaskRunner(-5, balancer);
		TaskRunner t2 = new TaskRunner(5, balancer);
//		t1.start();	//Start to create chaos
//		t2.start();	//Start to create chaos
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {		}
	
		balancer.stopOperating();
	}
}
