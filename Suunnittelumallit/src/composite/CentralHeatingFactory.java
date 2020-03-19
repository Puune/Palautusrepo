package composite;

import composite.parts.CPU;
import composite.parts.Case;
import composite.parts.Component;
import composite.parts.GPU;
import composite.parts.MemoryDrive;
import composite.parts.Motherboard;
import composite.parts.RAM;

public class CentralHeatingFactory implements ComputerFactory{

	@Override
	public Component getCase() {
		return new Case("Lian Li PC-A41", "2909.99");
	}

	@Override
	public Component getMotherboard() {
		return new Motherboard("Asus RAMPAGE V EXTREME", "1640.78");
	}

	@Override
	public Component getCPU() {
		return new CPU("AMD Threadripper 3990X 2.9", "3899.00");
	}

	@Override
	public Component getGPU() {
		return new GPU("NVIDIA Titan V 12 GB", "3899.90");
	}

	@Override
	public Component getRAM() {
		return new RAM("Crucial 64 GB", "1277.77");
	}

	@Override
	public Component getMemoryDrive() {
		return new MemoryDrive("Seagate Nytro Enterprise 15.36 TB 2.5\" Solid State Drive", "4295.00");
	}

}
