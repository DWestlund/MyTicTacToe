package com.westlund.david.input;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import com.westlund.david.player.Player;

import com.westlund.david.board.Board;
import com.westlund.david.console.ConsoleMod;

public class UserInput {
	public static int roundInput() {
		int rounds;
		Scanner scanner = new Scanner(System.in);
			do {
				System.out.print("Number of won rounds to win the game > ");
				try {
					rounds = scanner.nextInt();
					break;				
				} catch(InputMismatchException ex) {
					System.out.println("\nOnly numbers are allowed\n");
					scanner.nextLine();
				}
			} while(true);	
		return rounds;
	}
	
	public static String nameInput(int playerNum) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("\nName player" + playerNum + " > ");	
		String name = scanner.nextLine();
	
		return name;		
	}
	
	public static char symbolInput(String name) {	
		Scanner scanner = new Scanner(System.in);
		char symbol;
		
		if(Player.getPlayers().size() == 0) {
			do {
				System.out.print("Choose to play with symbol 'X' or 'O' > ");
				symbol = scanner.nextLine().toUpperCase().charAt(0);
			}while(symbol != 'X' && symbol != 'O');
		} else {
			symbol = (Player.getPlayers().get(0).getSymbol() == 'X' ? 'O' : 'X');
			System.out.println(name + " plays with symbol '" + symbol + "'\n");
			ConsoleMod.consoleSleep(1500);
		}
		return symbol;
	}
	
	//TODO try med scanner fungerar inte.....
	public static void boardInput(Player player, Board board) {
		Scanner scanner = new Scanner(System.in);
		boolean added = false;
		do {
				try {
					System.out.print(player.getName() + "[" + player.getSymbol() + "] >> ");
					int squareNum = scanner.nextInt();
					
					if(squareNum >= 1 && squareNum <= 9) {
						added = board.setPlayedSquares(squareNum);
						if(added) {
							board.convertAndAddToBoard(squareNum, player, board);
						} else {
							System.out.println("This square is already played...");
						}						
					} else {
						System.out.println("Gameboard is between 1-9...");
					}
				} catch(InputMismatchException ex) {
					scanner.nextLine();
				}			
		}while(!added);

		
	}
	
	
}
