import java.util.Scanner;

public class SymbolInMatrix {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());
		boolean found = false;
		char[][] matrix = new char[N][N];
		
		for (int i = 0; i < N; i++) {
			char[] data = sc.nextLine().toCharArray();
			for (int j = 0; j < N; j++) {
				matrix[i][j] = data[j];
			}
		}
		
		char symb = sc.nextLine().charAt(0);
		
		sc.close();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (matrix[i][j] == symb) {
					System.out.println(String.format("(%d, %d)", i, j));
					found = true;
					break;
				}
			}
		}
		
		if (!found) {
			System.out.println(String.format("%c does not occur in the matrix", symb));
		}
		
	}

}
