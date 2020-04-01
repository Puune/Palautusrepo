package stateAndTemplate.pokemon;

public abstract class EvolutionState {	
	private PokemonUI ui = PokemonUI.getInstance();
	protected Pokemon pokemon;
	public EvolutionState(Pokemon pokemon) {
		this.pokemon = pokemon;
	}
	
	public void checkEvolve() {
		if(pokemon.getExp()>getEvolveThreshold()) {
			EvolutionState next = getNext();
			if(next != null) {
				pokemon.update(next);
				ui.evolving(pokemon);
			}
		}
	}
	
	public abstract int getMaxHealth();
	public abstract String getType();
	public abstract Attack getAttack();
	public abstract int getEvolveThreshold();
	public abstract EvolutionState getNext();
}
