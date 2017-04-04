package me.embryogod.persona;

public class Persona {

	private String name;
	private short age;
	private Race race;
	private String bio;

	public Persona(String name, short age, Race race) {
		this.name = name;
		this.age = age;
		this.race = race;
		this.bio = "";
	}

	public Persona(String name, short age, Race race, String bio) {
		this.name = name;
		this.age = age;
		this.race = race;
		this.bio = bio;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(short age) {
		this.age = age;
	}

	public void setRace(Race race) {
		this.race = race;
	}

	public void addBio(String bio) {
		StringBuilder bioBuilder = new StringBuilder(this.bio);
		bioBuilder.append(" " + bio);
		this.bio = bioBuilder.toString();
	}

	public String getBio() {
		return this.bio;
	}

	public short getAge() {
		return this.age;
	}

	public String getName() {
		return this.getName();
	}

	public Race getRace() {
		return race;
	}

	public boolean isCreated() {
		return race == null;
	}

}