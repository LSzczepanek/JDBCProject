package main.webapp.databaseHelpers;

public class AddDrug {

	public static boolean addDrugToPatient(int patientID, int drugID, int dose) {

		boolean result;
		String SQL;
		if (dose < CheckAmountOfDrug.check(drugID)) {
			if (checkPatientHaveAlreadyThisDrug(patientID, drugID)) {
				SQL = "SELECT Il_dawek FROM Pacjent_Leki_Junction WHERE Pacjent_ID = " + patientID + " AND Leki_ID = " + drugID;
				int patientAmountOfDrugAfter = Integer.parseInt(Database.selectFromDatabase(SQL, "Il_dawek"));
				patientAmountOfDrugAfter += dose;
				SQL = "UPDATE Pacjent_Leki_Junction SET Il_dawek = " + patientAmountOfDrugAfter + " WHERE Pacjent_ID = "
						+ patientID + " AND Leki_ID = " + drugID;
				result = Database.insertUpdateIntoDatabase(SQL);
			} else {

				SQL = "INSERT Pacjent_Leki_Junction (Pacjent_ID, Leki_ID, Il_dawek) VALUES (" + patientID + "," + drugID
						+ "," + dose + ")";
				result = Database.insertUpdateIntoDatabase(SQL);

			}
			if (result) {
				int drugAmountAfter = CheckAmountOfDrug.check(drugID) - dose;
				SQL = "UPDATE Leki SET ilosc = " + drugAmountAfter + " WHERE Leki_ID = " + drugID;
				result = Database.insertUpdateIntoDatabase(SQL);
			}
		} else {
			result = false;
		}
		return result;
	}

	private static boolean checkPatientHaveAlreadyThisDrug(int patientID, int drugID) {
		String SQL = "SELECT Leki_ID FROM Pacjent_Leki_Junction WHERE Pacjent_ID = " + patientID;

		if (Database.selectFromDatabase(SQL).contains(drugID + ",")) {
			return true;
		} else {
			return false;
		}

	}
}
