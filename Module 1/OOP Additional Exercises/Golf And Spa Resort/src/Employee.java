
public class Employee extends Person {
	
	private String department;
	private int employeeID;

	public Employee(String fn, String ln, String dp, int eID) {
		super(fn, ln);
		setDepartment(dp);
		setEmployeeID(eID);
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	
	public String startWorkingDay() {
		return super.getFirstName() + " " + super.getLastName() + " with id " + employeeID + " starts a new working day in the department " + department + ".";
	}

}
