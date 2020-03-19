package composite;

import composite.parts.Component;

public interface ComputerFactory {	
		
	public Component getCase();
	
	public Component getMotherboard();
	
	public Component getCPU();
	
	public Component getGPU();
	
	public Component getRAM();
	
	public Component getMemoryDrive();
}
