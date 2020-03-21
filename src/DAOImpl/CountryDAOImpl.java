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
	    ResultSet res = null;
	    List<Country> countryList = new ArrayList<Country>();
	    try
	    {
	    	
	    	String query = "SELECT * FROM country"; // selecting from country table
	 	    stmt = conn.createStatement(); // creating the statement
	 	    res = stmt.executeQuery(query);// executing Query
	 	   while( res.next()) {
	 		   
	 		   Country country = new Country(); //country object
		       country.setCode(res.getString("Code"));
		       country.setName(res.getString("Name"));
		       country.setContinent(res.getString("Continent"));
		       country.setSurfaceArea(res.getFloat("SurfaceArea"));
		       country.setHeadOfState(res.getString("HeadOfState"));
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
	          
		      if( res != null ) {
		    	  
		          res.close();
		        }
	 
	      }
	      
	      //catch
	      catch( Exception exe ){
	    	  
	        exe.printStackTrace();
	        
	      }

	    }
	    
		return countryList; //returning the list
	}
	
	public static void main( String[] args ){
		
		  CountryDAO countryDAO = new CountryDAOImpl ();

			
		    System.out.println();
		    
		    // print all Data
		    for( Country country : countryDAO.ListAllCountry())
		    {
		      System.out.println (country.getCode() +
						  			","+" " + country.getName() + 
						  			","+" " + country.getContinent() + 
						  			","+" " + country.getSurfaceArea() + 
						  			","+" " + country.getHeadOfState());
		    }
	}

}
