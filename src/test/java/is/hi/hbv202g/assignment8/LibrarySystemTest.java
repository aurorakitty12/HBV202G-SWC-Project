package is.hi.hbv202g.assignment8;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class LibrarySystemTest {
    @Test
    public void shouldBePossibleToAddBookToLibrarySystem() throws UserOrBookDoesNotExistException{
        LibrarySystem librarySystem = new LibrarySystem();
        Book book = new Book("The Great Gatsby", "F. Scott Fitzgerald", true);
        librarySystem.addBook(book);
        assertEquals(book.getTitle(), librarySystem.findBookByTitle("The Great Gatsby").getTitle());
    }
        @Test
    public void shouldBePossibleToAddUserToLibrarySystem() throws UserOrBookDoesNotExistException{
        LibrarySystem librarySystem = new LibrarySystem();
        librarySystem.addStudentUser("John Student", true);
        assertEquals("John Student", librarySystem.findUserByName("John Student").getName());
    }
        @Test
    public void shouldBePossibleToBorrowAndReturnBook() throws UserOrBookDoesNotExistException, BookNotAvailableException {
        LibrarySystem librarySystem = new LibrarySystem();
        librarySystem.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald", true));
        librarySystem.addStudentUser("John Student", true);
        librarySystem.BorrowBook("John Student", "The Great Gatsby");
        assertFalse(librarySystem.findBookByTitle("The Great Gatsby").isAvailable());
        assertTrue(librarySystem.searchLendingByUserAndBook(librarySystem.findUserByName("John Student"), 
        librarySystem.findBookByTitle("The Great Gatsby")) != null);
        librarySystem.returnBook("John Student", "The Great Gatsby");
        assertTrue(librarySystem.findBookByTitle("The Great Gatsby").isAvailable());
        assertTrue(librarySystem.searchLendingByUserAndBook(librarySystem.findUserByName("John Student"),
        librarySystem.findBookByTitle("The Great Gatsby")) == null);
    }
}
