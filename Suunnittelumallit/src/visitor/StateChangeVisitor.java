package visitor;

import visitor.states.Emptying;
import visitor.states.Gaining;
import visitor.states.Holding;
import visitor.states.State;

public class StateChangeVisitor implements Visitor {
	
	private static int target = 0;
	public static void setStaticTarget(int amount) {
		target = amount;
	}
	

	@Override
	public void visit(State state) {
				
		int amount = state.getAmount();
		Balancer b = state.getBalancer();
		
		if (amount<target && state.getClass()!=Gaining.class) 
			b.changeState(new Gaining(amount, b));
		else if (amount==target && state.getClass()!=Holding.class) 
			b.changeState(new Holding(amount, b));
		else if (amount > target && state.getClass()!=Emptying.class) 
			b.changeState(new Emptying(amount, b));
		else
			return;
		
		System.out.println("Changed state to: "+ b);
	}
}
