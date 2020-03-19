package abstractFactory.clothes;

public class DefaultTShirt implements IShirt{
	String description = "Tavallinen t-paita";
	
	public String toString() {
		return description;
	}
}
