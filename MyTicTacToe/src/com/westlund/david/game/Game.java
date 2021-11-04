package com.westlund.david.game;

import com.westlund.david.input.UserInput;
import com.westlund.david.player.Player;

public class Game {
	private int maxRoundWins;
	private int currentRound;
	private boolean endGame;
	
	public Game(int decidedRounds) {
		this.setMaxRoundWins(decidedRounds);
		this.setCurrentRound(0);
		this.endGame = false;
	}
	
	public int getMaxRoundWins() {
		return maxRoundWins;
	}
	public void setMaxRoundWins(int maxRoundWins) {
		this.maxRoundWins = maxRoundWins;
	}

	public int getCurrentRound() {
		return currentRound;
	}
	public void setCurrentRound(int currentRound) {
		this.currentRound = currentRound;
	}
	
	public boolean isEndGame() {
		return endGame;
	}
	public void setEndGame(boolean endGame) {
		this.endGame = endGame;
	}

	
	public static void createGamePvP() {
		int rounds = UserInput.roundInput();
		Game myGame = new Game(rounds);
		Player.createPlayer(2);
		myGame.playGame(myGame);
	}
	
	private void playGame(Game myGame) {
		//TODO skapa klassen Board
		//TODO
		
		for(Player player : Player.getPlayers()) {
			
			//Loop som körs så player.gameWinner är false
				
				//Loop som körs så länge player.roundWinner är false
				//Eller om alla rutor är spelade i board
			
		}

		
	}


	


}
