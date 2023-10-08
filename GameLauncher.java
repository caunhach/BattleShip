package BattleShip;

public class GameLauncher{
	public static void main(String[] args){
		System.out.println("<<<<<< Welcome to battleship game >>>>>>");
		System.out.println("");
		System.out.println("[  Goal  ]");
		System.out.println("");
		System.out.println("sink all three dot coms ships");
		Game game = new Game();
		System.out.println("");
		System.out.println("[  Map  ]");
		System.out.println("");
		System.out.println("Map Size : " + game.get_size() + " " + "x" + " " + game.get_size());
		game.print_ship();
		StartGame new_game = new StartGame(game);
	}
}