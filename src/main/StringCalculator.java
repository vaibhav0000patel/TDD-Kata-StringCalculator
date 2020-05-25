package main;

public class StringCalculator {

	public int Add(String numbers) throws Exception {
		if(numbers.length()==0) return 0;
		if(numbers.length()==1) return Integer.parseInt(numbers);
		
		String delimiter = ",";
		if(numbers.startsWith("//")) {
			delimiter = ""+numbers.charAt(2);
			numbers = numbers.substring(3);
		}
		
		if(numbers.endsWith("\n")) {
			throw new Exception("Invalid Input");
		}
		
		numbers = numbers.replace("\n", delimiter);
		String[] numbersArray = numbers.split(delimiter);
		int totalSum = 0;
		
		for(String num: numbersArray) {
			if(num.length()>0){
				totalSum += Integer.parseInt(num);
			}
		}
		
		return totalSum;
	}
	
	public static void main(String[] args) {

	}

}
