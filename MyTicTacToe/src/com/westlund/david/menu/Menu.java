package com.westlund.david.menu;

import com.westlund.david.game.Game;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
	private static Scanner scanner = new Scanner(System.in);

	public static void displayMenu() {
		int menuInput = -1;
		do {
			System.out.println("[1] Player vs Player");
			System.out.println("[2] Player vs Computer");
			System.out.println("[3] How to play");
			System.out.println("[0] Exit game");
			System.out.print(">>> ");

			try {
				menuInput = scanner.nextInt();

				switch (menuInput) {
				case 1:
					Game.createGamePvP();
					break;
				case 0:
					System.out.println("\nI hope you enjoyed my awesome game, BYE\n");
					break;
				default:
					System.out.println("\nChoose a option from the menu...\n");
					continue;
				}
			} catch (InputMismatchException ex) {
				System.out.println("\nThat is not in the menu...\n");
				scanner.nextLine();
			}
		} while (menuInput != 0);
	}
}
