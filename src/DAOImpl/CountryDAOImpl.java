package DAOImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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

			String query = "SELECT * FROM country"; // selecting from country table
			stmt = conn.createStatement(); // creating the statement
			reslt = stmt.executeQuery(query);// executing Query
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
	}
	
	
	public void addCountry(Country country) {
		 Connection Conn = null;
		    Statement Stmt = null;

		    String query = "INSERT INTO country" +" VALUES(" + "'"+country.getCode() +"'"+","+ "'"+country.getName() +"'"+","+ "'"+country.getContinent()
			+"'"+","+ country.getSurfaceArea() +","+ "'"+country.getHeadOfState()+"'" + ")";

		    try
		    {
		    DatabaseConnection databaseCo = new DatabaseConnection();
		      Conn = databaseCo.MySQLConnection();
		      Stmt = Conn.prepareStatement(query);
		      
		    
		      Stmt.executeUpdate(query);

		    }
		    catch( SQLException e )
		    {

		      e.printStackTrace();

		    }
		    
		    finally
		    {

		      if( Stmt != null )
		      {
		        try
		        {
		          Stmt.close();
		        }
		        catch( SQLException e )
		        {
		          e.printStackTrace();
		        }
		      }

		      if( Conn != null )
		      {
		        try
		        {
		          Conn.close();
		        }
		        catch( SQLException e )
		        {
		          e.printStackTrace();
		        }
		      }
		      

		    }

	}
	
	/*

	@Override
	public void addCountry(Country country) {
		Connection Conn = null;
		Statement stmt = null;
		
		String query = "insert into country (Code, Name, Continent, SurfaceArea, HeadOfState)" 
		+ "values(" + country.getCode() +","+ country.getName() +","+ country.getContinent()
		+","+ country.getSurfaceArea() +","+ country.getHeadOfState() + ")";

		try {
			DatabaseConnection databaseCo = new DatabaseConnection();
			Conn = databaseCo.MySQLConnection();
			stmt = Conn.prepareStatement(query);
			stmt.executeUpdate(query);

			System.out.println("successfully new country added");

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (Conn != null) {
				try {
					Conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}

	}
	*/

}
