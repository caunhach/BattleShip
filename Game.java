package BattleShip;

import java.util.*;

class Ship{
	private String Name = null;
	static String[] list = {"Pornhub.coms", "Petshop.com", "Megahard.com", "Scam.com", "Pipex.com"};
	public String set_name(){
		int	index = (int) (Math.random() * 4);
		Name = list[index];
		return Name;
	}
	public String get_name(){
		return Name;
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
		System.out.println("Ships : [ " + One.get_name() + Two.get_name() + Three.get_name());
	}
}