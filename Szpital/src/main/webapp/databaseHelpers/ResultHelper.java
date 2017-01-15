package main.webapp.databaseHelpers;

public class ResultHelper {
	
	public static String[] getArrayOfResult(String result){
		String preparedResult = result.replace("\n", ",");
		String[] arrayResult = preparedResult.split(",");
		
		
		return arrayResult;
	}
	
	
	
	public static String[][] getArrayOfResult2(String result){
		String preparedResult = result.replace("\n", ",");
		String[] arrayResult = preparedResult.split(",");
		
		int first = 0;
		int second = 0 ;
		for (int i = 0; i < arrayResult.length; i++) {
			if(Character.isWhitespace(arrayResult[i].charAt(0)) && arrayResult[i].length() == 1){
				first++;
				continue;
			}
			second++;
		}
		
		
		String[][] test = new String[first][second/first];
		for (int i = 0, j = 0, k = 0; i < arrayResult.length; i++) {
			if(Character.isWhitespace(arrayResult[i].charAt(0)) && arrayResult[i].length() == 1){
				j++;
				k = 0;
				continue;
			}
			test[j][k] = new String(arrayResult[i]);
			k++;
		}
		
		return test;
	}
}
