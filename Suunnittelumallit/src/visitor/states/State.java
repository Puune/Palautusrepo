package visitor.states;

import visitor.Balancer;

public abstract class State {
	
	protected int amount;
	protected Balancer balancer;
	
	public State(int amount, Balancer b) {
		this.amount = amount;
		this.balancer = b;
	}
	
	public int changeAmount(int i) {
		amount = amount + i;;
		return amount;
	}
	
	public Balancer getBalancer() {
		return balancer;
	}
	
	public int getAmount() { return amount; }
	
	public abstract int operate();
	
	public abstract String toString();
}
