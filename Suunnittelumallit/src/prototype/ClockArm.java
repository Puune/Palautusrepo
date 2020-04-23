package prototype;

public class ClockArm extends Thread implements Cloneable {

	private boolean running = true;
	private int secondsPerTick = 1;
	private volatile int time = 0;
	private String name = "";
	private Clock clock;
	
	public ClockArm(int secondsPerTick, String name, Clock clock) {
		this.secondsPerTick = secondsPerTick;
		this.name = name;
		this.clock = clock;
		this.time = time;
	}
	
	
	/**
	 * For Clone()
	 * @param secondsPerTick
	 * @param name
	 * @param clock
	 * @param Time
	 */
	private ClockArm(int secondsPerTick, String name, Clock clock, int time){
		this.secondsPerTick = secondsPerTick;
		this.name = name;
		this.clock = clock;
		this.time = time;
	}
	
	public void setClock(Clock clock) {
		this.clock = clock;
	}
	
	
	/*
	 * Oh no, Thread doesn't support Cloning :( 
	 */
	@Override
	public Object clone() throws CloneNotSupportedException {
//		return super.clone();
		return new ClockArm(secondsPerTick, name, clock, time);
	}
	
	@Override
	public void run() {
		long previousTime = System.currentTimeMillis();
		previousTime = (long) Math.floor(previousTime / 1000);
		while(running) {
			long currentTime = (long) System.currentTimeMillis() / 1000;
			if(currentTime-previousTime >= 1) {
				time++;
				if(time % secondsPerTick == 0) {
					clock.update(this);
				}
				previousTime = (long) Math.floor(currentTime);
			}
		}
	}
	
	
	public String getArmName() {
		return name;
	}
	
	public void addTime(int seconds) {
		time += seconds;
	}
	
	public void end() {
		running = false;
	}
}
