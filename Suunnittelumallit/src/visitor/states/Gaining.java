package visitor.states;

import visitor.Balancer;
import visitor.StateChangeVisitor;
import visitor.Visitor;

public class Gaining extends State{
	
	public  Gaining(int amount, Balancer b) {
		super(amount, b);
	}

	@Override
	public int operate() {
		super.changeAmount(1);
		Visitor visitor = StateChangeVisitor.getInstance();
		visitor.visit(this);
		return super.amount;
	}

	
	@Override
	public String toString() {
		return "Gaining";
	}
}
