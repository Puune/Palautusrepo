package builder;

import java.util.ArrayList;

public class McDBuilder extends HamburgerBuilder {
	private ArrayList<Content> contents = new ArrayList<>();
	
	@Override
	public void buildBun() {
		contents.add(new Content() {
			@Override
			public String getInfo() {
				return "Hamburger bun";
			}
		});
	}

	@Override
	public void buildSteak() {
		contents.add(new Content() {
			@Override
			public String getInfo() {
				return "McDonalds rubber flapjack";
			}
		});
	}

	@Override
	public void buildSalad() {
		contents.add(new Content() {	
			@Override
			public String getInfo() {
				return "Dry lettuce and pickle";
			}
		});
	}

	@Override
	public void buildSauce() {
		contents.add(new Content() {
			@Override
			public String getInfo() {
				return "Ketchup";
			}
		} );
	}

	@Override
	Object getProduct() {
		return contents;
	}

}
