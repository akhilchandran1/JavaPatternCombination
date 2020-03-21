package DataAccessObjectPattern;

import java.util.List;

import DataTransferObjectPattern.Country;


public interface CountryDAO {

	
	// creating a list
	
	public List<Country> ListAllCountry();
	
}

