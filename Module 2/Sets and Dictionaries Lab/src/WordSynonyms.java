import java.util.*;

public class WordSynonyms {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		HashMap<String, List<String>> words = new LinkedHashMap<>();
		
		int N = Integer.parseInt(sc.nextLine());
		
		for (int i = 0; i < N; i++) {
			String word = sc.nextLine();
			String synonym = sc.nextLine();
			
			if (words.containsKey(word)) {
				words.get(word).add(synonym);
			}
			else {
				List<String> synonyms = new LinkedList<>();
				synonyms.add(synonym);
				words.put(word, synonyms);
			}
		}
		
		sc.close();
		
		for (String s : words.keySet()) {
			String output = s + " - ";
			for (String sy : words.get(s)) {
				output += sy + ", ";
			}
			System.out.println(output);
		}
		
	}

}
