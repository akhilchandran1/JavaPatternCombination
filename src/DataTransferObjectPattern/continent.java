package DataTransferObjectPattern;



/*
 * ENUM
 */

public enum Continent {


	// adding enum constants and associating with values

	ASIA("Asia"), EUROPE("Europe"), NORTHAMERICA("North America"), AFRICA("Africa"), OCEANIA("Oceania"),
	ANTARCTICA("Antarctica"), SOUTHAMERICA("South America");
	
	
	// adding instance variable
	   private String conti;
	   
	// getter method
	   public String getContinent() {
	       return this.conti;
	   }
	   
	// constructor
	   Continent(String conti) {
	           this.conti = conti;
	   }
}

