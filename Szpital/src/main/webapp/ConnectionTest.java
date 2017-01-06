package main.webapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

//ServerName: 31.41.178.89:1433
//login: AplikacjaLukasz
//haslo: 12345678

public class ConnectionTest {

	public static void main(String[] args) {
		// Create a variable for the connection string.  
	      String connectionUrl = "jdbc:sqlserver://31.41.178.89:1433;" +  
	         "databaseName=AplikacjaLukasz;user=AplikacjaLukasz;password=12345678";  
	  
	      // Declare the JDBC objects.  
	      Connection con = null;  
	      Statement stmt = null;  
	      ResultSet rs = null;  
	  
	      try {  
	         // Establish the connection.  
	         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
	         con = DriverManager.getConnection(connectionUrl);  
	  
	         // Create and execute an SQL statement that returns some data.  
	         String SQL = "SELECT * FROM Ordynator";  
	         stmt = con.createStatement();  
	         rs = stmt.executeQuery(SQL);  
	  
	         // Iterate through the data in the result set and display it.  
	         while (rs.next()) {  
	            System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString("OrLogin")+" "+rs.getString("OrHaslo"));  
	         }  
	      }  
	  
	      // Handle any errors that may have occurred.  
	      catch (Exception e) {  
	         e.printStackTrace();  
	      }  
	      finally {  
	         if (rs != null) try { rs.close(); } catch(Exception e) {}  
	         if (stmt != null) try { stmt.close(); } catch(Exception e) {}  
	         if (con != null) try { con.close(); } catch(Exception e) {}  
	      }  
	    } 

	}


