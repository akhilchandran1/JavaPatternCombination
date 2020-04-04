package BuilderDesignPattern;

import EnumContinent.Continent;

/*
 * BUILDER DESIGN PATTERN
 */

public class country {

	
	// creating variables
	private String Code;
	private String Name;
	private Continent continent;
	private float SurfaceArea;
	private String HeadOfState;


	// creating constructor
	private country(CountryBuilder builder) {

		super();
		this.Code = builder.Code;
		this.Name = builder.Name;
		this.continent = builder.continent;
		this.SurfaceArea = builder.SurfaceArea;
		this.HeadOfState = builder.HeadOfState;

	}
	

// toSrting method to get the data
	@Override
	public String toString() {
		return "'" + Code + "'" + "," + "'" + Name + "'" + "," + "'" + continent.getContinent() + "'" + "," + SurfaceArea + "," + "'"
				+ HeadOfState + "'";
	}
	
	
	//getter
	public String getCode() {
		return Code;
	}

	public String getName() {
		return Name;
	}

	public Continent getContinent() {
		return continent;
	}

	public float getSurfaceArea() {
		return SurfaceArea;
	}

	public String getHeadOfState() {
		return HeadOfState;
	}

	public static class CountryBuilder {

		// variables
		private String Code;
		private String Name;
		private Continent continent;
		private float SurfaceArea;
		private String HeadOfState;

		// adding setters (instead of void mentioning CountryBuilder object)
		public CountryBuilder setCode(String code) {
			this.Code = code;
			return this; // returning the object
		}

		public CountryBuilder setName(String name) {
			this.Name = name;
			return this; // returning the object
		}

		public CountryBuilder setContinent(Continent continent) {
			this.continent = continent;
			return this; // returning the object
		}

		public CountryBuilder setSurfaceArea(float surfaceArea) {
			this.SurfaceArea = surfaceArea;
			return this; // returning the object
		}

		public CountryBuilder setHeadOfState(String headOfState) {
			this.HeadOfState = headOfState;
			return this; // returning the object
		}

		// creating a method to get the country object
		public country getCountry() {
			
			//return
			return new country(this);

		}

	}

}
