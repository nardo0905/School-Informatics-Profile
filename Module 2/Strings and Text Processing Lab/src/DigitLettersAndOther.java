import java.util.Scanner;

public class DigitLettersAndOther {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String sequence = sc.nextLine();
		
		sc.close();
		
		StringBuilder digits = new StringBuilder();
		StringBuilder letters = new StringBuilder();
		StringBuilder other = new StringBuilder();
		
		for (int i = 0; i < sequence.length(); i++) {
			
			if (Character.isDigit(sequence.charAt(i))) digits.append(sequence.charAt(i));
			else if (Character.isLetter(sequence.charAt(i))) letters.append(sequence.charAt(i));
			else other.append(sequence.charAt(i));
			
		}
		
		System.out.println(digits + "\n" + letters + "\n" + other);
		
	}

}
