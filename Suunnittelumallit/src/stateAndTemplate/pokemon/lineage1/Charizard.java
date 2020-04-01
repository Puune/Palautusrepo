package stateAndTemplate.pokemon.lineage1;

import stateAndTemplate.pokemon.Attack;
import stateAndTemplate.pokemon.EvolutionState;
import stateAndTemplate.pokemon.Pokemon;

public class Charizard extends EvolutionState {

	public Charizard(Pokemon pokemon) {
		super(pokemon);
	}

	@Override
	public int getMaxHealth() {
		return 25;
	}

	@Override
	public String getType() {
		return "Charizard";
	}

	@Override
	public Attack getAttack() {
		return new Attack("Flamethrower", 30);
	}

	@Override
	public int getEvolveThreshold() {
		return 100;
	}

	@Override
	public EvolutionState getNext() {
		return null;
	}

}
