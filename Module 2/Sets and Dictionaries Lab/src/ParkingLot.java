import java.util.*;
import java.util.stream.Stream;

public class ParkingLot {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		SortedSet<String> plates = new TreeSet<>();
		
		String command = sc.nextLine();
		
		while (!command.equals("END")) {
			
			String[] data = command.split(", ");
			
			if (data[0].equals("IN")) {
				plates.add(data[1]);
			}
			else {
				plates.remove(data[1]);
			}
			
			command = sc.nextLine();
			
		}
		
		sc.close();
		
		if (!plates.isEmpty()) {
			Stream<String> stream = plates.stream();
			stream.forEach(elem -> System.out.println(elem));
		}
		else {
			System.out.println("Parking lot is empty");
		}
		
	}

}
