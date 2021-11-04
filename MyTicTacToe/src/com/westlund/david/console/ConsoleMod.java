package com.westlund.david.console;

public class ConsoleMod {

	public static void consoleSleep(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
