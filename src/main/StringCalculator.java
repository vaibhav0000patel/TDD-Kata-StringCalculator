package main;

public class StringCalculator {

	public int Add(String numbers) throws Exception {
		if(numbers.length()==0) return 0;
		
		// Sanitize the input String
		String[] operators = new String[] {"\\+","\\*","x","\\^","X"};
		for(String operator:operators) {
			numbers = numbers.replaceAll("["+operator+"+]", ";");
		}
		
		// Determine the delimiter
		String delimiter = ",";
		if(numbers.startsWith("//")) {
			if(numbers.contains("[") && numbers.contains("]")) {
				while(numbers.contains("[") && numbers.contains("]")) {
					int startIndex = numbers.indexOf("[");
					int endIndex = numbers.indexOf("]");
					delimiter = numbers.substring(startIndex+1, endIndex);
					numbers = numbers.substring(endIndex+1).replaceAll("["+delimiter+"+]", ";");
					delimiter = ";";
				}
			}else {
				delimiter = ""+numbers.charAt(2);
				numbers = numbers.substring(3);
			}
		}
		
		// Validate the input String
		if(numbers.endsWith("\n")) {
			throw new Exception("Invalid Input");
		}
		
		// Split the input String
		numbers = numbers.replace("\n", delimiter);
		String[] numbersArray = numbers.split(delimiter);
		String negatives = "";
		
		// Convert the splitted string into numbers and calculate its total
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
		
		// Check if any number was negative and raise exception if any
		if(negatives.length()>0) {
			throw new Exception("Negatives not allowed : "+negatives.substring(2));
		}
		
		return totalSum;
	}
	
	public static void main(String[] args) {

	}

}
