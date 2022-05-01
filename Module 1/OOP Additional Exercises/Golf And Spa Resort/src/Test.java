import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int currLine = 1;
		String command = sc.nextLine();
		
		while (!command.equals("End")) {
			
			String[] data = command.split(" ");
			
			switch(data.length) {
			
			case 2: {
				
				String fName = data[0];
				String lName = data[1];
				
				Guest g = new Guest(fName, lName);
				System.out.println(g.newGuest());
				
			} break;
			
			case 3: {
				
				String fName = data[0];
				String lName = data[1];
				int id = Integer.parseInt(data[2]);
				String access = (currLine % 2 == 0) ? "fitness" : "spa ";
				
				Member m = new Member(fName, lName, id);
				System.out.println(m.getMemberCard(access));
				
			} break;
			
			case 4: {
				
				String fName = data[0];
				String lName = data[1];
				String department = data[2];
				int id = Integer.parseInt(data[3]);
				
				Employee e = new Employee(fName, lName, department, id);
				System.out.println(e.startWorkingDay());
				
			} break;
			
			}
			
			currLine++;
			command = sc.nextLine();
			
		}
		
		sc.close();
		
	}

}
