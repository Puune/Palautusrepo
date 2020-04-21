package builder;

public class HesBuilder extends HamburgerBuilder{
	StringBuilder sb = new StringBuilder();

	@Override
	public void buildBun() {
		sb.append((new Content() {
			@Override
			public String getInfo() {
				return "White burger bun";
			}
		}.getInfo() + "\n"));
	}

	@Override
	public void buildSteak() {
		sb.append((new Content() {
			@Override
			public String getInfo() {
				return "Hesburger steak";
			}
		}.getInfo() + "\n"));
	}

	@Override
	public void buildSalad() {
		sb.append((new Content() {
			@Override
			public String getInfo() {
				return "Lettuce and tomato";
			}
		}.getInfo() + "\n"));
	}

	@Override
	public void buildSauce() {
		sb.append((new Content() {
			@Override
			public String getInfo() {
				return "Bucket of mayonnaise";
			}
		}.getInfo() + "\n"));
	}

	@Override
	Object getProduct() {
		return new String(sb.toString());
	}

}
