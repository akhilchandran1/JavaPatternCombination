package DataTransferObjectPattern;

import java.util.ArrayList;

/*
 * ENUM (Singleton)
 */

public enum Continent {

	// adding enum constants and associating with values

	ASIA("Asia"), EUROPE("Europe"), NORTHAMERICA("North America"), AFRICA("Africa"), OCEANIA("Oceania"),
	ANTARCTICA("Antarctica"), SOUTHAMERICA("South America");

	// adding instance variable
	private String conti;

	// constructor
	Continent(String conti) {
		this.conti = conti;
	}

	// getter method
	public String getContinent() {
		return this.conti;
	}
}

/*
 //Another Singleton enum

public enum SingletonContinent {

	INSTANCE;

	private static SingletonContinent singletonContinent;
	private ArrayList<String> Continents;

	SingletonContinent(){
		Continents = new ArrayList<String>();
		Continents.add("Asia");
		Continents.add("Europe");
		Continents.add("North America");
		Continents.add("Africa");
		Continents.add("Oceania");
		Continents.add("Antarctica");
		Continents.add("South America");

		
	}

	public String getContinent() {
		return Continents.toString();
	}


}


*/