package stateAndTemplate.pokemon;

import java.util.Scanner;

public class PokemonUI {	
	//*****************************************************************
	//Singleton stuff
	private PokemonUI() { }
	private static class PUIHolder {
		private static final PokemonUI INSTANCE = new PokemonUI();
	}
	
	public static PokemonUI getInstance() {
		return PUIHolder.INSTANCE;
	}
	//End of singleton stuff
	//*****************************************************************
	
	private static Scanner scan = new Scanner(System.in);
	
	public String read() {
		return scan.next();
	}
	
	public void print(String in) {
		System.out.println(in);
	}
	
	public void introduceOpponents(Pokemon[] ops) {
		System.out.println("Your opponents in this game are..");
		for(Pokemon p : ops) {
			System.out.println(p.getName() + ", a " + p.getEvoState());
		}
		System.out.println("\n");
	}
	
	public void newMatch(Pokemon p) {
		System.out.println("\nA new opponent approaches!");
		System.out.println("It's " + p.getName() + ", a " + p.getEvoState());
		System.out.println("Fight!\n");
	}
	
	public void attackMove(Pokemon target, Pokemon mover, Attack atk) {
		System.out.println(mover.getName() + " attacks " + target.getEvoState() + " with " + atk.getName());
		System.out.println("That did " + atk.getDamage() + " points of damage.\n");
	}
	
	public void run(Pokemon p) {
		System.out.println("Opponent " + p.getName() + " runs away!");
	}
	
	public void runFailed(Pokemon p) {
		System.out.println("Pokemon " + p.getName() + " tries to run but is too stubborn to!");
	}
	
	public void endMatch(Pokemon loser, Pokemon winner, int xp) {
		System.out.println(loser.getName() + " has fainted.");
		System.out.println(winner.getName() + " gains " + xp + " xp!\n");
	}
	
	public void evolving(Pokemon p) {
		System.out.println("\n==============================");
		System.out.println("What! " + p.getName() + " is evolving!");
		System.out.println(p.getName() + " has evolved to " + p.getEvoState());
		System.out.println("==============================");
	}
	
	public void endTournament(boolean playerWin, Pokemon winner) {
		if(playerWin) {
			System.out.println("The player has won the Tournament!");
		} else {
			System.out.println("The opponents have won the Tournament..");
		}
		System.out.println("The winner " + winner.getEvoState() + ", " + winner.getName());
		System.out.println("has " + winner.getExp() + " experience points");
		System.out.println("was left with " + winner.getHealth() + " health.");
	}
}
