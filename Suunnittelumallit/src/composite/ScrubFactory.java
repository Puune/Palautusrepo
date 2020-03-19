package composite;

import composite.parts.CPU;
import composite.parts.Case;
import composite.parts.Component;
import composite.parts.GPU;
import composite.parts.MemoryDrive;
import composite.parts.Motherboard;
import composite.parts.RAM;

public class ScrubFactory implements ComputerFactory{

	@Override
	public Component getCase() {
		return new Case("Open air", "0");
	}

	@Override
	public Component getMotherboard() {
		return new Motherboard("Optiplex 790 MT PG55N Intel Q65 Chipset LGA1155/Socket DDR3 SDRAM Desktop Motherboard ", "18.55");
	}

	@Override
	public Component getCPU() {
		return new CPU("Intel Q65 Express Chipset", "--");
	}

	@Override
	public Component getGPU() {
		return new GPU("Integrated graphics card", "--");
	}

	@Override
	public Component getRAM() {
		return new RAM("Integrated RAM", "--");
	}

	@Override
	public Component getMemoryDrive() {
		return new MemoryDrive("Sandisk 64GB usb-drive", "11.49");
	}


}
