package composite;

import composite.parts.Component;

public class Main {

	public static void main(String[] args) {
		
		/*
		 * First computer
		 */
		System.out.println("build a potato");
		ComputerFactory scrub = new ScrubFactory();
		
		Component mobo = scrub.getMotherboard();
		mobo.addPart(scrub.getCPU());
		mobo.addPart(scrub.getGPU());
		mobo.addPart(scrub.getMemoryDrive());
		mobo.addPart(scrub.getRAM());
		Component cCase = scrub.getCase();
		cCase.addPart(mobo);
		
		cCase.printDescription();
		System.out.println("total: " + cCase.getCombinedPrice());
		
		
		/*
		 * 2nd computer
		 */
		System.out.println("\n\nbuild a new heating unit for your apartment");
		ComputerFactory warm = new CentralHeatingFactory();
		
		mobo = warm.getMotherboard();
		for(int i=0; i<2; i++) {
			mobo.addPart(warm.getRAM());
			mobo.addPart(warm.getGPU());
			
			for(int j=0; j<2; j++) {
				mobo.addPart(warm.getMemoryDrive());
			}
		}
		mobo.addPart(warm.getCPU());
		
		cCase = warm.getCase();
		cCase.addPart(mobo);
		
		cCase.sort();
		cCase.printDescription();
		System.out.println("total: " + cCase.getCombinedPrice());

	}
	

}
