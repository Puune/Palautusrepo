package builder;

import builder.parts.Content;
import builder.parts.Product;

public abstract class HamburgerBuilder {	
	protected Product product;
	
	public Product getProduct() { return product; }
	public void createNewProduct() { product = new Product(); }

	
	public abstract void buildBun();
	public abstract void buildSteak();
	public abstract void buildSalad();
	public abstract void buildSauce();
	

	
	
	/**
	 * @author Panu
	 *	Mac D burger builder
	 */
	static class McDBuilder extends HamburgerBuilder{

		@Override
		public void buildBun() {
			super.product.addContent(new Content() {
				@Override
				public String getInfo() {
					return "Hamburger bun";
				}
			});
		}

		@Override
		public void buildSteak() {
			super.product.addContent(new Content() {
				@Override
				public String getInfo() {
					return "McDonalds rubber flapjack";
				}
			});
		}

		@Override
		public void buildSalad() {
			super.product.addContent(new Content() {	
				@Override
				public String getInfo() {
					return "Dry lettuce and pickle";
				}
			});
		}

		@Override
		public void buildSauce() {
			super.product.addContent(new Content() {
				@Override
				public String getInfo() {
					return "Ketchup";
				}
			} );
		}
		
	}
	
	
	/**
	 * @author Panu
	 * Hes B burger builder
	 */
	static class HesBuilder extends HamburgerBuilder{

		@Override
		public void buildBun() {
			super.product.addContent(new Content() {
				@Override
				public String getInfo() {
					return "White burger bun";
				}
			});
		}

		@Override
		public void buildSteak() {
			super.product.addContent(new Content() {
				@Override
				public String getInfo() {
					return "Hesburger steak";
				}
			});
		}

		@Override
		public void buildSalad() {
			super.product.addContent(new Content() {
				@Override
				public String getInfo() {
					return "Lettuce and tomato";
				}
			});
		}

		@Override
		public void buildSauce() {
			super.product.addContent(new Content() {
				@Override
				public String getInfo() {
					return "Bucket of mayonnaise";
				}
			});
		}
		
	}
}
