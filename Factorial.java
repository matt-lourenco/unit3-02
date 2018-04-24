/****************************************************************************
 *
 * Created by: Matthew lourenco
 * Created on: Apr 2018
 * This program Calculates the factorial of the input
 *
 ****************************************************************************/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Factorial {
	
	Integer number;
	
	@SuppressWarnings("serial")
	private static class InvalidInputException extends Exception {

	    public InvalidInputException(String message) {
	    	//exception that displays a message
	        super(message);
	    }
	}
	
	Factorial(Integer number) throws InvalidInputException {
		//Default constructor
		if(number > 0) {
			this.number = number;
			findFactorial(this.number);
		} else if(number == 0) {
			this.number = 1;
		} else {
			throw new InvalidInputException("Inputted number is less than 0");
		}
	}
	
	private void findFactorial(Integer unprocessed) {
		//multiply number by unprocessed - 1 until unprocessed == 2
		Integer newNumber = unprocessed - 1;
		if(newNumber > 1) {
			number *= newNumber;
			System.out.println(number);
			findFactorial(newNumber);
		}
	}
	
	public Integer getfactorial() { return number; } //getter
	
	public static void main(String[] args) throws Exception {
		//Get a input from the user
		
		BufferedReader reader = new BufferedReader(new InputStreamReader
				(System.in));
		System.out.println("Enter an integer: ");
		String input = reader.readLine();
		
		Integer inputNumber = 0;
		
		try {
			inputNumber = Integer.parseInt(input);
		} catch(NumberFormatException notAnInteger) {
			throw new InvalidInputException("Input is not an integer");
		}
		
		Factorial factorial = new Factorial(inputNumber);
		
		System.out.println("Original: " + inputNumber + "\nFactorial: "
							+ factorial.getfactorial());
	}
}