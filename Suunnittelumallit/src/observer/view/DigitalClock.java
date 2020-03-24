package observer.view;

import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import observer.model.ClockTimer;

public class DigitalClock  implements Observer{
	
	private ClockTimer ct;

	public DigitalClock(ClockTimer ct) {
		this.ct = ct;
		ct.attach(this);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		draw();
	}
	
	private void draw() {
		System.out.println("DigitalClock");
		System.out.println(ct.getHours() + ":" + ct.getMinutes() + ":" + ct.getSeconds());
	}
}
