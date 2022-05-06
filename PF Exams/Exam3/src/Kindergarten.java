import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Child {
	
	private String name;
	private String egn;
	private int group;
	
	public Child(String name, String egn, int group) {
		this.name = name;
		this.egn = egn;
		this.group = group;
	}

	public String getName() {
		return name;
	}

	public String getEgn() {
		return egn;
	}

	public int getGroup() {
		return group;
	}
	
	public int getAge() {
		return 2000 - Integer.parseInt(egn.substring(0,2));
	}
	
	public String getFirstName() {
		return getName().split(" ")[0];
	}
	
	public String getLastName() {
		return getName().split(" ")[1];
	}
	
}

class Parent {
	
	private String name;
	private String job;
	private Child child;
	
	public Parent(String name, String job) {
		this.name = name;
		this.job = job;
	}

	public String getName() {
		return name;
	}

	public String getJob() {
		return job;
	}

	public Child getChild() {
		return child;
	}

	public void addChild(Child c) {
		child = c;
	}
	
	public String getFirstName() {
		return getName().split(" ")[0];
	}
	
	public String getLastName() {
		return getName().split(" ")[1];
	}
	
}

public class Kindergarten {

	public static void main(String[] args) {
		
		ArrayList<Child> children = new ArrayList<Child>();
		ArrayList<Parent> parents = new ArrayList<Parent>();
		Scanner sc = null;
		
		try {
			
			sc = new Scanner(new File("data.txt"));
			
			while (sc.hasNextLine()) {
				
				int N = sc.nextInt();
				sc.nextLine();
				
				for (int i = 0; i < N; i++) {
					
					String childName = sc.nextLine();
					
					String parentInfo = sc.nextLine();
					String[] parentData = parentInfo.split(" ");
					String parentName = parentData[0] + " " + parentData[1];
					String parentJob = "";
					
					for (int j = 2; j < parentData.length; j++) {
						parentJob = parentJob + parentData[j] + " ";
					}
					
					parentJob = parentJob.trim();
					
					String childEGN = sc.next();
					int childGroup = sc.nextInt();
					sc.nextLine();
					
					Child c = new Child(childName, childEGN, childGroup);
					Parent p = new Parent(parentName, parentJob);
					
					p.addChild(c);
					children.add(c);
					parents.add(p);
					
				}
				
			}
			
		} catch (Exception e) {
			System.out.println("File not found.");
		}
		
		sc.close();
		
		Collections.sort(children, Comparator.comparing((Child c) -> c.getAge()));
		
		int num = 1;
		
		for (Child c : children) {
			System.out.println(num + ". " + c.getFirstName());
			num++;
		}
		
		System.out.println();
		
		ArrayList<Parent> teachers = new ArrayList<Parent>();
		
		for (Parent p : parents) {
			if (p.getJob().equals("учител")) {
				teachers.add(p);
			}
		}
		
		Collections.sort(teachers, Comparator.comparing((Parent p) -> p.getChild().getFirstName())/*.reversed()*/);
		
		num = 1;
		
		for (Parent p : teachers) {
			
			System.out.println(num + ". " + p.getChild().getFirstName() + ", " + p.getFirstName());
			num++;
			
		}
		
		System.out.println();
		
		num = 1;
		
		for (Child c : children) {
			
			if (c.getFirstName().equals("Георги")) {
				System.out.println(num + ". " + c.getLastName() + " " + c.getGroup());
				num++;
			}
			
		}
		
	}

}
