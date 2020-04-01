package stateAndTemplate.pokemon;

public class Attack {
	private String name;
	private int damage;
	
	public Attack(String name, int baseDamage) {
		this.name = name;
		this.damage = (int) Math.floor(baseDamage / 1.3 + (Math.random() * 2 * (baseDamage / 3)));
	}
	
	public int getDamage() {
		return damage;
	}
	
	public String getName() {
		return name;
	}
}
