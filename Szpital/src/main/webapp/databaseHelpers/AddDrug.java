package main.webapp.databaseHelpers;

public class AddDrug {

	public static boolean addDrugToPatient(int patientID, int drugID, int dose){
		
		String SQL = "INSERT Pacjent_Leki_Junction (Pacjent_ID, Leki_ID, Il_dawek) VALUES ("+patientID+","+drugID+","+dose+")";
		boolean result = Database.insertIntoDatabase(SQL);
		
		return result;
	}
}
