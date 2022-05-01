
public class Customer {
	
	private int customerID, age, bonusPoints;
	private String name, email;
	
	public Customer(int cID, String name, int age, String email) {
		
		customerID = cID;
		this.name = name;
		this.age = age;
		this.email = email;
		bonusPoints = 10;
		
	}
	
	public void addBonusPoints(int points) {
		
		bonusPoints += points;
		
		System.out.println("You have " + bonusPoints + " bonus points.");
		
	}
	
	public void exchangePoints(int points) {
		
		if (bonusPoints < points) {
			System.out.println("You do not have enough bonus points.");
			return;
		}
		
		bonusPoints -= points;
		
		System.out.println("You have " + bonusPoints + " points left.");
		
	}

}
