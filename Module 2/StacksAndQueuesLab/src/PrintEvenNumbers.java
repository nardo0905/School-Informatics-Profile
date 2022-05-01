import java.util.*;

public class PrintEvenNumbers {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String[] data = sc.nextLine().split(" ");
		sc.close();
		
		Queue<Integer> numbers = new LinkedList<>();
		
		for (String s : data) {
			numbers.add(Integer.parseInt(s));
		}
		
		while (numbers.size() > 0) {
			if (!(numbers.peek() % 2 == 0)) {
				numbers.remove();
			}
			else {
				System.out.print(numbers.remove() + ", ");
			}
		}
		
	}

}
