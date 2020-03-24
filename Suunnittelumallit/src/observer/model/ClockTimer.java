package observer.model;

import java.util.Date;

/**
 * @author Panu Lindqvist
 * ClockTimer
 */
public class ClockTimer  extends Subject{
	
	public ClockTimer() {
		Ticker ticker = new Ticker(this);
		ticker.start();
	}
	
	private Date date = new Date();
	
	@SuppressWarnings("deprecation")
	public int getHours() {
		return date.getHours();
	}
	
	@SuppressWarnings("deprecation")
	public int getMinutes() {
		return date.getMinutes();
	}
	
	@SuppressWarnings("deprecation")
	public int getSeconds() {
		return date.getSeconds();
	}
	
	public void tick() {
		date = new Date();
		notifyObservers();
	}
	
	
	/**
	 * @author Panu Lindqvist
	 * Ticker runnable
	 */
	class Ticker extends Thread{
		ClockTimer timer = null;
		boolean run = true;
		long last = 0;
		
		Ticker(ClockTimer timer){
			this.timer = timer;
		}
		
		@Override
		public void run() {
			//main loop
			while(run) {
				double previous = Math.floor(last / 1000);
				boolean hasChanged = false;
			
				//between seconds loop
				while(!hasChanged) {
					long current_ms = System.currentTimeMillis();
					double current = Math.floor(current_ms / 1000);
					
					if(current>previous) {
						timer.tick();
						last = current_ms;
						hasChanged = true;
					}
				}
			}
		}
	}
}
