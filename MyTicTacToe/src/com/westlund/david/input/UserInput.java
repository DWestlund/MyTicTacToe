package com.westlund.david.input;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.westlund.david.player.Player;
import com.westlund.david.console.ConsoleMod;

public class UserInput {
	
	public static int roundInput() {
		Scanner scanner = new Scanner(System.in);
		
		int rounds;
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
		
		char symbol='X';
		if(Player.getPlayers().size() == 0) {
			do {
				System.out.print("Choose to play with symbol 'X' or 'O' > ");
				symbol = scanner.nextLine().toUpperCase().charAt(0);
			} while(symbol != 'X' && symbol != 'O');
		} else {
			symbol = (Player.getPlayers().get(0).getSymbol() == 'X' ? 'O' : 'X');
		}
		
		System.out.println(name + " is symbol '" + symbol + "'");
		ConsoleMod.consoleSleep(1500);
		
		return symbol;
	}
	
	
}
