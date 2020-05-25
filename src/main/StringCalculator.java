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
		String negatives = "";
		
		int totalSum = 0;
		for(String num: numbersArray) {
			num = num.trim();
			if(num.length()>0){
				int n = Integer.parseInt(num);
				if(n<0) {
					negatives += ", "+num;
				}
				if(n<=1000) totalSum += n;
			}
		}
		
		if(negatives.length()>0) {
			throw new Exception("Negatives not allowed : "+negatives.substring(2));
		}
		
		return totalSum;
	}
	
	public static void main(String[] args) {

	}

}
