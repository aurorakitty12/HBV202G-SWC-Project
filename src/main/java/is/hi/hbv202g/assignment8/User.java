package is.hi.hbv202g.assignment8;

public abstract class User {
	//user constructor; takes in name as a parameter
	public User(String name) {
		this.name = name;
	}
	private String name;
	//user name getter
	public String getName() {
		return name;
	}
	//user name setter
	public void setName(String name) {
		this.name = name;
	}
}
