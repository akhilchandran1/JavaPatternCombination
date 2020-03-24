package DataTransferObjectPattern;

/*
 * ENUM
 */

public enum continent {
	
	// adding enum constants and associating with values
	
	ASIA("Asia"), EUROPE("Europ"), NORTHAMERICA("North America"), AFRICA("Africa"), OCEANIA("Oceania"),
	ANTARCTICA("Antarctica"), SOUTHAMERICA("Soutn America");
	
	// adding instance variable
	private String Con;
	
	
	// constructor
	continent (String Con){
		
		this.Con = Con;
		
	}
	
	// getter method
	public String getCont() {
		return Con;
	}
}

