package prototype;

public class Main {	
	public static void main(String[] args) {
		Clock clock = new Clock();
		clock.setName("original clock");
		clock.clockStart();

		delay(4000);
		System.out.println("*** clone clock ***");
		
		Clock copy = clock.clone(); 
		copy.clockStart();
		
		delay(4000);
		System.out.println("Rename copy");
		copy.setName("copy clock");
		
		
		delay(4000);
		System.out.println("*** add 45s to copy *** ");
		copy.addTime(45);
		
		delay(6000);
		clock.stop();
		copy.stop();
	}
	
	private static void delay(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
