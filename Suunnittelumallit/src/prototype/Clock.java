package prototype;

public class Clock implements Cloneable{
	private ClockArm secondsArm;
	private ClockArm minutesArm;
	private volatile int minutes = 0;
	private volatile int seconds = 0;
	private String name ="";
	
	public Clock() {
		secondsArm = new ClockArm(1, "seconds", this);
		minutesArm = new ClockArm(60, "minutes", this);
	}
	
	public void clockStart() {
		secondsArm.start();
		minutesArm.start();
	}
	
	public void setClockArms(ClockArm seconds, ClockArm minutes) {
		this.minutesArm = minutes;
		this.minutesArm.setClock(this);
		this.secondsArm = seconds;
		this.secondsArm.setClock(this);
	}
	
	
	public void update(ClockArm clockArm) {
		if(clockArm.equals(secondsArm)) {
			seconds++;
			if(seconds>= 60)
				seconds = 0;
			System.out.println(minutes + ":" + (seconds<10 ? "0" : "") + seconds + "  " + name);
		} else if(clockArm.equals(minutesArm)) {
			minutes++;
		}
			}
	

	public void addTime(int seconds) {
		int minutes = (int)  Math.floor(seconds / 60);
		seconds = seconds - (minutes * 60);
				
		this.minutes += (int) Math.floor(seconds / 60);
		this.seconds += seconds % 60;
		
		minutesArm.addTime(seconds); 
		secondsArm.addTime(seconds);
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public Clock clone() {
		Clock copy = null;
		try {
			copy = (Clock) super.clone();
			copy.setClockArms((ClockArm) secondsArm.clone(), (ClockArm) minutesArm.clone());
		
		} catch (CloneNotSupportedException cnse) {
			cnse.printStackTrace();
		}
		return copy;
	}

	public void stop() {
		minutesArm.end();
		secondsArm.end();
	}
	
	
}
