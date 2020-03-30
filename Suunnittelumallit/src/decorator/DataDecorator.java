package decorator;

public abstract class DataDecorator implements IData{
	protected IData dataToBeDecorated;
	
	public DataDecorator (IData DataToBeDecorated) {
		this.dataToBeDecorated = dataToBeDecorated;
	}
	
	public String read() {
		return dataToBeDecorated.read();
	}
	
	public void write(String data) {
		dataToBeDecorated.write(data);
	}
}
