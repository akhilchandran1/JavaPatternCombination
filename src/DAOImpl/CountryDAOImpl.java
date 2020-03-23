package DAOImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import BuilderDesignPattern.CountryBuilder;
import BuilderDesignPattern.country;
import DataAccessObjectPattern.CountryDAO;
import DataAccessObjectPattern.DatabaseConnection;
import DataTransferObjectPattern.Country;

public class CountryDAOImpl implements CountryDAO {

	@Override
	public List<Country> ListAllCountry() {
		// TODO Auto-generated method stub

		// getting the connection
		Connection conn = DatabaseConnection.MySQLConnection();
		Statement stmt = null;
		ResultSet reslt = null;
		List<Country> countryList = new ArrayList<Country>();
		try {

			// executing Query
			String query = "SELECT * FROM country"; // selecting from country table
			stmt = conn.createStatement(); // creating the statement
			reslt = stmt.executeQuery(query);
			
			while (reslt.next()) {
		
				Country country = new Country(); // country object
				country.setCode(reslt.getString("Code"));
				country.setName(reslt.getString("Name"));
				country.setContinent(reslt.getString("Continent"));
				country.setSurfaceArea(reslt.getFloat("SurfaceArea"));
				country.setHeadOfState(reslt.getString("HeadOfState"));
				countryList.add(country); // adding to the list
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return countryList; // returning the list
	} // end ListAllCountry

	
	public void addCountry(Country count) { // passing the country object
		Connection Conn = null;
		Statement Stmt = null;
		//count = new CountryBuilder().getCountry()

		// getting values
		String query = "INSERT INTO country" + " VALUES(" + "'" + count.getCode() + "'" + "," + "'"
				+ count.getName() + "'" + "," + "'" + count.getContinent() + "'" + "," + count.getSurfaceArea()
				+ "," + "'" + count.getHeadOfState() + "'" + ")";

		// Insert query
		try {
			
			Conn = DatabaseConnection.MySQLConnection();
			Stmt = Conn.prepareStatement(query);

			Stmt.executeUpdate(query); // executing

			// catch
		} catch (SQLException e) {

			e.printStackTrace();

		}

	} // end addCountry

	@Override
	public Country FindCountryByCode(String countryCode) { // passing Country Code

		// getting the connection
		Connection Conn = DatabaseConnection.MySQLConnection();
		Statement stmt = null;
		ResultSet reslt = null;

		try {

			// executing Query
			String query = "SELECT * FROM country where Code='" + countryCode + "'"; // select from country table by
																						// code (user input)
			stmt = Conn.createStatement();
			reslt = stmt.executeQuery(query);
			if (reslt.next()) {
				Country country = new Country(); // country object
				country.setCode(reslt.getString("Code"));
				country.setName(reslt.getString("Name"));
				country.setContinent(reslt.getString("Continent"));
				country.setSurfaceArea(reslt.getFloat("SurfaceArea"));
				country.setHeadOfState(reslt.getString("HeadOfState"));

				return country; // returning back

			} else {
				// show message dialog
				JOptionPane.showMessageDialog(null, "No Country in this Code");

			}

			// catch
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}// end FindCountryByCode

	@Override
	public Country FindCountryByName(String countryName) { // passing Country Name

		// getting the connection
		Connection Conn = DatabaseConnection.MySQLConnection();
		Statement stmt = null;
		ResultSet reslt = null;

		try {

			// executing Query
			String query = "SELECT * FROM country where Name='" + countryName + "'"; // select from country table by
																						// Name (user input)
			stmt = Conn.createStatement();
			reslt = stmt.executeQuery(query);
			if (reslt.next()) {
				Country country = new Country(); // country object
				country.setCode(reslt.getString("Code"));
				country.setName(reslt.getString("Name"));
				country.setContinent(reslt.getString("Continent"));
				country.setSurfaceArea(reslt.getFloat("SurfaceArea"));
				country.setHeadOfState(reslt.getString("HeadOfState"));

				return country; // returning back

			} else {
				// show message dialog
				JOptionPane.showMessageDialog(null, "No Country in this Name");

			}

			// catch
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}// end FindCountryByCode

}
