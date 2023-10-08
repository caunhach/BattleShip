package BattleShip;

import java.util.*;

class Coord{
	private int x = -1;
	private int y = -1;
	public void set_coord(int x, int y){
		this.x = x;
		this.y = y;
	}
	public int[] get_coord(){
		int[] coord = {this.x, this.y};
		// System.out.println(Arrays.toString(coord));
		return (coord);
	}
}

class Ship{
	private String Name = null;
	private static String[] list = {"Pornhub.coms", "Petshop.com", "Megahard.com", "Scam.com", "Pipex.com"};
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
			System.out.println(Arrays.toString(p1.get_coord()));
			System.out.println(Arrays.toString(p2.get_coord()));
			p2.set_coord(x + 1, y);
			p3.set_coord(x + 2, y);
		}
		else{
			p1.set_coord(x, y);
			p2.set_coord(x, y + 1);
			p3.set_coord(x, y + 2);
		}
		// System.out.println(Arrays.toString(p1.get_coord()));
	}
	public ArrayList<int []> get_coord(){
		ArrayList<int[]> list = new ArrayList<int[]>();
		list.add(p1.get_coord());
		list.add(p2.get_coord());
		list.add(p3.get_coord());
		return (list);
	}
}

public class Game{
	private int size;
	private Ship One = new Ship();
	private Ship Two = new Ship();
	private Ship Three = new Ship();
	private ArrayList<String> list = new ArrayList<String>();
	public Game(){
		String tmp;
		gen_map();
		tmp = One.set_name();
		One.set_coord(size);
		System.out.println(Arrays.deepToString(One.get_coord().toArray()));
		list.add(tmp);
		do{
			tmp = Two.set_name();
		} while(list.contains(tmp));
		list.add(tmp);
		do{
			tmp = Three.set_name();
		} while(list.contains(tmp));
		list.add(tmp);
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
		System.out.println("Ships : [ " + One.get_name() + ", " + Two.get_name() + ", " + Three.get_name() + " ]");
	}
}