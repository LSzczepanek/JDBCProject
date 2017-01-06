package main.webapp.databaseHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Database {

	private static String connectionUrl = "jdbc:sqlserver://31.41.178.89:1433;"
			+ "databaseName=AplikacjaLukasz;user=AplikacjaLukasz;password=12345678";

	// Declare the JDBC objects.
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;

	public static String selectFromDatabase(String SQLCommand, String column) {

		String result = "";

		try {
			// Establish the connection.
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(connectionUrl);

			// Create and execute an SQL statement that returns some data.
			String SQL = new String(SQLCommand);
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQL);
			while (rs.next()) {
				result = new String(rs.getString(column));
			}

			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		} finally {
			if (rs != null)
				try {rs.close();} catch (Exception e) {}
			if (stmt != null)
				try {stmt.close();} catch (Exception e) {}
			if (con != null)
				try {con.close();} catch (Exception e) {}
		}
	}
	
	
	public static String selectFromDatabase(String SQLCommand, String column, String column2) {

		String result = "";

		try {
			// Establish the connection.
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(connectionUrl);

			// Create and execute an SQL statement that returns some data.
			String SQL = new String(SQLCommand);
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQL);
			while (rs.next()) {
				result = new String(rs.getString(column)+rs.getString(column2));
			}

			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		} finally {
			if (rs != null)
				try {rs.close();} catch (Exception e) {}
			if (stmt != null)
				try {stmt.close();} catch (Exception e) {}
			if (con != null)
				try {con.close();} catch (Exception e) {}
		}
	}
	
	
	public static boolean insertIntoDatabase(){
		return false;
	}
	
	
	public static boolean deleteFromDatabase(){
		return false;
	}
	public static boolean updateIntoDatabase(){
		return false;
	}
}
