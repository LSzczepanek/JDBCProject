package main.webapp.java;

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
		
		System.out.println(CheckPatient.checkPatientStatus("Paździoch"));
		
		System.out.println(PatientsInHospitalWard.checkPatientsInHospitalWard("Oddziaź kardiologii"));
		
		System.out.println(CheckPatientDrugs.checkDrugs("Marian", "Paździoch"));
	}

}
