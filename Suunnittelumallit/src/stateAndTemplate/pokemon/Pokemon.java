package stateAndTemplate.pokemon;

public class Pokemon {

	// stay/cumulate over Pokemon's lifetime
	private int experience;
	private String name;
	
	// get overridden by statechange.
	private int health;
	private EvolutionState state;
	
	
	/**
	 * Create new pokemon
	 * @param state {@link EvolutionState}
	 * @param name String
	 */
	public Pokemon(EvolutionState intitialState, String name) {
		this.state = intitialState;
		state.pokemon = this;
		this.name = name;
		health = state.getMaxHealth();
	}
	
	
	/**
	 * Update context
	 * @param state {@link EvolutionState}
	 */
	protected void update(EvolutionState state) {
		this.state = state;
		health = state.getMaxHealth();
	}
	
	
	/**
	 * Attack this pokemon
	 * @param atk {@link Attack}
	 * @return experiencepoints int
	 */
	public int attackThis(Attack atk) {
		health = health - atk.getDamage();
		return (int) Math.ceil(atk.getDamage() / 2 * (Math.random() * 2));
	}
	
	
	/**
	 * Get this pokemon's attack move
	 */
	public Attack attack() {
		return state.getAttack();
	}
	

	public int getExp() {
		return experience;
	}
	public void giveExp(int exp) {
		experience += exp;
		state.checkEvolve();
	}
	public String getEvoState() {
		return state.getType();
	}
	public String getName() {
		return name;
	}
	public int getHealth() {
		return health;
	}
}
