import java.sql.Connection;
import java.sql.DriverManager;



public class DatabaseConnection
{
  static Connection conn;

  public static void main (String [] args) {
	  MySQLConnection();
  }
	//MySQL connection	
	public static Connection MySQLConnection(){
		// create a mysql database connection
	    try{
	    	Class.forName("com.mysql.cj.jdbc.Driver");
	    	conn = DriverManager.getConnection("jdbc:mysql://52.50.23.197:3306/world?autoReconnect=true&useSSL=false", "cctstudent", "Pass1234!");
		
	    }catch (Exception e){
		      System.err.println(e.getMessage());
		      System.out.println("not success");
		}
	   System.out.println("Success");
		return conn; //returnstatement
	 }//end method MySQLConnection
}