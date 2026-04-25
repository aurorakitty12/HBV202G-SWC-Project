package is.hi.hbv202g.assignment8;

import java.util.ArrayList;
import java.time.LocalDate;

public class LibrarySystem {
	private ArrayList<Book> books = new ArrayList<>();
	private ArrayList<User> users = new ArrayList<>();
	private ArrayList<Lending> lendings = new ArrayList<>();
	
	public LibrarySystem() {}
	
	public void addBook(String title, String author, boolean available) {
		Book book = new Book(title, author, available);
		books.add(book);
	}
	public void addStudentUser(String name, boolean feePaid) {
		User student = new Student(name, feePaid);
		users.add(student);
	}
	public void addFacultyMemberUser(String name, String department) {
		User facultyMember = new FacultyMember(name, department);
		users.add(facultyMember);
	}
	public Book findBookByTitle(String title) throws UserOrBookDoesNotExistException {
		for(int i = 0; i < books.size(); i++) {
			if(books.get(i).getTitle().equals(title)) {
				return books.get(i);
			}	
		}
		throw new UserOrBookDoesNotExistException("Book not found");
	}
	public User findUserByName(String name) throws UserOrBookDoesNotExistException {
		for(int i = 0; i < users.size(); i++) {
			if(users.get(i).getName().equals(name)) {
				return users.get(i);
			}
		}
		throw new UserOrBookDoesNotExistException("User not found");
	}
    public void BorrowBook(String userName, String bookTitle) throws UserOrBookDoesNotExistException, BookNotAvailableException {
        User user = findUserByName(userName);
        Book book = findBookByTitle(bookTitle);
        if (!book.isAvailable()) {
            throw new BookNotAvailableException("Book is not available");
        }
        lendings.add(new Lending(book, user));
    }
    public void extendLending(FacultyMember facultyMember, Book book, LocalDate newDueDate) {
        for (Lending lending : lendings) {
            if (lending.getUser() == facultyMember && lending.getBook() == book) {
                lending.setDueDate(newDueDate);
                break;
            }
        }
    }
	public Lending searchLendingByUserAndBook(User user, Book book) {
		for (Lending lending : lendings) {
			if (lending.getUser() == user && lending.getBook() == book) {
				return lending;
			}
		}
		return null;
	}

    public void returnBook(String userName, String bookTitle) throws UserOrBookDoesNotExistException {
        User user = findUserByName(userName);
        Book book = findBookByTitle(bookTitle);
        lendings.removeIf(lending -> lending.getUser() == user && lending.getBook() == book);
		book.setAvailable(true);
    }
}
