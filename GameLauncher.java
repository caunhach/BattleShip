package BattleShip;

public class GameLauncher{
	private static final String ANSI_RESET = "\u001B[0m";
	private static final String ANSI_GREEN = "\u001B[32m";
	private static final String ANSI_BLUE = "\u001B[34m";
	public static void main(String[] args){
		int	exit_status = 0;
		Game game = new Game();
		System.out.println(ANSI_GREEN + "<<<<<< Welcome to battleship game >>>>>>" + ANSI_RESET);
		System.out.println("");
		System.out.println(ANSI_GREEN + "[  Goal  ]" + ANSI_RESET);
		System.out.println("");
		System.out.println(ANSI_BLUE + "sink all three dot coms ships" + ANSI_RESET);
		System.out.println("");
		System.out.println(ANSI_GREEN + "[  Map  ]" + ANSI_RESET);
		System.out.println("");
		System.out.println(ANSI_BLUE + "Map Size : " + game.get_size() + " " + "x" + " " + game.get_size() + ANSI_RESET);
		game.print_ship();
		StartGame new_game = new StartGame(game);
		while(new_game.get_exit()){
			game.clear_data();
			game.setup();
			System.out.println(ANSI_GREEN + "<<<<<< Welcome to battleship game >>>>>>" + ANSI_RESET);
			System.out.println("");
			System.out.println(ANSI_GREEN + "[  Goal  ]" + ANSI_RESET);
			System.out.println("");
			System.out.println(ANSI_BLUE + "sink all three dot coms ships" + ANSI_RESET);
			System.out.println("");
			System.out.println(ANSI_GREEN + "[  Map  ]" + ANSI_RESET);
			System.out.println("");
			System.out.println(ANSI_BLUE + "Map Size : " + game.get_size() + " " + "x" + " " + game.get_size() + ANSI_RESET);
			game.print_ship();
			new_game.initialize(game);
		}
	}
}