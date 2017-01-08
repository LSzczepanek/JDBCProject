package main.webapp.java;

import main.webapp.databaseHelpers.Drug;
import main.webapp.databaseHelpers.CheckAmountOfDrug;
import main.webapp.databaseHelpers.CheckHeadOfHospitalWard;
import main.webapp.databaseHelpers.CheckPatient;
import main.webapp.databaseHelpers.CheckPatientDrugs;
import main.webapp.databaseHelpers.LoginValidate;
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
//		System.out.println(AddDrug.addDrugToPatient(1, 2, 1));
		
		System.out.println(CheckPatient.checkPatientStatus("Paździoch"));
		
		System.out.println(PatientsInHospitalWard.checkPatientsInHospitalWard("Oddział kardiologii"));
		
		
		
		
		System.out.println(CheckPatientDrugs.checkDrugs("Marian", "Paździoch"));
		
		System.out.println("Ilosc leku");
		System.out.println(Drug.checkAmountOfDrug(2));
//		if(AddDrug.checkPatientHaveAlreadyThisDrug(1,2)){
//			System.out.println("Yes");
//		}
		
		//System.out.println(CheckHeadOfHospitalWard.check("MarMar", "MarMar"));
	}

}
