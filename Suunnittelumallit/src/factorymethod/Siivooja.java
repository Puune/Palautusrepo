package factorymethod;

public class Siivooja extends AterioivaOtus{

	@Override
	public Juoma createJuoma() {
		return new Omenamehu();
	}
	
}
