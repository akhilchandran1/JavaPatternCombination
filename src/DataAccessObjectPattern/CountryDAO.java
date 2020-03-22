package DataAccessObjectPattern;

import java.util.List;

import DataTransferObjectPattern.Country;

public interface CountryDAO {

	// methods to perform the operations

	public List<Country> ListAllCountry();

	public void addCountry(Country country);

	public Country FindCountryByCode(String countryCode);
	
	public Country FindCountryByName(String countryName);

}
