package visitor;

import visitor.states.Holding;

/**
 * Balancer works states, that manipulate integer amount.
 * @author Panu Lindqvist
 */
public class Balancer extends Thread{
	
	/**
	 * Attack depicts the speed (or delay) that the program reacts to changes
	 */
	private visitor.states.State state;
	private boolean operating = true;
	private int BAL_ATTACK;
	
	public Balancer(int initialValue, int bal_attack) {
		state = new Holding(initialValue, this);
		BAL_ATTACK = bal_attack;
	}
	
	protected void changeState(visitor.states.State state) {
		this.state = state;
	}
	
	public synchronized int changeAmount(int i) {
		System.out.println("changing amount: " + i);
		return state.changeAmount(i);
	}
	
	public void run() {
		int lastValue = 0;
		
		while(operating) {
			int amount = state.operate();
			if(amount != lastValue) {
				System.out.println("Amount: " + amount);
			}
			lastValue = amount;
			delay();
		}
	}
	
	public void delay() {
		try {
			Thread.sleep(BAL_ATTACK);
		} catch (InterruptedException e) {
		}
	}
	
	public void stopOperating() {
		operating = false;
	}
	
	@Override
	public String toString() {
		return state.toString();
	}
} 
