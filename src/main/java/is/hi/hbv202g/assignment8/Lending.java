package is.hi.hbv202g.assignment8;

import java.time.LocalDate;

public class Lending {
	private LocalDate dueDate;
	private Book book;
	private User user;
	//Lending constructor; takes in a book and a user as parameters and sets the due date to 30 days from the current date
	public Lending(Book book, User user) {
		dueDate = LocalDate.now().plusDays(30);
		this.book = book;
		this.user = user;
		book.setAvailability(false);
	}
	//getter for lending due date
	public LocalDate getDueDate() {
		return dueDate;
	}
	//setter for lending due date
	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}
	//getter for lending book
	public Book getBook() {
		return book;
	}
	//setter for lending book
	public void setBook(Book book) {
		this.book = book;
	}
	//getter for lending user
	public User getUser() {
		return user;
	}
	//setter for lending user
	public void setUser(User user) {
		this.user = user;
	}
}
