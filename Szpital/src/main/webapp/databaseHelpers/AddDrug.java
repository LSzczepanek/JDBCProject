package main.webapp.databaseHelpers;

public class AddDrug {

	public static boolean addDrugToPatient(int patientID, int drugID, int dose) {

		boolean result;
		if (dose < CheckAmountOfDrug.check(drugID)) {
			String SQL = "INSERT Pacjent_Leki_Junction (Pacjent_ID, Leki_ID, Il_dawek) VALUES (" + patientID + ","
					+ drugID + "," + dose + ")";
			result = Database.insertUpdateIntoDatabase(SQL);
			int drugAmountAfter = CheckAmountOfDrug.check(drugID) - dose;
			SQL = "UPDATE Leki SET ilosc = "+drugAmountAfter+" WHERE Leki_ID = "+drugID;
			result = Database.insertUpdateIntoDatabase(SQL);
		} else {
			result = false;
		}
		return result;
	}
}
