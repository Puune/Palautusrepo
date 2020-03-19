package composite;

import composite.parts.Component;
import composite.parts.subParts.CPU;
import composite.parts.subParts.Case;
import composite.parts.subParts.GPU;
import composite.parts.subParts.MemoryDrive;
import composite.parts.subParts.Motherboard;
import composite.parts.subParts.RAM;

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
