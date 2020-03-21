package DataAccessObjectPattern;

import DAOImpl.CountryDAOImpl;
import DataTransferObjectPattern.Country;


public class CountryDAOPattern {


	// Main method
	public static void main(String[] args) {

		CountryDAO countryDAO = new CountryDAOImpl();

		
		System.out.println();

		// print all Employees
		for (Country country : countryDAO.ListAllCountry()) {
			System.out.println(country.getCode() + "," + " " + country.getName() + "," + " " + country.getContinent()
					+ "," + " " + country.getSurfaceArea() + "," + " " + country.getHeadOfState());
		}
	}

}
