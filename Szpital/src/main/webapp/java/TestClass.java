package main.webapp.java;

import main.webapp.databaseHelpers.Database;
import main.webapp.databaseHelpers.Drug;
import main.webapp.databaseHelpers.LoginValidate;
import main.webapp.databaseHelpers.Patient;
import main.webapp.databaseHelpers.PatientsInHospitalWard;

public class TestClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		if(LoginValidate.validateLogin("marmar", "MarMar")){
			System.out.println("Yes");
		}else{
			System.out.println("No");
		}
		
//		System.out.println("Dodaj lek");
//		System.out.println(Drug.addDrugToPatient(1, 1, 5));
//		System.out.println(Drug.removeDrugFromPatient(1, 1, 3));
		
//		System.out.println(Drug.addAmountOfDrug(1, 2));
//		System.out.println(Patient.addNewPatient("Bartek2", "Foszmanowicz", "Łódź", "28PSK 6/10", "1993-12-13", 4));
		System.out.println(Patient.checkStatus("Foszmanowicz"));
		
		System.out.println(PatientsInHospitalWard.checkPatientsInHospitalWard("Oddział psychiatryczny"));
		
		
		
		
		System.out.println(Patient.checkDrugs("Marian", "Paździoch"));
		
		System.out.println("Ilosc leku");
		System.out.println(Drug.checkAmountOfDrug(1));
		
		System.out.println(Database.selectFromDatabase("SELECT * FROM Pacjent"));
		if(3>=3){
			System.out.println("yes");
		}
		
//		System.out.println(Patient.addNewPatient("Bartek", "Foszmanowicz", "Łódź", "28PSK 6/10", "1993-12-13", 4));
//		if(AddDrug.checkPatientHaveAlreadyThisDrug(1,2)){
//			System.out.println("Yes");
//		}
		
		//System.out.println(CheckHeadOfHospitalWard.check("MarMar", "MarMar"));
	}

}
