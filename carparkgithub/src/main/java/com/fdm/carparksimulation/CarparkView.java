package com.fdm.carparksimulation;

import java.util.Scanner;

public class CarparkView implements iCarparkView {

	private Scanner scanner;

	public CarparkView() {
		scanner = new Scanner(System.in);
	}
	
	public void println(String message) {
		System.out.println(message);
	}

	public int nextInt() {
		int totalSpaces = scanner.nextInt();
		return totalSpaces;
	}

	public String nextLine() {
		String input = scanner.nextLine();
		return input;
	}

}


