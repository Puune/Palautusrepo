package singleton;

public class Main {
	public static void main(String[] args) {
		ConfigReaderSingleton conf = ConfigReaderSingleton.getInstance();
		for(int i=0; i<20; i++) {
			//alternate between params
			String param = i%2==0 ? conf.P_MAX : conf.P_MIN;
			
			TaskThread t = new TaskThread(param);
			t.start();
		}
	}
}
	
class TaskThread extends Thread{
	//Each thread gets INSTANCE independently
	ConfigReaderSingleton conf = ConfigReaderSingleton.getInstance();
	private String param;
	
	public TaskThread(String param) {
		this.param = param;
	}
	
	public void run() {
		for(int i=0; i<2; i++) {
			if(Math.random()>0.5) {
				int a = conf.readConfig(param);
				System.out.println(this.getId() + ", " + param + "=" + a);
			} else {
				int a = (int) Math.floor(Math.random() * 1000 * Math.PI / 4);
				a = conf.writeConfig(param, a);
				System.out.println(this.getId() + ", " + param + "=" + a);
			}
			System.out.println();		
		}
	}
}
