package proxy;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static Scanner scan = new Scanner(System.in);
	
	/**
	 * Test method
	 */
	public static void main(final String[] arguments) {

		ArrayList<Image> folder = new ArrayList<>();

		boolean running = true;
		while (running) {
			System.out.println("***************\n1:write new\n2:browse folder\n3:view image\n4:exit");
			switch(read()) {
			case "1":
				System.out.println("write filename");
				folder.add(new ProxyImage(read()));
				break;
			case "2":
				int n = 1;
				for(Image i : folder) {
					System.out.println(n + ". " + i.getData());
					n++;
				}
				break;
			case "3":
				System.out.println("Select image by index number");
				int num;
				try {
					num = Integer.parseInt(read());
					folder.get(num-1).displayImage();
				}catch(Exception e) {e.printStackTrace();}
				break;
			case "4":
				running = false;
			}
		}
	}
	
	
	static String read() {
		return scan.next();
	}
}
