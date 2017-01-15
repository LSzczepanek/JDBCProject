package main.webapp.java;

import main.webapp.databaseHelpers.Database;
import main.webapp.databaseHelpers.Drug;
import main.webapp.databaseHelpers.LoginValidate;
import main.webapp.databaseHelpers.Patient;
import main.webapp.databaseHelpers.PatientsInHospitalWard;
import main.webapp.databaseHelpers.ResultHelper;

public class TestClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		if(LoginValidate.validateLogin("marmar", "MarMar")){
			System.out.println("Yes");
		}else{
			System.out.println("No");
		}
//		Patient.updatePatient(6, "Bartek", "Foszmanowicz", "Ĺ�ĂłdĹş", "28PSK 6/10", "1994-12-13", 4);
//		System.out.println("Dodaj lek");
//		System.out.println(Drug.addDrugToPatient(1, 1, 5));
//		System.out.println(Drug.addDrugToPatient(2, 1, 5));
//		System.out.println(Drug.addDrugToPatient(4, 1, 5));
//		System.out.println(Drug.removeDrugFromPatient(1, 1, 3));
		
//		System.out.println(Drug.addAmountOfDrug(1, 2));
//		System.out.println(Patient.addNewPatient("Bartek3", "Foszmanowicz", "Ĺ�ĂłdĹş", "28PSK 6/10", "1993-12-13", 4));
//		System.out.println(Patient.removePatient(7, 4));
		System.out.println(Patient.checkStatus("Foszmanowicz"));
		
		System.out.println(PatientsInHospitalWard.checkPatientsInHospitalWard("Oddział kardiologii"));
		
		String[] test = ResultHelper.getArrayOfResult(PatientsInHospitalWard.checkPatientsInHospitalWard("Oddział kardiologii"));
		
		System.out.println("Start of Array");
		int count = 0;
		for (String string : test) {
			System.out.println(count++ +": "+string);
		}
		
		System.out.println("End of Array\n");
		
		String[][] test2 = ResultHelper.getArrayOfResult2(Drug.printAllAvalaibleDrugs());
		
		System.out.println("Start of Array");
		int count2 = 0;
		for (String[] string : test2) {
			System.out.println("\nWiersz "+count2++);
			for (String string2 : string) {
				System.out.print(string2+", ");
			}
		}
		
		System.out.println("\nEnd of Array");
		
		System.out.println(Patient.checkDrugs("Marian", "Paździoch"));
		
		
		
		
		System.out.println(Database.selectFromDatabase("SELECT * FROM Pacjent"));
		System.out.println(Database.selectFromDatabase("SELECT nazwa,Ilosc_pac, Oddzial_ID FROM Oddzial"));
		
		System.out.println(Drug.printAllAvalaibleDrugs());
		
//		System.out.println("Ilosc leku");
//		System.out.println(Drug.checkAmountOfDrug(1));
//		System.out.println("Ilosc leku");
//		System.out.println(Drug.checkAmountOfDrug(2));
//		
//		System.out.println(Patient.checkStatus("Paździoch"));
//		System.out.println(Drug.removeAllDrugFromPatient(1));
//		System.out.println(Patient.checkStatus("Paździoch"));
//		
//		System.out.println("Ilosc leku");
//		System.out.println(Drug.checkAmountOfDrug(1));
//		System.out.println("Ilosc leku");
//		System.out.println(Drug.checkAmountOfDrug(2));
		
//		System.out.println(Drug.addDrugToPatient(5, 1, 12));
//		System.out.println(Drug.removeDrugFromPatient(6, 2, 1));

		
//		System.out.println(Patient.addNewPatient("Bartek", "Foszmanowicz", "Ĺ�ĂłdĹş", "28PSK 6/10", "1993-12-13", 4));
//		if(AddDrug.checkPatientHaveAlreadyThisDrug(1,2)){
//			System.out.println("Yes");
//		}
		
		//System.out.println(CheckHeadOfHospitalWard.check("MarMar", "MarMar"));
	}

}
