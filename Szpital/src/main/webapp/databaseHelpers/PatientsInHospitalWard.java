package main.webapp.databaseHelpers;

import java.sql.PreparedStatement;

public class PatientsInHospitalWard {

	public static String checkPatientsInHospitalWard(String hospitalWard) {
		
		String SQL = "SELECT Od.Oddzial_ID, Od.Nazwa, P.Pacjent_ID, P.Imie, P.Nazwisko, P.Data_ur, P.Miasto, P.Adres "
				+ "FROM Oddzial Od INNER JOIN Pacjent P on P.Oddzial_ID = Od.Oddzial_ID "
				+ "WHERE Od.Nazwa LIKE '"+hospitalWard+"'";
		String result = Database.selectFromDatabase(SQL);
		

		return result;
	}
	
public static String searchForPatientsInHospitalWard(String hospitalWard, String searchWord) {
		
		String SQL = "SELECT Od.Oddzial_ID, Od.Nazwa, P.Pacjent_ID, P.Imie, P.Nazwisko, P.Data_ur, P.Miasto, P.Adres "
				+ "FROM Oddzial Od INNER JOIN Pacjent P on P.Oddzial_ID = Od.Oddzial_ID "
				+ "WHERE Od.Nazwa LIKE '"+hospitalWard+"' AND stuff(coalesce('|' + P.Imie, '') + coalesce('|' + P.Nazwisko, '') + coalesce('|' + cast(P.Data_ur AS varchar(255)), '')  + coalesce('|' + P.Miasto, '')  + coalesce('|' + P.Adres, ''), 1, 1, '') LIKE '%" + searchWord +"%'";
		String result = Database.selectFromDatabase(SQL);
		
		return result;
	}
	
}
