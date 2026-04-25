package is.hi.hbv202g.assignment8;

public class Student extends User {
	private boolean feePaid;
	//Student constructor; takes in name and fee paid status as parameters
	public Student(String name, boolean feePaid) {
		super(name);
		this.feePaid = feePaid;
	}
	//getter for student fee paid status
	public boolean isFeePaid() {
		return feePaid;
	}
	//setter for student fee paid status
	public void setFeePaid(boolean feePaid) {
		this.feePaid = feePaid;
	}

}
