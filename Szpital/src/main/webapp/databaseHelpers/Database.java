package main.webapp.databaseHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

	private static String connectionUrl = "jdbc:sqlserver://31.41.178.89:1433;"
			+ "databaseName=AplikacjaLukasz;user=AplikacjaLukasz;password=12345678";

	// Declare the JDBC objects.
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;

	public static String selectFromDatabase(String SQLCommand) {

		String result = "";

		try {
			// Establish the connection.
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(connectionUrl);

			// Create and execute an SQL statement that returns some data.
			String SQL = new String(SQLCommand);
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQL);

			result += Database.getResult(rs);

			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (Exception e) {
				}
			if (stmt != null)
				try {
					stmt.close();
				} catch (Exception e) {
				}
			if (con != null)
				try {
					con.close();
				} catch (Exception e) {
				}
		}
	}

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
				try {
					rs.close();
				} catch (Exception e) {
				}
			if (stmt != null)
				try {
					stmt.close();
				} catch (Exception e) {
				}
			if (con != null)
				try {
					con.close();
				} catch (Exception e) {
				}
		}
	}
	
	public static String[] selectFromDatabase(String SQLCommand, String column, String column2) {

		String result = "";
		String[] resultArray = new String[2];

		try {
			// Establish the connection.
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(connectionUrl);

			// Create and execute an SQL statement that returns some data.
			String SQL = new String(SQLCommand);
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQL);
			while (rs.next()) {
				result = new String(rs.getString(column)+","+new String(rs.getString(column2)));
			}
			
			resultArray = result.split(",");
			if(resultArray[0].length() == 0){
				resultArray[0] = "error";
				//resultArray[1] = "";
				return resultArray;
			}

			return resultArray;
		} catch (Exception e) {
			e.printStackTrace();
			resultArray[0] = "error";
			//resultArray[1] = "";
			return resultArray;
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (Exception e) {
				}
			if (stmt != null)
				try {
					stmt.close();
				} catch (Exception e) {
				}
			if (con != null)
				try {
					con.close();
				} catch (Exception e) {
				}
		}
	}


	private static String getResult(ResultSet rs) throws SQLException {
		ResultSetMetaData metadata = rs.getMetaData();
		int columnNumber = metadata.getColumnCount();
		String result = "";
		// Iterate through the data in the result set and display it.
		while (rs.next()) {
			String row = "";
			for (int i = 1; i <= columnNumber; i++) {
				row += rs.getString(i) + ", ";
			}
			result += row + "\n";
		}

		return result;

	}

	public static boolean insertUpdateIntoDatabase(String SQLCommand) {

		try {
			// Establish the connection.
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(connectionUrl);

			// Create and execute an SQL statement that returns some data.
			String SQL = new String(SQLCommand);
			stmt = con.createStatement();
			stmt.executeUpdate(SQL);
			
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (Exception e) {
				}
			if (stmt != null)
				try {
					stmt.close();
				} catch (Exception e) {
				}
			if (con != null)
				try {
					con.close();
				} catch (Exception e) {
				}
		}

	}

	public static boolean deleteFromDatabase(String SQLCommand) {
		return insertUpdateIntoDatabase(SQLCommand);
	}

}
