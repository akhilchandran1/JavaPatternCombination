package DataTransferObjectPattern;

public class Country {
	
	// private fields
	
	private String Code;
	private String Name;
	private String Continent;
	private float SurfaceArea;
	private String HeadOfState;
	
	
	// Getter and Setter
	
	public String getCode() {
		return Code;
	}
	public void setCode(String code) {
		Code = code;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getContinent() {
		return Continent;
	}
	public void setContinent(String continent) {
		Continent = continent;
	}
	public float getSurfaceArea() {
		return SurfaceArea;
	}
	public void setSurfaceArea(float surfaceArea) {
		SurfaceArea = surfaceArea;
	}
	public String getHeadOfState() {
		return HeadOfState;
	}
	public void setHeadOfState(String headOfState) {
		HeadOfState = headOfState;
	}


}
