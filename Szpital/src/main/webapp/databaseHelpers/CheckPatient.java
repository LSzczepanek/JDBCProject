package main.webapp.databaseHelpers;

public class CheckPatient {

	public static String checkPatientStatus(String surname) {

		String SQL = "SELECT P.*, Od.Nazwa, L.Nazwa, PL.Il_dawek FROM Pacjent P JOIN "
				+ "Oddzial Od on Od.Oddzial_ID = P.Oddzial_ID JOIN Pacjent_Leki_Junction PL "
				+ "on PL.Pacjent_ID = P.Pacjent_ID JOIN Leki L on PL.Leki_ID = L.Leki_ID " + "WHERE P.Nazwisko = '"
				+ surname + "'";
		String result = Database.selectFromDatabase(SQL);

		return result;

	}
}
