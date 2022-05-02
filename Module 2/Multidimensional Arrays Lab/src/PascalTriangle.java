import java.util.Scanner;

public class PascalTriangle {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());
		sc.close();
		
		long[][] arr = new long [N + 1][999999];
		arr[0][0] = 1;
		
		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j <= i; j++) {
				arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		
	}

}
