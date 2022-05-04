import java.util.*;

public class RepeatStrings {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String[] word = sc.nextLine().split(" ");
		sc.close();
		
		StringBuilder repeated = new StringBuilder();
		
		for (String s : word) {
			
			for (int i = 0; i < s.length(); i++) {
				repeated.append(s);
			}
			
		}
		
		System.out.println(repeated);
		
	}

}
