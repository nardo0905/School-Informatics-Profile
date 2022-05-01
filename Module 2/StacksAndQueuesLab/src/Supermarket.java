import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Supermarket {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Queue<String> customers = new LinkedList<>();
		
		String command = sc.nextLine();
		
		while (!command.equals("End")) {
			
			if (!command.equals("Paid")) {
				customers.add(command);
			}
			else {
				while (customers.size() > 0) {
					System.out.println(customers.remove());
				}
			}
			
			command = sc.nextLine();
			
		}
		
		sc.close();
		
		System.out.println(String.format("%d people remaining", customers.size()));
		
	}

}
