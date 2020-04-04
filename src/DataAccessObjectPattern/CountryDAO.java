package DataAccessObjectPattern;

import java.util.ArrayList;
import java.util.List;

import BuilderDesignPattern.country;
import DataTransferObjectPattern.Country;

public interface CountryDAO {

	// methods to perform the operations

	public List<country> ListAllCountry();

	public void addCountry(country newCountry);

	public Country FindCountryByCode(String countryCode);

	public ArrayList<Country> FindCountryByName(String countryName);

}
