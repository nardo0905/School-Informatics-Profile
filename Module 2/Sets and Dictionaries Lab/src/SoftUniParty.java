import java.util.*;

public class SoftUniParty {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		HashSet<String> regulars = new HashSet<>();
		HashSet<String> vip = new HashSet<>();
		
		String command = sc.nextLine();
		
		while (!command.equals("PARTY")) {
			
			if (Character.isDigit(command.charAt(0))) {
				vip.add(command);
			}
			else {
				regulars.add(command);
			}
			
			command = sc.nextLine();
			
		}
		
		while (!command.equals("END")) {
			
			if(vip.contains(command)) {
				vip.remove(command);
			}
			else {
				regulars.remove(command);
			}
			
			command = sc.nextLine();
			
		}
		
		sc.close();
		
		System.out.println(vip.size() + regulars.size());
		
		for (String n : vip) {
			System.out.println(n);
		}
		
		for (String n : regulars) {
			System.out.println(n);
		}
		
	}

}
