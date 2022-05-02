import java.util.Scanner;

public class JaggedArrayModification {

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
		
		String command = sc.nextLine();
		
		while(!command.equals("END")) {
			
			String[] data = command.split(" ");
			
			if (data[0].equals("Add")) {
				int x = Integer.parseInt(data[1]);
				int y = Integer.parseInt(data[2]);
				int num = Integer.parseInt(data[3]);
				if ((x >= 0 && x < N) && (y >= 0 && y < N)) {
					matrix[x][y] += num;
				}
				else {
					System.out.println("Invalid coordinates");
				}
			}
			
			if (data[0].equals("Subtract")) {
				int x = Integer.parseInt(data[1]);
				int y = Integer.parseInt(data[2]);
				int num = Integer.parseInt(data[3]);
				if ((x >= 0 && x < N) && (y >= 0 && y < N)) {
					matrix[x][y] -= num;
				}
				else {
					System.out.println("Invalid coordinates");
				}
			}
			
			command = sc.nextLine();
			
		}
		
		sc.close();
		
		for (int i = 0; i < N; i++) {
			String line = "";
			for (int j = 0; j < N; j++) {
				line += matrix[i][j] + " ";
			}
			System.out.print(line.trim());
			System.out.println();
		}
		
	}

}
