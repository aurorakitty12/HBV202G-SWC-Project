package is.hi.hbv202g.assignment8;

import java.util.ArrayList;
import java.time.LocalDate;

public class LibrarySystem {
	private ArrayList<Book> books = new ArrayList<>();
	private ArrayList<User> users = new ArrayList<>();
	private ArrayList<Lending> lendings = new ArrayList<>();
	//Library system constructor; no args
	public LibrarySystem() {}
	
	//method to add a book to the library system; takes in title, author, and availability status as parameters
	public void addBook(String title, String author, boolean available) {
		Book book = new Book(title, author, available);
		books.add(book);
	}
	//method to add a student user to the library system; takes in name and fee payment status as parameters
	public void addStudentUser(String name, boolean feePaid) {
		User student = new Student(name, feePaid);
		users.add(student);
	}
	//method to add a faculty member user to the library system; takes in name and department as parameters
	public void addFacultyMemberUser(String name, String department) {
		User facultyMember = new FacultyMember(name, department);
		users.add(facultyMember);
	}
	//method to find a book by its title; takes in title as a parameter and returns the book if found, otherwise throws an exception
	public Book findBookByTitle(String title) throws UserOrBookDoesNotExistException {
		for(int i = 0; i < books.size(); i++) {
			if(books.get(i).getTitle().equals(title)) {
				return books.get(i);
			}	
		}
		throw new UserOrBookDoesNotExistException("Book not found");
	}
	//method to find a user by their name; takes in name as a parameter and returns the user if found, otherwise throws an exception
	public User findUserByName(String name) throws UserOrBookDoesNotExistException {
		for(int i = 0; i < users.size(); i++) {
			if(users.get(i).getName().equals(name)) {
				return users.get(i);
			}
		}
		throw new UserOrBookDoesNotExistException("User not found");
	}
	//method to borrow a book; takes in user name and book title as parameters, checks if the book is available, and creates a new lending if it is, otherwise throws an exception
    public void BorrowBook(String userName, String bookTitle) throws UserOrBookDoesNotExistException, BookNotAvailableException {
        User user = findUserByName(userName);
        Book book = findBookByTitle(bookTitle);
        if (!book.isAvailable()) {
            throw new BookNotAvailableException("Book is not available");
        }
        lendings.add(new Lending(book, user));
    }
	//method to extend a lending; takes in a faculty member, a book, and a new due date as parameters
    public void extendLending(FacultyMember facultyMember, Book book, LocalDate newDueDate) {
        for (Lending lending : lendings) {
            if (lending.getUser() == facultyMember && lending.getBook() == book) {
                lending.setDueDate(newDueDate);
                break;
            }
        }
    }
	//method to find a lending by user and book; takes in a user and a book as parameters and returns the lending if found, otherwise returns null
	public Lending findLendingByUserAndBook(User user, Book book) {
		for (Lending lending : lendings) {
			if (lending.getUser() == user && lending.getBook() == book) {
				return lending;
			}
		}
		return null;
	}
	//method to return a book; takes in user name and book title as parameters, finds the corresponding lending, removes it from the list of lendings, and sets the book's availability to true. If no lending is found, throws an exception
    public void returnBook(String userName, String bookTitle) throws UserOrBookDoesNotExistException {
        User user = findUserByName(userName);
        Book book = findBookByTitle(bookTitle);
        lendings.removeIf(lending -> lending.getUser() == user && lending.getBook() == book);
		book.setAvailability(true);
    }
	
}
