package is.hi.hbv202g.assignment8;

public class FacultyMember extends User {
	private String department;
	//Faculty member constructor; takes in name and department as parameters
	public FacultyMember(String name, String department) {
		super(name);
		this.department = department;
	}
	//getter for faculty member department
	public String getDepartment() {
		return department;
	}
	//setter for faculty member department
	public void setDepartment(String department) {
		this.department = department;
	}
}
