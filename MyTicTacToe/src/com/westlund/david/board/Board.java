package com.westlund.david.board;

import java.util.HashSet;

import com.westlund.david.game.Game;
import com.westlund.david.player.Player;

public class Board {
	private char[][] boardArray;
	private HashSet<Character> playedSquares;
	
	public Board() {
		char[][] newBoardArr = {{'1', '2', '3'}, {'4', '5', '6'}, {'7', '8', '9'}}; 
		
		this.setBoardArray(newBoardArr);
		this.playedSquares = new HashSet<Character>();
	}

	public char[][] getBoardArray() {
		return boardArray;
	}
	public void setBoardArray(char[][] boardArray){
		this.boardArray = boardArray;
	}
	
	public HashSet<Character> getPlayedSquares() {
		return playedSquares;
	}
	public boolean setPlayedSquares(int squareNr) {
		boolean added = this.playedSquares.add((char) (squareNr + '0'));	
		return added;
	}

	
	public void printBoard(Board board) {
		for(int row = 0; row < board.getBoardArray().length; row++) {
			for(int col = 0; col < board.getBoardArray()[row].length; col++) {
				System.out.print((col != 0) ? " | " + board.boardArray[row][col] : " " + board.boardArray[row][col]);
			}
			System.out.println((row != 2) ? "\n-----------" : "");
		}
	}

	public void convertAndAddToBoard(int squareNum, Player player, Board board) {
		int row, col;
		
		//What row squareNum is
		if(squareNum == 1 || squareNum == 2 || squareNum == 3)
			row = 0;
		else if(squareNum == 4 || squareNum == 5 || squareNum == 6)
			row = 1;
		else
			row = 2;
		
		//Whar column squareNum is
		if(squareNum == 1 || squareNum == 4 || squareNum == 7)
			col = 0;
		else if(squareNum == 2 || squareNum == 5 || squareNum == 8)
			col = 1;
		else
			col = 2;
		
		addMove(row, col, player, board);
		
	}
	
	private static void addMove(int row, int col, Player player, Board board) {
		char[][] tempBoard = board.getBoardArray();
		tempBoard[row][col] = player.getSymbol();		
		board.setBoardArray(tempBoard);
		
	}
	
	public void checkRoundWinner(Player player, Board board, Game myGame) {
		
		//Check if player has won vertically
		if(board.getBoardArray()[0][0] == player.getSymbol() && board.getBoardArray()[0][1] == player.getSymbol() && board.getBoardArray()[0][2] == player.getSymbol()) {
			myGame.setRoundWinner(true);
			player.setRoundWinner(true);
		}
		else if(board.getBoardArray()[1][0] == player.getSymbol() && board.getBoardArray()[1][1] == player.getSymbol() && board.getBoardArray()[1][2] == player.getSymbol()) {
			myGame.setRoundWinner(true);
			player.setRoundWinner(true);
		}
		else if(board.getBoardArray()[2][0] == player.getSymbol() && board.getBoardArray()[2][1] == player.getSymbol() && board.getBoardArray()[2][2] == player.getSymbol()) {
			myGame.setRoundWinner(true);
			player.setRoundWinner(true);
		}
		
		//Check if player has won horisontally
		if(board.getBoardArray()[0][0] == player.getSymbol() && board.getBoardArray()[1][0] == player.getSymbol() && board.getBoardArray()[2][0] == player.getSymbol()) {
			myGame.setRoundWinner(true);
			player.setRoundWinner(true);
		}
		else if(board.getBoardArray()[0][1] == player.getSymbol() && board.getBoardArray()[1][1] == player.getSymbol() && board.getBoardArray()[2][1] == player.getSymbol()) {
			myGame.setRoundWinner(true);
			player.setRoundWinner(true);
		}
		else if(board.getBoardArray()[0][2] == player.getSymbol() && board.getBoardArray()[1][2] == player.getSymbol() && board.getBoardArray()[2][2] == player.getSymbol()) {
			myGame.setRoundWinner(true);
			player.setRoundWinner(true);
		}
		
		//Check if winner has won diagonally
		if(board.getBoardArray()[0][0] == player.getSymbol() && board.getBoardArray()[1][1] == player.getSymbol() && board.getBoardArray()[2][2] == player.getSymbol()) {
			myGame.setRoundWinner(true);
			player.setRoundWinner(true);
		}
		else if(board.getBoardArray()[0][2] == player.getSymbol() && board.getBoardArray()[1][1] == player.getSymbol() && board.getBoardArray()[2][0] == player.getSymbol()) {
			myGame.setRoundWinner(true);
			player.setRoundWinner(true);
		}
	}
	
	
}
