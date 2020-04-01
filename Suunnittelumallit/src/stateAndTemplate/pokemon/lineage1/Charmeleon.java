package stateAndTemplate.pokemon.lineage1;

import stateAndTemplate.pokemon.Attack;
import stateAndTemplate.pokemon.EvolutionState;
import stateAndTemplate.pokemon.Pokemon;

public class Charmeleon extends EvolutionState{

	public Charmeleon(Pokemon pokemon) {
		super(pokemon);
	}

	@Override
	public int getMaxHealth() {
		return 18;
	}

	@Override
	public String getType() {
		return "Charmeleon";
	}

	@Override
	public Attack getAttack() {
		return new Attack("Tackle", 8);
	}

	@Override
	public int getEvolveThreshold() {
		return 19;
	}

	@Override
	public EvolutionState getNext() {
		return new Charizard(pokemon);
	}

	@Override
	public boolean canRun() {
		return false;
	}

}
