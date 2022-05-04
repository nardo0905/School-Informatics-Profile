import java.util.*;

public class TextFilter {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String[] bannedWords = sc.nextLine().split(", ");
		String text = sc.nextLine();
		
		sc.close();
		
		for (String s : bannedWords) {

			StringBuilder ast = new StringBuilder();
			
			for (int i = 0; i < s.length(); i++) {
				ast.append("*");
			}
			
			text = text.replaceAll(s, ast.toString());
			
		}
		
		System.out.println(text);
		
	}

}
