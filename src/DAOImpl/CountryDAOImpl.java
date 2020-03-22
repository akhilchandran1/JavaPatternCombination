package DAOImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import DataAccessObjectPattern.CountryDAO;
import DataAccessObjectPattern.DatabaseConnection;
import DataTransferObjectPattern.Country;

public class CountryDAOImpl implements CountryDAO {

	@Override
	public List<Country> ListAllCountry() {
		// TODO Auto-generated method stub

		// getting the connection
		DatabaseConnection databaseCo = new DatabaseConnection();
		Connection conn = databaseCo.MySQLConnection();
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
		// closing connection, statement and resultSet
		finally {

			try {

				if (conn != null) {

					conn.close();
				}

				if (stmt != null) {

					stmt.close();
				}

				if (reslt != null) {

					reslt.close();
				}

			}

			// catch
			catch (Exception exe) {

				exe.printStackTrace();

			}

		}

		return countryList; // returning the list
	} // end ListAllCountry

	@Override
	public void addCountry(Country country) { // passing the country object
		Connection Conn = null;
		Statement Stmt = null;

		// getting values
		String query = "INSERT INTO country" + " VALUES(" + "'" + country.getCode() + "'" + "," + "'"
				+ country.getName() + "'" + "," + "'" + country.getContinent() + "'" + "," + country.getSurfaceArea()
				+ "," + "'" + country.getHeadOfState() + "'" + ")";

		// Insert query
		try {
			DatabaseConnection databaseCo = new DatabaseConnection();
			Conn = databaseCo.MySQLConnection();
			Stmt = Conn.prepareStatement(query);

			Stmt.executeUpdate(query); // executing

			// catch
		} catch (SQLException e) {

			e.printStackTrace();

		}

		// closing connection, statement

		finally {

			if (Stmt != null) {
				try {
					Stmt.close(); // stmt closing

					// catch
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (Conn != null) {
				try {
					Conn.close(); // conn closing

					// catch
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}

	} // end addCountry

	@Override
	public Country FindCountryByCode(String countryCode) { // passing Country Code

		// getting the connection
		DatabaseConnection databaseCo = new DatabaseConnection();
		Connection Conn = databaseCo.MySQLConnection();
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
		// closing connection, statement and resultSet
		finally {
			try {
				if (Conn != null) {
					Conn.close();// Conn close
				}
				if (stmt != null) {
					stmt.close();// stmt close
				}
				if (reslt != null) {
					reslt.close(); // reslt close
				}
				// catch
			} catch (Exception exe) {
				exe.printStackTrace();
			}

		}
		return null;
	}// end FindCountryByCode

	@Override
	public Country FindCountryByName(String countryName) { // passing Country Name

		// getting the connection
		DatabaseConnection databaseCo = new DatabaseConnection();
		Connection Conn = databaseCo.MySQLConnection();
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
		// closing connection, statement and resultSet
		finally {
			try {
				if (Conn != null) {
					Conn.close();// Conn close
				}
				if (stmt != null) {
					stmt.close();// stmt close
				}
				if (reslt != null) {
					reslt.close(); // reslt close
				}
				// catch
			} catch (Exception exe) {
				exe.printStackTrace();
			}

		}
		return null;
	}// end FindCountryByCode

}
