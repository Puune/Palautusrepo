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
		int time[] = { ct.getHours(), ct.getMinutes(), ct.getSeconds() };
		
		String[] print = new String[3];
		for(int i=0; i<3; i++) {
			if(time[i]<9) {
				print[i] = "0" + time[i];
			} else {
				print[i] = String.valueOf(time[i]);
			}
		}
		
		System.out.println(print[0] + ":" + print[1] + ":" + print[2]);
	}
}
