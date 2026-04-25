package is.hi.hbv202g.assignment8;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;


public class EmptyAuthorListExceptionTest {
    @Test
    public void shouldThrowEmptyAuthorListExceptionWhenGettingAuthorFromEmptyList() throws EmptyAuthorListException {
        Book book = new Book(); //Create a book with no title and no authors
        assertThrows(EmptyAuthorListException.class, () -> {
            book.getAuthor();
        });
    }
}
