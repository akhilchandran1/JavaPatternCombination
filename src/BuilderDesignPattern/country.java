package BuilderDesignPattern;


public class country {
	
	// private fields
	
	private String Code;
	private String Name;
	private String Continent;
	private float SurfaceArea;
	private String HeadOfState;
	
	
public country(String Code, String Name, String Continent, float SurfaceArea, String HeadOfState) {
	
	super();
	this.Code = Code;
	this.Name = Name;
	this.Continent = Continent;
	this.SurfaceArea = SurfaceArea;
	this.HeadOfState = HeadOfState;
	
}


@Override
public String toString() {
	return  "'"+Code +"'"+ "," +"'"+ Name +"'"+ "," +"'"+ Continent+"'" + "," + SurfaceArea
			+ "," + "'"+HeadOfState+"'";
}



}
