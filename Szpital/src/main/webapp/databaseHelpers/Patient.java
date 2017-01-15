package main.webapp.databaseHelpers;

public class Patient {

	public static boolean addNewPatient(String name, String surname, String city, String address, String birthDay,
			int hospitalWard_ID) {

		boolean result;
		String SQL = "INSERT INTO Pacjent VALUES ('" + name + "', '" + surname + "', '" + city + "', '" + address
				+ "', '" + birthDay + "', " + hospitalWard_ID + ")";

		result = Database.insertUpdateIntoDatabase(SQL);

		if (result) {
			result = updateAmountOfPatients(hospitalWard_ID, 1);
		}
		return result;
	}

	public static boolean removePatient(int patientID, int hospitalWard_ID) {

		boolean result;

		result = Drug.removeAllDrugFromPatient(patientID);
		String SQL = "DELETE FROM Pacjent WHERE Pacjent_ID = " + patientID;
		
		if(result){
		result = Database.deleteFromDatabase(SQL);
		}
		
		if (result) {
			result = updateAmountOfPatients(hospitalWard_ID, -1);
		}
		return result;
	}

	public static boolean updatePatient(int patientID, String name, String surname, String city, String address,
			String birthDay, int hospitalWard_ID) {

		boolean result = false;
		String SQL = "SELECT Oddzial_ID FROM Pacjent WHERE Pacjent_ID = " + patientID;
		int oldHospitalWard = Integer.parseInt(Database.selectFromDatabase(SQL, "Oddzial_ID"));

		SQL = "UPDATE Pacjent SET Imie = '" + name + "', Nazwisko = '" + surname + "', Miasto = '" + city
				+ "', Adres = '" + address + "', Data_ur = '" + birthDay + "', Oddzial_ID = " + hospitalWard_ID+" WHERE Pacjent_ID = "+patientID;
		
		result = Database.insertUpdateIntoDatabase(SQL);

		if (result && oldHospitalWard!=hospitalWard_ID) {
			result = updateAmountOfPatients(hospitalWard_ID, 1);
			if(result){
				result = updateAmountOfPatients(oldHospitalWard, -1);
			}else{
				result = false;
			}
		}
		return result;
	}

	private static boolean updateAmountOfPatients(int hospitalWard_ID, int amountToChange) {
		String SQL = "SELECT Ilosc_pac FROM Oddzial WHERE Oddzial_ID = " + hospitalWard_ID;
		int amoutOfPatients = Integer.parseInt(Database.selectFromDatabase(SQL, "Ilosc_pac")) + amountToChange;

		SQL = "UPDATE Oddzial SET Ilosc_pac = " + amoutOfPatients + "WHERE Oddzial_ID = " + hospitalWard_ID;
		return Database.insertUpdateIntoDatabase(SQL);

	}

	public static String checkStatus(String surname) {

		String SQL = "SELECT P.*, Od.Nazwa, L.Nazwa, PL.Il_dawek FROM Pacjent P JOIN "
				+ "Oddzial Od on Od.Oddzial_ID = P.Oddzial_ID LEFT OUTER JOIN Pacjent_Leki_Junction PL "
				+ "on PL.Pacjent_ID = P.Pacjent_ID LEFT OUTER JOIN Leki L on PL.Leki_ID = L.Leki_ID "
				+ "WHERE P.Nazwisko = '" + surname + "'";
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
