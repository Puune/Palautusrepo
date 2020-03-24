package observer;

import observer.model.ClockTimer;
import observer.view.DigitalClock;

public class Main {
	
	public static void main(String[] args) {
		ClockTimer ct = new ClockTimer();		
		DigitalClock dc = new DigitalClock(ct);
	}	
}
