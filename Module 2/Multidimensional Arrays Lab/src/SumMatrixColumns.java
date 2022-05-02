import java.util.Scanner;

public class SumMatrixColumns {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String[] data = sc.nextLine().split(", ");
		int rows = Integer.parseInt(data[0]);
		int columns = Integer.parseInt(data[1]);
		
		int[][] matrix = new int[rows][columns];
		
		
		for (int i = 0; i < rows; i++) {
			data = sc.nextLine().split(" ");
			for (int j = 0; j < columns; j++) {
				matrix[i][j] = Integer.parseInt(data[j]);
			}
		}
		
		sc.close();
		
		for (int i = 0; i < columns; i++) {
			int sum = 0;
			for (int j = 0; j < rows; j++) {
				sum += matrix[j][i];
			}
			System.out.println(sum);
		}
		
	}

}
