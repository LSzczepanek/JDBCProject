import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection("jdbc:sqlserver://31.41.178.89:1433;" +  
"databaseName=AplikacjaLukasz;user=AplikacjaLukasz;password=12345678");
			Statement st = con.createStatement();

			st.executeUpdate(
					"insert into ordynator (Imie, Nazwisko, OrLogin, OrHaslo) values ('Marianna', 'Niedzielska', 'MarNie', 'MarNie')");
			con.commit();
			
			ResultSet rs = st.executeQuery("Select * from Ordynator");
			String i1 = "";
			String i2 = "";
			String i3 = "";
			String i4 = "";
			
			while(rs.next())
			{
				i1 = rs.getString(1);
				i2 = rs.getString(2);
				i3 = rs.getString(3);
				i4 = rs.getString(4);
				System.out.println(i1 + " " + i2 + " " + i3 + " " + i4);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
