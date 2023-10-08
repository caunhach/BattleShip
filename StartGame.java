package BattleShip;

import java.util.Arrays;
import java.util.Scanner;

public class StartGame {
	private int try_count;
	private static final String ANSI_RED = "\u001B[31m";
	private static final String ANSI_RESET = "\u001B[0m";
	Scanner out = new Scanner(System.in);
	public StartGame(Game game){
		String input;
		int	size = game.get_size();
		try_count = size * 2;
		int [] guess_coord = new int[2];
		do{
			System.out.println("retry count: " + try_count);
			System.out.print("let's guess coordinates: ");
			input = out.nextLine();
			if (input.length() == 2 && Character.isLetter(input.charAt(0)) && Character.isDigit(input.charAt(1))){
				if (Character.isUpperCase(input.charAt(0))){
					guess_coord[0] = (int)input.charAt(0) - 65;
					guess_coord[1] = Character.getNumericValue(input.charAt(1));
				}
				else{
					guess_coord[0] = (int)input.charAt(0) - 97;
					guess_coord[1] = Character.getNumericValue(input.charAt(1));
				}
				// System.out.println(Arrays.toString(guess_coord));
			}
			else{
				System.out.println(ANSI_RED + "Wrong Valid input. Please try again!" + ANSI_RESET);
				continue;
			}
			try_count--;
		}while(try_count != 0);
	}
}
