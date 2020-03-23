package DataTransferObjectPattern;

public enum continent {
	
	ASIA("Asia"), EUROPE("Europ"), NORTHAMERICA("North America"), AFRICA("Africa"), OCEANIA("Oceania"),
	ANTARCTICA("Antarctica"), SOUTHAMERICA("Soutn America");
	
	private String Con;
	

	continent (String Con){
		
		this.Con = Con;
		
	}
	
	public String getCont() {
		return Con;
	}
}

