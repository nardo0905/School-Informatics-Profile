import java.util.*;

public class Bigger {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int S = Integer.parseInt(sc.nextLine());

		ArrayList<Integer> numbers = new ArrayList<>();

		while (sc.hasNextInt()) {
			numbers.add(sc.nextInt());
		}

		sc.close();

		int count = 0;

		for (int i = 0; i < numbers.size() - 1; i++) {

			for (int j = i + 1; j < numbers.size(); j++) {

				int num1 = numbers.get(i);
				int num2 = numbers.get(j);

				if (num1 + num2 > S) {
					count++;
				}

			}

		}

		System.out.println(count);

	}

}
