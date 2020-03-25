package singleton;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * @author Panu Lindqvist
 * configs.txt lue ja kirjoita työkalu, data säilötty mallia {key}={value};\n
 * Tämän ei pitänyt olla näin laaja, mutta tulipa tehtyä
 */
public class ConfigReaderSingleton {
	
	//**********************************************************
	//Singleton stuff
	private ConfigReaderSingleton() { 	}
	
	private static class CRSHolder {
		private static final ConfigReaderSingleton INSTANCE = new ConfigReaderSingleton();
	}
	
	public static ConfigReaderSingleton getInstance() {
		return CRSHolder.INSTANCE;
	}
	//end of singleton stuff
	//***********************************************************
	
	private static String FILEPATH = "src/singleton/configs.txt";
	
	public final String P_MAX = "MAX_NUMBER";
	public final String P_MIN = "MIN_NUMBER";
	
	private Object lock = new Object();
	
	private boolean operating = false;
	
	/**
	 * Read lines until searched param is found, return value. 
	 * Thread-safe
	 * @param PARAM String
	 * @return config int
	 */
	public int readConfig(String PARAM) {	
		int result = 0;		
		synchronized(lock) {
			lock();
			try(
					FileReader fr = new FileReader(FILEPATH); 
					BufferedReader br = new BufferedReader(fr);) 
			{	
				String line = "";
				while(line != null) {
					line = br.readLine();
					if(line.contains(PARAM)) {
						int i = line.indexOf("=");
						String res = line.substring(i+1, line.length()-1);
						result = Integer.parseInt(res);
						break;
					}
				}
				
				fr.close();
			} catch(Exception e) {
				System.out.println("Exception reading configs");
				e.printStackTrace();
			}
			unlock();
		}				
		return result;
	}
	
	/**
	 * Read lines until searcher PARAM is found, replace value.
	 * Thread-safe
	 * @param PARAM String
	 * @param newConfig int
	 * @return config int
	 */

	public int writeConfig(String PARAM, int newConfig) {
		int result = 0;
		StringBuffer file = new StringBuffer();
		
		synchronized(lock) {
			lock();
			try (
					FileReader fr = new FileReader(FILEPATH);
					BufferedReader br = new BufferedReader(fr))
			{
				String line = br.readLine();
				
				while(line != null) {
					file.append(line);
					file.append("\n");
					line = br.readLine();
				}				
				fr.close();
			} catch(Exception e) {
				System.out.println("Exception reading configs");
				e.printStackTrace();
			}
			
			//find param + skip to end of param + skip "="
			int startIndex = file.lastIndexOf(PARAM) + PARAM.length() + 1;
			int edit = 0;
			int endIndex = startIndex;
			while(!file.substring(endIndex, endIndex+1).equals(";")) {
				endIndex++;
			}
			String change = String.valueOf(newConfig);
			/* Handle changing all indexes in old file */
			while(edit<endIndex-startIndex) {
				String s = "";
				if(edit<change.length()) {
					s = change.substring(edit, edit+1);
				} else {
					file.replace(startIndex+edit, endIndex, "");
					break;
				}
				file.replace(edit+startIndex, edit+startIndex+1, s);
				edit++;
			}
			/*  handle there being more indexes than before */
			if(edit<change.length()-1) {
				String s = change.substring(edit);
				file.insert(startIndex+edit, s);
			}	
			try (
					FileOutputStream fos = new FileOutputStream(FILEPATH))
			{
				fos.write(file.toString().getBytes());
				fos.close();
			} catch(Exception e) {
				System.out.println("Exception writing configs");
				e.printStackTrace();
			}
			unlock();
		}
		return result;
	}
	
	
	/**
	 * - wait for unlock  
	 * - lock when getting to operate
	 */
	private void lock() {
		while(operating) {
			try {
				lock.wait();
			} catch (InterruptedException e) {}
		}
		operating = true;
	}
	
	/**
	 * Release lock
	 */
	private void unlock() {
		operating = false;
		lock.notifyAll();
	}
}
