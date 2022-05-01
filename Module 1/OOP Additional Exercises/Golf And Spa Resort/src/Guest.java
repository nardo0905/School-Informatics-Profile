
public class Guest extends Customer {

	public Guest(String fn, String ln) {
		super(fn, ln);
	}
	
	public String newGuest() {
		return "Mr/Ms/Mrs " + super.getFirstName() + " "  + super.getLastName() + " registers as a guest.";
	}

}
