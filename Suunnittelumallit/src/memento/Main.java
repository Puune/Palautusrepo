package memento;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		final int ASIAKKAAT = 10;
		
		Arvuuttelija a = new Arvuuttelija();
		ArrayList<Asiakas> asiakkaat = new ArrayList<>();
		
		for(int i=0; i<ASIAKKAAT; i++) {
			asiakkaat.add(new Asiakas(a));
			a.liityPeliin(asiakkaat.get(i));
		}
		
		for(int i=0; i<ASIAKKAAT; i++) {
			asiakkaat.get(i).start();
		}
	}
}
