package is.hi.hbv202g.assignment8;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;


public class BookTest {
    @Test
    public void shouldBePossibleToInstantiateBook() {
        Book book = new Book("The Great Gatsby", "F. Scott Fitzgerald", true);
        assertEquals("The Great Gatsby", book.getTitle());
        assertEquals("F. Scott Fitzgerald", book.getAuthor());
        assertTrue(book.isAvailable());
    }
}
