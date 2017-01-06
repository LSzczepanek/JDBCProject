package main.webapp.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginValidate {

	public static boolean validateLogin(String login, String password){
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
		         String SQL = "SELECT OrHaslo FROM Ordynator where OrLogin='"+login+"'";  
		         String realPassword = "";
		         stmt = con.createStatement();  
		         rs = stmt.executeQuery(SQL);  
		         
		  
		         // Iterate through the data in the result set and display it.  
		         while (rs.next()) {  
		            realPassword = new String(rs.getString("OrHaslo"));  
		         }
		         
		         if(password.equals(realPassword)){
			    	  return true;
			      }else{
			    	  return false;
			      }
		      }  
		  	     
		      // Handle any errors that may have occurred.  
		      catch (Exception e) {  
		         e.printStackTrace();  
		         return false;
		      }  
		      finally {  
		         if (rs != null) try { rs.close(); } catch(Exception e) {}  
		         if (stmt != null) try { stmt.close(); } catch(Exception e) {}  
		         if (con != null) try { con.close(); } catch(Exception e) {}  
		      }  
		    
	}
}
