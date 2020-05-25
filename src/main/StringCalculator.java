package main;

public class StringCalculator {

	public int Add(String numbers) throws Exception {
		if(numbers.length()==0) return 0;
		if(numbers.length()==1) return Integer.parseInt(numbers);
		
		String delimiter = ",";
		String[] numbersArray = numbers.split(delimiter);
		int totalSum = 0;
		for(String num: numbersArray) {
			if(num.indexOf("\n")!=-1){
				String[] separatedBynewLine = num.split("\n");
				for(String n: separatedBynewLine) {
					if(n.length()==0) {
						throw new Exception("Invalid Input");
					}
					totalSum += Integer.parseInt(n); 
				}
			}else {
				totalSum += Integer.parseInt(num);
			}
		}
		
		return totalSum;
	}
	
	public static void main(String[] args) {

	}

}
