package me.embryogod.persona;

public enum Race {

	PLACEHOLDER1("Placeholder 1"),
	PLACEHOLDER2("Placeholder 2")
	;
	
	private final String raceName;
	
	Race(String raceName) {
		this.raceName = raceName;
	}
	
	public String toString() {
		return raceName;
	}
	
}