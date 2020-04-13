package memento;

import memento.Arvuuttelija.Memento;

public class Asiakas extends Thread {
	private Memento m = null;
	private Arvuuttelija a;
	
	public Asiakas(Arvuuttelija a) {
		this.a = a;
	}
	
	public void vastaanotaMemento(Memento memento) {
		m = memento;
	}

	@Override
	public void run() {
		boolean oikeaVastaus = false;
		int yritykset = 0;
		while(!oikeaVastaus) {
			oikeaVastaus = a.arvaus((int) Math.floor(Math.random() * 10), m);
			yritykset++;
		}
		
		System.out.println(this.getId() + " Arvasi " + yritykset + " kertaa.");
	}
}
