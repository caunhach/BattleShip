package BattleShip;

import java.util.Arrays;
import java.util.Scanner;

public class StartGame {
	private int try_count;
	private boolean exit_status = true;
	private static final String ANSI_RED = "\u001B[31m";
	private static final String ANSI_RESET = "\u001B[0m";
	private static final String ANSI_GREEN = "\u001B[32m";
	private static final String ANSI_BLACK = "\u001B[30m";
	private static final String ANSI_BLUE = "\u001B[34m";
	Scanner out = new Scanner(System.in);
	public StartGame(Game game){
		initialize(game);
	}
	public void initialize(Game game){
		String input;
		int	size = game.get_size();
		int kill = 0;
		try_count = size * 2;
		int [] guess_coord = new int[2];
		do{
			System.out.println(ANSI_BLACK + "retry count: " + ANSI_RESET + try_count);
			System.out.print(ANSI_BLACK + "let's guess coordinates: " + ANSI_RESET);
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
				if (guess_coord[0] > size - 1 || guess_coord[1] > size - 1){
					System.out.println(ANSI_RED + "Coordinates is not in grid's boundary. Please try again!" + ANSI_RESET);
					continue;
				}
			}
			else{
				System.out.println(ANSI_RED + "Wrong Valid input. Please try again!" + ANSI_RESET);
				continue;
			}
			if (game.Check_kill(guess_coord))
				kill++;
			if (kill == 3){
				System.out.println(ANSI_GREEN + "<< Congrat you send all dot coms to Sky 404! >>" + ANSI_RESET);
				System.out.print("Type start for new game/ exit to quit: ");
				break;
			}
			try_count--;
		}while(try_count != 0);
		if (try_count == 0)
			System.out.println(ANSI_RED + "<< Enough time!!! not today for you ... >>" + ANSI_RESET);
		System.out.print(ANSI_BLUE + "Type start for new game/ exit to quit: " + ANSI_RESET);
		input = out.nextLine();
		if (input.equals("exit"))
			exit_status = false;
		else if (!input.equals("start")){
			while(!input.equals("start") && !input.equals("exit")){
				System.out.println(ANSI_RED + "there is no allowed command: " + input + ANSI_RESET);
				System.out.print(ANSI_BLUE + "Type start for new game/ exit to quit: " + ANSI_RESET);
				input = out.nextLine();
				if (input.equals("exit"))
					exit_status = false;
			}
		}
	}

	public boolean get_exit(){
		return this.exit_status;
	}
}
