package main.webapp.databaseHelpers;

public class CheckPatientDrugs {

	public static String checkDrugs(String name, String surname){
		
		String SQL = "SELECT P.Pacjent_ID, P.Imie, P.Nazwisko, P.Data_ur, L.Nazwa, PL.Il_dawek "
				+ "FROM Pacjent P JOIN Pacjent_Leki_Junction PL on PL.Pacjent_ID = P.Pacjent_ID "
				+ "JOIN Leki L on PL.Leki_ID = L.Leki_ID WHERE P.Imie LIKE '"+name+"' AND P.Nazwisko LIKE '"+surname+"'";
		String result = Database.selectFromDatabase(SQL);

		return result;
	}
}
