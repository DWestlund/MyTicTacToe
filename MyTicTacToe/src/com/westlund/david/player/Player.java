package com.westlund.david.player;

import java.util.ArrayList;

import com.westlund.david.input.UserInput;

public class Player {
	private static ArrayList<Player> players = new ArrayList<Player>();
	private String name;
	private char symbol;
	private boolean roundWinner;
	private boolean gameWinner;
	
	public Player(String name, char symbol){
		this.name = name;
		this.symbol = symbol;
		this.setRoundWinner(false);
		this.setGameWinner(false);
	}
	
	public static ArrayList<Player> getPlayers() {
		return players;
	}

	public String getName() {
		return name;
	}

	public char getSymbol() {
		return symbol;
	}

	public boolean isRoundWinner() {
		return roundWinner;
	}
	public void setRoundWinner(boolean roundWinner) {
		this.roundWinner = roundWinner;
	}

	public boolean isGameWinner() {
		return gameWinner;
	}
	public void setGameWinner(boolean gameWinner) {
		this.gameWinner = gameWinner;
	}
	
	
	public static void createPlayer(int playerCount) {
		for(int i = 1; i <= playerCount; i++) {
			String name = UserInput.nameInput(i);
			char symbol = UserInput.symbolInput(name);
			
			Player player = new Player(name, symbol);
			players.add(player);
		}
			
	}

	


	
}
