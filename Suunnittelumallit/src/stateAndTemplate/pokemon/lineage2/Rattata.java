package stateAndTemplate.pokemon.lineage2;

import stateAndTemplate.pokemon.Attack;
import stateAndTemplate.pokemon.EvolutionState;
import stateAndTemplate.pokemon.Pokemon;

public class Rattata extends EvolutionState{

	public Rattata(Pokemon pokemon) {
		super(pokemon);
	}

	@Override
	public int getMaxHealth() {
		return 13;
	}

	@Override
	public String getType() {
		return "Rattata";
	}

	@Override
	public Attack getAttack() {
		return new Attack("Scratch", 4);
	}

	@Override
	public int getEvolveThreshold() {
		return 12;
	}

	@Override
	public EvolutionState getNext() {
		return new BigRattata(pokemon);
	}

	@Override
	public boolean canRun() {
		return true;
	}

}
