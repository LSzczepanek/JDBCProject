package main.webapp.databaseHelpers;

public class PatientsInHospitalWard {

	public static String checkPatientsInHospitalWard(String hospitalWard) {
		
		String SQL = "SELECT Od.Oddzial_ID, Od.Nazwa, P.Pacjent_ID, P.Imie, P.Nazwisko, P.Data_ur "
				+ "FROM Oddzial Od INNER JOIN Pacjent P on P.Oddzial_ID = Od.Oddzial_ID "
				+ "WHERE Od.Nazwa LIKE '"+hospitalWard+"'";
		String result = Database.selectFromDatabase(SQL);

		return result;
	}
}