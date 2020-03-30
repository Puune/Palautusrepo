package decorator;

import java.util.ArrayList;
import java.util.Scanner;

class Printer {		
	
	ArrayList<IData> list = new ArrayList<>();

	/**
	 * Printer utility
	 * @param list
	 */
	public Printer(ArrayList<IData> list) {
		this.list = list;
	}
	
	public void menu() {
		System.out.println("\n__________SELECT___________");
		System.out.println("1: Read data\n2:write data\n3.quit");
	}
	
	public boolean selectItem() {
		if(list.size()>0) {
			System.out.println("Select file from:");
			for(int i=0; i<list.size(); i++) {
				System.out.println(i + ".");
			}
			System.out.println("\n");
			return true;
		} else {
			System.out.println("list is empty");
			return false;
		}
	}
	
	public void willSecure() {
		System.out.println("Secure new item?\nY/n");
	}
	
	public void askContent() {
		System.out.println("Write file content:");
	}
	
	public void badInput() {
		System.out.println("You have given the program bad input..");
	}
}



/**
 * @author Panu Lindqvist
 * Main app
 */
public class Main {
	static ArrayList<IData> list = new ArrayList<>();
	static Scanner scan = new Scanner(System.in);
	static boolean run = true;
	
	public static void main(String[] args) {
		Printer print = new Printer(list);
		
		while(run) {
			print.menu();
			String in = scan.next();
			int sel = 3;
			
			try {
				sel = Integer.valueOf(in);
			} catch (Exception e) {
				print.badInput();
				continue;
			}
			
			
			switch(sel) {
			case 1: 
				if(!print.selectItem()) { continue; }
				in = scan.next();
				sel = Integer.valueOf(in);
				System.out.println(list.get(sel).read());
				break;
				
			case 2:
				print.willSecure();
				in = scan.next();
				
				if(in.toLowerCase().equals("y")) {
					print.askContent();
					in = scan.next();
					IData d = new DataSecurityDecorator(new Data());
					d.write(in);
					list.add(d);
					
				} else {
					print.askContent();
					in = scan.next();
					IData d = new Data();
					d.write(in);
					list.add(d);
				}
				break;
				
			case 3:
				run = false;
				break;
				
			default:
				print.badInput();
			}
		}
	}
}
