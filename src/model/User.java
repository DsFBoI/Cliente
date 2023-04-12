package model;

import java.util.List;

public class User {

	private static int next_id = 1;
	private int id;
	private String name;
	private List<User> amigos;
	private List<message> inbox;
	
	public User(String name) {
		this.name = name;
		this.id = next_id;
		User.next_id++;
	}
	
	public User(String name, int id) {
		this.name = name;
		this.id = id;
	}
	
	public User() {
		
	}

	public String getName() {
		return name;
	}
	
	public int getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

}
