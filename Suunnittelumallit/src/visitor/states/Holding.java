package visitor.states;

import visitor.Balancer;
import visitor.StateChangeVisitor;
import visitor.Visitor;

public class Holding extends State {


	public Holding(int amount, Balancer b) {
		super(amount, b);
	}

	@Override
	public int operate() {
		Visitor visitor = StateChangeVisitor.getInstance();
		visitor.visit(this);
		return super.amount;
	}
	
	
	public String toString() {
		return "Holding";
	}
}
