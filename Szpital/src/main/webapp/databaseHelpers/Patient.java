package main.webapp.databaseHelpers;

public class Patient {

	public static boolean addNewPatient(String name, String surname, String city, String address, String birthDay,
			int hospitalWard_ID) {

		boolean result;
		String SQL = "INSERT INTO Pacjent VALUES ('" + name + "', '" + surname + "', '" + city + "', '" + address
				+ "', '" + birthDay + "', " + hospitalWard_ID + ")";

		result = Database.insertUpdateIntoDatabase(SQL);

		if (result) {

			SQL = "SELECT Ilosc_pac FROM Oddzial WHERE Oddzial_ID = " + hospitalWard_ID;
			int amoutOfPatients = Integer.parseInt(Database.selectFromDatabase(SQL, "Ilosc_pac")) + 1;

			SQL = "UPDATE Oddzial SET Ilosc_pac = " + amoutOfPatients + "WHERE Oddzial_ID = " + hospitalWard_ID;
			result = Database.insertUpdateIntoDatabase(SQL);
		}
		return result;
	}
	
	
	public static boolean removePatient(int patientID){
		
		return false;
	}

	public static String checkStatus(String surname) {

		String SQL = "SELECT P.*, Od.Nazwa, L.Nazwa, PL.Il_dawek FROM Pacjent P JOIN "
				+ "Oddzial Od on Od.Oddzial_ID = P.Oddzial_ID JOIN Pacjent_Leki_Junction PL "
				+ "on PL.Pacjent_ID = P.Pacjent_ID JOIN Leki L on PL.Leki_ID = L.Leki_ID " + "WHERE P.Nazwisko = '"
				+ surname + "'";
		String result = Database.selectFromDatabase(SQL);

		return result;

	}

	public static String checkDrugs(String name, String surname) {

		String SQL = "SELECT P.Pacjent_ID, P.Imie, P.Nazwisko, P.Data_ur, L.Nazwa, PL.Il_dawek "
				+ "FROM Pacjent P JOIN Pacjent_Leki_Junction PL on PL.Pacjent_ID = P.Pacjent_ID "
				+ "JOIN Leki L on PL.Leki_ID = L.Leki_ID WHERE P.Imie LIKE '" + name + "' AND P.Nazwisko LIKE '"
				+ surname + "'";
		String result = Database.selectFromDatabase(SQL);

		return result;
	}

}
