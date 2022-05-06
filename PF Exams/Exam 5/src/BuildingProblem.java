import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

interface Price {
	
	public double getPrice();
	
}

class Element {
	
	private double breadth, height, unitPrice;

	public Element(double breadth, double height, double unitPrice) {
		this.breadth = breadth;
		this.height = height;
		this.unitPrice = unitPrice;
	}

	public double getBreadth() {
		return breadth;
	}

	public double getHeight() {
		return height;
	}

	public double getUnitPrice() {
		return unitPrice;
	}
	
}

class Wall extends Element implements Price {
	
	private int width;
	
	public Wall() {
		super(0, 0, 0);
		width = 0;
	}

	public Wall(double breadth, double height, int width, double unitPrice) {
		super(breadth, height, unitPrice);
		this.width = width;
	}

	@Override
	public double getPrice() {
		return width * super.getBreadth() * super.getHeight() * super.getUnitPrice();
	}

}

class Slab extends Element implements Price {

	public Slab(double breadth, double height, double unitPrice) {
		super(breadth, height, unitPrice);
	}

	@Override
	public double getPrice() {
		return super.getBreadth() * super.getHeight() * super.getUnitPrice();
	}
	
}

class Room implements Price {
	
	private Wall[] walls = new Wall[4];
	private Slab ceiling;
	
	public Room(double width, double breadth, double height, int thickness, double wallUnitPrice, double slabUnitPrice) {
		
		walls[0] = walls[1] = new Wall(breadth, height, thickness, wallUnitPrice);
		walls[2] = walls[3] = new Wall(width, height, thickness, wallUnitPrice);
		
		ceiling = new Slab(width, breadth, slabUnitPrice);
		
	}
			
	@Override
	public double getPrice() {
		
		return walls[0].getPrice() + walls[1].getPrice() + walls[2].getPrice() + walls[3].getPrice() + ceiling.getPrice();
		
	}
	
}

class Flat implements Price {
	
	private ArrayList<Room> rooms;
	
	public Flat() {
		rooms = new ArrayList<>();
	}
	
	public void addRoom(double width, double breadth, double height, int thickness, double wallUnitPrice, double slabUnitPrice) {
		rooms.add(new Room(width, breadth, height, thickness, wallUnitPrice, slabUnitPrice));
	}

	@Override
	public double getPrice() {
		
		double sum = 0;
		
		for (Room r : rooms) {
			sum += r.getPrice();
		}
		
		return sum;
		
	}
	
}

class Building implements Price {
	
	public ArrayList<Flat> flats;
	
	public Building() {
		flats = new ArrayList<>();
	}

	@Override
	public double getPrice() {
		
		double sum = 0;
		
		for (Flat f : flats) {
			sum += f.getPrice();
		}
		
		return sum;
		
	}
	
}

public class BuildingProblem {

	public static void main(String[] args) {
		
		Building b = new Building();
		
		Scanner sc = null;
		try {
			File file = new File("Building.txt");
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
		}
		
		int flatCount = Integer.parseInt(sc.nextLine());
		
		for (int i = 0; i < flatCount; i++) {
			
			int roomCount = Integer.parseInt(sc.nextLine());
			
			Flat f = new Flat();
			
			for (int j = 0; j < roomCount; j++) {
				
				String[] data = sc.nextLine().split(" ");
				double width = Double.parseDouble(data[0]);
				double breadth = Double.parseDouble(data[1]);
				double height = Double.parseDouble(data[2]);
				int thickness = Integer.parseInt(data[3]);
				double wallUnitPrice = Double.parseDouble(data[4]);
				double slabUnitPrice = Double.parseDouble(data[5]);
				
				f.addRoom(breadth, width, height, thickness, wallUnitPrice, slabUnitPrice);
				
			}
			
			b.flats.add(f);
			
		}
		
		sc.close();
		
		System.out.println(String.format("%.2f", b.getPrice()));
		
	}

}
