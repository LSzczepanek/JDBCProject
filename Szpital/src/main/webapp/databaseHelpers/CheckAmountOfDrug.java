package main.webapp.databaseHelpers;

public class CheckAmountOfDrug {

	public static int check(int drugID){
		
		String SQL = "SELECT Ilosc FROM Leki L Where Leki_ID = "+drugID;
		int result = Integer.parseInt(Database.selectFromDatabase(SQL, "ilosc"));
		
		return result;
	}
}
