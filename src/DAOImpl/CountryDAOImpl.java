package DAOImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import BuilderDesignPattern.country;
import DataAccessObjectPattern.CountryDAO;
import DataAccessObjectPattern.DatabaseConnection;
import EnumContinent.Continent;

public class CountryDAOImpl implements CountryDAO {

	@Override
	public List<country> ListAllCountry() {
		// TODO Auto-generated method stub

		// getting the connection
		Connection conn = DatabaseConnection.MySQLConnection();
		Statement stmt = null; //statement
		ResultSet reslt = null;//resultset
		String query = "SELECT * FROM country"; // selecting from country table
		List<country> countryList = new ArrayList<country>();

		try {

			stmt = conn.createStatement(); // creating the statement
			reslt = stmt.executeQuery(query);// executing Query
			// while result.next do this
			while (reslt.next()) {
				// Continent verification
				Continent c = Continent.continent(reslt.getString("Continent"));

				// Adding new country
				country NewCountry = new country.CountryBuilder().setCode(reslt.getString("Code"))
																.setName(reslt.getString("Name"))
																.setContinent(c)
																.setSurfaceArea(reslt.getFloat("SurfaceArea"))
																.setHeadOfState(reslt.getString("HeadOfState"))
																.getCountry();

				countryList.add(NewCountry); //adding to the countryList
			}
			
			//catch
		} catch (SQLException e) {

			e.printStackTrace(); //error
		}

		return countryList; // returning the list
		
	} // end ListAllCountry
	

	public void addCountry(country count) { // passing the country object
		
		Connection Conn = null;// connection
		Statement Stmt = null; //statement

		// getting values
		String query = "INSERT INTO country" + " VALUES(" + count.toString() + ")";

		// Insert query
		try {
			
			//database connection
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

		}//end catch

	} // end addCountry

	@Override
	public country FindCountryByCode(String countryCode) { // passing Country Code

		// getting the connection
		Connection conn = DatabaseConnection.MySQLConnection();
		Statement stmt = null;
		ResultSet reslt = null;

		try {

			// executing Query
			String query = "SELECT * FROM country where Code='" + countryCode + "'"; // select from country table by
																						// code (user input)

			// statement and resultSet
			stmt = conn.createStatement();
			reslt = stmt.executeQuery(query);// executing Query

			while (reslt.next()) {
				
				// Continent verification
				Continent c = Continent.continent(reslt.getString("Continent"));

				// Adding new country
				country NewCountry = new country.CountryBuilder().setCode(reslt.getString("Code"))
						.setName(reslt.getString("Name")).setContinent(c).setSurfaceArea(reslt.getFloat("SurfaceArea"))
						.setHeadOfState(reslt.getString("HeadOfState")).getCountry();

				return NewCountry; // returning NewCountry

			}

			// catch
		} catch (SQLException e) {

			e.printStackTrace();// error
		}

		return null; // return null
		
	}// end FindCountryByCode

	@Override
	public ArrayList<country> FindCountryByName(String countryName) { // passing Country Name
		// TODO Auto-generated method stub

		// getting the connection
		Connection conn = DatabaseConnection.MySQLConnection();
		Statement stmt = null;
		ResultSet reslt = null;
		ArrayList<country> countryL = new ArrayList<country>();
		try {

			// executing Query
			String query = "SELECT * FROM country WHERE Name LIKE'%" + countryName + "%'";// select from country table
																							// by
																							// Name (user input)
			stmt = conn.createStatement(); // creating the statement
			reslt = stmt.executeQuery(query);// executing Query
			
			while (reslt.next()) {
				// Continent verification
				Continent c = Continent.continent(reslt.getString("Continent"));

				// Adding new country
				country NewCountry = new country.CountryBuilder().setCode(reslt.getString("Code"))
						.setName(reslt.getString("Name")).setContinent(c).setSurfaceArea(reslt.getFloat("SurfaceArea"))
						.setHeadOfState(reslt.getString("HeadOfState")).getCountry();

				countryL.add(NewCountry);
			}
			//catch
		} catch (SQLException e) {

			e.printStackTrace();//error
		}

		return countryL; // returning the list
		
	} // end FindCountryByName
}
