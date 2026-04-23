package is.hi.hbv202g.assignment8;

import java.util.ArrayList;
import java.time.LocalDate;

public class LibrarySystem {
	private ArrayList<Book> books;
	private ArrayList<User> users;
	private ArrayList<Lending> lendings;
	
	public LibrarySystem() {}
	
	public void addBookWithTitleAndAuthorList(String title, ArrayList<Author> authors) {
		books.add(new Book( /**/ ));
	}
	public void addStudentUser(String name, boolean feePaid) {
		users.add(new Student(name, feePaid));
	}
	public void addFacultyMemberUser(String name, String department) {
		users.add(new FacultyMember(name, department));
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
    public void BorrowBook(String userName, String bookTitle) throws UserOrBookDoesNotExistException {
        User user = findUserByName(userName);
        Book book = findBookByTitle(bookTitle);
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
    public void returnBook(String userName, String bookTitle) throws UserOrBookDoesNotExistException {
        User user = findUserByName(userName);
        Book book = findBookByTitle(bookTitle);
        lendings.removeIf(lending -> lending.getUser() == user && lending.getBook() == book);
    }
}
