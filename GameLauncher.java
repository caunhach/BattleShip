package BattleShip;

import java.util.*;

public class GameLauncher{
	public static void main(String[] args){
		System.out.println("<<<<<< Welcome to battleship game >>>>>>");
		System.out.println(" ________");
		System.out.println("|        |");
		System.out.println("|  Goal  |");
		System.out.println("|________|");
		System.out.println("");
		System.out.println("sink all three dot coms ships (Pornhubs.com, Petshops.com, Megahard.com)");
		Game game = new Game();
		System.out.println(" ________");
		System.out.println("|        |");
		System.out.println("|  Map   |");
		System.out.println("|________|");
		System.out.println("");
		System.out.println("Map Size : " + game.get_size() + " " + "x" + " " + game.get_size());
		game.print_ship();
	}
}