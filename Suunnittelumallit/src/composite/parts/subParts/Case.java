package composite.parts.subParts;

import composite.parts.Component;

public class Case extends Component {
	
	public Case(String model, String price) {
		super(model, price);
	}

	@Override
	public void addPart(Component c) {
		super.parts.add(c);
	}

}
