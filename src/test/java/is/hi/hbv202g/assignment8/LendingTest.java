package is.hi.hbv202g.assignment8;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class LendingTest {
    @Test
    public void shouldBePossibleToLendAndReturnBook() {
        Book book = new Book("The Great Gatsby", "F. Scott Fitzgerald", true);
        FacultyMember user = new FacultyMember("John Computer", "Computer Science");
        Lending lending = new Lending(book, user);
        
        assertFalse(book.isAvailable());
        assertEquals(user, lending.getUser());
        assertEquals(book, lending.getBook());
    }
}
