import java.util.Scanner;

public class SumMatrixElements {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String[] data = sc.nextLine().split(", ");
		int rows = Integer.parseInt(data[0]);
		int columns = Integer.parseInt(data[1]);
		int sum = 0;
		
		for (int i = 0; i < rows; i++) {
			data = sc.nextLine().split(", ");
			for (int j = 0; j < data.length; j++) {
				//System.out.println(data[j]);
				sum += Integer.parseInt(data[j]);
			}
		}
		
		sc.close();
		
		System.out.println(rows + "\n" + columns + "\n" + sum);
		
	}

}
