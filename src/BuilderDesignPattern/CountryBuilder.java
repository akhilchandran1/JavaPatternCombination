package BuilderDesignPattern;


public class CountryBuilder {
	
	
	private String Code;
	private String Name;
	private String Continent;
	private float SurfaceArea;
	private String HeadOfState;
	
	
	public CountryBuilder setCode(String code) {
		Code = code;
		return this;
	}
	public CountryBuilder setName(String name) {
		Name = name;
		return this;
	}
	public CountryBuilder setContinent(String continent) {
		Continent = continent;
		return this;
	}
	public CountryBuilder setSurfaceArea(float surfaceArea) {
		SurfaceArea = surfaceArea;
		return this;
	}
	public CountryBuilder setHeadOfState(String headOfState) {
		HeadOfState = headOfState;
		return this;
	}
	
	
	public country getCountry() {
		
		return new country (Code, Name, Continent, SurfaceArea, HeadOfState);
	}
	

}
