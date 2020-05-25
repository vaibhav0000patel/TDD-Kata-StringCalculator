package main;

public class StringCalculator {

	public int Add(String numbers) throws Exception {
		if(numbers.length()==0) return 0;
		if(numbers.length()==1) return Integer.parseInt(numbers);
		return 9999;
	}
	
	public static void main(String[] args) {

	}

}
