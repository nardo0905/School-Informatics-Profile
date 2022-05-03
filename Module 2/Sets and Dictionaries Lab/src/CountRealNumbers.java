import java.util.*;

public class CountRealNumbers {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String[] data = sc.nextLine().split(" ");
		sc.close();
		
		HashMap<Integer, Integer> nums = new HashMap<>();
		
		for (String s : data) {
			
			if (nums.containsKey(Integer.parseInt(s))) {
				nums.put(Integer.parseInt(s), nums.get(Integer.parseInt(s)) + 1);
			}
			else {
				nums.put(Integer.parseInt(s), 1);
			}
			
		}
		
		for (int k : nums.keySet()) {
			System.out.println(String.format("%d -> %d", k, nums.get(k)));
		}
		
	}

}
