package stateAndTemplate.pokemon.lineage2;

import stateAndTemplate.pokemon.Attack;
import stateAndTemplate.pokemon.EvolutionState;
import stateAndTemplate.pokemon.Pokemon;

public class BigRattata extends EvolutionState {

	public BigRattata(Pokemon pokemon) {
		super(pokemon);
	}

	@Override
	public int getMaxHealth() {
		return 16;
	}

	@Override
	public String getType() {
		return "Raticate";
	}

	@Override
	public Attack getAttack() {
		return new Attack("HyperBeam", 8);
	}

	@Override
	public int getEvolveThreshold() {
		return 100;
	}

	@Override
	public EvolutionState getNext() {
		return null;
	}

	@Override
	public boolean canRun() {
		return false;
	}

}
