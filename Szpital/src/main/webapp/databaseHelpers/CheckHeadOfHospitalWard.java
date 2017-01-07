package main.webapp.databaseHelpers;

public class CheckHeadOfHospitalWard {

	public static String check(String OrHaslo, String OrLogin) {

		String SQL = "SELECT o.Ordynator_ID, o.imie, o.nazwisko, odd.Oddzial_ID, odd.nazwa, odd.ilosc_pac "
				+ "FROM ordynator o, oddzial odd WHERE o.Ordynator_ID = odd.Ordynator_ID AND o.OrHaslo = '"
				+ OrHaslo + "'AND o.OrLogin = '" + OrLogin + "'";

		String result = Database.selectFromDatabase(SQL);
		
		return result;
	}
}
