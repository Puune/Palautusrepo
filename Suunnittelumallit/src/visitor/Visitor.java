package visitor;

import visitor.states.State;

public interface Visitor {
	public void visit(State state);
}
