import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		String command = sc.nextLine();
		
		String[] data = command.split(", ");
		int id = Integer.parseInt(data[0]);
		String name = data[1];
		int age = Integer.parseInt(data[2]);
		String email = data[3];
		
		Customer c = new Customer(id, name, age, email);
		
		command = sc.nextLine();
		
		while(!command.equals("End")) {
			
			
			data = command.split(" ");
			
			if (data[0].equals("Bonus")) {
				c.addBonusPoints(Integer.parseInt(data[2]));
			}
			else {
				c.exchangePoints(Integer.parseInt(data[1]));
			}
			
			command = sc.nextLine();
			
		}
		
		sc.close();
		

	}

}
