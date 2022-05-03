import java.util.*;

public class OddOccurrences {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String[] data = sc.nextLine().toLowerCase().split(" ");
		sc.close();
		
		HashMap<String, Integer> strings = new LinkedHashMap<>();
		
		for (String s : data) {
			
			System.out.println(s);
			
			if (strings.containsKey(s)) {
				strings.replace(s, strings.get(s) + 1);
			}
			else {
				strings.put(s, 1);
			}
			
		}
		
		System.out.println(strings);
		
		String output = "";
		for (String s : strings.keySet()) {
			if (strings.get(s) % 2 != 0) {
				output = output + s + " ";
			}
		}
		
		System.out.println(output.trim());
		
	}

}
