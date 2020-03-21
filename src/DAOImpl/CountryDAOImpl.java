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
	    try
	    {
	    	
	    	String query = "SELECT * FROM country"; // selecting from country table
	 	    stmt = conn.createStatement(); // creating the statement
	 	    reslt = stmt.executeQuery(query);// executing Query
	 	   while( reslt.next()) {
	 		   
	 		   Country country = new Country(); //country object
		       country.setCode(reslt.getString("Code"));
		       country.setName(reslt.getString("Name"));
		       country.setContinent(reslt.getString("Continent"));
		       country.setSurfaceArea(reslt.getFloat("SurfaceArea"));
		       country.setHeadOfState(reslt.getString("HeadOfState"));
		       countryList.add(country); // adding to the list
	 	   }
	    	
	    } catch(SQLException e) {
	    	
		      e.printStackTrace();
		    }
		  //closing connection, statement and resultSet
	    finally {
	    	
	      try {
	    	  
	          if( conn != null ){
	        	  
		          conn.close(); 
		        }
		     
	          if( stmt != null ) {
	        	  
		          stmt.close();
		        }
	          
		      if( reslt != null ) {
		    	  
		          reslt.close();
		        }
	 
	      }
	      
	      //catch
	      catch( Exception exe ){
	    	  
	        exe.printStackTrace();
	        
	      }

	    }
	    
		return countryList; //returning the list
	}

}
