/*
 * written by Itay Abulafia 303033286
 * 3rd Ex-Blackjack.
 * program "plays" a simplified version of Blackjack against user.
 */
import intro.blackjack.*;

public class Blackjack {
	
	//annauncing all the static fields\ objects so I dont have to call them in every method.
	private static int roundBet;
	private static final int BJACK=21, ZERO=0;
	private static Player user, comp;
	private static BlackjackUI game;
	
	/*running the program*/
	public static void main(String[] args) {
		//initiating classes and running the basic commands
		game = new BlackjackUI();
		user= new Player();
		comp= new Player();
		gameLunch();
		playGame();
		endGame();

	}

	/*makes a new board with players*/
	private static void gameLunch (){
		int START_COINS=1000;

		//dealing with players
		user.addCoins(START_COINS);
		comp.addCoins(START_COINS);

		//dealing with GUI
		game.updateCompBalance(START_COINS);
		game.updateUserBalance(START_COINS);

	}

	/*managing the game*/
	private static void playGame (){

		boolean anotherGame=true;
		do{
			newTurn();
			userTurn();
			if (user.getCardsSum() <= BJACK) //if player looses, no need for comp to play
				compTurn();
			endTurn();
			if ((user.getBalance()>ZERO)&& (comp.getBalance()>ZERO))//check if possible to play
				anotherGame= game.askYesNo("Do you want another game?");
			else
				anotherGame=false;
		}
		while (anotherGame==true);
	}

	/*initializing a new turn*/
	private static void newTurn(){
		//clearing bet, users and GUI's cards. dealing a new game.
		roundBet=ZERO;
		game.setBet(roundBet);
		game.clearCards();
		user.clearCards();
		comp.clearCards();
		askForBet();
		dealCardsStart();	
	}

	/*getting a legal bet from user*/
	private static void askForBet (){
		boolean legalBet= false;
		do{
			roundBet= game.askNumber("Please enter the bet value for this round:");
			
			//checking the bet sum and that the comp and user have the coins to bet on. 
			if ((roundBet > ZERO) && (roundBet <= user.getBalance()) &&
					(roundBet <= comp.getBalance())){
				legalBet= true;
			}
			else{
				if(roundBet <= ZERO)//illegal bet sum
					game.displayErrorMessage("Your bet value must be greater than zero!");
				else//either comp or user doesnt have the coins.
					game.displayErrorMessage("You cannot bet on a value greater than your or the computer's balance!");
			}
		}
		while (legalBet==false);
		game.setBet(roundBet);
	}

	/*dealing the cards at the beginning of the game*/
	private static void dealCardsStart(){
		dealCardToUser();
		dealCardToUser();
		dealCardToComp();
		dealCardToComp();
	}

	/*dealing a card to player*/
	private static void dealCardToUser (){
		Card randomCard= new Card();
		user.addCard(randomCard);
		game.addUserCard(randomCard);
	}

	/*dealing a card to computer*/
	private static void dealCardToComp (){
		Card randomCard= new Card();
		comp.addCard(randomCard);
		game.addCompCard(randomCard);
	}

	/*user turn to play*/
	private static void userTurn(){
		boolean gameOn=true;
		while (gameOn){
			checkAce(user);
			if (user.getCardsSum() == BJACK){// if user hits Blackjack, no need for more cards
				gameOn=false;
				break;
			}
			if (user.getCardsSum() < BJACK){//user can take a card
				if (game.askYesNo("Do you want another card?")){
					dealCardToUser();
					checkAce(user);
					if (user.getCardsSum() > BJACK)
						gameOn= false;
				}
				else
					gameOn= false;
			}
			else// user got mor than 21
				gameOn= false;
		}
	}
	
	/*comp turn to play*/
	private static void compTurn(){
		int SOFT_SIXTEEN=16;
		checkAce(comp);
		while (comp.getCardsSum() <= SOFT_SIXTEEN){//comp play until he get to soft 16.
			dealCardToComp();
			checkAce(comp);
		}
	
	}

	/*checking and lowering aces if needed*/
	private static void checkAce(Player checkPlayer){
		if (checkPlayer.getCardsSum() > BJACK)
			checkPlayer.changeAceHighToLow();
	}

	/*end the turn after user and computer turn*/
	private static void endTurn(){
		if (user.getCardsSum() <= BJACK){// user has a legal hand
			if ((comp.getCardsSum() <= BJACK) &&// comp has a legal hand
					(comp.getCardsSum() > user.getCardsSum())){// comp has a better hand
				game.displayMessage("You lost the game!");
				takeCoins(comp, user);
			}
			else{
				if (user.getCardsSum() > comp.getCardsSum() || //user has a better hand
						(comp.getCardsSum() > BJACK)){//comp has illegal hand
					game.displayMessage("You won the game!");
					takeCoins(user, comp);
				}
				else//no one has a better hand and no one has illegal hand
					game.displayMessage("This game ends with a draw.");
			}
		}
		else{// user has illegal hand
			game.displayMessage("You lost the game!");
			takeCoins(comp, user);
		}


	}

	/*transferring coins from looser to winner*/
	private static void takeCoins (Player winner, Player looser ){
		winner.addCoins(roundBet);
		looser.deductCoins(roundBet);
		game.updateCompBalance(comp.getBalance());
		game.updateUserBalance(user.getBalance());
	}


	/*finishing the game*/
	private static void endGame (){
		game.displayMessage("You finished your session with "+ user.getBalance() + " coins");
		game.close();
	}
}
