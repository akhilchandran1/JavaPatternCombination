package DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.mysql.cj.x.protobuf.MysqlxConnection.Close;
import com.sun.jdi.connect.spi.ClosedConnectionException;

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

			String query = "SELECT * FROM country"; // selecting from country table
			stmt = conn.createStatement(); // creating the statement
			reslt = stmt.executeQuery(query);// executing Query

			while (reslt.next()) {

				Country country = new Country(); // country object
				country.setCode(reslt.getString("Code"));
				country.setName(reslt.getString("Name"));
				country.setContinent(reslt.getString("Continent"));
				// Continent.valueof(rs.getString());

				country.setSurfaceArea(reslt.getFloat("SurfaceArea"));
				country.setHeadOfState(reslt.getString("HeadOfState"));
				countryList.add(country); // adding to the list
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return countryList; // returning the list
	} // end ListAllCountry

	public void addCountry(country count) { // passing the country object
		Connection Conn = null;
		Statement Stmt = null;
		// count = new CountryBuilder().getCountry()

		// getting values
		String query = "INSERT INTO country" + " VALUES(" + count.toString() + ")";

		// Insert query
		try {

			Conn = DatabaseConnection.MySQLConnection();
			Stmt = Conn.prepareStatement(query);

			Stmt.executeUpdate(query); // executing

			// show message dialog
			JOptionPane.showMessageDialog(null, "New Country Successfully Added");

			// catch
		} catch (SQLException e) {

			// if the country code is already exist this message will pop up
			if (e instanceof SQLIntegrityConstraintViolationException) {

				// show message dialog
				JOptionPane.showMessageDialog(null, "Country code is already exist. please try with different code");

			} else {
				// other errors
				e.printStackTrace();
			}

		}

	} // end addCountry

	@Override
	public Country FindCountryByCode(String countryCode) { // passing Country Code

		// getting the connection
		Connection Conn = DatabaseConnection.MySQLConnection();

		// executing Query
		String query = "SELECT * FROM country where Code='" + countryCode + "'"; // select from country table by
																					// code (user input)

		try {

			// statement and resultSet
			Statement stmt = Conn.createStatement();
			ResultSet reslt = stmt.executeQuery(query);

			while (reslt.next()) {
				Country country = new Country(); // country object
				country.setCode(reslt.getString("Code"));
				country.setName(reslt.getString("Name"));
				country.setContinent(reslt.getString("Continent"));
				country.setSurfaceArea(reslt.getFloat("SurfaceArea"));
				country.setHeadOfState(reslt.getString("HeadOfState"));

				return country; // returning back

			}

			// catch
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return null;
	}// end FindCountryByCode

	@Override
	public ArrayList<Country> FindCountryByName(String countryName) { // passing Country Name
		// TODO Auto-generated method stub

		// getting the connection
		Connection conn = DatabaseConnection.MySQLConnection();
		Statement stmt = null;
		ResultSet reslt = null;
		ArrayList<Country> countryL = new ArrayList<Country>();
		try {

			// executing Query
			String query = "SELECT * FROM country WHERE Name LIKE'%" + countryName + "%'";// select from country table
																							// by
																							// Name (user input)
			stmt = conn.createStatement(); // creating the statement
			reslt = stmt.executeQuery(query);// executing Query

			while (reslt.next()) {

				Country country = new Country(); // country object
				country.setCode(reslt.getString("Code"));
				country.setName(reslt.getString("Name"));
				country.setContinent(reslt.getString("Continent"));
				country.setSurfaceArea(reslt.getFloat("SurfaceArea"));
				country.setHeadOfState(reslt.getString("HeadOfState"));
				countryL.add(country); // adding to the list
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return countryL; // returning the list
	} // end FindCountryByName
}
