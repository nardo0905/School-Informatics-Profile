import java.util.Scanner;
import java.util.Stack;

public class MatchingBrackets {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String data = sc.nextLine();
		sc.close();
		
		Stack<Integer> brIndex = new Stack<>();
		
		for (int i = 0; i < data.length(); i++) {
			
			if (data.charAt(i) == '(') {
				brIndex.push(i);
			}
			
			if (data.charAt(i) == ')') {
				int opBr = brIndex.pop();
				System.out.println(data.substring(opBr, i + 1));
			}
			
		}
		
	}

}
