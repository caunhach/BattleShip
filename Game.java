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
	public boolean check_bound(int size){
		if (this.x >= size || this.y >= size)
		{
			// System.out.println("this.x: " + this.x + " this.y: " + this.y + " size: " + size);
			return (false);
		}
		return (true);
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
		// System.out.println("survive");
		// System.out.println("list : " + Arrays.deepToString(list.toArray()));
		// System.out.println("p1 : " + Arrays.toString(p1.get_coord()));
		// System.out.println("p2 : " + Arrays.toString(p2.get_coord()));
		// System.out.println("p3 : " + Arrays.toString(p3.get_coord()));
		// System.out.println("Size : " + size);
		// System.out.println("option : " + option);
		return (false);
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
		ArrayList<int[]> tmp_ship = new ArrayList<>();
		gen_map();
		tmp = One.set_name();
		// System.out.println(Arrays.deepToString(One.get_coord().toArray()));
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
			// System.out.println(One.check_crash(tmp_ship, size, 0));
			// System.out.println(Two.check_crash(tmp_ship, size, 1));
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
		System.out.println("Ships : [ " + One.get_name() + ", " + Two.get_name() + ", " + Three.get_name() + " ]");
		System.out.println(One.get_name() + ": " + Arrays.deepToString(One.get_coord().toArray()));
		System.out.println(Two.get_name() + ": " + Arrays.deepToString(Two.get_coord().toArray()));
		System.out.println(Three.get_name() + ": " + Arrays.deepToString(Three.get_coord().toArray()));
	}
	// public Boolean Check_hit()
}