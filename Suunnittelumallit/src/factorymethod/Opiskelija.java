package factorymethod;

public class Opiskelija extends AterioivaOtus {

	@Override
	public Juoma createJuoma() {
		return new Olut();
	}

}
