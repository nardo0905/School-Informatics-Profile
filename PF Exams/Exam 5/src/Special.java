import java.util.*;

public class Special {

	public static void main(String[] args) {
		
		ArrayList<Integer> foundNumbers = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		int a = Integer.parseInt(sc.next());
		int b = Integer.parseInt(sc.next());
		System.out.println(a + " " + b);
		sc.close();
		
		for (int i = a; i <= b; i++) {
			
			for (int j = 2; j <= 16; j++) {
				
				boolean found = true;
				String number = Integer.toString(i, j);
				
				for (int k = 0; k < number.length(); k++) {
					if (number.charAt(k) != number.charAt(0)) {
						found = false; 
						break;
					}
				}
				
				if (found) {
					foundNumbers.add(i);
					break;
				}
				
			}
			
		}
		
		StringJoiner joiner = new StringJoiner(", ");
		foundNumbers.forEach(num -> joiner.add(Integer.toString(num)));
		
		System.out.println(joiner);
		
	}

}
