package main.webapp.databaseHelpers;

public class LoginValidate {

	public static boolean validateLogin(String login, String password){

		String SQL = "SELECT OrHaslo FROM Ordynator where OrLogin='"+login.toLowerCase()+"'";
		         String realPassword = Database.selectFromDatabase(SQL, "OrHaslo");
		         if(password.equals(realPassword)){
			    	  return true;
			      }else{
			    	  return false;
			      }
		      }

}
