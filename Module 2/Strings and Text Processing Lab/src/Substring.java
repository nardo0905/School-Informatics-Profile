import java.util.*;

public class Substring {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String toRemove = sc.nextLine();
		String word = sc.nextLine();
		
		sc.close();
		
		toRemove = toRemove.toLowerCase();
		
		while (word.contains(toRemove)) {
			word = word.replaceAll(toRemove, "");
		}
		
		System.out.println(word);
		
	}

}
