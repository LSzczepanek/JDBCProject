package main.webapp.databaseHelpers;

public class PatientsInHospitalWard {

	public static String checkPatientsInHospitalWard(String hospitalWard) {
		
		String SQL = "SELECT Od.Oddzial_ID, Od.Nazwa, P.Pacjent_ID, P.Imie, P.Nazwisko, P.Data_ur, P.Miasto, P.Adres "
				+ "FROM Oddzial Od INNER JOIN Pacjent P on P.Oddzial_ID = Od.Oddzial_ID "
				+ "WHERE Od.Nazwa LIKE '"+hospitalWard+"'";
		String result = Database.selectFromDatabase(SQL);
		

		return result;
	}
	
	
	public static String[] getArrayOfResult(String result){
		String preparedResult = result.replace("\n", ",");
		String[] arrayResult = preparedResult.split(",");
		
		return arrayResult;
	}
}
