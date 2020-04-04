package DataAccessObjectPattern;

import java.util.ArrayList;
import java.util.List;

import BuilderDesignPattern.country;

public interface CountryDAO {

	// methods to perform the operations

	public List<country> ListAllCountry();

	public void addCountry(country newCountry);

	public country FindCountryByCode(String countryCode);

	public ArrayList<country> FindCountryByName(String countryName);

}
