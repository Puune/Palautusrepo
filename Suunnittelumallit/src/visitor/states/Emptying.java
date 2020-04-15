package visitor.states;

import visitor.Balancer;
import visitor.StateChangeVisitor;
import visitor.Visitor;

public class Emptying extends State {


	public Emptying(int amount, Balancer b) {
		super(amount, b);
	}

	@Override
	public int operate() {
		super.changeAmount(-1);
		Visitor visitor = new StateChangeVisitor();
		visitor.visit(this);
		return super.amount;
	}
	
	@Override
	public String toString() {
		return "Emptying";
	}
}
