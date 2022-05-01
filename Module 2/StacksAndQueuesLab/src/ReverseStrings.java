import java.util.*;

public class ReverseStrings {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		sc.close();
		
		Stack<Character> stack = new Stack<>();
		
		for (int i = 0; i < input.length(); i++) {
			stack.push(input.charAt(i));
		}
		
		System.out.println(stack + ", " + stack.size());
		
		while (stack.size() > 0) {
			System.out.print(stack.pop());
		}

	}

}
