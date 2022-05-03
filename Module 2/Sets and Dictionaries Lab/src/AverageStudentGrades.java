import java.util.*;

public class AverageStudentGrades {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		HashMap<String, List<Double>> students = new LinkedHashMap<>();
		
		int N = Integer.parseInt(sc.nextLine());
		
		for (int i = 0; i < N; i++) {
			
			String[] data = sc.nextLine().split(" ");
			
			if (students.containsKey(data[0])) {
				students.get(data[0]).add(Double.parseDouble(data[1]));
			}
			else {
				List<Double> grades = new LinkedList<>();
				grades.add(Double.parseDouble(data[1]));
				students.put(data[0], grades);
			}
			
		}
		
		sc.close();
		
		for (String s : students.keySet()) {
			
			String output = s + " -> ";
			double gradeSum = 0;
			
			for (double g : students.get(s)) {
				gradeSum += g;
				output = output + g + " ";
			}
			
			output = output + "(avg: " + String.format("%.2f", gradeSum / students.get(s).size()) + ")";
			
			System.out.println(output);
			
		}
		
	}

}
