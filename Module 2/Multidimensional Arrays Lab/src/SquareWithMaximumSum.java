import java.util.Scanner;

public class SquareWithMaximumSum {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String[] data = sc.nextLine().split(", ");
		int rows = Integer.parseInt(data[0]);
		int columns = Integer.parseInt(data[1]);
		int[][] matrix = new int[rows][columns];
		
		for (int i = 0; i < rows; i++) {
			data = sc.nextLine().split(", ");
			for (int j = 0; j < columns; j++) {
				matrix[i][j] = Integer.parseInt(data[j]);
			}
		}
		
		sc.close();
		
		int biggestSum = Integer.MIN_VALUE;
		int row = 0;
		int col = 0;
		
		for (int i = 0; i < rows - 1; i++) {
			for (int j = 0; j < columns - 1; j++) {
				
				int sum = matrix[i][j] + matrix[i][j + 1] + matrix [i + 1][j] + matrix[i + 1][j + 1];
				
				if (sum > biggestSum) {
					biggestSum = sum;
					row = i;
					col = j;
				}
				
			}
		}
		
		System.out.println(matrix[row][col] + " " + matrix[row][col + 1] + "\n" + matrix[row + 1][col] + " " + matrix[row + 1][col + 1] + "\n" + biggestSum);
		
	}

}
