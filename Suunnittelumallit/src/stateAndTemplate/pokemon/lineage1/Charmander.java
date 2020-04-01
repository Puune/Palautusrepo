package stateAndTemplate.pokemon.lineage1;

import stateAndTemplate.pokemon.Attack;
import stateAndTemplate.pokemon.EvolutionState;
import stateAndTemplate.pokemon.Pokemon;

public class Charmander extends EvolutionState{

	public Charmander(Pokemon pokemon) {
		super(pokemon);
	}

	@Override
	public int getMaxHealth() {
		return 16;
	}

	@Override
	public String getType() {
		return "Charmander";
	}

	@Override
	public Attack getAttack() {
		return new Attack("Ember", 7);
	}

	@Override
	public int getEvolveThreshold() {
		return 7;
	}

	@Override
	public EvolutionState getNext() {
		return new Charmeleon(pokemon);
	}

	@Override
	public boolean canRun() {
		return true;
	}

	
}
