package stateAndTemplate;

import stateAndTemplate.pokemon.Attack;
import stateAndTemplate.pokemon.Pokemon;
import stateAndTemplate.pokemon.PokemonUI;
import stateAndTemplate.pokemon.lineage1.Charmander;
import stateAndTemplate.pokemon.lineage2.BigRattata;
import stateAndTemplate.pokemon.lineage2.Rattata;

abstract class Game {
	 
    protected int playersCount;

    abstract void initializeGame();

    abstract void makePlay(int player);

    abstract boolean endOfGame();

    abstract void printWinner();

    /* A template method : */
    public final void playOneGame(int playersCount) {
        this.playersCount = playersCount;
        initializeGame();
        int j = 0;
        while (!endOfGame()){
            makePlay(j);
            j = (j + 1) % playersCount;
        }
        printWinner();
    }
}


class PokemonGame extends Game {
	PokemonUI ui = PokemonUI.getInstance();
	Pokemon mainPL;
	Pokemon[] opponents;
	
	//cheating
	int overrideJ = 0;

	@Override
	void initializeGame() {
		ui.print("Name your pokemon");
		mainPL = new Pokemon(new Charmander(null), ui.read());
		
		opponents = new Pokemon[playersCount];
		for(int i=0; i<playersCount; i++) {
			opponents[i] = Math.random()>0.5
					? new Pokemon(new Rattata(null), String.valueOf(i)) 
					: new Pokemon(new BigRattata(null),String.valueOf(i));
					
			delay();
		}
		ui.introduceOpponents(opponents);
	}

	@Override
	void makePlay(int player) {
		
		ui.newMatch(opponents[overrideJ]);
		int expGain = 0;
		
		boolean finished = false;
		int round = 1;
		Attack atk;
		while(!finished) {	
			
			if(round%2==1) {
				atk = mainPL.attack();
				expGain += opponents[overrideJ].attackThis(atk);
				ui.attackMove(opponents[overrideJ], mainPL, atk);
				if(opponents[overrideJ].getHealth()<1) {
					ui.endMatch(opponents[overrideJ], mainPL, expGain);
					mainPL.giveExp(expGain);
					finished = true;
				}
				
			} else {
				atk = opponents[overrideJ].attack();
				mainPL.attackThis(atk);
				ui.attackMove(mainPL, opponents[overrideJ], atk);
				if(mainPL.getHealth()<1) {
					ui.endMatch(mainPL, opponents[overrideJ], expGain);
					finished = true;
				}
			}
			round++;
			delay();
		}
		
		overrideJ++;
	}

	@Override
	boolean endOfGame() {
		//dirty deeds, done dirt cheap
		try {
			opponents[overrideJ+1] = opponents[overrideJ+1];
			
			//main pl fainted
			if(mainPL.getHealth()<1){
				return true;
			}
			
			return false;
		} catch(IndexOutOfBoundsException ie) {
			//ran out of opponens
			return true;
		}
	}

	@Override
	void printWinner() {
		if(mainPL.getHealth()<1) {
			ui.endTournament(false, opponents[overrideJ]);
		} else {
			ui.endTournament(true, mainPL);
		}
	}
	
	void delay() {
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}


public class Main {
	
	public static void main(String[] args) {
		PokemonGame pg = new PokemonGame();
		pg.playOneGame(5);
	}
}
