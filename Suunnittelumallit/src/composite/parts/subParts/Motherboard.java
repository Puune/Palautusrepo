package composite.parts.subParts;

import composite.parts.Component;

public class Motherboard extends Component {

	public Motherboard(String model, String price) {
		super(model, price);
	}
	
	@Override
	public void addPart(Component c) {
		super.parts.add(c);
	}
}
