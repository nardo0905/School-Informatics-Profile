import java.util.Scanner;
import java.util.Stack;

public class StackSum {

	public static void main(String[] args) {
		
		Stack<Integer> intStack = new Stack<>();
		Scanner sc = new Scanner(System.in);
		
		String command = sc.nextLine();
		String[] data = command.split(" ");
		
		for (String n : data) {
			intStack.push(Integer.parseInt(n));
		}
		
		command = sc.nextLine();
		command = command.toLowerCase();
		
		while (!command.equals("end")) {
			
			data = command.split(" ");
			
			if (data[0].equals("add")) {
				intStack.push(Integer.parseInt(data[1]));
				intStack.push(Integer.parseInt(data[2]));
			}
			else {
				if (intStack.size() < Integer.parseInt(data[1])) {
					command = sc.nextLine();
					command = command.toLowerCase();
					continue;
				}
				for (int i = 0; i < Integer.parseInt(data[1]); i++) {
					intStack.pop();
				}
			}
			
			command = sc.nextLine();
			command = command.toLowerCase();
			
		}
		
		sc.close();
		
		int sum = 0;
		for (int n : intStack) {
			sum += n;
		}
		
		System.out.println(String.format("Sum: %d", sum));

	}

}
