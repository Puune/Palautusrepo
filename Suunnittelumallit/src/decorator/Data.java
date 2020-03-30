package decorator;

public class Data  implements IData{

	protected String data;
	
	@Override
	public String read() {
		return data;
	}

	@Override
	public void write(String data) {	
		this.data = data;
	}

}
