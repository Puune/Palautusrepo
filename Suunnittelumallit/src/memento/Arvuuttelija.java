package memento;

public class Arvuuttelija {

	
	public void liityPeliin(Asiakas asiakas) {
		Memento memento = new Memento((int) Math.floor(Math.random()*10));
		asiakas.vastaanotaMemento(memento);
	}
	
	
	public synchronized boolean arvaus(int a, Memento m) {
		if(m.getArvattava()==a) {
			return true;
		} else {
			return false;
		}
	}
	
	
	
	protected class Memento {
		private int arvattava;
		Memento(int i){
			arvattava = i;
		}
		
		private int getArvattava(){
			return arvattava;
		}
	}
}
