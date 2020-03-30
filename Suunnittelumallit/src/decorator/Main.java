package decorator;

import java.util.Scanner;

public class Main {
	static Scanner scan = new Scanner(System.in);
	static boolean run = true;
	
	public static void main(String[] args) {
		while(run) {
			System.out.println("\n__________SELECT___________");
			System.out.println("1: Read data\n2:write data\n3.quit");
			String in = scan.next();
			int sel = 3;
			try {
				sel = Integer.valueOf(in);
			} catch (Exception e) {}
			
			switch(sel) {
			case 1: 
				
			}
		}
	}
}