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
	
	
	
	public static String[][] getArrayOfResult2(String result){
		String preparedResult = result.replace("\n", ",");
		String[] arrayResult = preparedResult.split(",");
		
		int first = 0;
		int second = 0 ;
		for (int i = 0; i < arrayResult.length; i++) {
			if(Character.isWhitespace(arrayResult[i].charAt(0)) && arrayResult[i].length() == 1){
				first++;
				continue;
			}
			second++;
		}
		
		
		String[][] test = new String[first][second/first];
		for (int i = 0, j = 0, k = 0; i < arrayResult.length; i++) {
			if(Character.isWhitespace(arrayResult[i].charAt(0)) && arrayResult[i].length() == 1){
				j++;
				k = 0;
				continue;
			}
			test[j][k] = new String(arrayResult[i]);
			k++;
		}
		
		return test;
	}
}
