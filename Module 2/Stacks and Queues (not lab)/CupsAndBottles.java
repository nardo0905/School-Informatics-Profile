import java.util.*;

public class CupsAndBottles {

	public static void main(String[] args) {
		
		Queue<Integer> cups = new LinkedList<>();
		Stack<Integer> bottles = new Stack<>();
		
		Scanner sc = new Scanner(System.in);
		
		String[] cupsData = sc.nextLine().split(" ");
		String[] bottlesData = sc.nextLine().split(" ");
		
		sc.close();
		
		for (String s : cupsData) {
			cups.add(Integer.parseInt(s));
		}
		
		for (String s : bottlesData) {
			bottles.add(Integer.parseInt(s));
		}
		
		int wastedWater = 0;
		while(cups.size() > 0) {
			
			if (bottles.size() == 0) {
				break;
			}
			
			int currFill = cups.peek();
			
			while (currFill > 0) {
				
				int currBottle = bottles.pop();
				
				if (currBottle > currFill) {
					wastedWater += currBottle - currFill;
					cups.remove();
					break;
				}
				
				if (currBottle == currFill) {
					cups.remove();
					break;
				}
				
				else {
					currFill -= currBottle;
				}
				
			}
			
		}
		
		if (cups.size() > 0) {
			System.out.print("Cups: ");
			String output = "";
			for (int c : cups) {
				output = output + c + " ";
			}
			System.out.print(output.trim());
			System.out.println();
			System.out.println(String.format("Wasted liters of water: %d", wastedWater));
		}
		else {
			System.out.print("Bottles: ");
			String output = "";
			for (int c : bottles) {
				output = output + c + " ";
			}
			System.out.print(output.trim());
			System.out.println();
			System.out.println(String.format("Wasted liters of water: %d", wastedWater));
		}
		
	}

}
