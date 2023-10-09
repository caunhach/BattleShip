package BattleShip;

import java.util.*;

class Coord{
	private int x = -1;
	private int y = -1;
	private Boolean hit = false;
	public void set_coord(int x, int y){
		this.x = x;
		this.y = y;
	}
	public int[] get_coord(){
		int[] coord = {this.x, this.y};
		return (coord);
	}
	public boolean check_bound(int size){
		if (this.x >= size || this.y >= size)
		{
			return (false);
		}
		return (true);
	}
	public void set_hit(){
		hit = true;
	}
	public Boolean get_hit(){
		return hit;
	}
	public void clear_data(){
		this.x = -1;
		this.y = -1;
		hit = false;
	}
}

class Ship{
	private String Name = null;
	private static String[] list = {"Pornhub.coms", "Petshop.com", "Megahard.com", "Scam.com", "Pipex.com"};
	private static final String ANSI_RESET = "\u001B[0m";
	private static final String ANSI_GREEN = "\u001B[32m";
	private Coord p1 = new Coord();
	private Coord p2 = new Coord();
	private Coord p3 = new Coord();
	public String set_name(){
		int	index = (int) (Math.random() * 4);
		Name = list[index];
		return Name;
	}
	public String get_name(){
		return Name;
	}
	public void set_coord(int size){
		int align = (int) (Math.random() * 2);
		int x = (int)(Math.random() * (size));
		int y = (int)(Math.random() * (size));
		if (align >= 1){
			p1.set_coord(x, y);
			p2.set_coord(x + 1, y);
			p3.set_coord(x + 2, y);
		}
		else{
			p1.set_coord(x, y);
			p2.set_coord(x, y + 1);
			p3.set_coord(x, y + 2);
		}
	}
	public ArrayList<int[]> get_coord(){
		ArrayList<int[]> coordinate = new ArrayList<>();
		coordinate.add(p1.get_coord());
		coordinate.add(p2.get_coord());
		coordinate.add(p3.get_coord());
		return (coordinate);
	}

	public Boolean check_crash(ArrayList<int[]> list, int size, int option){
		for (int[] coord : list)
		{
			if (Arrays.equals(coord, p1.get_coord()) && option == 0)
				return (true);
			if (!p1.check_bound(size))
				return (true);
			if (Arrays.equals(coord, p2.get_coord()) && option == 0)
				return (true);
			if (!p2.check_bound(size))
				return (true);
			if (Arrays.equals(coord, p3.get_coord()) && option == 0)
				return (true);
			if (!p3.check_bound(size))
				return (true);
		}
		return (false);
	}
	public int check_hit(int[] hit_coord){
		if (Arrays.equals(p1.get_coord(), hit_coord) && !p1.get_hit()){
			p1.set_hit();
			if (p1.get_hit() && p2.get_hit() && p3.get_hit()){
				System.out.println(ANSI_GREEN + "Ouch! You sunk " + this.Name + ": (" + ANSI_RESET);
				System.out.println(ANSI_GREEN + "kill" + ANSI_RESET);
				return 2;
			}
			else{
				System.out.println(ANSI_GREEN + "hit" + ANSI_RESET);
				return 1;
			}
		}
		else if (Arrays.equals(p2.get_coord(), hit_coord) && !p2.get_hit()){
			p2.set_hit();
			if (p1.get_hit() && p2.get_hit() && p3.get_hit()){
				System.out.println(ANSI_GREEN + "Ouch! You sunk " + this.Name + ": (" + ANSI_RESET);
				System.out.println(ANSI_GREEN + "kill" + ANSI_RESET);
				return 2;
			}
			else{
				System.out.println(ANSI_GREEN + "hit" + ANSI_RESET);
				return 1;
			}
		}
		else if (Arrays.equals(p3.get_coord(), hit_coord) && !p3.get_hit()){
			p3.set_hit();
			if (p1.get_hit() && p2.get_hit() && p3.get_hit()){
				System.out.println(ANSI_GREEN + "Ouch! You sunk " + this.Name + ": (" + ANSI_RESET);
				System.out.println(ANSI_GREEN + "kill" + ANSI_RESET);
				return 2;
			}
			else{
				System.out.println(ANSI_GREEN + "hit" + ANSI_RESET);
				return 1;
			}
		}
		return 0;
	}
	public void clear_data(){
		Name = null;
		p1.clear_data();
		p2.clear_data();
		p3.clear_data();
	}
}

public class Game{
	private int size;
	private Ship One = new Ship();
	private Ship Two = new Ship();
	private Ship Three = new Ship();
	private ArrayList<String> list = new ArrayList<String>();
	private static final String ANSI_RESET = "\u001B[0m";
	private static final String ANSI_BLUE = "\u001B[34m";
	private static final String ANSI_RED = "\u001B[31m";
	public Game(){
		setup();
	}
	public void setup(){
		String tmp;
		ArrayList<int[]> tmp_ship = new ArrayList<>();
		gen_map();
		tmp = One.set_name();
		list.add(tmp);
		do{
			tmp = Two.set_name();
		} while(list.contains(tmp));
		list.add(tmp);
		do{
			tmp = Three.set_name();
		} while(list.contains(tmp));
		list.add(tmp);
		while (true){
			One.set_coord(size);
			tmp_ship = One.get_coord();
			if (!One.check_crash(tmp_ship, size, 1))
				break;
		}
		while (true){
			Two.set_coord(size);
			tmp_ship = Two.get_coord();
			if (!One.check_crash(tmp_ship, size, 0) && !Two.check_crash(tmp_ship, size, 1))
				break;
		}
		while (true){
			Three.set_coord(size);
			tmp_ship = Three.get_coord();
			if (!One.check_crash(tmp_ship, size, 0) && !Two.check_crash(tmp_ship, size, 0) && !Three.check_crash(tmp_ship, size, 1))
				break;
		}
	}
	private void gen_map(){
		do{
		size = (int) (Math.random() * 9);
		} while(size < 7 || size > 9);
	}
	public int get_size(){
		return size;
	}
	public void print_ship(){
		System.out.println(ANSI_BLUE + "Ships : [ " + One.get_name() + ", " + Two.get_name() + ", " + Three.get_name() + " ]" + ANSI_RESET);
	}
	public Boolean Check_kill(int[] guess_coord){
		int check_miss = 0;
		int	exit_status = 0;
		exit_status = One.check_hit(guess_coord);
		if (exit_status == 2)
			return true;
		else if (exit_status == 0)
			check_miss++;
		exit_status = Two.check_hit(guess_coord);
		if (exit_status == 2)
			return true;
		else if (exit_status == 0)
			check_miss++;
		exit_status = Three.check_hit(guess_coord);
		if (exit_status == 2)
			return true;
		else if (exit_status == 0)
			check_miss++;
		if (check_miss == 3)
			System.out.println(ANSI_RED + "miss" + ANSI_RESET);
		return (false);
	}
	public void clear_data(){
		this.size = 0;
		list.clear();
		One.clear_data();
		Two.clear_data();
		Three.clear_data();
	}
}