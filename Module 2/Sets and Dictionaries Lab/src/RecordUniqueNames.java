import java.util.*;

public class RecordUniqueNames {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());
		HashSet<String> names = new HashSet<>();
		
		for (int i = 0; i < N; i++) {
			
			String name = sc.nextLine();
			names.add(name);
			
		}
		
		sc.close();
		
		for (String n : names) {
			System.out.println(n);
		}
		
	}

}
