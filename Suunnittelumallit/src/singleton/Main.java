package singleton;

public class Main {
	public static void main(String[] args) {
		ConfigReaderSingleton conf = ConfigReaderSingleton.getInstance();
		Thread a = new TaskThread(conf.P_MAX);
		Thread b = new TaskThread(conf.P_MIN);
		Thread c = new TaskThread(conf.P_MAX);
		
		a.start();
		b.start();
		c.start();
	}
}
	
class TaskThread extends Thread{
	ConfigReaderSingleton conf = ConfigReaderSingleton.getInstance();
	private String param;
	public TaskThread(String param) {
		this.param = param;
	}
	
	public void run() {
		for(int i=0; i<1000; i++) {
			if(Math.random()>0.5) {
				int a = conf.getInstance().readConfig(param);
				System.out.println(this + ", " + param + "=" + a);
			} else {
				int a = (int) Math.floor(Math.random() * 100 * Math.PI / 4);
				System.out.println(this + ", " + param + "=" + a);
			}
		}
	}
}
