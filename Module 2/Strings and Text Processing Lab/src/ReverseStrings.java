import java.util.*;

public class ReverseStrings {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String command = sc.nextLine();
		
		while (!command.equals("end")) {
			
			String word = command;
			StringBuilder reversed = new StringBuilder();
			
			reversed.append(word);
			reversed.reverse();
			
			System.out.println(String.format("%s = %s", word, reversed));
			
			command = sc.nextLine();
			
		}
		
		sc.close();
		
	}

}
