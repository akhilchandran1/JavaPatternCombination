package BuilderDesignPattern;

/*
 * BUILDER DESIGN PATTERN
 */

public class country {

	// creating variables
	private String Code;
	private String Name;
	private String Continent;
	private float SurfaceArea;
	private String HeadOfState;

	// creating constructor
	public country(String Code, String Name, String Continent, float SurfaceArea, String HeadOfState) {

		super();
		this.Code = Code;
		this.Name = Name;
		this.Continent = Continent;
		this.SurfaceArea = SurfaceArea;
		this.HeadOfState = HeadOfState;

	}

// toSrting method to get the data
	@Override
	public String toString() {
		return "'" + Code + "'" + "," + "'" + Name + "'" + "," + "'" + Continent + "'" + "," + SurfaceArea + "," + "'"
				+ HeadOfState + "'";
	}

	public static class CountryBuilder {

		// variables
		private String Code;
		private String Name;
		private String Continent;
		private float SurfaceArea;
		private String HeadOfState;

		public CountryBuilder() {
		}

		// adding setters (instead of void mentioning CountryBuilder object)
		public CountryBuilder setCode(String code) {
			this.Code = code;
			return this; // returning the object
		}

		public CountryBuilder setName(String name) {
			this.Name = name;
			return this; // returning the object
		}

		public CountryBuilder setContinent(String continent) {
			this.Continent = continent;
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

			return new country(Code, Name, Continent, SurfaceArea, HeadOfState);

		}

	}

}
