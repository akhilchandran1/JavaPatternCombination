package DataAccessObjectPattern;

import java.sql.Connection;
import java.sql.DriverManager;



public class DatabaseConnection
{
  Connection conn;

  public DatabaseConnection()
  {
	  MySQLConnection();
  }

	//MySQL connection	
	public Connection MySQLConnection(){
		// create a mysql database connection
	    try{
	    	Class.forName("com.mysql.cj.jdbc.Driver");
	    	conn = DriverManager.getConnection("jdbc:mysql://52.50.23.197:3306/world?autoReconnect=true&useSSL=false", "cctstudent", "Pass1234!");
		
	    }catch (Exception e){
		      System.err.println(e.getMessage());
		      System.out.println("not success");
		}
	   
		return conn; //return
	 }//end method MySQLConnection
}