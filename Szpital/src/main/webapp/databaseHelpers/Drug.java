package main.webapp.databaseHelpers;

public class Drug {

	public static boolean addDrugToPatient(int patientID, int drugID, int dose) {

		boolean result;
		String SQL;
		if (dose <= checkAmountOfDrug(drugID)) {
			if (checkPatientHaveAlreadyThisDrug(patientID, drugID)) {
				SQL = "SELECT Il_dawek FROM Pacjent_Leki_Junction WHERE Pacjent_ID = " + patientID + " AND Leki_ID = "
						+ drugID;
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
				result = addRemoveAmountOfDrug(drugID, -dose);
			}
		} else {
			result = false;
		}
		return result;
	}

	public static boolean removeDrugFromPatient(int patientID, int drugID, int doseToRemove) {
		boolean result;
		String SQL;

		if (checkPatientHaveAlreadyThisDrug(patientID, drugID)) {
			SQL = "SELECT Il_dawek FROM Pacjent_Leki_Junction WHERE Pacjent_ID = " + patientID + " AND Leki_ID = "
					+ drugID;
			int amountOfPatientDrug = Integer.parseInt(Database.selectFromDatabase(SQL, "Il_dawek"));
			if (amountOfPatientDrug > doseToRemove) {
				int patientAmountOfDrugAfter = amountOfPatientDrug - doseToRemove;
				SQL = "UPDATE Pacjent_Leki_Junction SET Il_dawek = " + patientAmountOfDrugAfter + " WHERE Pacjent_ID = "
						+ patientID + " AND Leki_ID = " + drugID;
				result = Database.insertUpdateIntoDatabase(SQL);

				if (result) {
					result = addRemoveAmountOfDrug(drugID, doseToRemove);

				}
			} else if (amountOfPatientDrug == doseToRemove) {
				SQL = "DELETE FROM Pacjent_Leki_Junction WHERE Pacjent_ID = " + patientID + " AND Leki_ID = " + drugID;
				result = Database.deleteFromDatabase(SQL);
				
				if (result) {
					result = addRemoveAmountOfDrug(drugID, doseToRemove);
				}

			} else {
				result = false;
			}
		} else {
			result = false;
		}

		return result;
	}
	
	public static boolean removeAllDrugFromPatient(int patientID){
		
		boolean result;
		boolean loopResult = true;
		String[] sqlResult;
		String SQL = "SELECT TOP 1 Leki_ID, Il_dawek FROM Pacjent_Leki_Junction WHERE Pacjent_ID = "+patientID;
		sqlResult = Database.selectFromDatabase(SQL, "Leki_ID", "Il_dawek");
		
		while(!sqlResult[0].equals("error") && loopResult){
			loopResult = removeDrugFromPatient(patientID, Integer.parseInt(sqlResult[0]), Integer.parseInt(sqlResult[1]));
			sqlResult = Database.selectFromDatabase(SQL, "Leki_ID", "Il_dawek");
		}
		
		result = loopResult;
		
		return result;
	}

	public static boolean addRemoveAmountOfDrug(int drugID, int amount) {
		int amountAfterAdd = checkAmountOfDrug(drugID) + amount;
		String SQL = "UPDATE Leki SET Ilosc = " + amountAfterAdd + " WHERE Leki_ID = " + drugID;
		return Database.insertUpdateIntoDatabase(SQL);
	}

	public static int checkAmountOfDrug(int drugID) {

		String SQL = "SELECT Ilosc FROM Leki L Where Leki_ID = " + drugID;
		int result = Integer.parseInt(Database.selectFromDatabase(SQL, "ilosc"));

		return result;
	}
	
	public static String printAllAvalaibleDrugs(){
		String SQL = "SELECT * FROM Leki";
		String result = Database.selectFromDatabase(SQL);
		
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
