import java.util.Scanner;

public class PrimaryDiagonal {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());
		
		int[][] matrix = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			String[] data = sc.nextLine().split(" ");
			for (int j = 0; j < N; j++) {
				matrix[i][j] = Integer.parseInt(data[j]);
			}
		}
		
		sc.close();
		
		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += matrix[i][i];
		}
		
		System.out.println(sum);
		
	}

}
