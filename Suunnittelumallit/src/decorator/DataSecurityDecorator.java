package decorator;

import java.util.Scanner;

public class DataSecurityDecorator extends DataDecorator{

	Scanner scan = new Scanner(System.in);
	private String username;
	private String psw;
	
	public DataSecurityDecorator(IData DataToBeDecorated) {
		super(DataToBeDecorated);
	}
	
	@Override
	public String read() {
		if(validationRoutine()) {
			return super.read();
		}
		return null;
	}
	
	@Override
	public void write(String data) {
		if(validationRoutine()) {
			super.write(data);
		} else {
			return;
		}
	}
	
	
	/**
	 * Ask and check creds
	 * @return valid boolean
	 */
	private boolean validationRoutine() {
		System.out.println("Please input credentials,\nusername:");
		String inputUname = scan.next();
		
		System.out.println("\npassword:");
		String inputPsw = scan.next();
		
		if(username==null) {
			//initial write
			username = inputUname;
			psw = inputPsw;
			return true;
			
		} else if(inputPsw.equals(psw) && inputUname.equals(username)) {
			return true;
			
		} else {
			return false;
		}
	}
}
