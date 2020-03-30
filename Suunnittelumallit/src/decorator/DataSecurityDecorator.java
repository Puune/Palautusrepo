package decorator;

public class DataSecurityDecorator extends DataDecorator{

	public DataSecurityDecorator(IData DataToBeDecorated) {
		super(DataToBeDecorated);
	}
	
	@Override
	public String read() {
		
	}
	
	@Override
	public void write(String data) {
		
	}
}
