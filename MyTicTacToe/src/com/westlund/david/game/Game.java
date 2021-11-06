package com.westlund.david.game;

import com.westlund.david.board.Board;
import com.westlund.david.input.UserInput;
import com.westlund.david.player.Player;

public class Game {
	private int RoundsToWin;
	private int currentRound;
	private boolean roundWinner;
	
	public Game(int decidedRounds) {
		this.setRoundsToWin(decidedRounds);
		this.setCurrentRound(0);
		this.roundWinner = false;
	}
	
	public int getRoundsToWin() {
		return RoundsToWin;
	}
	public void setRoundsToWin(int maxRoundWins) {
		this.RoundsToWin = maxRoundWins;
	}

	public int getCurrentRound() {
		return currentRound;
	}
	public void setCurrentRound(int currentRound) {
		this.currentRound = currentRound;
	}
	
	public boolean isRoundWinner() {
		return roundWinner;
	}
	public void setRoundWinner(boolean roundWinner) {
		this.roundWinner = roundWinner;
	}
	
	
	public static void createGamePvP() {
		int rounds = UserInput.roundInput();
		Game myGame = new Game(rounds);
		Player.createPlayer(2);
		Board board = new Board();
		
		Player.rndRoundStarter();
		
		myGame.playGame(myGame, board);
	}
	
	private void playGame(Game myGame, Board board) {
		while(!myGame.isRoundWinner()) {
			myGame.setCurrentRound(myGame.getCurrentRound() +1);
			
			for(Player player : Player.getPlayers()) {
				if(player.isRoundStarter()) {
					printRound(player, myGame);
					player.setRoundStarter(false);
					
				} else if(!player.isRoundStarter() && myGame.getCurrentRound() == 1) {
					continue;	
				}
					board.printBoard(board);
					UserInput.boardInput(player, board);
					board.checkRoundWinner(player, board, myGame);//check if the player has won the round
					
					if(player.isRoundWinner()) {
						//Print the player who won
					}
								
			}
		}
	}
	
	public void printRound(Player player, Game myGame) {
		System.out.println("  Round " + myGame.getCurrentRound());
	}




	


}
