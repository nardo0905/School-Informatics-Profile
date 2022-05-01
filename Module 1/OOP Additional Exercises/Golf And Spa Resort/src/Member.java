
public class Member extends Customer {
	
	private int membershipID;

	public Member(String fn, String ln, int mID) {
		super(fn, ln);
		setMembershipID(mID);
	}

	public int getMembershipID() {
		return membershipID;
	}

	public void setMembershipID(int membershipID) {
		this.membershipID = membershipID;
	}
	
	public String getMemberCard(String freeAccess) {
		return "Member " + super.getFirstName() + " " + super.getLastName() + " with membership number " + membershipID + " gets free access to the " + freeAccess + ".";
	}

}
