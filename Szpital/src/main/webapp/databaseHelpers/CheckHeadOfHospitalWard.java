package main.webapp.databaseHelpers;

public class CheckHeadOfHospitalWard {

	public static String check(int ordynaotor_ID) {

		String SQL = "SELECT o.Ordynator_ID, o.imie, o.nazwisko, odd.Oddzial_ID, odd.nazwa, odd.ilosc_pac "
				+ "FROM ordynator o, oddzial odd WHERE o.Ordynator_ID = odd.Ordynator_ID AND o.Ordynator_ID = "
				+ ordynaotor_ID;

		String result = Database.selectFromDatabase(SQL);
		
		return result;
	}
}
